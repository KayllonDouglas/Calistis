package team.calistis.commands;

import cn.nukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import lombok.Data;
import team.calistis.Calistis;

@Data 
@AllArgsConstructor
public abstract class SubCommand {

  private String usage, permission;

  public Calistis getCore() {
    return Calistis.getInstance();
  }

  public abstract boolean execute(CommandSender sender, String label, String[] args);

}
