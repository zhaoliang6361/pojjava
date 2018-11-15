package cn.self.code.data;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoliang on 2018/11/15.
 * 高价值专利数据加工
 */
public class HighFigureData {

    /**
     * 取得MySQL连接
     * @return
     */
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://192.168.0.201:3306/topic8?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "root";
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Test
    public void updateTopicNodeLevel() throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
            List<Integer> list  = selectChildList(conn,0);

            for(Integer id : list){
                updateLevel(conn,id, 1);
                List<Integer> level2List = selectChildList(conn,id);
                for(Integer level2id : level2List){
                    updateLevel(conn, level2id,2);
                    List<Integer> level3List = selectChildList(conn,level2id);
                    for(Integer level3id : level3List){
                        updateLevel(conn, level3id,3);
                        List<Integer> level4List = selectChildList(conn,level3id);
                        for(Integer level4id : level4List){
                            updateLevel(conn, level4id,4);
                            List<Integer> level5List = selectChildList(conn,level4id);
                            for(Integer level5id : level5List){
                                updateLevel(conn, level5id,5);
                            }
                        }
                    }
                }
            }

//            for(int i=0;i<6;i++){
//                if(list==null){
//                    list= selectChildList(conn,0);
//                }
//            }
//            PreparedStatement stmt = conn.prepareStatement("SELECT  id from tb_topic WHERE  pid=0");
//            ResultSet resultSet = stmt.executeQuery();
//            int root = 0;
//            while(resultSet.next()){
//                root = resultSet.getInt(1);
//                System.out.println(root);
//            }
//            resultSet.close();
//            stmt.close();
//            stmt = conn.prepareStatement("update tb_topic SET is_leaf=1 WHERE id="+root);
//            stmt.executeUpdate();
//            stmt.close();
//            List<Integer> oneList =
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(conn!=null){
                conn.close();
            }
        }
    }

    public List<Integer> selectChildList(Connection conn, int parent) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select id from tb_topic where pid=?");
        stmt.setInt(1,parent);
        List<Integer> list = new ArrayList<Integer>();
        ResultSet resultset = stmt.executeQuery();
        while(resultset.next()){
            list.add(resultset.getInt(1));
        }
        resultset.close();
        stmt.close();
        return list;
    }

    public void updateLevel(Connection conn, int id, int level) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("update tb_topic set is_leaf=? where id=?");
        stmt.setInt(1,level);
        stmt.setInt(2,id);
        stmt.executeUpdate();
        stmt.close();
    }
}
