package team.calistis.command;

import cn.nukkit.command.Command;
import lombok.Getter;
import team.calistis.Calistis;
import team.calistis.command.economy.MoneyCommand;

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

  private void registerCommand(Command command) {
    this.calistis.getServer()
            .getCommandMap()
            .register(command.getName(), command);
  }

}
