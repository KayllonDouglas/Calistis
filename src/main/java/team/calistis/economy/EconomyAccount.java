package team.calistis.economy;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EconomyAccount {

  public static final int DEFAULT_MONEY_VALUE = 1000;
  public static final int DEFAULT_CASH_VALUE = 100;

  private UUID uniqueId;
  private double money;
  private double cash;
  
}
