/*
 * Replacer instance to improve code readability when replacing a lot of different strings with the same pattern.
 * @Author Gustavo Arantes (https://arantes.dev/) <- Autor Original
 */
package team.calistis.zcore.utils.text;

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
