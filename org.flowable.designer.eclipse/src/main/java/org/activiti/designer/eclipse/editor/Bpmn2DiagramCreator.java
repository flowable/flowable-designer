/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.designer.eclipse.editor;

import org.activiti.designer.eclipse.util.FileService;
import org.activiti.designer.util.ActivitiConstants;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

public class Bpmn2DiagramCreator {
  
  public ActivitiDiagramEditorInput createBpmnDiagram(final IFile dataFile, final IFile diagramFile, final ActivitiDiagramEditor diagramEditor,
          final boolean openEditor) {
    
    IFile finalDataFile = dataFile;

    final IPath diagramPath = diagramFile.getFullPath();
    final String diagramName = diagramPath.removeFileExtension().lastSegment();
    final URI uri = URI.createPlatformResourceURI(diagramPath.toString(), true);

    final Diagram diagram = Graphiti.getPeCreateService().createDiagram("BPMNdiagram", diagramName, true);

    FileService.createEmfFileForDiagram(uri, diagram, diagramEditor, null, null);

    final String providerId = GraphitiUi.getExtensionManager().getDiagramTypeProviderId(diagram.getDiagramTypeId());
    final ActivitiDiagramEditorInput result = new ActivitiDiagramEditorInput(EcoreUtil.getURI(diagram), providerId);
    result.setDataFile(finalDataFile);
    result.setDiagramFile(diagramFile);

    if (openEditor) {
      openEditor(result);
    }

    return result;
  }

  public void openEditor(final ActivitiDiagramEditorInput editorInput) {
    final IWorkbench workbench = PlatformUI.getWorkbench();

    workbench.getDisplay().syncExec(new Runnable() {

      @Override
      public void run() {
        try {
          IDE.openEditor(workbench.getActiveWorkbenchWindow().getActivePage(), editorInput, ActivitiConstants.DIAGRAM_EDITOR_ID);

        } catch (PartInitException exception) {
          exception.printStackTrace();
        }
      }
    });
  }

  /**
   * Delete the temporary diagram file. If the containing folder hierarchy is
   * empty, it will also be deleted.
   * 
   * @param file
   *          - the temporary diagram file.
   */
  public static void dispose(IFile file) {
    try {
      IContainer container = file.getParent();
      file.delete(true, null);
      while (isEmptyFolder(container)) {
        container.delete(true, null);
        container = container.getParent();
      }
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Check if the given folder is empty. This is true if it contains no files,
   * or only empty folders.
   * 
   * @param container
   *          - folder to check
   * @return true if the folder is empty.
   */
  public static boolean isEmptyFolder(IContainer container) {
    try {
      IResource[] members = container.members();
      for (IResource res : members) {
        int type = res.getType();
        if (type == IResource.FILE || type == IResource.PROJECT || type == IResource.ROOT) {
          return false;
        }
        if (!isEmptyFolder((IContainer) res)) {
          return false;
        }
      }
    } catch (CoreException e) {
      return false;
    }
    return true;
  }

}
