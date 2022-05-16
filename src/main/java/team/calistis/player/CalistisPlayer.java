package team.calistis.player;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CalistisPlayer {

  private String password;
  private double balance;
  private Date lastLogin;

}
