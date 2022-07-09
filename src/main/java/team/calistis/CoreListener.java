package team.calistis;

import cn.nukkit.event.Listener;

public class CoreListener implements Listener {

  private final Core core;

  public CoreListener(Core core) {
    this.core = core;
  }

  public Core getCore() {
    return core;
  }

}
