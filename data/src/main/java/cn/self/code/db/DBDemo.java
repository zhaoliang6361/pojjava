package cn.self.code.db;

import cn.self.code.util.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhaoliang on 2018/11/21.
 */
    public class DBDemo {

        @Test
        public void sqliteTest(){
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                String path = "D:\\study\\sqlite\\demo.db";
                conn = DBUtil.createSqliteConnect(path);
                stmt = conn.prepareStatement("select * from Employee");
                rs = stmt.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                    System.out.println(rs.getString(3));
                    System.out.println(rs.getString(4));
                    System.out.println(rs.getString(5));
                    System.out.println(rs.getString(6));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally{
                DBUtil.releaseConnection(conn,stmt,rs);
            }
        }
}
