/*************************GO-LICENSE-START*********************************
 * Copyright 2014 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************GO-LICENSE-END***********************************/

package com.thoughtworks.go.plugin.activation;

import com.thoughtworks.go.plugin.api.annotation.Extension;
import com.thoughtworks.go.plugin.api.annotation.Load;
import com.thoughtworks.go.plugin.api.annotation.UnLoad;
import com.thoughtworks.go.plugin.api.info.PluginDescriptor;
import com.thoughtworks.go.plugin.api.info.PluginDescriptorAware;

abstract class ClassWithPublicLoadUnLoadAnnotationMethod {
    @Load
    public void setupData() {
        incrementLoadInvoked();
    }

    @UnLoad
    public void tearDownData() {
        incrementLoadInvoked();
    }

    protected abstract void incrementLoadInvoked();

    protected abstract void incrementUnLoadInvoked();
}

@Extension
public class GoExtensionWithInheritedPublicLoadUnloadAnnotationMethod extends ClassWithPublicLoadUnLoadAnnotationMethod implements PluginDescriptorAware {
    public static int loadInvoked = 0;
    public static int unLoadInvoked = 0;

    @Override
    protected void incrementLoadInvoked() {
        loadInvoked++;
    }

    @Override
    protected void incrementUnLoadInvoked() {
        unLoadInvoked++;
    }

    @Override
    public void setPluginDescriptor(PluginDescriptor descriptor) {
    }
}
