package com.xiaoxiaoowo.yuehua.utils;


import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.sql.*;

public final class SQL {
    private static Connection connection;
    private static int num = 0;

    private final static String url = "jdbc:sqlite:world/yh.db";
    private static final String storeInventory1 = """
            INSERT OR REPLACE INTO inventory1 (player_name, data)
            VALUES (?, ?);
            """;
    private static final String storeInventory2 = """
            INSERT OR REPLACE INTO inventory2 (player_name, data)
            VALUES (?, ?);
            """;

    private static final String storeInventory3 = """
            INSERT OR REPLACE INTO inventory3 (player_name, data)
            VALUES (?, ?);
            """;

    private static final String storeInventory4 = """
            INSERT OR REPLACE INTO inventory4 (player_name, data)
            VALUES (?, ?);
            """;


    private static final String storeInventory5 = """
            INSERT OR REPLACE INTO inventory5 (player_name, data)
            VALUES (?,  ?);
            """;


    private static final String storeInventory6 = """
            INSERT OR REPLACE INTO inventory6 (player_name, data)
            VALUES (?, ?);
            """;

    private static final String storeInventory7 = """
            INSERT OR REPLACE INTO inventory7 (player_name, data)
            VALUES (?, ?);
            """;

    private static final String storeInventory8 = """
            INSERT OR REPLACE INTO inventory8 (player_name, data)
            VALUES (?, ?);
            """;

    private static final String storeInventory9 = """
            INSERT OR REPLACE INTO inventory9 (player_name, data)
            VALUES (?, ?);
            """;

    private static final String storeShiPin = """
            INSERT OR REPLACE INTO shipin (player_name, data)
            VALUES (?, ?);
            """;

    private static final String getInventory1 = """
            SELECT data
            FROM inventory1
            WHERE player_name = ?;
            """;

    private static final String getInventory2 = """
            SELECT data
            FROM inventory2
            WHERE player_name = ?;
            """;

    private static final String getInventory3 = """
            SELECT data
            FROM inventory3
            WHERE player_name = ?;
            """;

    private static final String getInventory4 = """
            SELECT data
            FROM inventory4
            WHERE player_name = ?;
            """;

    private static final String getInventory5 = """
            SELECT data
            FROM inventory5
            WHERE player_name = ?;
            """;

    private static final String getInventory6 = """
            SELECT data
            FROM inventory6
            WHERE player_name = ?;
            """;

    private static final String getInventory7 = """
            SELECT data
            FROM inventory7
            WHERE player_name = ?;
            """;

    private static final String getInventory8 = """
            SELECT data
            FROM inventory8
            WHERE player_name = ?;
            """;

    private static final String getInventory9 = """
            SELECT  data
            FROM inventory9
            WHERE player_name = ?;
            """;
    private static final String getShiPin = """
            SELECT  data
            FROM shipin
            WHERE player_name = ?;
            """;


    public static void connect() {
        try {
            connection = DriverManager.getConnection(url);
            init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void checkConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url);
                num = 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else {
            num++;
            if (num > 1000) {
                num = 0;
                try {
                    connection.close();
                    connection = DriverManager.getConnection(url);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void init() {
        String CREATE_TABLE1 = """
                CREATE TABLE IF NOT EXISTS inventory1 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE2 = """
                CREATE TABLE IF NOT EXISTS inventory2 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE3 = """
                CREATE TABLE IF NOT EXISTS inventory3 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE4 = """
                CREATE TABLE IF NOT EXISTS inventory4 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE5 = """
                CREATE TABLE IF NOT EXISTS inventory5 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE6 = """
                CREATE TABLE IF NOT EXISTS inventory6 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE7 = """
                CREATE TABLE IF NOT EXISTS inventory7 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE8 = """
                CREATE TABLE IF NOT EXISTS inventory8 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE9 = """
                CREATE TABLE IF NOT EXISTS inventory9 (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        String CREATE_TABLE10 = """
                CREATE TABLE IF NOT EXISTS shipin (
                    id INTEGER PRIMARY KEY,
                    player_name TEXT NOT NULL UNIQUE,
                    data TEXT NOT NULL
                );""";

        // 假设 hikariDataSource 是您的 HikariCP 数据源
        // 创建一个 Statement 来执行 SQL 语句
        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE6);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE7);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE8);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE9);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement statement = connection.createStatement()) {
            // 执行创建表的 SQL 语句
            statement.execute(CREATE_TABLE10);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



    public static void storePlayerInventory1(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory1)) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory2(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory2)) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory3(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory3)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory4(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory4)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory5(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory5)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory6(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory6)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory7(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory7)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory8(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory8)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storePlayerInventory9(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeInventory9)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void storeShiPin(String playerName, Inventory inventory) {
        checkConnection();
        try (PreparedStatement pstmt = connection.prepareStatement(storeShiPin)
        ) {
            pstmt.setString(1, playerName);
            pstmt.setString(2, NBTItem.convertItemArraytoNBT(inventory.getContents()).toString());
            pstmt.execute();
        } // try-with-resources 将自动关闭 pstmt
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Inventory retrievePlayerInventory1(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd1"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory1)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory2(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd2"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory2)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory3(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd3"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory3)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory4(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd4"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory4)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory5(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd5"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory5)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory6(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd6"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory6)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory7(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd7"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory7)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory8(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd8"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory8)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrievePlayerInventory9(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 54, Component.translatable("qkd9"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getInventory9)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }

    public static Inventory retrieveShipin(Player player) {
        checkConnection();
        Inventory inventory = Bukkit.createInventory(player, 9, Component.translatable("sp"));
        String playerName = player.getName();
        try (PreparedStatement pstmt = connection.prepareStatement(getShiPin)) {
            pstmt.setString(1, playerName);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String data = resultSet.getString("data");
                inventory.setContents(NBTItem.convertNBTtoItemArray((NBTCompound) NBT.parseNBT(data)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }




}
