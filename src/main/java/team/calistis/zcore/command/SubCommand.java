package team.calistis.zcore.command;

import cn.nukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
public abstract class SubCommand {

  private String usage, permission;


  public abstract boolean execute(CommandSender sender, String label, String[] args);

}
