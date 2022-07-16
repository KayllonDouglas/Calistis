package github.kayllondouglas.player.entity;

import github.kayllondouglas.clan.entity.Clan;
import github.kayllondouglas.clan.entity.ClanRole;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CorePlayer {

  private double money, cash;

  private Clan clan;
  private ClanRole clanRole;

}
