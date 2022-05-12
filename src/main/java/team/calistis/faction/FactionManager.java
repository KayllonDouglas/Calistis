package team.calistis.faction;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import team.calistis.Calistis;

public class FactionManager {

  private final Calistis calistis;
  private Config config;

  private List<Faction> allFactions = new ArrayList<>();

  public FactionManager(Calistis calistis) {
    this.calistis = calistis;
    this.config = new Config(new File(this.calistis.getDataFolder(), "Factions.json"), Config.YAML);
    this.createFakeFaction();
  }

  private boolean createFakeFaction() {
    return this.allFactions.add(new Faction("ABACATE",
          "ABT", new FactionMember(UUID.randomUUID(), FactionRole.LEADER),
          new ArrayList<>(List.of(new FactionMember(UUID.randomUUID(), FactionRole.MEMBER), new FactionMember(UUID.randomUUID(), FactionRole.MEMBER))),
          new ArrayList<>(List.of(new FactionMember(UUID.randomUUID(), FactionRole.OFFICER), new FactionMember(UUID.randomUUID(), FactionRole.OFFICER))), 0.0, 0));
  }

  public Faction getFaction(String name) {
    for (Faction faction : this.allFactions) {
      if (faction.getName().equals(name)) {
        return faction;
      }
    }
    return null;
  }

  public String getName(String name) {
    return this.getFaction(name).getName();
  }

  public String getTag(String name) {
    return this.getFaction(name).getTag();
  }

  public FactionMember getLeader(String name) {
    return this.getFaction(name).getLeader();
  }

  public FactionMember getMember(String name, Player player) {
    for (FactionMember member : this.getFaction(name).getMembers()) {
      if (member.getMemberId().equals(player.getUniqueId())) {
        return member;
      }
    }
    return null;
  }

  public FactionMember getOfficer(String name, Player player) {
    for (FactionMember officer : this.getFaction(name).getOfficers()) {
      if (officer.getMemberId().equals(player.getUniqueId())) {
        return officer;
      }
    }
    return null;
  }

  public double getMoney(String name) {
    return this.getFaction(name).getMoney();
  }

  public int getPower(String name) {
    return this.getFaction(name).getPower();
  }

  public void save() {
    for (Faction faction : this.allFactions) {
      this.config.set("registered-factions." + faction.getName() + ".tag", faction.getTag());
      this.config.set("registered-factions." + faction.getName() + ".leader", faction.getLeader().getMemberId().toString());
      for (FactionMember member : faction.getMembers()) {
        this.config.set("registered-factions." + faction.getName() + ".members." + member.getMemberId().toString(), member.getMemberRole().toString());
      }
      for (FactionMember officer : faction.getMembers()) {
        this.config.set("registered-factions." + faction.getName() + ".officers." + officer.getMemberId().toString(), officer.getMemberRole().toString());
      }
      this.config.set("registered-factions." + faction.getName() + ".momey", faction.getMoney());
      this.config.set("registered-factions." + faction.getName() + ".power", faction.getPower());
      this.config.save();
    }
  }

  public void load() {
    this.config.getSection("registered-factions").getKeys().forEach(k -> {
      this.calistis.getLogger().info(" KEY " + k);
    });
  }

  public List<Faction> getAllFactions() {
    return allFactions;
  }

  public Config getConfig() {
    return config;
  }

  public Calistis getCalistis() {
    return calistis;
  }

}
