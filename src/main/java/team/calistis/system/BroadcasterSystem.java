package team.calistis.system;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import cn.nukkit.utils.Config;
import team.calistis.Calistis;

public class BroadcasterSystem {

  private static Config configuration;

  public static void autoAnnounce() {
    if (Optional
        .ofNullable(configuration.getStringList("broadcaster-messages"))
        .isEmpty()) {
      Calistis.getInstance().getLogger()
          .info("§c» §7Não há mensagens automaticas configuradas no arquivo 'BroadcasterConfiguration.json'");
      return;
    }
    List<String> msg = configuration.getStringList("broadcaster-messages");
    Calistis.getInstance().getServer().getScheduler().scheduleDelayedRepeatingTask(() -> {
      Calistis.getInstance().getServer().broadcastMessage(msg.get(new Random().nextInt(msg.size())));
    }, 0, configuration.getInt("delay-in-ticks"));
  }

  public static void init() {
    Calistis.getInstance().saveResource("BroadcasterConfiguration.yml", false);
    configuration = new Config(new File(Calistis.getInstance().getDataFolder(), "BroadcasterConfiguration.yml"),
        Config.YAML);
  }

}
