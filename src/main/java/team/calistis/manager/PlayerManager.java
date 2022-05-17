package team.calistis.manager;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import cn.nukkit.Player;
import team.calistis.component.user.CalistisUser;
import team.calistis.component.user.UserAccount;
import team.calistis.component.user.UserGroup;

public class PlayerManager {

  private static Map<UUID, CalistisUser> allUsers = new HashMap<>();
  private static List<UUID> loggedUsers = new ArrayList<>();

  public static CalistisUser getUser(Player player) {
    return allUsers.get(player.getUniqueId());
  }

  /**
   *
   */
  public static CalistisUser removeUser(Player player) {
    return allUsers.remove(player.getUniqueId());
  }

  /**
   *
   */
  public static CalistisUser createUser(Player player, CalistisUser user) {
    return allUsers.put(player.getUniqueId(), user);
  }

  /**
   *
   */
  public static UserAccount getUserAccount(Player player) {
    return getUser(player).getUserAccount();
  }

  /**
   *
   */
  public static void createUserAccount(Player player, UserAccount userAccount) {
    getUser(player).setUserAccount(userAccount);
  }

  /**
   *
   */
  public static void removeUserAccount(Player player) {
    getUser(player).setUserAccount(null);
  }

  public static UserGroup getUserGroup(Player player) {
    return getUser(player).getUserGroup();
  }

  /**
   *
   */
  public static void createUserGroup(Player player, UserGroup userGroup) {
    getUser(player).setUserGroup(userGroup);
  }

  /**
   *
   */
  public static void removeUserGroup(Player player) {
    getUser(player).setUserGroup(null);
  }

  /**
   *
   */
  public static Map<UUID, CalistisUser> getAllUsers() {
    return allUsers;
  }

  /**
   *
   */
  public static Collection<UUID> getLoggedUsers() {
    return loggedUsers;
  }

}
