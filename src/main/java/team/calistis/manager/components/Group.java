package team.calistis.manager.components;

import java.util.List;

public class Group {

  private final String name;
  private final String prefix;
  private final List<GroupPermission> groupPermissions;

  public Group(String name, String prefix, List<GroupPermission> groupPermissions) {
    this.name = name;
    this.prefix = prefix;
    this.groupPermissions = groupPermissions;
  }

  public String getName() {
    return name;
  }

  public String getPrefix() {
    return prefix;
  }

  public List<GroupPermission> getGroupPermissions() {
    return groupPermissions;
  }

}
