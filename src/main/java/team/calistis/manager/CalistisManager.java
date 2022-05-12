package team.calistis.manager;

import team.calistis.Calistis;
import team.calistis.manager.components.Group;
import team.calistis.manager.components.GroupPermission;

import java.util.*;

public class CalistisManager {

  private final Calistis calistis;

  private final Map<UUID, Group> groupMap = new HashMap<>();
  private final List<Group> groupsList = new ArrayList<>();

  public CalistisManager(Calistis calistis) {
    this.calistis = calistis;
  }

  public Group getGroupByName(String name) {
    for (Group group : this.groupsList) {
      if (group.getName().equalsIgnoreCase(name)) return group;
    }
    return null;
  }

  public String getGroupPrefix(String name) {
    return this.getGroupByName(name).getPrefix();
  }

  public GroupPermission getGroupPermission(String name) {
    for (GroupPermission permission : this.getGroupByName(name).getGroupPermissions()) {
      return permission;
    }
    return null;
  }

  public Calistis getCalistis() {
    return calistis;
  }

  public Map<UUID, Group> getGroupMap() {
    return groupMap;
  }

  public List<Group> getGroupsList() {
    return groupsList;
  }

}
