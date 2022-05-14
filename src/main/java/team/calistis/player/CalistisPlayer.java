package team.calistis.player;


import lombok.Data;

import java.util.Date;

@Data
public class CalistisPlayer {

  private final String password;
  private final double balance;
  private final Date lastLogin;

}
