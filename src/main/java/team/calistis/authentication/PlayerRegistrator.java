package team.calistis.authentication;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerRegistrator {
  
  private String password;
  private Date date;

}
