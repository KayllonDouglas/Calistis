package team.calistis.repositories;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import team.calistis.controllers.FactionController;
import team.calistis.objects.factions.Faction;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class FactionsRepository {

  private static final Type mapType = new TypeToken<HashMap<String, Faction>>(){}.getType();
  private static File file;

  @SneakyThrows
  public static void save() {
    if (!file.exists()) file.createNewFile();
    Writer writer = new FileWriter(file);
    writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(writer, mapType));
    writer.close();
  }

  @SneakyThrows
  public static void load() {
    if (!file.exists()) return;
    Reader reader = new FileReader(file);
    Map<String, Faction> map = new GsonBuilder().setPrettyPrinting().create().fromJson(reader, mapType);
    FactionController.getFactionsMap().putAll(map);
    reader.close();
  }

}
