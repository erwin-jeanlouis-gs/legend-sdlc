// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.sdlc.protocol.pure.v1;

import org.finos.legend.engine.protocol.pure.v1.ProtocolToClassifierPathLoader;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.PackageableElement;
import org.finos.legend.engine.shared.core.ObjectMapperFactory;
import org.finos.legend.sdlc.protocol.ProtocolToEntityConverter;

import java.util.Map;

public class PureToEntityConverter extends ProtocolToEntityConverter<PackageableElement>
{
    private final Map<Class<? extends PackageableElement>, String> classToClassifier = ProtocolToClassifierPathLoader.getProtocolClassToClassifierMap();


    public PureToEntityConverter()
    {
        super(ObjectMapperFactory.getNewStandardObjectMapperWithPureProtocolExtensionSupports());
    }

    @Override
    protected String getClassifierForClass(Class<?> cls)
    {
        return classToClassifier.get(cls);
    }

    @Override
    protected String getEntityPath(PackageableElement element)
    {
        return element.getPath();
    }

}

