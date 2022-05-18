package team.calistis.authentication;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import lombok.Getter;
import lombok.NonNull;
import team.calistis.Calistis;
import team.calistis.authentication.listener.AuthenticationListener;

public class AuthenticationManager {
  
  @Getter private static Map<UUID, PlayerRegistrator> registeredPlayers = new HashMap<>();
  @Getter private static List<UUID> authenticatedPlayers = new ArrayList<>();

  @Getter private static Config configuration;

  public static boolean isPlayerRegistrated(@NonNull Player player) {
    return registeredPlayers.containsKey(player.getUniqueId());
  }

  public static PlayerRegistrator registerPlayer(@NonNull Player player, PlayerRegistrator playerRegistrator) {
    return registeredPlayers.put(player.getUniqueId(), playerRegistrator);
  }

  public static PlayerRegistrator unregisterPlayer(@NonNull Player player) {
    return registeredPlayers.remove(player.getUniqueId());
  }

  public static boolean isPlayerAuthenticated(@NonNull Player player) {
    return authenticatedPlayers.contains(player.getUniqueId());
  }

  public static boolean authenticatePlayer(@NonNull Player player) {
    return authenticatedPlayers.add(player.getUniqueId());
  }

  public static boolean deauthenticatePlayer(@NonNull Player player) {
    return authenticatedPlayers.remove(player.getUniqueId());
  }

  public static void initListener() {
    Calistis.getInstance().getServer().getPluginManager().registerEvents(new AuthenticationListener(), Calistis.getInstance());
  }

  public static void initConfiguration() {
    Calistis.getInstance().saveResource("AuthenticationConfiguration.yml");
    configuration = new Config(new File(Calistis.getInstance().getDataFolder(), "AuthenticationConfiguration.yml"), Config.YAML);
  }

}
