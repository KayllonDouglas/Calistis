package team.calistis.command.account;

import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;

import cn.nukkit.Player;
import team.calistis.api.CalistisPlayerApi;
import team.calistis.command.CalistisCommand;

public class RegisterAccountCommand implements CalistisCommand {

	@Override
	public String getName() {
		return "registrar";
	}

	@Override
	public String getDescription() {
		return "Utilize efetuar o registro da sua conta";
	}

	@Override
	public String getPermission() {
		return "calistis.command.account-create";
	}

	@Override
	public void perform(Player player, String[] args) {
		if (args.length <= 1) {
			player.sendMessage(
					" \n§c» §7Comando usado de forma incorreta, utilize §c/conta registrar <senha> §7para concluir seu registro.\n");
			return;
		}
		String password = args[1];
		if (password.length() > 16 || password.length() < 8) {
			player.sendMessage(" \n§6» §7A senha informada deve conter no minimo 8 caracteres e no maximo 16 caracteres.\n");
			return;
		}
		String upperCaseChars = "(.*[A-Z].*)";
		if (!password.matches(upperCaseChars)) {
			player.sendMessage(" \n§6» §7A senha informada deve conter pelomenos 1 caracter em maiusculo.\n");
			return;
		}
		String lowerCaseChars = "(.*[a-z].*)";
		if (!password.matches(lowerCaseChars)) {
			player.sendMessage(" \n§6» §7A senha informada deve conter pelomenos 1 caracter em minusculo.\n");
			return;
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			player.sendMessage(" \n§6» §7A senha informada deve conter pelomenos 1 numeral.\n");
			return;
		}
		String specialChars = "(.*[@,#,$,%].*$)";
		if (!password.matches(specialChars)) {
			player.sendMessage(" \n§6» §7A senha informada deve conter pelomenos 1 caracter especial.\n");
			return;
		}
		if (Optional.ofNullable(CalistisPlayerApi.getCalistisPlayerPassword(player)).isPresent()) {
			player.sendMessage(" \n§c» §7Você ja tem uma senha registrada no banco de dados do servidor.\n");
			return;
		}
		if (Optional.ofNullable(CalistisPlayerApi.getCalistisPlayerPassword(player)).isEmpty()) {
			player.sendMessage(" \n§6» §7Registrando sua senha no banco de dados, por favor aguarde.\n");
			CalistisPlayerApi.setCalistisPlayerPassword(player, DigestUtils.sha256Hex(password));
			CalistisPlayerApi.authenticateCalistisPlayer(player);
			player.sendMessage(" \n§a» §7A sua senha foi registrada com §asucesso§7, tenha um bom jogo.\n");
			return;
		}
	}

}
