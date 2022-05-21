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
package team.calistis.utils;

public class EntityUtils {

  public static final String FORMAT;

  private Entity entity;

  public MobStackEntity(final Entity entity) {
		this.entity = entity;
	}

  public Entity getEntity() {
    return this.entity;
  }

  public boolean hasMetadata() {
    return this.entity.hasMetadata("stack");
  }

  public int getAmount() {
    return this.entity.getMetadata("stack").get(0).asInt();
  }

  public void setAmount(final int newAmount) {
    if (newAmount <= 0) {
      this.removeEntity();
    }
    EntityUtils.setEntityMeta(this.entity, newAmount);
    this.entity.setCustomName(
        MobStackEntity.FORMAT.replace("<mob>", EntityUtils.getEntityTypeNameFormat(this.entity.getType()))
            .replace("<quantidade>", Integer.toString(newAmount)));
  }

  public boolean isSpawnerAbove() {
    return EntityUtils.getSpawner(this.entity).getY() > this.entity.getLocation().getY();
  }

  public int getSpawnersAround() {
    return EntityUtils.getSpawnersCount(this.entity);
  }

  public boolean isThereSpawnerClose() {
    return this.getSpawnersAround() != 0;
  }

  public Entity getMostProximityEntity() {
    try {
      return (Entity) this.entity.getNearbyEntities(15.0, 15.0, 15.0).stream()
          .filter(r -> r.getType().equals((Object) this.entity.getType())).filter(r -> !r.isDead())
          .filter(r -> r.hasMetadata("stack")).findFirst().get();
    } catch (NoSuchElementException e) {
      return null;
    }

  }

  public void removeEntity() {
    this.entity.remove();
  }

  static {
    FORMAT = new String(ChatColor.YELLOW + "x<quantidade> <mob>");
  }

  public static int getLootMath(final ItemStack item) {
    final int enchantmentLevel = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
    return enchantmentLevel;
  }

  public static String getEntityTypeNameFormat(final EntityType type) {
    final String typeName = type.name().replace("_", " ");
    final StringJoiner newName = new StringJoiner(" ");
    Stream.of(typeName.split(" "))
        .forEach(r -> newName.add(r.substring(0, 1).toUpperCase() + r.substring(1).toLowerCase()));
    return newName.toString();
  }

  public static Location getSpawner(Entity entity) {
    return Stream.of(entity.getLocation().getChunk().getTileEntities()).filter(r -> r instanceof CreatureSpawner)
        .filter(r -> ((CreatureSpawner) r).getSpawnedType().equals(entity.getType())).findFirst().get()
        .getLocation();
  }

  public static int getSpawnersCount(Entity entity) {
    return Stream.of(entity.getLocation().getChunk().getTileEntities()).filter(r -> r instanceof CreatureSpawner)
        .filter(r -> ((CreatureSpawner) r).getSpawnedType().equals(entity.getType()))
        .collect(Collectors.toList()).size();
  }

  public static void setEntityMeta(final Entity entity, final Object value) {
    entity.setMetadata("quantidade", (MetadataValue) new FixedMetadataValue((Plugin) Main.get(), value));
  }

  public static int getLootMath(final ItemStack item) {
    final int enchantmentLevel = item.getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
    return enchantmentLevel;
  }

  public static final ItemStack getHeadFarmI() {
    ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
    ItemMeta itemMeta = item.getItemMeta();
    setSkin(item, "MHF_GOLEM");
    itemMeta.setDisplayName("�aFarm");
    itemMeta.setLore(Arrays.asList("�7Use esta cabe�a para ter 10% a mais de b�nus drop.", " ", "�6N�vel: �7I"));
    itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    item.setItemMeta(itemMeta);
    return item;
  }

  public static ItemStack setSkin(ItemStack item, String nick) {
    try {
      SkullMeta meta = (SkullMeta) item.getItemMeta();
      meta.setOwner(nick);
      item.setItemMeta(meta);
    } catch (Throwable e) {
    }
    return item;
  }

  public static ItemStack get(String type, int amount) {
    ItemStack spawner = new ItemStack(Material.SKULL_ITEM, amount, (byte) 3);
    ItemMeta meta = spawner.getItemMeta();
    String entityName = EntityName.valueOf(type).getName();
    String spawnerName = SpawnerName.valueOf(type).getName();
    List<String> lore = new ArrayList<>();
    for (String line : Settings.Lore_Do_Spawner)
      lore.add(line.replace("%tipo%", entityName));
    meta.setDisplayName(Settings.Nome_Do_Spawner.replace("%tipo%", entityName));
    meta.setLore(lore);
    spawner.setItemMeta(meta);
    setSkin(spawner, "MHF_" + spawnerName.toUpperCase());
    return ItemAPI.saveInfo(spawner, "Entity", type);
  }

  @SuppressWarnings("deprecation")
  public static ItemStack getOld(String type, int amount) {
    ItemStack spawner = new ItemStack(Material.SKULL_ITEM, amount, (byte) 3);
    ItemMeta meta = spawner.getItemMeta();
    short entityId = EntityType.valueOf(type).getTypeId();
    String entityName = EntityName.valueOf(type).getName();
    String spawnerName = SpawnerName.valueOf(type).getName();
    List<String> lore = new ArrayList<>();
    for (String line : Settings.Lore_Do_Spawner)
      lore.add(line.replace("%tipo%", entityName));
    meta.setDisplayName(Settings.Nome_Do_Spawner.replace("%tipo%", entityName));
    meta.setLore(lore);
    spawner.setItemMeta(meta);
    spawner.setDurability(entityId);

    setSkin(spawner, "MHF_" + spawnerName.toUpperCase());
    return spawner;
  }

  public static ItemStack setSkin(ItemStack item, String nick) {
    try {
      SkullMeta meta = (SkullMeta) item.getItemMeta();
      meta.setOwner(nick);
      item.setItemMeta(meta);
    } catch (Throwable e) {
    }

    return item;
  }

}
