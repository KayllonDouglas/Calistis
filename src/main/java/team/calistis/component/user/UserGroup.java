package team.calistis.component.user;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserGroup {
  
  private String name;
  private List<String> permissions;
  private boolean isDefault;

}
