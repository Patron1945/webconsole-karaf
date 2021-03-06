/*
 * Copyright (C) 2014 Code-House, Lukasz Dywicki.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.webconsole.karaf.features.jmx;

import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.apache.karaf.features.management.FeaturesServiceMBean;
import org.code_house.service.api.WrapperConnection;
import org.code_house.service.jmx.JmxServicePointer;
import org.webconsole.karaf.features.dto.FeaturesServiceAdapter;

public class JmxFeaturesPointer extends JmxServicePointer<FeaturesServiceAdapter> {

    private Map<String, Object> properties = new HashMap<>();

    public JmxFeaturesPointer(WrapperConnection<MBeanServerConnection> connection, ObjectName objectName) {
        super(connection, objectName);

        properties.put("InstanceName", objectName.getKeyProperty("name"));
    }

    @Override
    public FeaturesServiceAdapter createService() {
        return new JmxFeaturesService(createProxy(FeaturesServiceMBean.class));
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

}
