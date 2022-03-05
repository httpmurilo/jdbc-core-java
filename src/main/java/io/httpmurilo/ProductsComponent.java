package io.httpmurilo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductsComponent {

    public boolean tryConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://172.106.0.118:3306/estudojdbc?user=qualquercoisa2&password=$WQ?B99u91Aq9jKp&serverTimezone=UTC");
        boolean isValid = connection.isValid(2);
        connection.close();
        return isValid;
    }

    public boolean tryConnectionForClassName() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.106.0.118:3306/estudojdbc?user=qualquercoisa2&password=$WQ?B99u91Aq9jKp&serverTimezone=UTC");
        boolean isValid = connection.isValid(2);
        connection.close();
        return isValid;
    }
}
