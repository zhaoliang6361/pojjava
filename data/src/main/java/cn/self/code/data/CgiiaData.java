package cn.self.code.data;

import com.sun.javafx.binding.StringFormatter;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 地理标志数据加工
 * @author zhaoliang
 */
public class CgiiaData {

    public static void main(String[] args){
        Workbook workbook = null;
        BufferedWriter writer = null;
        try {
            workbook = WorkbookFactory.create(new File("E:/works/地理标志/地理标志数据库（2018.11.13更新）.xls"));
            Sheet sheet = workbook.getSheetAt(0);
            //质检数据
            Map<String,String> qMap = new HashMap<String, String>();
            //商标数据
            Map<String,String> mMap = new HashMap<String, String>();
            //农业数据
            Map<String,String> aMap = new HashMap<String, String>();
            Connection conn = null;
            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/works/地理标志/update.sql"),true),"UTF-8"));
                conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement("select title,code from tb_agriculture");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    aMap.put(rs.getString(1),rs.getString(2));
                }
                rs.close();
                stmt.close();
                stmt = conn.prepareStatement("select title, code from tb_quality");
                rs = stmt.executeQuery();
                while(rs.next()){
                    qMap.put(rs.getString(1),rs.getString(2));
                }
                rs.close();
                stmt.close();
                stmt = conn.prepareStatement("select title, code,registion_number from tb_trade_mark");
                rs = stmt.executeQuery();
                while(rs.next()){
                    mMap.put(rs.getString(1)+"_"+rs.getString(3),rs.getString(2));
                }
                rs.close();
                stmt.close();
            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                if(conn!=null){
                    conn.close();
                }
            }
            int anum=0, mnum=0,qnum=0;
            int idx1 = 2498;
            int idx2 =  3625;
            int idx3 = 2117;
            String pattern1 = "insert into tb_quality(code,title,register_unit,approve_date,approve_notice,province,city,district,class_1,class_2,class_3) values({0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10});";
            String pattern2 = "insert into tb_trade_mark(code,title,registrant,approve_date, registion_number,province,city,district,class_1,class_2,class_3) values({0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10});";
            String pattern3 = "insert into tb_agriculture(code,title,applicant,approve_date,pub_code,province,city,district,class_1,class_2,class_3) values({0},{1},{2},{3},{4},{5},{6},{7},{8},{9},{10});";
            for(int i=1;i<=sheet.getLastRowNum();i++){
//                System.out.println(i);
                Row row = sheet.getRow(i);
                String name = row.getCell(1).getStringCellValue();
                String unit = row.getCell(2).getStringCellValue();
                String depart = row.getCell(3).getStringCellValue();
                String year = "";
                if(row.getCell(4)!=null){
                  if(row.getCell(4).getCellTypeEnum()== CellType.STRING){
                      year = row.getCell(4).getStringCellValue();
                  }  else {
                      year = Math.round(row.getCell(4).getNumericCellValue()) + "" ;
                  }
                }
                String num = "";
                if(row.getCell(6)!=null){
                    if(row.getCell(6).getCellTypeEnum()== CellType.STRING){
                        num = row.getCell(6).getStringCellValue();
                    }  else if(row.getCell(6).getCellTypeEnum()!=CellType.ERROR){
                        num = Math.round(row.getCell(6).getNumericCellValue()) + "" ;
                    }
                }
                String country = row.getCell(7).getStringCellValue();
                String province = row.getCell(8).getStringCellValue();
                String city = row.getCell(9).getStringCellValue();
                String district = row.getCell(10).getStringCellValue();

                String cls_1 = row.getCell(11).getStringCellValue();
                String cls_2 = row.getCell(12).getCellTypeEnum()!= CellType.ERROR ? row.getCell(12).getStringCellValue() : "";
                String cls_3 = row.getCell(13).getCellTypeEnum()!= CellType.ERROR ? row.getCell(13).getStringCellValue() : "";

                Set<String> qSet = qMap.keySet();
                Set<String> mSet = mMap.keySet();
                Set<String> aSet = aMap.keySet();
                if(country.equals("中国")){
                    if(depart.equals("质检总局") || depart.equals("国家知识产权局")){
                        if(!qSet.contains(name)){
                            qnum++;
                            idx1++;
                            String code = 100000 + idx1 + "";
                            String sql = MessageFormat.format(pattern1,"'"+code+"'","'"+name+"'","'"+unit+"'","'"+year+"'","'"+num+"'","'"+province+"'","'"+city+"'","'"+district+"'","'"+cls_1+"'","'"+cls_2+"'","'"+cls_3+"'");
                            writer.write(sql + System.getProperty("line.separator"));
                            writer.flush();
                        }
                    } else if(depart.equals("工商总局")){
                        System.out.println(name+"_" + num);
                        if(!mSet.contains(name + "_" + num)){
                            mnum++;
                            idx2++;
                            String code = 200000 + idx2 + "";
                            String sql = MessageFormat.format(pattern2,"'"+code+"'","'"+name+"'","'"+unit+"'","'"+year+"'","'"+num+"'","'"+province+"'","'"+city+"'","'"+district+"'","'"+cls_1+"'","'"+cls_2+"'","'"+cls_3+"'");
                            writer.write(sql+ System.getProperty("line.separator"));
                            writer.flush();
                        }
                    } else if(depart.equals("农业部")){
                        if(!aSet.contains(name)){
                            anum++;
                            idx3++;
                            String code = 300000 + idx3 + "";
                            String sql = MessageFormat.format(pattern3,"'"+code+"'","'"+name+"'","'"+unit+"'","'"+year+"'","'"+num+"'","'"+province+"'","'"+city+"'","'"+district+"'","'"+cls_1+"'","'"+cls_2+"'","'"+cls_3+"'");
                            writer.write(sql + System.getProperty("line.separator"));
                            writer.flush();
                        }
                    }else {

                    }

                }

//                System.out.println(name);
            }

            System.out.println("质检"+qMap.size() + " | " + qnum);
            System.out.println("商标"+mMap.size() + " | " + mnum);
            System.out.println("农业"+aMap.size() + " | " + anum);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(workbook!=null){
                    workbook.close();
                }
                if(writer!=null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    /**
     * 取得MySQL连接
     * @return
     */
    private static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/cgiia?useUnicode=true&characterEncoding=utf-8";
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
    public void strPattern(){
        String pattern = "insert into table '{0}', value {1}";
        String str = MessageFormat.format(pattern,"'北京'","'上海'");
        System.out.println(str);
    }
}
