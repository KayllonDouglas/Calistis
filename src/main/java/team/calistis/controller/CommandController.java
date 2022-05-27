/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Calistis. All rights reserved.
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
package team.calistis.controller;

import cn.nukkit.command.Command;
import lombok.Getter;
import team.calistis.Calistis;
import team.calistis.economy.command.MoneyCommand;

@Getter
public class CommandController {

  private final Calistis calistis;

  public CommandController(Calistis calistis) {
    this.calistis = calistis;
    this.handleCommands();
  }

  private void handleCommands() {
    this.registerCommand(new MoneyCommand());
  }

  public boolean registerCommand(Command command) {
    return this.calistis.getServer()
        .getCommandMap()
        .register(command.getName(), command);
  }

}
