package team.calistis;

import lombok.extern.log4j.Log4j2;
import team.calistis.zcore.CoreBase;

@Log4j2
public class Core extends CoreBase {

    @Override
    public void onCoreEnable() {
        log.info("§7CalistisCore has been enabled, version: §7[§a" + this.getDescription().getVersion() + "§7].");
    }

    @Override
    public void onCoreDisable() {
        log.info("§7CalistisCore has been disabled.");
    }

}
