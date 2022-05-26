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

/**
 * Replacer instance to improve code readability when replacing a lot of different strings with the same pattern.
 * @Author Gustavo Arantes (https://arantes.dev/) <- Autor Original
 */
package team.calistis.utils;

import java.util.HashMap;
import java.util.Map;

public class TextReplacer {

  private Map<CharSequence, CharSequence> replacers;

  public TextReplacer() {
    this.replacers = new HashMap<>();
  }

  public TextReplacer add(CharSequence key, Object value) {
    replacers.put(key, value.toString());
    return this;
  }

  public String replace(String message) {
    for (Map.Entry<CharSequence, CharSequence> entry : replacers.entrySet()) {
      message = message.replace(entry.getKey(), entry.getValue());
    }
    return message;
  }

}
