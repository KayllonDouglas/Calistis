package team.calistis.manager;

import cn.nukkit.Player;
import team.calistis.Calistis;
import team.calistis.CalistisPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CalistisManager {

  private final Calistis calistis;

  private final List<CalistisPlayer> allPlayers = new ArrayList<>();

  public CalistisManager(Calistis calistis) {
    this.calistis = calistis;
  }

  public Calistis getCalistis() {
    return calistis;
  }

  public List<CalistisPlayer> getAllPlayers() {
    return allPlayers;
  }

}
