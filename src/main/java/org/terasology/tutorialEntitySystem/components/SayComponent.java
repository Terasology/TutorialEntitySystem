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

package org.terasology.tutorialEntitySystem.components;

import org.terasology.gestalt.entitysystem.component.Component;

/**
 * This component prints a message to the in-game console when activated.
 */
public class SayComponent implements Component<SayComponent> {
    /**
     * The message to print
     */
    public String message = "Hello there";

    @Override
    public void copyFrom(SayComponent other) {
        this.message = other.message;
    }
}
