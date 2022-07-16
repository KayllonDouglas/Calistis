package github.kayllondouglas.entity.clan;

import cn.nukkit.level.Level;
import cn.nukkit.math.AxisAlignedBB;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClanClaim {

  private AxisAlignedBB area;
  private Level level;

}
