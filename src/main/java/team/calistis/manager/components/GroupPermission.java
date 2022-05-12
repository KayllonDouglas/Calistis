package team.calistis.manager.components;

public class GroupPermission {

  private final String permission;
  private final int permissionLevel;

  public GroupPermission(String permission, int permissionLevel) {
    this.permission = permission;
    this.permissionLevel = permissionLevel;
  }

  public String getPermission() {
    return permission;
  }

  public int getPermissionLevel() {
    return permissionLevel;
  }

}
