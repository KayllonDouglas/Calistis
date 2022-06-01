package team.calistis.command;

import cn.nukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import lombok.Data;
import team.calistis.Core;

@Data 
@AllArgsConstructor
public abstract class SubCommand {

  private String usage, permission;

  public Core getCore() {
    return Core.getInstance();
  }

  public abstract boolean execute(CommandSender sender, String label, String[] args);

}
