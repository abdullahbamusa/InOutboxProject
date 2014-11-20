/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbAccess;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Abdullah
 */
public class Database {

    String _tableName;

    public Database(String tableName) {
        _tableName = tableName;
    }

    public boolean Save(String[] values) throws Exception {
        if (values.length > 4) {
            throw new IndexOutOfBoundsException();
        }
        boolean success = true;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=JsaDb;integratedSecurity=true");
        PreparedStatement stat = conn.prepareStatement("Insert into outboxes(OutboxNo, OutboxDate, Subject, GoingTo,  Deleted) VALUES(?, ?, ?, ?,?)");
        String outboxNo = values[0];
        String date = values[1];
        String subj = values[2];
        String goingTo = values[3];
        boolean deleted = false;
        stat.setString(1, outboxNo);
        stat.setString(2, date);
        stat.setString(3, subj);
        stat.setString(4, goingTo);
        stat.setBoolean(5, deleted);
        int result = stat.executeUpdate();
        if (result == 0) {
            success = false;
        }
        return success;

    }

}
