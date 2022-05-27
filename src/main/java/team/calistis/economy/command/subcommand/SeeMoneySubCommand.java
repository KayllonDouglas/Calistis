/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Constanze. All rights reserved.
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
package team.calistis.economy.command.subcommand;

import cn.nukkit.command.CommandSender;
import team.calistis.command.SubCommand;

public class SeeMoneySubCommand extends SubCommand {

  public SeeMoneySubCommand() {
		super("see", "See your or others money", new String[]{"s"});
	}

@Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    return false;
  }

}
