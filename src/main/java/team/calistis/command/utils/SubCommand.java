package team.calistis.command.utils;

import cn.nukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class SubCommand {
 
  private String name, usage;
  private String[] aliases;

  public abstract void execute(CommandSender sender, String label, String[] args);

}
