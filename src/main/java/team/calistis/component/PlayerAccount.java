package team.calistis.component;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class PlayerAccount {

  private String password;
  private double balance;
  private Date loginDate;

}
