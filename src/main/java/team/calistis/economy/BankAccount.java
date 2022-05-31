package team.calistis.economy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {

  public static final double DEFAULT_MONEY_VALUE = 1000;
  public static final double DEFAULT_CASH_VALUE = 100;
  public static final double DEFAULT_MOBCOINS_VALUE = 0;
  public static final double DEFAULT_SHARDS_VALUE = 0;

  private double money, cash, mobCoins, shards;

}
