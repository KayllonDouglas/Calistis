package team.calistis.objects.factions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Faction {

    private String tag;
    private String description;
    private Map<UUID, FactionMember> members;
    private int power;

}
