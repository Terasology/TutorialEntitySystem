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

package org.terasology.tutorialEntitySystem.systems;

import org.terasology.entitySystem.entity.EntityRef;
import org.terasology.entitySystem.event.ReceiveEvent;
import org.terasology.entitySystem.systems.BaseComponentSystem;
import org.terasology.entitySystem.systems.RegisterMode;
import org.terasology.entitySystem.systems.RegisterSystem;
import org.terasology.logic.common.ActivateEvent;
import org.terasology.logic.console.Console;
import org.terasology.registry.In;
import org.terasology.rendering.logic.FloatingTextComponent;
import org.terasology.tutorialEntitySystem.components.DisplayComponent;
import org.terasology.tutorialEntitySystem.components.SayComponent;

@RegisterSystem(RegisterMode.AUTHORITY)
public class TutorialSystem extends BaseComponentSystem {
	
	@In
	private Console console;
	
	@ReceiveEvent
	public void onActivateSay(ActivateEvent event, EntityRef entity, SayComponent sayComponent) {
		console.addMessage(sayComponent.message); 
	}

	@ReceiveEvent
	public void onActivateDisplay(ActivateEvent event, EntityRef entity, DisplayComponent dispComponent) {
		if(entity.hasComponent(FloatingTextComponent.class)) {
			entity.removeComponent(FloatingTextComponent.class);
		} else {
			FloatingTextComponent text = new FloatingTextComponent();
			text.text = dispComponent.num + "";
			text.isOverlay = true;
			entity.addOrSaveComponent(text);
		}
	}
}
