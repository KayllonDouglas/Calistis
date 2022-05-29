package team.calistis.zcore.utils;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.utils.BinaryStream;

public final class Utils {

  public static void messagePlayer(Player player, String... strings) {
    for (String string : strings)
      player.sendMessage(string);
  }

  public static final byte[] encodeItem(Item item) {
    BinaryStream stream = new BinaryStream();
    stream.putSlot(item);
    return stream.getBuffer();
  }

  public static final Item decodeItem(byte[] input) {
    BinaryStream stream = new BinaryStream(input);
    return stream.getSlot();
  }

}
