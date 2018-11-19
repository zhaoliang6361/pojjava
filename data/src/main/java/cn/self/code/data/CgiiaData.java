package cn.self.code.data;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

/**
 * 地理标志数据加工
 */
public class CgiiaData {

    public static void main(String[] args){
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File("E:/works/地理标志/地理标志数据库（2018.11.13更新）.xls"));
            Sheet sheet = workbook.getSheetAt(0);
            for(int i=1;i<=sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);
                String name = row.getCell(1).getStringCellValue();
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(workbook!=null){
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
    }
}
