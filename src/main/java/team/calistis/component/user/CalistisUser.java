package team.calistis.component.user;
  
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalistisUser {
  
  private UserAccount userAccount;
  private UserGroup userGroup;
  
}
