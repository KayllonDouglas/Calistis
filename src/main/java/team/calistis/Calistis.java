/**
 * The APACHE License (APACHE)
 *
 * Copyright (c) 2022 Author: Constanze, All rights reserved.
 *
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
package team.calistis;

import lombok.Getter;
import team.calistis.controller.CommandController;
import team.calistis.controller.EconomyController;
import team.calistis.zcore.CalistisPlugin;

@Getter
public class Calistis extends CalistisPlugin {

  @Getter
  private static Calistis instance;
  
  private EconomyController economyController;
  private CommandController commandController;

  @Override
  public boolean onCoreEnable() {
    instance = this;
    this.commandController = new CommandController(this);
    this.economyController = new EconomyController(this);
    this.getServer().getPluginManager().registerEvents(new CalistisListener(this), this);
    this.getLogger().info("§aCalistisCore is now enabled, version: " + this.getDescription().getVersion() + ".");
    return false;
  }

  @Override
  public boolean onCoreDisable() {
    this.getLogger().info("§cCalistisCore is now disabled.");
    return false;
  }

}
