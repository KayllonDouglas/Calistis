package team.calistis.manager;

import cn.nukkit.utils.LogLevel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import team.calistis.Calistis;
import team.calistis.CalistisManager;
import team.calistis.player.CalistisPlayer;

import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

  private final CalistisManager calistisManager;

  private Map<UUID, CalistisPlayer> allPlayers = new HashMap<>();

  private final Type mapType = new TypeToken<Map<UUID, CalistisPlayer>>(){}.getType();

  public PlayerManager(CalistisManager calistisManager) {
    this.calistisManager = calistisManager;
//    this.allPlayers.put(UUID.randomUUID(), new CalistisPlayer("d328r2rhr0", 0.0, new Date()));
  }

  public CalistisPlayer getCalistisPlayer(UUID uuid) {
    return this.allPlayers.get(uuid);
  }

  public boolean existsCalistisPlayer(UUID uuid) {
    return this.allPlayers.containsKey(uuid);
  }

  public CalistisPlayer removeCalistisPlayer(UUID uuid) {
    return this.allPlayers.remove(uuid);
  }

  public void load() {
    String a = this.getCalistisManager().getPlayerConfiguration().getString("registered-players");
    Gson gson = new Gson();
    this.allPlayers = gson.fromJson(a, mapType);
  }

  public void save() {
    Gson gson = new Gson();
    this.calistisManager.getPlayerConfiguration().set("registered-players", gson.toJson(this.allPlayers, mapType));
    this.calistisManager.getPlayerConfiguration().save();
    this.calistisManager.getCalistis().getLogger().log(LogLevel.NOTICE, "§6Saving all players data..");
  }

  public Map<UUID, CalistisPlayer> getAllPlayers() {
    return allPlayers;
  }

  public CalistisManager getCalistisManager() {
    return calistisManager;
  }

}
