/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Condtanze. All rights reserved.
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
package team.calistis.zcore;

import cn.nukkit.plugin.PluginBase;

public abstract class CalistisPlugin extends PluginBase {

  @Override
  public void onEnable() {
    this.getLogger().notice("Pre enabling the plugin, this action could take some time.");
    this.onCoreEnable();
  }

  @Override
  public void onDisable() {
    this.getLogger().notice("Disabling the plugin, this action could take some time.");
    this.onCoreDisable();
  }

  public boolean suicide() {
    this.getServer().getPluginManager().disablePlugin(this);
    this.getLogger().error("An error occurred while trying to load/stop the plugin, stoping it safelly.");
    return true;
  }

  public abstract boolean onCoreEnable();

  public abstract boolean onCoreDisable();

}
