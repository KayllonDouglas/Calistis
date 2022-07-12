package github.kayllondouglas.command;

import cn.nukkit.command.CommandSender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data 
@AllArgsConstructor
public abstract class SubCommand {

  private String permission;

  public abstract boolean execute(CommandSender sender, String label, String[] args);

}
