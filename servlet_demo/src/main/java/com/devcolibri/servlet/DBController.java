package com.devcolibri.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DBController {

    private Connection conn;

    // Попытка соединения с БД
    /* ------------------------------------------------------------------------------------------------------------- */
    public boolean isConnected() {
        boolean connected = false;
        try
        {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection (IDBContract.HOST + IDBContract.DB_NAME, IDBContract.USERNAME,
                                                IDBContract.PASSWORD);
            connected = true;
        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return connected;
    }

    /* ------------------------------------------------------------------------------------------------------------- */
    public int insert(String table, Map<String, String> values) {

        String columns = "";
        String vals = "";
        int result = 0;

        for (String col : values.keySet()) {
            columns = columns + "\"" + col + "\", ";
            vals = vals + "'" + values.get(col) + "', ";
        }

        columns = columns.substring(0, columns.length() - 2);
        vals = vals.substring(0, vals.length() - 2);

        String query = String.format("INSERT INTO %s (%s) VALUES (%s)", table, columns, vals);

        try { result = this.conn.createStatement().executeUpdate(query); }
        catch (SQLException e) { e.printStackTrace(); }

        return result;

    }

    /* ------------------------------------------------------------------------------------------------------------- */
    public ResultSet execQuery(String query) {
        ResultSet rs = null;
        try
        {
            rs = this.conn.createStatement().executeQuery(query);
        }
        catch (SQLException e) { e.printStackTrace(); }
        return rs;
    }

}
