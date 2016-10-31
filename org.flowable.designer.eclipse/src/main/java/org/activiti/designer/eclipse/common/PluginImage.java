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
package org.activiti.designer.eclipse.common;

/**
 * Enum that lists the frequently used images available in this plugin.
 * 
 * @author Tiese Barrell
 * @version 2
 * @since 5.5
 * 
 * 
 */
public enum PluginImage {

  FLOWABLE_LOGO_16x16("icons/logo/flowable.logo.16x16.png"), //$NON-NLS-1$ 
  FLOWABLE_LOGO_32x32("icons/logo/flowable.logo.32x32.png"), //$NON-NLS-1$ 
  FLOWABLE_LOGO_48x48("icons/logo/flowable.logo.48x48.png"), //$NON-NLS-1$ 
  FLOWABLE_LOGO_64x64("icons/logo/flowable.logo.64x64.png"), //$NON-NLS-1$  
  FLOWABLE_LOGO_128x128("icons/logo/flowable.logo.128x128.png"); //$NON-NLS-1$

  private final String imagePath;

  private PluginImage(final String imagePath) {
    this.imagePath = imagePath;
  }

  public String getImagePath() {
    return imagePath;
  }

}
