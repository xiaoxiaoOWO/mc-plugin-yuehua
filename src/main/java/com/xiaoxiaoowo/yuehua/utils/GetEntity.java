package com.xiaoxiaoowo.yuehua.utils;

import com.xiaoxiaoowo.yuehua.Yuehua;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public final class GetEntity {
    public static World world;
    public static Random random;

    public static Collection<Entity> getMonsters(Location location, double x, double y, double z) {
        return world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("m"));
    }

    public static Collection<Entity> getMonsters2(Location location, double x, double y, double z) {
        return world.getNearbyEntities(location, x, y, z, entity -> Yuehua.monsterData.containsKey(entity.getUniqueId()));
    }


//    public static ArrayList<Creature> getMonstersWithPredict(Location location, double x, double y, double z) {
//        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("monster"));
//        ArrayList<Creature> monsters = new ArrayList<>(entities.size());
//        for (Entity entity : entities) {
//            if (entity instanceof Creature creature) {
//                monsters.add(creature);
//            }
//        }
//        return monsters;
//    }
//
//    public static Collection<Entity> getMonstersWithPredict2(Location location, double x, double y, double z){
//        return world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("monster"));
//    }
//
//    public static Collection<Creature> getMonstersWithPredictByType(Location location, double x, double y, double z) {
//        return world.getNearbyEntitiesByType(Creature.class, location, x, y, z, entity -> entity.getScoreboardTags().contains("monster"));
//    }

//    public static ArrayList<Mob> getNumberLimitMonsters(Location location, double x, double y, double z, int num) {
//        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("monster"));
//        ArrayList<Mob> monsters = new ArrayList<>(num);
//        int i = 0;
//        for (Entity entity : entities) {
//            monsters.add((Mob) entity);
//            i++;
//            if (i == num) {
//                break;
//            }
//        }
//        return monsters;
//    }

//    public static Entity[] getNumberLimitMonsters2(Location location, double x, double y, double z, int num){
//        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("monster"));
//        num = Math.min(num, entities.size());
//        Entity[] monsters = new Entity[num];
//        int i = 0;
//        for (Entity entity : entities) {
//            monsters[i] = entity;
//            i++;
//            if (i == num) {
//                break;
//            }
//        }
//        return monsters;
//    }

//    public static Mob getOneMonster(Location location, double x, double y, double z) {
//        Iterator<Entity> iterator = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("monster")).iterator();
//        if (iterator.hasNext()) {
//            return (Mob) iterator.next();
//        }
//        return null;
//    }

    public static ArrayList<Mob> getRandomMonsters(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("m"));
        ArrayList<Mob> monsters = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if (i < num) {
                monsters.add((Mob) entity);
            } else {
                int replaceIndex = random.nextInt(i + 1);
                if (replaceIndex < num) {
                    monsters.set(replaceIndex, (Mob) entity);
                }
            }
            i++;
        }
        return monsters;
    }

    public static Mob getRandomMonster(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("m"));
        Mob monster = null;
        int i = 0;
        for (Entity entity : entities) {

            if (i == 0) {
                monster = (Mob) entity;
            } else {
                int replaceIndex = random.nextInt(i + 1);
                if (replaceIndex == 0) {
                    monster = (Mob) entity;
                }
            }
            i++;

        }
        return monster;
    }


    public static Mob getNearestMonster(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("m"));
        Mob nearest = null;
        double nearestDistance = 0;
        for (Entity entity : entities) {
            Mob mob = (Mob) entity;
            double distance = location.distanceSquared(mob.getLocation());
            if (nearest == null || distance < nearestDistance) {
                nearest = mob;
                nearestDistance = distance;
            }
        }
        return nearest;
    }

//    public static ArrayList<Player> getPlayers(Location location, double x, double y, double z) {
//        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z);
//        ArrayList<Player> players = new ArrayList<>(entities.size());
//        for (Entity entity : entities) {
//            if (entity instanceof Player player) {
//                players.add(player);
//            }
//        }
//        return players;
//    }
//
//    public static Collection<Entity> getPlayers2(Location location, double x, double y, double z) {
//        return world.getNearbyEntities(location, x, y, z,entity -> entity instanceof Player);
//    }


//    public static Collection<Entity> getPlayers2(Location location, double x, double y, double z) {
//        return world.getNearbyEntities(location, x, y, z, entity -> entity instanceof Player);
//    }

    public static Collection<Entity> getPlayers(Location location, double x, double y, double z) {
        return world.getNearbyEntities(location, x, y, z, entity -> entity.getType() == EntityType.PLAYER);
    }


//    public static ArrayList<Player> getNumberLimitPlayers(Location location, double x, double y, double z, int num) {
//        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("player"));
//        ArrayList<Player> players = new ArrayList<>(num);
//        int i = 0;
//        for (Entity entity : entities) {
//            players.add((Player) entity);
//            i++;
//            if (i == num) {
//                break;
//            }
//        }
//        return players;
//    }
//
//    public static Player getOnePlayer(Location location, double x, double y, double z) {
//        Iterator<Entity> iterator = world.getNearbyEntities(location, x, y, z, entity -> entity.getScoreboardTags().contains("player")).iterator();
//        if (iterator.hasNext()) {
//            return (Player) iterator.next();
//        }
//
//        return null;
//    }

    public static ArrayList<Player> getRandomPlayers(Location location, double x, double y, double z, int num) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getType() == EntityType.PLAYER);
        ArrayList<Player> players = new ArrayList<>(num);
        int i = 0;
        for (Entity entity : entities) {
            if (i < num) {
                players.add((Player) entity);
            } else {
                int replaceIndex = random.nextInt(i + 1);
                if (replaceIndex < num) {
                    players.set(replaceIndex, (Player) entity);
                }
            }
            i++;
        }
        return players;
    }

    public static Player getRandomPlayer(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getType() == EntityType.PLAYER);
        Player player = null;
        int i = 0;
        for (Entity entity : entities) {
            if (i < 0) {
                player = (Player) entity;
            } else {
                int replaceIndex = random.nextInt(i + 1);
                if (replaceIndex == 0) {
                    player = (Player) entity;
                }
            }
            i++;
        }
        return player;
    }

    public static Player getNearestPlayer(Location location, double x, double y, double z) {
        Collection<Entity> entities = world.getNearbyEntities(location, x, y, z, entity -> entity.getType() == EntityType.PLAYER);
        Player nearest = null;
        double nearestDistance = 0;
        for (Entity entity : entities) {
            Player player = (Player) entity;
            double distance = location.distanceSquared(player.getLocation());
            if (nearest == null || distance < nearestDistance) {
                nearest = player;
                nearestDistance = distance;
            }

        }
        return nearest;
    }

    public static ArrayList<Mob> getRayMonsterWithRoatation(Player player, double midDistance, double angle) {
        Location location = player.getEyeLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        Vector direction = location.getDirection().rotateAroundY(angle);
        double dx = direction.getX() * midDistance;
        double dy = direction.getY() * midDistance;
        double dz = direction.getZ() * midDistance;
        Location midPoint = new Location(GetEntity.world, x + dx, y + dy, z + dz);
        Collection<Entity> monsters = GetEntity.getMonsters(midPoint, dx + 0.5, dy + 0.5, dz + 0.5);
        ArrayList<Mob> mobs = new ArrayList<>(monsters.size());
        Vector eyeVector = location.toVector();
        //生物高度的一半加上去获得中心坐标向量，距离设置为高度宽度平均值一半的平方（避免一个过大造成的严重影响）,再稍微大一点
        for (Entity entity : monsters) {
            switch (entity.getType()) {
                case SILVERFISH -> {
                    //高度：0.3格
                    //宽度：0.4格
                    Silverfish mob = (Silverfish) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.15).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.031) {
                        mobs.add(mob);
                    }
                }

                case SHULKER -> {
                    //宽高1格
                    Shulker mob = (Shulker) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.5).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.255) {
                        mobs.add(mob);
                    }
                }


                case RAVAGER -> {
                    Ravager mob = (Ravager) entity;

                    //高度：2.2格
                    //宽度：1.95格
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 1.1).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 1.08) {
                        mobs.add(mob);
                    }
                }

                case WITCH -> {
                    Witch mob = (Witch) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ILLUSIONER -> {
                    Illusioner mob = (Illusioner) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case VINDICATOR -> {
                    Vindicator mob = (Vindicator) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }


                case PILLAGER -> {
                    Pillager mob = (Pillager) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ZOMBIFIED_PIGLIN -> {
                    PigZombie mob = (PigZombie) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }


                case PIGLIN_BRUTE -> {
                    PiglinBrute mob = (PiglinBrute) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ZOGLIN -> {
                    Zoglin mob = (Zoglin) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.4格
                        //宽度：1.3965格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.7).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.495) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.7格
                        //宽度：0.6982格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.123) {
                            mobs.add(mob);
                        }
                    }
                }


                case RABBIT -> {
                    Rabbit mob = (Rabbit) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.5格
                        //宽度：0.4格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.25).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.051) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.25格
                        //宽度：0.2格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.125).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.013) {
                            mobs.add(mob);
                        }
                    }
                }

                case PHANTOM -> {
                    Phantom mob = (Phantom) entity;
                    int size = mob.getSize();
                    //尺寸
                    double halfwidth = 0.9 + 0.2 * size;
                    double halfweight = 0.5 + 0.1 * size;
                    double average = (halfwidth + halfweight) / 2;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + halfweight).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < average * average) {
                        mobs.add(mob);
                    }
                }

                case SPIDER -> {
                    Spider mob = (Spider) entity;
                    //高度：0.9格
                    //宽度：1.4格
                    mob.getWidth();
                    mob.getHeight();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.45).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.331) {
                        mobs.add(mob);
                    }
                }

                case CAVE_SPIDER -> {
                    CaveSpider mob = (CaveSpider) entity;
                    //高度: 0.5方块
                    //宽度: 0.7方块
                    mob.getWidth();
                    mob.getHeight();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.25).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.095) {
                        mobs.add(mob);
                    }
                }


                case STRAY -> {
                    Stray mob = (Stray) entity;
                    //高度1.99
                    //宽度0.6
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.993).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.662).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.324).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.655).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.331).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.11) {
                        mobs.add(mob);
                    }
                }

                case SKELETON -> {
                    Skeleton mob = (Skeleton) entity;
                    //高度1.99
                    //宽度0.6
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.993).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.662).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.324).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.655).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.331).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.11) {
                        mobs.add(mob);
                    }
                }

                case MAGMA_CUBE -> {
                    MagmaCube mob = (MagmaCube) entity;
                    //高度：0.52*size
                    //宽度：0.52*size
                    int size = mob.getSize();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.26 * size).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.068 * size * size) {
                        mobs.add(mob);
                    }
                }

                case SLIME -> {
                    Slime mob = (Slime) entity;
                    //高度：0.52*size
                    //宽度：0.52*size
                    int size = mob.getSize();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.26 * size).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.068 * size * size) {
                        mobs.add(mob);
                    }
                }

                case PIGLIN -> {
                    Piglin mob = (Piglin) entity;

                    //成年
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ZOMBIE_VILLAGER -> {
                    ZombieVillager mob = (ZombieVillager) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }

                case ZOMBIE -> {
                    Zombie mob = (Zombie) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }

                case DROWNED -> {
                    Drowned mob = (Drowned) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }


                case EVOKER -> {
                    //高度：1.95格
                    //宽度：0.6格
                    Evoker mob = (Evoker) entity;


                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case GHAST -> {
                    //高度：4.0格
                    //宽度：4.0格
                    Ghast mob = (Ghast) entity;

                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 2.0).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 4.0) {
                        mobs.add(mob);
                    }
                }

                case ENDERMITE -> {
                    //高度：0.3格
                    //宽度：0.4格
                    Endermite mob = (Endermite) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.15).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.031) {
                        mobs.add(mob);
                    }
                }

                case ELDER_GUARDIAN -> {
                    //高度：1.9975格
                    //宽度：1.9975格
                    ElderGuardian mob = (ElderGuardian) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.99875).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 1) {
                        mobs.add(mob);
                    }
                }

                case GUARDIAN -> {
                    //高度：0.85格
                    //宽度：0.85格
                    Guardian mob = (Guardian) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.425).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.181) {
                        mobs.add(mob);
                    }
                }

                case HUSK -> {
                    Husk mob = (Husk) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }

                }
//
                case HOGLIN -> {
                    Hoglin mob = (Hoglin) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.4格
                        //宽度：1.3965格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.7).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.495) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.7格
                        //宽度：0.6982格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.123) {
                            mobs.add(mob);
                        }

                    }
                }

                case ENDERMAN -> {
                    Enderman mob = (Enderman) entity;
                    //高度：2.9格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 1.45).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 1.16).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.74).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 2.03).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.81).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v6 = base.clone().setY(base.getY() + 0.58).subtract(eyeVector);
                    double distance6 = v6.crossProduct(direction).lengthSquared();
                    if (distance6 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v7 = base.clone().setY(base.getY() + 2.32).subtract(eyeVector);
                    double distance7 = v7.crossProduct(direction).lengthSquared();
                    if (distance7 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v8 = base.clone().setY(base.getY() + 0.29).subtract(eyeVector);
                    double distance8 = v8.crossProduct(direction).lengthSquared();
                    if (distance8 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v9 = base.clone().setY(base.getY() + 2.61).subtract(eyeVector);
                    double distance9 = v9.crossProduct(direction).lengthSquared();
                    if (distance9 < 0.095) {
                        mobs.add(mob);
                    }
                }

                case WITHER -> {
                    Wither mob = (Wither) entity;
                    //高度：3.5格
                    //宽度：0.9格
                    Vector base = mob.getLocation().toVector();


                    Vector v1 = base.clone().setY(base.getY() + 2.0).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 1.5).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.0).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 2.5).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 3.0).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v6 = base.clone().setY(base.getY() + 0.5).subtract(eyeVector);
                    double distance6 = v6.crossProduct(direction).lengthSquared();
                    if (distance6 < 0.255) {
                        mobs.add(mob);
                    }
                }

                case WITHER_SKELETON -> {
                    WitherSkeleton mob = (WitherSkeleton) entity;
                    //高度：2.4格
                    //宽度：0.7格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 1.372).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 1.029).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 0.686).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.715).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 2.058).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v6 = base.clone().setY(base.getY() + 0.343).subtract(eyeVector);
                    double distance6 = v6.crossProduct(direction).lengthSquared();
                    if (distance6 < 0.123) {
                        mobs.add(mob);
                    }
                }

                case WARDEN -> {
                    Warden mob = (Warden) entity;
                    //高度：2.9格
                    //宽度：0.9格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 1.45).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.966).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.929).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 2.412).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.483).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.234) {
                        mobs.add(mob);
                    }
                }


                case BLAZE -> {
                    //高度：1.8格
                    //宽度：0.6格
                    Blaze mob = (Blaze) entity;
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.9).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.6).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.2).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.5).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.3).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.095) {
                        mobs.add(mob);
                    }


                }
                case CREEPER -> {
                    //高度：1.7格
                    //宽度：0.6格
                    Creeper mob = (Creeper) entity;

                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.85).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.566).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.132).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.415).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.283).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.095) {
                        mobs.add(mob);
                    }
                }

                //条件敌对

                case POLAR_BEAR -> {
                    PolarBear mob = (PolarBear) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.4格
                        //宽度：1.4格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.7).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.495) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.7格
                        //宽度：0.7格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.123) {
                            mobs.add(mob);
                        }
                    }
                }

                case BEE -> {
                    Bee mob = (Bee) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.6格
                        //宽度：0.7格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.3).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.106) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.3格
                        //宽度：0.35格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.15).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.027) {
                            mobs.add(mob);
                        }
                    }
                }
                case DOLPHIN -> {
                    //高度：0.6格
                    //宽度：0.9格
                    Dolphin mob = (Dolphin) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.3).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.165) {
                        mobs.add(mob);
                    }
                }
                case FOX -> {
                    Fox mob = (Fox) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.7格
                        //宽度：0.6格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.106) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.35格
                        //宽度：0.3格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.175).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.027) {
                            mobs.add(mob);
                        }
                    }
                }

                case IRON_GOLEM -> {
                    //高度：2.7格
                    //宽度：1.4格
                    IronGolem mob = (IronGolem) entity;
                    Vector base = mob.getLocation().toVector();
                    Vector v1 = base.clone().setY(base.getY() + 1.35).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.495) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.675).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.495) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 2.025).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.495) {
                        mobs.add(mob);
                    }
                }

                case VEX -> {
                    Vex mob = (Vex) entity;
                    //高度：0.8格
                    //宽度：0.4格
                    Vector base = mob.getLocation().toVector();
                    Vector v1 = base.clone().setY(base.getY() + 0.6).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.045) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.4).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.045) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 0.2).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.045) {
                        mobs.add(mob);
                    }
                }

                case WOLF -> {
                    Wolf mob = (Wolf) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.85格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();
                        Vector v1 = base.clone().setY(base.getY() + 0.284).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.095) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.568).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.095) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.425格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();
                        Vector v1 = base.clone().setY(base.getY() + 0.142).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.023) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.284).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.023) {
                            mobs.add(mob);
                        }

                    }
                }

                case PANDA -> {
                    Panda mob = (Panda) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.25格
                        //宽度：1.3格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.625).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.407) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.625格
                        //宽度：0.65格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.3125).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.102) {
                            mobs.add(mob);
                        }
                    }
                }

            }

        }
        return mobs;
    }


    public static ArrayList<Mob> getRayMonster(Player player, double midDistance) {
        Location location = player.getEyeLocation();
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        Vector direction = location.getDirection();
        double dx = direction.getX() * midDistance;
        double dy = direction.getY() * midDistance;
        double dz = direction.getZ() * midDistance;
        Location midPoint = new Location(GetEntity.world, x + dx, y + dy, z + dz);
        Collection<Entity> monsters = GetEntity.getMonsters(midPoint, dx + 0.5, dy + 0.5, dz + 0.5);
        ArrayList<Mob> mobs = new ArrayList<>(monsters.size());
        Vector eyeVector = location.toVector();
        //生物高度的一半加上去获得中心坐标向量，距离设置为高度宽度平均值一半的平方（避免一个过大造成的严重影响）,再稍微大一点
        for (Entity entity : monsters) {
            switch (entity.getType()) {
                case SILVERFISH -> {
                    //高度：0.3格
                    //宽度：0.4格
                    Silverfish mob = (Silverfish) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.15).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.031) {
                        mobs.add(mob);
                    }
                }

                case SHULKER -> {
                    //宽高1格
                    Shulker mob = (Shulker) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.5).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.255) {
                        mobs.add(mob);
                    }
                }


                case RAVAGER -> {
                    Ravager mob = (Ravager) entity;

                    //高度：2.2格
                    //宽度：1.95格
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 1.1).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 1.08) {
                        mobs.add(mob);
                    }
                }

                case WITCH -> {
                    Witch mob = (Witch) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ILLUSIONER -> {
                    Illusioner mob = (Illusioner) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case VINDICATOR -> {
                    Vindicator mob = (Vindicator) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }


                case PILLAGER -> {
                    Pillager mob = (Pillager) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ZOMBIFIED_PIGLIN -> {
                    PigZombie mob = (PigZombie) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }


                case PIGLIN_BRUTE -> {
                    PiglinBrute mob = (PiglinBrute) entity;
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ZOGLIN -> {
                    Zoglin mob = (Zoglin) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.4格
                        //宽度：1.3965格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.7).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.495) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.7格
                        //宽度：0.6982格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.123) {
                            mobs.add(mob);
                        }
                    }
                }


                case RABBIT -> {
                    Rabbit mob = (Rabbit) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.5格
                        //宽度：0.4格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.25).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.051) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.25格
                        //宽度：0.2格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.125).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.013) {
                            mobs.add(mob);
                        }
                    }
                }

                case PHANTOM -> {
                    Phantom mob = (Phantom) entity;
                    int size = mob.getSize();
                    //尺寸
                    double halfwidth = 0.9 + 0.2 * size;
                    double halfweight = 0.5 + 0.1 * size;
                    double average = (halfwidth + halfweight) / 2;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + halfweight).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < average * average) {
                        mobs.add(mob);
                    }
                }

                case SPIDER -> {
                    Spider mob = (Spider) entity;
                    //高度：0.9格
                    //宽度：1.4格
                    mob.getWidth();
                    mob.getHeight();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.45).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.331) {
                        mobs.add(mob);
                    }
                }

                case CAVE_SPIDER -> {
                    CaveSpider mob = (CaveSpider) entity;
                    //高度: 0.5方块
                    //宽度: 0.7方块
                    mob.getWidth();
                    mob.getHeight();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.25).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.095) {
                        mobs.add(mob);
                    }
                }


                case STRAY -> {
                    Stray mob = (Stray) entity;
                    //高度1.99
                    //宽度0.6
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.993).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.662).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.324).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.655).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.331).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.11) {
                        mobs.add(mob);
                    }
                }

                case SKELETON -> {
                    Skeleton mob = (Skeleton) entity;
                    //高度1.99
                    //宽度0.6
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.993).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.662).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.324).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.655).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.11) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.331).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.11) {
                        mobs.add(mob);
                    }
                }

                case MAGMA_CUBE -> {
                    MagmaCube mob = (MagmaCube) entity;
                    //高度：0.52*size
                    //宽度：0.52*size
                    int size = mob.getSize();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.26 * size).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.068 * size * size) {
                        mobs.add(mob);
                    }
                }

                case SLIME -> {
                    Slime mob = (Slime) entity;
                    //高度：0.52*size
                    //宽度：0.52*size
                    int size = mob.getSize();
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.26 * size).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.068 * size * size) {
                        mobs.add(mob);
                    }
                }

                case PIGLIN -> {
                    Piglin mob = (Piglin) entity;

                    //成年
                    //高度：1.95格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case ZOMBIE_VILLAGER -> {
                    ZombieVillager mob = (ZombieVillager) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }

                case ZOMBIE -> {
                    Zombie mob = (Zombie) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }

                case DROWNED -> {
                    Drowned mob = (Drowned) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }
                }


                case EVOKER -> {
                    //高度：1.95格
                    //宽度：0.6格
                    Evoker mob = (Evoker) entity;


                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.106) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.106) {
                        mobs.add(mob);
                    }
                }

                case GHAST -> {
                    //高度：4.0格
                    //宽度：4.0格
                    Ghast mob = (Ghast) entity;

                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 2.0).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 4.0) {
                        mobs.add(mob);
                    }
                }

                case ENDERMITE -> {
                    //高度：0.3格
                    //宽度：0.4格
                    Endermite mob = (Endermite) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.15).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.031) {
                        mobs.add(mob);
                    }
                }

                case ELDER_GUARDIAN -> {
                    //高度：1.9975格
                    //宽度：1.9975格
                    ElderGuardian mob = (ElderGuardian) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.99875).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 1) {
                        mobs.add(mob);
                    }
                }

                case GUARDIAN -> {
                    //高度：0.85格
                    //宽度：0.85格
                    Guardian mob = (Guardian) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.425).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.181) {
                        mobs.add(mob);
                    }
                }

                case HUSK -> {
                    Husk mob = (Husk) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.95格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.975).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 1.3).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 1.625).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.106) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.106) {
                            mobs.add(mob);
                        }

                    } else {
                        //幼年
                        //高度：0.975格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();

                        Vector v1 = base.clone().setY(base.getY() + 0.4875).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.325).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v3 = base.clone().setY(base.getY() + 0.65).subtract(eyeVector);
                        double distance3 = v3.crossProduct(direction).lengthSquared();
                        if (distance3 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v4 = base.clone().setY(base.getY() + 0.8125).subtract(eyeVector);
                        double distance4 = v4.crossProduct(direction).lengthSquared();
                        if (distance4 < 0.027) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v5 = base.clone().setY(base.getY() + 0.1625).subtract(eyeVector);
                        double distance5 = v5.crossProduct(direction).lengthSquared();
                        if (distance5 < 0.027) {
                            mobs.add(mob);
                        }

                    }

                }
//
                case HOGLIN -> {
                    Hoglin mob = (Hoglin) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.4格
                        //宽度：1.3965格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.7).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.495) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.7格
                        //宽度：0.6982格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.123) {
                            mobs.add(mob);
                        }

                    }
                }

                case ENDERMAN -> {
                    Enderman mob = (Enderman) entity;
                    //高度：2.9格
                    //宽度：0.6格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 1.45).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 1.16).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.74).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 2.03).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.81).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v6 = base.clone().setY(base.getY() + 0.58).subtract(eyeVector);
                    double distance6 = v6.crossProduct(direction).lengthSquared();
                    if (distance6 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v7 = base.clone().setY(base.getY() + 2.32).subtract(eyeVector);
                    double distance7 = v7.crossProduct(direction).lengthSquared();
                    if (distance7 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v8 = base.clone().setY(base.getY() + 0.29).subtract(eyeVector);
                    double distance8 = v8.crossProduct(direction).lengthSquared();
                    if (distance8 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v9 = base.clone().setY(base.getY() + 2.61).subtract(eyeVector);
                    double distance9 = v9.crossProduct(direction).lengthSquared();
                    if (distance9 < 0.095) {
                        mobs.add(mob);
                    }
                }

                case WITHER -> {
                    Wither mob = (Wither) entity;
                    //高度：3.5格
                    //宽度：0.9格
                    Vector base = mob.getLocation().toVector();


                    Vector v1 = base.clone().setY(base.getY() + 2.0).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 1.5).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.0).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 2.5).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 3.0).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.255) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v6 = base.clone().setY(base.getY() + 0.5).subtract(eyeVector);
                    double distance6 = v6.crossProduct(direction).lengthSquared();
                    if (distance6 < 0.255) {
                        mobs.add(mob);
                    }
                }

                case WITHER_SKELETON -> {
                    WitherSkeleton mob = (WitherSkeleton) entity;
                    //高度：2.4格
                    //宽度：0.7格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 1.372).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 1.029).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 0.686).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.715).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 2.058).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.123) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v6 = base.clone().setY(base.getY() + 0.343).subtract(eyeVector);
                    double distance6 = v6.crossProduct(direction).lengthSquared();
                    if (distance6 < 0.123) {
                        mobs.add(mob);
                    }
                }

                case WARDEN -> {
                    Warden mob = (Warden) entity;
                    //高度：2.9格
                    //宽度：0.9格
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 1.45).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.966).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.929).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 2.412).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.234) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.483).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.234) {
                        mobs.add(mob);
                    }
                }


                case BLAZE -> {
                    //高度：1.8格
                    //宽度：0.6格
                    Blaze mob = (Blaze) entity;
                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.9).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.6).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.2).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.5).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.3).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.095) {
                        mobs.add(mob);
                    }


                }
                case CREEPER -> {
                    //高度：1.7格
                    //宽度：0.6格
                    Creeper mob = (Creeper) entity;

                    Vector base = mob.getLocation().toVector();

                    Vector v1 = base.clone().setY(base.getY() + 0.85).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.566).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 1.132).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v4 = base.clone().setY(base.getY() + 1.415).subtract(eyeVector);
                    double distance4 = v4.crossProduct(direction).lengthSquared();
                    if (distance4 < 0.095) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v5 = base.clone().setY(base.getY() + 0.283).subtract(eyeVector);
                    double distance5 = v5.crossProduct(direction).lengthSquared();
                    if (distance5 < 0.095) {
                        mobs.add(mob);
                    }
                }

                //条件敌对

                case POLAR_BEAR -> {
                    PolarBear mob = (PolarBear) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.4格
                        //宽度：1.4格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.7).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.495) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.7格
                        //宽度：0.7格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.123) {
                            mobs.add(mob);
                        }
                    }
                }

                case BEE -> {
                    Bee mob = (Bee) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.6格
                        //宽度：0.7格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.3).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.106) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.3格
                        //宽度：0.35格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.15).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.027) {
                            mobs.add(mob);
                        }
                    }
                }
                case DOLPHIN -> {
                    //高度：0.6格
                    //宽度：0.9格
                    Dolphin mob = (Dolphin) entity;
                    Vector eyeToEntityFeet = mob.getLocation().toVector();
                    eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.3).subtract(eyeVector);
                    double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                    if (distance < 0.165) {
                        mobs.add(mob);
                    }
                }
                case FOX -> {
                    Fox mob = (Fox) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.7格
                        //宽度：0.6格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.35).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.106) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.35格
                        //宽度：0.3格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.175).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.027) {
                            mobs.add(mob);
                        }
                    }
                }

                case IRON_GOLEM -> {
                    //高度：2.7格
                    //宽度：1.4格
                    IronGolem mob = (IronGolem) entity;
                    Vector base = mob.getLocation().toVector();
                    Vector v1 = base.clone().setY(base.getY() + 1.35).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.495) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.675).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.495) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 2.025).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.495) {
                        mobs.add(mob);
                    }
                }

                case VEX -> {
                    Vex mob = (Vex) entity;
                    //高度：0.8格
                    //宽度：0.4格
                    Vector base = mob.getLocation().toVector();
                    Vector v1 = base.clone().setY(base.getY() + 0.6).subtract(eyeVector);
                    double distance1 = v1.crossProduct(direction).lengthSquared();
                    if (distance1 < 0.045) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v2 = base.clone().setY(base.getY() + 0.4).subtract(eyeVector);
                    double distance2 = v2.crossProduct(direction).lengthSquared();
                    if (distance2 < 0.045) {
                        mobs.add(mob);
                        continue;
                    }
                    Vector v3 = base.clone().setY(base.getY() + 0.2).subtract(eyeVector);
                    double distance3 = v3.crossProduct(direction).lengthSquared();
                    if (distance3 < 0.045) {
                        mobs.add(mob);
                    }
                }

                case WOLF -> {
                    Wolf mob = (Wolf) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：0.85格
                        //宽度：0.6格
                        Vector base = mob.getLocation().toVector();
                        Vector v1 = base.clone().setY(base.getY() + 0.284).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.095) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.568).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.095) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.425格
                        //宽度：0.3格
                        Vector base = mob.getLocation().toVector();
                        Vector v1 = base.clone().setY(base.getY() + 0.142).subtract(eyeVector);
                        double distance1 = v1.crossProduct(direction).lengthSquared();
                        if (distance1 < 0.023) {
                            mobs.add(mob);
                            continue;
                        }
                        Vector v2 = base.clone().setY(base.getY() + 0.284).subtract(eyeVector);
                        double distance2 = v2.crossProduct(direction).lengthSquared();
                        if (distance2 < 0.023) {
                            mobs.add(mob);
                        }

                    }
                }

                case PANDA -> {
                    Panda mob = (Panda) entity;
                    if (mob.isAdult()) {
                        //成年
                        //高度：1.25格
                        //宽度：1.3格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.625).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.407) {
                            mobs.add(mob);
                        }
                    } else {
                        //幼年
                        //高度：0.625格
                        //宽度：0.65格
                        Vector eyeToEntityFeet = mob.getLocation().toVector();
                        eyeToEntityFeet.setY(eyeToEntityFeet.getY() + 0.3125).subtract(eyeVector);
                        double distance = eyeToEntityFeet.crossProduct(direction).lengthSquared();
                        if (distance < 0.102) {
                            mobs.add(mob);
                        }
                    }
                }

            }

        }
        return mobs;
    }


    public static void init() {
        world = Bukkit.getWorld("world");
        random = new Random();

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


}






























