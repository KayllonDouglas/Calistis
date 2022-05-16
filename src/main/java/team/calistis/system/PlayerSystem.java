package team.calistis.system;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.reflect.TypeToken;

import cn.nukkit.Player;
import team.calistis.component.PlayerAccount;

public class PlayerSystem {

  private static Map<UUID, PlayerAccount> allAccounts = new HashMap<>();
  private static List<UUID> authenticatedAccounts = new ArrayList<>();

  private static final Type mapType = new TypeToken<Map<UUID, PlayerAccount>>(){}.getType();

  public static PlayerAccount createAccount(Player player, PlayerAccount playerAccount) {
    return allAccounts.put(player.getUniqueId(), playerAccount);
  }

  public static PlayerAccount getAccount(Player player) {
    return allAccounts.get(player.getUniqueId());
  }

  public static PlayerAccount deleteAccount(Player player) {
    return allAccounts.remove(player.getUniqueId());
  }

  public static boolean isAccountAuthenticated(Player player) {
    return authenticatedAccounts.contains(player.getUniqueId());
  }

  public static boolean authenticateAccount(Player player) {
    return authenticatedAccounts.add(player.getUniqueId());
  }

  public static boolean deauthenticateAccount(Player player) {
    return authenticatedAccounts.remove(player.getUniqueId());
  }

  public static String getAccountPassword(Player player) {
    return allAccounts.get(player.getUniqueId()).getPassword();
  }

  public static void setAccountPassword(Player player, String password) {
    allAccounts.get(player.getUniqueId()).setPassword(password);
  }

}
