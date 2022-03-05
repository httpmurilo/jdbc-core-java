package io.httpmurilo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectComponent {

    public boolean tryConnection() throws Exception{

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://172.106.0.118:3306/estudojdbc?user=qualquercoisa2&password=$WQ?B99u91Aq9jKp&serverTimezone=UTC")){

            return conn.isValid(2);

        }
    }
}
