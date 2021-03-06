/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.openshift.commands;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.karaf.shell.console.CommandLoggingFilter;
import org.apache.karaf.shell.console.RegexCommandLoggingFilter;

/**
 * Used to filter out passwords from command logging.
 */
@Component(immediate = true)
@Service({ CommandLoggingFilter.class })
public class OpenshiftCommandLoggingFilter extends RegexCommandLoggingFilter {
    public OpenshiftCommandLoggingFilter() {
        addCommandOption("--zookeeper-password", "container-create-openshift");
        addCommandOption("--password",
                "container-create-openshift",
                ApplicationInfo.FUNCTION_VALUE,
                ApplicationCreate.FUNCTION_VALUE,
                ApplicationStart.FUNCTION_VALUE,
                ApplicationStop.FUNCTION_VALUE,
                ApplicationList.FUNCTION_VALUE,
                ApplicationRestart.FUNCTION_VALUE,
                ApplicationDestroy.FUNCTION_VALUE,
                DomainList.FUNCTION_VALUE);
    }
}
