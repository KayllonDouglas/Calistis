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

import cn.nukkit.command.PluginCommand;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.LogLevel;
import team.calistis.command.CommandManager;

public class Calistis extends PluginBase {

  public static Calistis instance;

  @Override
  public void onEnable() {
    instance = this;

    ((PluginCommand<?>)this.getCommand("staff")).setExecutor(new CommandManager());

    this.getLogger().log(LogLevel.INFO, "§aCalistis is now enabled");
  }

  @Override
  public void onDisable() {

    this.getLogger().log(LogLevel.INFO, "§cCalistis is now disabled.");
  }

  public static Calistis getInstance() {
    return instance;
  }

}
