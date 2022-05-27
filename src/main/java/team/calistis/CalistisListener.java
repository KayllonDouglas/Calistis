/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Author. All rights reserved.
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

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerLoginEvent;
import lombok.Getter;
import team.calistis.economy.EconomyAccount;

@Getter
public class CalistisListener implements Listener {

  private final Calistis calistis;

  public CalistisListener(Calistis calistis) {
    this.calistis = calistis;
  }

  @EventHandler
  public void onLogin(PlayerLoginEvent event) {
    Player player = event.getPlayer();
    if (!this.calistis.getEconomyController().hasEconomyAccount(player)) {
      this.calistis.getEconomyController().createEconomyAccount(player, new EconomyAccount(EconomyAccount.DEFAULT_MONEY_VALUE, EconomyAccount.DEFAULT_CASH_VALUE));
    }
  }

}
