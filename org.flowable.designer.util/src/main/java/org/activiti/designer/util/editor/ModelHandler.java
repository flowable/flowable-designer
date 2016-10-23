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
package org.activiti.designer.util.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

public class ModelHandler {

	private static Map<URI, BpmnMemoryModel> modelMap = new HashMap<URI, BpmnMemoryModel>();
	
	public static void addModel(URI uri, Object model) {
	  if (model instanceof BpmnMemoryModel) {
	    modelMap.put(uri, (BpmnMemoryModel) model);
	  }
	}

	public static BpmnMemoryModel getModel(URI uri) {
		return modelMap.get(uri);
	}

	public static void removeModel(URI uri) {
		modelMap.remove(uri);
	}
}
