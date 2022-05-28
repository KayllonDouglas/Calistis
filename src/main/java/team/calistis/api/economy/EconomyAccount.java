package team.calistis.api.economy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EconomyAccount {

  public static final double DEFAULT_MONEY_VALUE = 1000;
  public static final double DEFAULT_CASH_VALUE = 100;

  private double currentMoney;
  private double currentCash;

}
