package team.calistis.command.account;

import org.apache.commons.codec.digest.DigestUtils;

import cn.nukkit.Player;
import team.calistis.system.PlayerSystem;
import team.calistis.command.CalistisCommand;

public class AuthenticateAccountCommand implements CalistisCommand {

	@Override
	public String getName() {
		return "logar";
	}

	@Override
	public String getDescription() {
		return "Utilize para efetuar o login na sua conta";
	}

	@Override
	public String getPermission() {
		return "calistis.command.account-authenticate";
	}

	@Override
	public void perform(Player player, String[] args) {
		if (args.length <= 1) {
			player.sendMessage(" §c» §7Comando usado de forma incorreta, utilize §c/conta logar <senha> §7para concluir o seu login.");
			return;
		}
		String password = args[1];
		if (!PlayerSystem.getAccountPassword(player).equals(DigestUtils.sha256Hex(password))) {
			player.sendMessage(" \n§c» §7A senha informada esta incorreta, §cdigite-a corretamente§7.\n");
			return;
		}
		PlayerSystem.authenticateAccount(player);
		player.sendMessage(" \n§a» §7Você logou com sucesso, tenha um bom jogo.\n");
	}
  
}
