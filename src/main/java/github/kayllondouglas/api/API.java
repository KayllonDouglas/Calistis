package github.kayllondouglas.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import cn.nukkit.event.player.PlayerChatEvent;
import github.kayllondouglas.faction.Faction;
import github.kayllondouglas.profile.Profile;

public class API {
  
  private static final Map<String, Faction> factions = new HashMap<>();
  private static final Map<UUID, Profile> profiles = new HashMap<>();

  private static final Map<UUID, Consumer<PlayerChatEvent>> conversations = new HashMap<>();

  public static Map<String, Faction> getFactions() {
      return factions;
  }

  public static Map<UUID, Profile> getProfiles() {
      return profiles;
  }

  public static Map<UUID, Consumer<PlayerChatEvent>> getConversations() {
      return conversations;
  }

}
