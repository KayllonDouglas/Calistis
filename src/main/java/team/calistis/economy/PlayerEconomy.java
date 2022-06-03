package team.calistis.economy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerEconomy {

  public static final double DEFAULT_MONEY_VALUE = 1000;
  public static final double DEFAULT_CASH_VALUE = 100;

  private double money, cash;

}
