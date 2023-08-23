package org.xiaoxiao.yuehua.util;

import org.bukkit.Bukkit;
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
        random = new Random(System.currentTimeMillis());
    }

    public static ArrayList<Creature> getMonsters(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Creature> monsters = new ArrayList<>(entities.size());
        for (Entity entity : entities) {
            if (Creature.class.isAssignableFrom(entity.getClass())) {
                monsters.add((Creature) entity);
            }
        }
        return monsters;
    }

    public static ArrayList<Creature> getRandomMonsters(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
        ArrayList<Creature> monsters = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if (Creature.class.isAssignableFrom(entity.getClass())) {
                if (i < num) {
                    monsters.add((Creature) entity);
                } else {
                    int replaceIndex = random.nextInt(i + 1);
                    if (replaceIndex < num) {
                        monsters.set(replaceIndex, (Creature) entity);
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
            if (Creature.class.isAssignableFrom(entity.getClass())) {
                if (i == 0) {
                    monster = (Creature) entity;
                } else {
                    int replaceIndex = random.nextInt(i + 1);
                    if (replaceIndex == 0) {
                        monster = (Creature) entity;
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
            if (Creature.class.isAssignableFrom(entity.getClass())) {
                Creature creature = (Creature) entity;
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
                if (i == 0) {
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






























