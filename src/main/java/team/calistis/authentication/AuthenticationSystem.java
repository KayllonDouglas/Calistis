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
package team.calistis.authentication;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.gson.reflect.TypeToken;

import cn.nukkit.utils.Config;
import lombok.Getter;
import team.calistis.authentication.components.AuthenticationAccount;

public class AuthenticationSystem {

  @Getter
  private static final Type mapType = new TypeToken<Map<UUID, AuthenticationAccount>>() {}.getType();
  @Getter
  private Config configuration;
  @Getter
  private static Map<UUID, AuthenticationAccount> allAccounts = new HashMap<>();
  @Getter
  private static List<UUID> loggedPlayers = new ArrayList<>();

  public static void save() {
  }

  public static void load() {
  }

}
