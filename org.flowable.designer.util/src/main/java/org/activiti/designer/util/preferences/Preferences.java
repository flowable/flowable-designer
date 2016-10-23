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
/**
 * 
 */
package org.activiti.designer.util.preferences;

/**
 * Enumeration of preferences used in the designer.
 * 
 * @author Tiese Barrell
 * @since 0.5.1
 * @version 2
 * 
 */
public enum Preferences {

  
  ECLIPSE_ACTIVITI_JAR_LOCATION("org.activiti.designer.preferences.eclipse.activitiJarLocation"),
  EDITOR_ADD_LABELS_TO_NEW_SEQUENCEFLOWS("org.activiti.designer.preferences.editor.addLabelsToNewSequenceFlows"), 
  EDITOR_ADD_DEFAULT_CONTENT_TO_DIAGRAMS("org.activiti.designer.preferences.editor.addDefaultContentToDiagrams"), 
  SAVE_TO_FORMAT("org.activiti.designer.preferences.save.saveToFormat"), 
  SAVE_IMAGE("org.activiti.designer.preferences.save.imageFormat"),
  SAVE_IMAGE_ADD_OVERLAY("org.activiti.designer.preferences.save.imageAddOverlay"),
  SAVE_IMAGE_ADD_OVERLAY_POSITION("org.activiti.designer.preferences.save.imageAddOverlayPosition"),
  SAVE_IMAGE_ADD_OVERLAY_FILENAME("org.activiti.designer.preferences.save.imageAddOverlayFilename"),
  SAVE_IMAGE_ADD_OVERLAY_KEY("org.activiti.designer.preferences.save.imageAddOverlayKey"),
  SAVE_IMAGE_ADD_OVERLAY_DATE("org.activiti.designer.preferences.save.imageAddOverlayDate"),
  SAVE_IMAGE_ADD_OVERLAY_NAMESPACE("org.activiti.designer.preferences.save.imageAddOverlayNamespace"),
  SAVE_IMAGE_ADD_OVERLAY_REVISION("org.activiti.designer.preferences.save.imageAddOverlayRevision"),
  SAVE_IMAGE_ADD_OVERLAY_TEXT_COLOR("org.activiti.designer.preferences.save.imageAddOverlayTextColor"),
  SAVE_IMAGE_ADD_OVERLAY_BORDER_COLOR("org.activiti.designer.preferences.save.imageAddOverlayBorderColor"),
  SAVE_IMAGE_ADD_OVERLAY_BACKGROUND_COLOR("org.activiti.designer.preferences.save.imageAddOverlayBackgroundColor"),
  
  ACTIVITI_CLOUD_EDITOR_URL("org.activiti.designer.preferences.activiticloudeditor.url"),
  ACTIVITI_CLOUD_EDITOR_USERNAME("org.activiti.designer.preferences.activiticloudeditor.username"),
  ACTIVITI_CLOUD_EDITOR_PASSWORD("org.activiti.designer.preferences.activiticloudeditor.password"),
  ACTIVITI_CLOUD_EDITOR_COOKIE("org.activiti.designer.preferences.activiticloudeditor.cookie"),
  
  ACTIVITI_LANGUAGES("org.activiti.designer.preferences.activiti.languages"),
  ACTIVITI_DEFAULT_LANGUAGE("org.activiti.designer.preferences.activiti.defaultlanguage"),
  
  PROCESS_TARGET_LOCATION_REPOSITORY("target-location-repository"),
  PROCESS_TARGET_LOCATION_SHARE("target-location-share"),
  PROCESS_EXPORT_TYPE("export-type");
  
  public static final String PROCESS_EXPORT_TYPE_TARGET = "target";
  
  private String preferenceId;

  private Preferences(final String preferenceId) {
    this.preferenceId = preferenceId;
  }

  public String getPreferenceId() {
    return preferenceId;
  }

}
