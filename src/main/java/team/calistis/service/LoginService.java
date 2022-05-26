/*
 * The APACHE License (APACHE)
 * 
 * Copyright (c) 2022 Constanze. All rights reserved.
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
package team.calistis.service;

import java.util.HashSet;
import java.util.Set;

import team.calistis.service.components.login.LoginAccount;
import team.calistis.service.components.login.LoginState;

public class LoginService {
  
  private static LoginState currentState;
  private static Set<LoginAccount> allAccounts = new HashSet<>();

  public static void setLoginState(LoginState state) {
    switch(state) {
      case REGISTERING:
        break;
      case LOGGING:
        break;
      case ONLINE:
        break;
      default:
        break;
    }
  }

  public static Set<LoginAccount> getAllAccounts() {
    return allAccounts;
  }

  public static LoginState getLoginState() {
    return currentState;
  }

}
