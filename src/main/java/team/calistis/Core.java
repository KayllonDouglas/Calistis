package team.calistis;

import team.calistis.zcore.CoreBase;

public class Core extends CoreBase {

  @Override
  public void onCoreEnable() {
    this.getLogger()
            .info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
  }

  @Override
  public void onCoreDisable() {
    this.getLogger()
            .info("§7CalistisCore has been disabled.");
  }

}
