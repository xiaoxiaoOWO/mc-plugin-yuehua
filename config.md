# 优化

| Server.properties             | 值                          |
| ----------------------------- | --------------------------- |
| network-compression-threshold | -1,CPU才是最累的，带宽足够  |
| broadcast-rcon-to-ops         | false,减少broadcast         |
| sync-chunk-writes             | false,异步提高性能          |
| broadcast-console-to-ops      | false，减少broadcast        |
| spawn-protection              | 0，盘出生点在选种族，没意义 |

| Bukkit.yml               | 值                               |
| ------------------------ | -------------------------------- |
| use-map-color-cache      | false,地图直接删除，自然无需缓存 |
| spawn-limits             | 0，不使用自然生成                |
| chunk-gc.period-in-ticks | 200，更快回收区块垃圾            |
| ticks-per                | 0，不使用自然生成                |
| autosave                 | 18000，15分钟自动保存一次足矣    |
|                          |                                  |

| Spigot.yml                         | 值                                                |
| ---------------------------------- | ------------------------------------------------- |
| log-villager-deaths                | false，少log减少服务器负担                        |
| log-named-deaths                   | false，少log减少服务器负担                        |
| save-user-cache-on-stop-only       | true,减少保存用户cache频率                        |
| arrow-despawn-rate                 | 1，服务端自动清理落地箭                           |
| trident-despawn-rate               | 1，服务端自动清理落地箭                           |
| villagers-active-for-panic         | false，村民不被恐慌激活（实际上村民不会恐慌）     |
| tick-inactive-villagers            | false，未激活村民的tick关闭                       |
| ignore-spectators                  | true，自然不需要考虑处于旁观模式的OP啦            |
| hanging-tick-frequency             | 0，悬挂实体（展示课，画）就别占用tick了           |
| zombie-aggressive-towards-villager | false，僵尸对村民有敌意只会增加僵尸AI对性能的消耗 |
| silent-commandblock-console        | true，命令方块执行命令如果还log,那真是浪费        |
| log                                | false，能不log就不                                |

| Paper-global.yml                               | 值                          |
| ---------------------------------------------- | --------------------------- |
| enable-player-collisions                       | false，玩家碰撞纯粹浪费性能 |
| send-full-pos-for-hard-colliding-entities      | false，碰撞浪费性能         |
| suggest-player-names-when-null-tab-completions | false                       |
| fix-target-selector-tag-completion             | false                       |
| auto-config-send-distance                      | false                       |
| fix-entity-position-desync                     | false                       |
| lag-compensate-block-breaking                  | false                       |
| max-joins-per-tick                             | 1                           |
| region-file-cache-size                         | 1024                        |
| ServerboundUseItemPacket                       | 防连点器                    |
| interval                                       | 10                          |
| save-empty-scoreboard-teams                    | true                        |
| player-auto-save.rate                          | 20                          |

| Paper-world-defaults.yml                | 值     |
| --------------------------------------- | ------ |
| prevent-moving-into-unloaded-chunks     | true   |
| only-players-collide                    | true   |
| disable-chest-cat-detection             | true   |
| disable-creeper-lingering-effect        | true   |
| phantoms-only-attack-insomniacs         | false  |
| phantoms-spawn-attempt-min-seconds      | 0      |
| phantoms-spawn-attempt-max-seconds      | 0      |
| piglins-guard-chests                    | false  |
| pillager-patrols. disable               | true   |
| player-insomnia-start-ticks             | 0      |
| zombies-target-turtle-eggs              | false  |
| entities-target-with-follow-range       | true   |
| per-player-mob-spawns                   | false  |
| disable-ice-and-snow                    | true   |
| disable-teleportation-suffocation-check | true   |
| optimize-explosions                     | true   |
| treasure-maps.enabled                   | false  |
| fishing-time-range                      | 无限大 |
| disable-move-event                      | true   |
| item-frame-cursor-update-interval       | 0      |
| shield-blocking-delay                   | 20     |
| keep-spawn-loaded                       | false  |
| keep-spawn-loaded-range                 | 0      |
| secondarypoisensor                      | 0      |
| grass-spread                            | 0      |
| validatenearbypoi                       | 0      |

| Purpur.yml                               | 值        |
| ---------------------------------------- | --------- |
| allow-unsafe-enchant-command             | true      |
| disable-mushroom-updates                 | true      |
| disable-chorus-plant-updates             | true      |
| hide-hidden-players-from-entity-selector | true      |
| max-joins-per-second                     | 1         |
| movement-resets-despawn-counter          | **false** |



# 机制

# 

| Server.properties       | 值        |
| ----------------------- | --------- |
| **gamemode**            | adventure |
| enable-command-block    | true      |
| generate-structures     | false     |
| **difficulty**          | hard      |
| allow-nether            | false     |
| **view-distance**       | 3         |
| **simulation-distance** | 3         |
| **player-idle-timeout** | 2         |
| **force-gamemode**      | true      |

| Bukkit.yml | 值             |
| ---------- | -------------- |
| allow-end  | false,关闭末地 |

| Spigot.yml                               | 值                  |
| ---------------------------------------- | ------------------- |
| **attribute**                            | 自行修改            |
| moved-too-quickly-multiplier             | 10000.0             |
| below-zero-generation-in-existing-chunks | false               |
| **item-despawn-rate**                    | 300                 |
| merge-radius.item                        | 3.0                 |
| thunder-chance                           | 0                   |
| mob-spawn-range                          | 0                   |
| growth                                   | 0                   |
| entity-activation-range                  | 自行调整,方块为单位 |
| **hunger**                               | ***自行设置***      |
| ticks-per.hopper-transfer                | 20                  |
| ticks-per.hopper-check                   | 20                  |
| max-tick-time                            | 10000               |
| enable-zombie-pigmen-portal-spawns       | false               |

| Paper-world-defaults.yml | 值         |
| ------------------------ | ---------- |
| **disable-player-crits** | ***true*** |

| Purpur.yml                           | 值             |
| ------------------------------------ | -------------- |
| **allow-infinity-on-crossbow**       | ***true***     |
| **clamp-levels**                     | ***false***    |
| **six-rows**                         | ***true***     |
| **food-properties**                  | ***自行设置*** |
| **clamp-attributes**                 | ***false***    |
| **starvation-damage**                | ***秒杀伤害*** |
| **bypass-mob-griefing**              | true           |
| **disable-trampling**                | true           |
| **explosion-power**                  | 12.0           |
| chest.open-with-solid-block-on-top   | true           |
| **magma-block.damage-when-sneaking** | true           |
| **powder_snow.bypass-mob-griefing**  | true           |
| allow-colors                         | true           |
| **stonecutter.damage**               | ***秒杀伤害*** |
| **poison-degeneration-amount**       | ***2.0***      |
| **wither-degeneration-amount**       | ***2.0***      |
| **hunger-exhaustion-amount**         | ***0.005***    |
| **void-damage-dealt**                | ***秒杀***     |
| **damage-from-drowning**             | ***10***       |

