package github.kayllondouglas.api;

import github.kayllondouglas.entity.clan.Clan;
import github.kayllondouglas.entity.player.CorePlayer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class API {

  private static final Map<UUID, CorePlayer> players = new LinkedHashMap<>();
  private static final Map<String, Clan> clans = new LinkedHashMap<>();

  public static Map<String, Clan> getClans() {
    return clans;
  }

  public static Map<UUID, CorePlayer> getPlayers() {
    return players;
  }

}
