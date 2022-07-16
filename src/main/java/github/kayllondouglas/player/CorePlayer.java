package github.kayllondouglas.player;

import java.util.UUID;

import github.kayllondouglas.clan.Clan;
import github.kayllondouglas.clan.ClanRole;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CorePlayer {

  private UUID uuid;

  private double money, cash;

  private Clan clan;
  private ClanRole clanRole;

}
