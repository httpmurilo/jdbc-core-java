package io.httpmurilo;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductsComponente_JNDI {

    public boolean getProductCount() throws NamingException, SQLException {
        InitialContext ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("jdbc/mysql");
        Connection connection = dataSource.getConnection("qualquercoisa2","$WQ?B99u91Aq9jKp");
        boolean isValid = connection.isValid(2);
        connection.close();
        return isValid;
    }
}
