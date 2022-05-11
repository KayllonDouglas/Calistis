package team.calistis.faction;

import java.util.UUID;

public class FactionMember {

  private final UUID memberId;
  private final FactionRole memberRole;

  public FactionMember(UUID memberId, FactionRole memberRole) {
    this.memberId = memberId;
    this.memberRole = memberRole;
  }

  public UUID getMemberId() {
    return memberId;
  }

  public FactionRole getMemberRole() {
    return memberRole;
  }

}
