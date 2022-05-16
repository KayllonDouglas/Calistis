package team.calistis.api;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.nukkit.Player;
import cn.nukkit.utils.LogLevel;
import team.calistis.Calistis;
import team.calistis.player.CalistisPlayer;

public class CalistisPlayerApi {

  public static Map<UUID, CalistisPlayer> allPlayers = new HashMap<>();
  public static List<UUID> authenticatedPlayers = new ArrayList<>();

  private static final Type mapType = new TypeToken<Map<UUID, CalistisPlayer>>(){}.getType();

  /**
   * Create a new CalistisPlayer object by <Player player> and insert into <Map<UUID, CalistisPlayer>.
   */
  public static CalistisPlayer createCalistisPlayer(Player player, CalistisPlayer calistisPlayer) {
    return allPlayers.put(player.getUniqueId(), calistisPlayer);
  }

  /**
   * Return's a specified CalistisPlayer object by <Player player>.
   */
  public static CalistisPlayer getCalistisPlayer(Player player) {
    return allPlayers.get(player.getUniqueId());
  }

  /**
   * Check's if a specified CalistisPl object exists by <Player player>.
   */
  public static boolean existsCalistisPlayer(Player player) {
    return allPlayers.containsKey(player.getUniqueId());
  }

  public static CalistisPlayer deleteCalistisPlayer(Player player) {
    return allPlayers.remove(player.getUniqueId());
  }

  public static boolean isCalistisPlayerAuthenticated(Player player) {
    return authenticatedPlayers.contains(player.getUniqueId());
  }

  public static boolean authenticateCalistisPlayer(Player player) {
    return authenticatedPlayers.add(player.getUniqueId());
  }

  public static boolean deauthenticateCalistisPlayer(Player player) {
    return authenticatedPlayers.remove(player.getUniqueId());
  }

  public static String getCalistisPlayerPassword(Player player) {
    return allPlayers.get(player.getUniqueId()).getPassword();
  }

  public static void setCalistisPlayerPassword(Player player, String password) {
    allPlayers.get(player.getUniqueId()).setPassword(password);
  }

  public static Map<UUID, CalistisPlayer> getAllPlayers() {
    return allPlayers;
  }

  public static void save() {
    Gson gson = new Gson();
    if (Optional.ofNullable(Calistis.getCalistisPlayerConfiguration().getString("registered-players")).isEmpty()) {
      Calistis.getInstance().getLogger().log(LogLevel.INFO, " §c» §7Arquivo de dados 'PlayerRepository.json' is empty or don't exists.");
      return;
    }
    Calistis.getCalistisPlayerConfiguration().set("registered-players", gson.toJson(allPlayers, mapType));
    Calistis.getCalistisPlayerConfiguration().save();
  }

  public static void load() {
    Gson gson = new Gson();
    if (Optional.ofNullable(Calistis.getCalistisPlayerConfiguration().getString("registered-players")).isPresent()) {
      Calistis.getInstance().getLogger().log(LogLevel.INFO, " §c» §7Carregando dados do arquivo de dados 'PlayerRepository.json'.");
      allPlayers = gson.fromJson(Calistis.getCalistisPlayerConfiguration().getString("registered-players"), mapType);
      return;
    }
  }

  public static List<UUID> getAuthenticatedPlayers() {
    return authenticatedPlayers;
  }

}
