/*
 * Copyright 2017 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.rendering.nui.layers.mainMenu;

import org.terasology.assets.ResourceUrn;
import org.terasology.rendering.nui.CoreScreenLayer;
import org.terasology.rendering.nui.WidgetUtil;

public class UniverseSetupScreen extends CoreScreenLayer {

    public static final ResourceUrn ASSET_URI = new ResourceUrn("engine:universeSetupScreen");

    @Override
    public void initialise(){


        WidgetUtil.trySubscribe(this, "close", button ->
                triggerBackAnimation()
        );

        WorldSetupScreen worldSetupScreen = getManager().createScreen(WorldSetupScreen.ASSET_URI, WorldSetupScreen.class);
        WidgetUtil.trySubscribe(this, "worldConfig", button ->
            triggerForwardAnimation(worldSetupScreen)
        );

        WorldPreGenerationScreen worldPreGenerationScreen = getManager().createScreen(WorldPreGenerationScreen.ASSET_URI, WorldPreGenerationScreen.class);
        WidgetUtil.trySubscribe(this, "continue", button ->
            triggerForwardAnimation(worldPreGenerationScreen)
        );
    }
}

