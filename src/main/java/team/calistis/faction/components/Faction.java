/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Author. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package team.calistis.faction.components;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Faction {
  
  public static final int MAX_NAME_LENGTH = 10;
  public static final int MAX_TAG_LENGTH = 3;
  public static final int MAX_MEMBERS = 30;
  public static final int MAX_OFFICERS = 2;

  private String tag;
  private FactionMember leader;
  private Set<FactionMember> guests;
  private Set<FactionMember> members;
  private Set<FactionMember> officers;

  private BigDecimal balance;
  private int power;

  private boolean isOpen;
  private boolean isPeaceful;
  private boolean inWar;

}
