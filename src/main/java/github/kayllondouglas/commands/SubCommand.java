package github.kayllondouglas.commands;

import cn.nukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class SubCommand {
  
  @Getter()
  private String permission, description;

  public abstract boolean dispatch(CommandSender commandSender, String[] arguments);

}
