package team.calistis.objects.factions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FactionRole {

    RECRUIT("+"),
    MEMBER("*"),
    OFFICER("**"),
    LEADER("***");

    private final String suffix;

}
