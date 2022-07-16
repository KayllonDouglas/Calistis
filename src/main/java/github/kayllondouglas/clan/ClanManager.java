package github.kayllondouglas.clan;

import github.kayllondouglas.clan.entity.Clan;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClanManager {

  private static final Map<String, Clan> clans = new LinkedHashMap<>();

  public static Map<String, Clan> getClans() {
    return clans;
  }

}
