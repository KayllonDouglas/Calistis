package github.kayllondouglas.player;

import github.kayllondouglas.player.entity.CorePlayer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

  private static final Map<UUID, CorePlayer> players = new LinkedHashMap<>();

  public static Map<UUID, CorePlayer> getPlayers() {
    return players;
  }

}
