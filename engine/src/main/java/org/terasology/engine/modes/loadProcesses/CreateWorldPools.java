/*
 * Copyright 2018 MovingBlocks
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
package org.terasology.engine.modes.loadProcesses;

import org.terasology.context.Context;
import org.terasology.entitySystem.entity.EntityManager;
import org.terasology.game.GameManifest;

public class CreateWorldPools extends SingleStepLoadProcess {

    private Context context;
    private GameManifest gameManifest;

    public CreateWorldPools(Context context, GameManifest gameManifest) {
        this.context = context;
        this.gameManifest = gameManifest;
    }

    @Override
    public String getMessage() {
        return "Creating entity pools for different worlds....";
    }

    @Override
    public boolean step() {
        EntityManager entityManager = context.get(EntityManager.class);
        entityManager.createWorldPools(gameManifest);
        return true;
    }

    @Override
    public int getExpectedCost() {
        return 1;
    }

}
