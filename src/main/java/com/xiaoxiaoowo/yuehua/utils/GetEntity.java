package com.xiaoxiaoowo.yuehua.utils;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public final class GetEntity {
    public static World world;
    public static Random random;

    public static void init() {
        world = Bukkit.getWorld("world");
        random = new Random(System.nanoTime());

        //Gamerule
        world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, true);
        world.setGameRule(GameRule.BLOCK_EXPLOSION_DROP_DECAY, true);
        world.setGameRule(GameRule.COMMAND_BLOCK_OUTPUT, false);
        world.setGameRule(GameRule.COMMAND_MODIFICATION_BLOCK_LIMIT, 1000000000);
        world.setGameRule(GameRule.DISABLE_ELYTRA_MOVEMENT_CHECK, true);
        world.setGameRule(GameRule.DISABLE_RAIDS, true);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
        world.setGameRule(GameRule.DO_ENTITY_DROPS, false);
        world.setGameRule(GameRule.DO_FIRE_TICK, false);
        world.setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true);
        world.setGameRule(GameRule.DO_INSOMNIA, false);
        world.setGameRule(GameRule.DO_LIMITED_CRAFTING, true);
        world.setGameRule(GameRule.DO_MOB_LOOT, true);
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        world.setGameRule(GameRule.DO_PATROL_SPAWNING, false);
        world.setGameRule(GameRule.DO_TILE_DROPS, false);
        world.setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        world.setGameRule(GameRule.DO_VINES_SPREAD, false);
        world.setGameRule(GameRule.DO_WARDEN_SPAWNING, false);
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        world.setGameRule(GameRule.DROWNING_DAMAGE, true);
        world.setGameRule(GameRule.FALL_DAMAGE, true);
        world.setGameRule(GameRule.FIRE_DAMAGE, true);
        world.setGameRule(GameRule.FORGIVE_DEAD_PLAYERS, false);
        world.setGameRule(GameRule.FREEZE_DAMAGE, true);
        world.setGameRule(GameRule.GLOBAL_SOUND_EVENTS, true);
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        world.setGameRule(GameRule.LAVA_SOURCE_CONVERSION, false);
        world.setGameRule(GameRule.LOG_ADMIN_COMMANDS, false);
        world.setGameRule(GameRule.MAX_COMMAND_CHAIN_LENGTH, 1000000000);
        world.setGameRule(GameRule.MAX_ENTITY_CRAMMING, 0);
        world.setGameRule(GameRule.MOB_EXPLOSION_DROP_DECAY, true);
        world.setGameRule(GameRule.MOB_GRIEFING, false);
        world.setGameRule(GameRule.NATURAL_REGENERATION, true);
        world.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 100);
        world.setGameRule(GameRule.RANDOM_TICK_SPEED, 0);
        world.setGameRule(GameRule.REDUCED_DEBUG_INFO, false);
        world.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, true);
        world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, true);
        world.setGameRule(GameRule.SNOW_ACCUMULATION_HEIGHT, 0);
        world.setGameRule(GameRule.SPAWN_RADIUS, 0);
        world.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, true);
        world.setGameRule(GameRule.TNT_EXPLOSION_DROP_DECAY, true);
        world.setGameRule(GameRule.UNIVERSAL_ANGER, false);
        world.setGameRule(GameRule.WATER_SOURCE_CONVERSION, true);
    }

    public static ArrayList<Creature> getMonsters(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Creature> monsters = new ArrayList<>(entities.size());
        for (Entity entity : entities) {
            if ((entity instanceof Creature creature) && (creature.getScoreboardTags().contains("monster"))) {
                monsters.add(creature);
            }
        }
        return monsters;
    }

    public static ArrayList<Creature> getNumberLimitMonsters(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Creature> monsters = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if ((entity instanceof Creature creature) && (creature.getScoreboardTags().contains("monster"))) {
                monsters.add(creature);
                i++;
                if (i == num) {
                    break;
                }
            }
        }
        return monsters;
    }

    public static Creature getOneMonster(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        Creature monster = null;
        for (Entity entity : entities) {
            if ((entity instanceof Creature creature) && (creature.getScoreboardTags().contains("monster"))) {
                monster = creature;
                break;
            }
        }
        return monster;
    }

    public static ArrayList<Creature> getRandomMonsters(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Creature> monsters = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if ((entity instanceof Creature creature) && (creature.getScoreboardTags().contains("monster"))) {
                if (i < num) {
                    monsters.add(creature);
                } else {
                    int replaceIndex = random.nextInt(i + 1);
                    if (replaceIndex < num) {
                        monsters.set(replaceIndex, creature);
                    }
                }
                i++;
            }
        }
        return monsters;
    }

    public static Creature getRandomMonster(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        Creature monster = null;
        int i = 0;
        for (Entity entity : entities) {
            if ((entity instanceof Creature creature) && (creature.getScoreboardTags().contains("monster"))) {
                if (i == 0) {
                    monster = creature;
                } else {
                    int replaceIndex = random.nextInt(i + 1);
                    if (replaceIndex == 0) {
                        monster = creature;
                    }
                }
                i++;
            }
        }
        return monster;
    }


    public static Creature getNearestMonster(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        Creature nearest = null;
        double nearestDistance = 0;
        for (Entity entity : entities) {
            if ((entity instanceof Creature creature) && (creature.getScoreboardTags().contains("monster"))) {
                double distance = location.distanceSquared(creature.getLocation());
                if (nearest == null || distance < nearestDistance) {
                    nearest = creature;
                    nearestDistance = distance;
                }
            }
        }
        return nearest;
    }

    public static ArrayList<Player> getPlayers(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Player> players = new ArrayList<>(entities.size());
        for (Entity entity : entities) {
            if (entity instanceof Player player) {
                players.add(player);
            }
        }
        return players;
    }

    public static ArrayList<Player> getNumberLimitPlayers(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Player> players = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if (entity instanceof Player player) {
                players.add(player);
                i++;
                if (i == num) {
                    break;
                }
            }
        }
        return players;
    }

    public static Player getOnePlayer(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        Player player = null;
        for (Entity entity : entities) {
            if (entity instanceof Player player1) {
                player = player1;
                break;
            }
        }
        return player;
    }

    public static ArrayList<Player> getRandomPlayers(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Player> players = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if (entity instanceof Player player) {
                if (i < num) {
                    players.add(player);
                } else {
                    int replaceIndex = random.nextInt(i + 1);
                    if (replaceIndex < num) {
                        players.set(replaceIndex, player);
                    }
                }
                i++;
            }
        }
        return players;
    }

    public static Player getRandomPlayer(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        Player player = null;
        int i = 0;
        for (Entity entity : entities) {
            if (entity instanceof Player player1) {
                if (i < 0) {
                    player = player1;
                } else {
                    int replaceIndex = random.nextInt(i + 1);
                    if (replaceIndex == 0) {
                        player = player1;
                    }
                }
                i++;
            }
        }
        return player;
    }

    public static Player getNearestPlayer(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        Player nearest = null;
        double nearestDistance = 0;
        for (Entity entity : entities) {
            if (entity instanceof Player player) {
                double distance = location.distanceSquared(player.getLocation());
                if (nearest == null || distance < nearestDistance) {
                    nearest = player;
                    nearestDistance = distance;
                }
            }
        }
        return nearest;
    }

}





























