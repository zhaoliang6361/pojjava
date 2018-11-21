package cn.self.code.util;

import java.sql.*;
import java.text.MessageFormat;

/**
 * Created by zhaoliang on 2018/11/21.
 */
public class DBUtil {

    private static final String SQLITE_CLASS_NAME = "org.sqlite.JDBC";

    private static final String MYSQL_CLASS_NAME = "com.mysql.jdbc.Driver";

    private static final String ORACLE_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";

    private static final String SQLITE_URL_PATTERN = "jdbc:sqlite:{0}";

    private static final String MYSQL_URL_PATTERN = "jdbc:mysql://{0}:3306/{1}?useUnicode=true&characterEncoding=utf-8";

    private static final String MYSQL_URL_NOPORT_PATTERN = "jdbc:mysql://{0}:{1}/{2}?useUnicode=true&characterEncoding=utf-8";

    private static final String ORACLE_URL_PATTERN = "jdbc:oracle:thin:@{0}:1521:{1}";

    public static Connection createSqliteConnect(String filePath) throws ClassNotFoundException, SQLException {
        Class.forName(SQLITE_CLASS_NAME);
        String url = MessageFormat.format(SQLITE_URL_PATTERN,filePath);
        return DriverManager.getConnection(url);
    }

    public static Connection createMySQLConnection(String url,String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_CLASS_NAME);
        return DriverManager.getConnection(url,username,password);
    }

    public static Connection createMySQLConnection(String host,String database,String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_CLASS_NAME);
        String url = MessageFormat.format(MYSQL_URL_NOPORT_PATTERN,host,database);
        return DriverManager.getConnection(url,username,password);
    }

    public static Connection createMySQLConnection(String host,String port, String database,String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(MYSQL_CLASS_NAME);
        String url = MessageFormat.format(MYSQL_URL_PATTERN,host,port,database);
        return DriverManager.getConnection(url,username,password);
    }

    public static Connection createOracleConnection(String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(ORACLE_CLASS_NAME);
        return DriverManager.getConnection(url,username,password);
    }

    public static Connection createOracleConnection(String host,String database, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(ORACLE_CLASS_NAME);
        String url = MessageFormat.format(ORACLE_URL_PATTERN,host,database);
        return DriverManager.getConnection(url,username,password);

    }

    public static void releaseConnection(Connection conn){
        try{
            if(conn!=null && !conn.isClosed()){conn.close();conn = null;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void releaseConnection(Connection conn, PreparedStatement stmt){
        try{
            if(stmt!=null){stmt.close(); stmt = null;}
            if(conn!=null && !conn.isClosed()){conn.close(); conn = null;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void releaseConnection(Connection conn, PreparedStatement stmt , ResultSet rs){
        try{
            if(rs!=null){rs.close(); stmt = null;}
            if(stmt!=null){stmt.close(); stmt = null;}
            if(conn!=null && !conn.isClosed()){conn.close();conn = null;}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
