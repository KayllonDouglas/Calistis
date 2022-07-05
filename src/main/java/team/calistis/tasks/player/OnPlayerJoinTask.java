package team.calistis.tasks.player;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.LevelEventPacket;
import cn.nukkit.scheduler.PluginTask;
import team.calistis.Core;
import team.calistis.api.API;

public class OnPlayerJoinTask extends PluginTask<Core> {

  private Player player;

  public OnPlayerJoinTask(Core owner, Player player) {
    super(owner);
    this.player = player;
  }

  @Override
  public void onRun(int currentTick) {

    LevelEventPacket eventPacket = new LevelEventPacket();
    eventPacket.data = 1;
    eventPacket.evid = LevelEventPacket.EVENT_GUARDIAN_CURSE;
    eventPacket.x = this.player.asVector3f().getY();
    eventPacket.y = this.player.asVector3f().getX();
    eventPacket.z = this.player.asVector3f().getZ();
    this.player.dataPacket(eventPacket);

    this.player.sendTitle("§6§lCalistis§r",
        "§7Welcome §6" + this.player.getNameTag() + "§7, enjoy the gameplay!", 30, 30, 30);

    if (API.getPlayersMap().get(player.getUniqueId()).getFaction() == null) {
      this.player.sendMessage(" §l§6»§r §7Heyo §6" + this.player.getNameTag()
          + "§7, it looks like you are not a faction leader and much less a member/recruit, start by creating yours or join one that is public.");
      return;
    } 
    this.owner.getServer().getScheduler().cancelTask(this.getTaskId());
  }

  public Player getPlayer() {
    return player;
  }

}
