package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper {

    static String url = "jdbc:mysql://db4free.net:3306/testdatabase9290";
    static String userName = "testdatabase9290";
    static String userPassword = "123qweASD";

    static Connection connection = null;
    static Statement statement = null;

    public static Connection init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, userPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ArrayList<HashMap<String, Object>> getSqlResult(final String sql) {
        ResultSet resultSet = null;
        init();

        ArrayList<HashMap<String, Object>> sqlResult = new ArrayList<>();
        HashMap<String, Object> map = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()) {
                map = new HashMap<String, Object>(resultSetMetaData.getColumnCount());
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    if (resultSet.getObject(i) == null) {
                        map.put(resultSetMetaData.getColumnName(i), "");
                    } else {
                        map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                    }
                }
                sqlResult.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sqlResult;

    }


    public static Connection getConnection() {
        return connection;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static String getValueFirstRow(final String sql, final String colName) {
        String value = getSqlResult(sql).get(0).get(colName).toString();
        return value;
    }
    //final float id, final String name, final String first, int age

    /**
     * Метод для инсерта в базу данных клиентских значений
     *
     * @param id
     * @param first
     * @param last
     * @param age
     * @return
     */
    public static String insertIntoBD(int id, String first, String last, int age) {
        init();

        //задаем коннект и объявляем переменную
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "INSERT INTO REGISTRATION VALUES(?, ?, ?, ?)";

        //Ввод пользовательских данных и закрытие шарманки(коннекта)
        try (final PreparedStatement ppStatement = connection.prepareStatement(sql)) {
            ppStatement.setInt(1, id);
            ppStatement.setString(2, last);
            ppStatement.setString(3, first);
            ppStatement.setInt(4, age);
            ppStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return sql;
    }


    /**
     * Проверка существования юзера
     *
     * @param id
     * @return
     */
    public static boolean isExist(int id) {
        init();
        boolean isUserExists = false;
        try (PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM REGISTRATION WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    isUserExists = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isUserExists) {
            System.out.println("User exists!");
        }
        return isUserExists;
    }
}
