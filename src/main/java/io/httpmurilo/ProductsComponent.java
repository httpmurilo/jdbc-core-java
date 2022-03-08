package io.httpmurilo;

import java.sql.*;
import java.util.Arrays;

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

    public void printProductList() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://172.106.0.118:3306/estudojdbc?user=qualquercoisa2&password=$WQ?B99u91Aq9jKp&serverTimezone=UTC");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from products");

        while(resultSet.next()) {
            String name = resultSet.getString("productName");
            System.out.println(name);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public void printProductListTwo() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://172.106.0.118:3306/estudojdbc?user=qualquercoisa2&password=$WQ?B99u91Aq9jKp&serverTimezone=UTC");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                String name = resultSet.getString("productName");
                int quantity = resultSet.getInt("quantityInStock");
                double price = resultSet.getDouble("buyPrice");
                System.out.format("%-45s %5d %10.2f%n", name, quantity, price);
            }


        } catch (Exception e) {
            System.out.println("SQLException message: " + e.getMessage());

            if(e instanceof SQLException) {
                SQLException sqlException = (SQLException) e;
                System.out.println("Error code: " + sqlException.getErrorCode());
                System.out.println("SQL State: " + sqlException.getSQLState());
            }

            System.out.println("Stacktrace " + Arrays.toString(e.getStackTrace()));
        }finally {
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

    public void printProductListThree() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/classicmodels?user=root&password=pluralsight&serverTimezone=UTC");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM products;");) {

            statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {

                String name = resultSet.getString("productName");
                System.out.println(name);
            }

        } catch (Exception exception) {
            handleException(exception);
        }
    }

    private void handleException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println("Error Code: " + sqlException.getErrorCode());
            System.out.println("SQL State: " + sqlException.getSQLState());
        }
        System.out.println("SQLException message: " + exception.getMessage());
        System.out.print("Stacktrace: ");
        exception.printStackTrace();
    }
}
