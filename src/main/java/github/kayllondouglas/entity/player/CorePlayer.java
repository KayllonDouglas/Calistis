package github.kayllondouglas.entity.player;

import github.kayllondouglas.entity.clan.Clan;
import github.kayllondouglas.entity.clan.ClanRole;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorePlayer {

  private double money, cash;

  private Clan clan;
  private ClanRole clanRole;

}
