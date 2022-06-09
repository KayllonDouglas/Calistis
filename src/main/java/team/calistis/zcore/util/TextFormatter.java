/*
 * Replacer instance to improve code readability when replacing a lot of different strings with the same pattern.
 * @Author Gustavo Arantes (https://arantes.dev/) <- Autor Original
 */
package team.calistis.zcore.util;

import java.util.HashMap;
import java.util.Map;

public class TextFormatter {

  private Map<CharSequence, CharSequence> replacers;

  public TextFormatter() {
    this.replacers = new HashMap<>();
  }

  public TextFormatter add(CharSequence key, Object value) {
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

