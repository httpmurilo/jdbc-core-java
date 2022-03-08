package io.httpmurilo.util;

import java.sql.SQLException;

public class ExceptionHandler {

    public static void handleException(Exception exception) {
        if (exception instanceof SQLException) {
            SQLException sqlException = (SQLException) exception;
            System.out.println(sqlException.getErrorCode());
            System.out.println(sqlException.getSQLState());
        }
        System.out.println(exception.getMessage());
        System.out.println(exception.printStackTrace();
    }
}
