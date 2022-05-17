package team.calistis.component.user;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAccount {
  
  private String password;
  private Date creationDate;

}
