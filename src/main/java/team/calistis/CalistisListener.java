package team.calistis;

import java.util.Date;
import java.util.Optional;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import team.calistis.api.CalistisPlayerApi;
import team.calistis.player.CalistisPlayer;

public class CalistisListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    event.setJoinMessage(" \n§a» §7O(a) jogador(a) §a" + event.getPlayer().getNameTag() + " §7 logou no servidor.\n");
    if (Optional.ofNullable(CalistisPlayerApi.getCalistisPlayer(event.getPlayer())).isEmpty()) {
      CalistisPlayerApi.createCalistisPlayer(event.getPlayer(), new CalistisPlayer(null, 0.0, new Date()));
      event.getPlayer().sendMessage(" \n§a» §7Bem-Vindo(a) §a" + event.getPlayer().getNameTag() + "§7, parece que você é novo(a) por aqui!\n");
      event.getPlayer().sendMessage(" \n§6» §7Assim que você efetuar o seu registro comece criando sua facção com §6/f criar §7ou se junte a uma que esteja publica com §6/f aderir§7.\n");
      return;
    }
    if (Optional.ofNullable(CalistisPlayerApi.getCalistisPlayer(event.getPlayer())).isPresent()) {
      event.getPlayer().sendMessage(" \n§a» §7Bem-Vindo(a) de volta §a" + event.getPlayer().getNameTag() + "§7, efetue seu login para poder jogar.\n");
      return;
    }
  }
  
  @EventHandler
  public void onAuthenticationCheck(PlayerJoinEvent event) {
    if (Optional.ofNullable(CalistisPlayerApi.getCalistisPlayerPassword(event.getPlayer())).isEmpty()) {
      event.getPlayer().sendMessage(" \n§6» §7Parece que você não tem uma senha cadastrada, utilize §a/conta registrar §7para efetuar seu cadastro.\n");
      return;
    }
    if (Optional.ofNullable(CalistisPlayerApi.getCalistisPlayerPassword(event.getPlayer())).isPresent()) {
      event.getPlayer().sendMessage(" \n§a» §7Você esta registrado em nosso banco de dados, utilize §a/conta logar §7para efetuar seu login.\n");
      return;
    }
  }

  @EventHandler
  public void onMove(PlayerMoveEvent event) {
    if (!CalistisPlayerApi.isCalistisPlayerAuthenticated(event.getPlayer())) {
      event.setCancelled(true);
      event.getPlayer().sendPopup("§6Você não pode concluir esta ação sem ter efetuado seu login antes.");
      return;
    }
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    CalistisPlayerApi.deauthenticateCalistisPlayer(event.getPlayer());
  }

}
