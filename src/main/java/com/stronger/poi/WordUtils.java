package com.stronger.poi;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  16:13 2018/7/5
 * @ModefiedBy:
 */
public class WordUtils {
    public static void main(String[] args) throws IOException {

        getAllFromRootFile("E:\\留宿学生列表");
    }

    public static List<Map<String,String>> getAllFromRootFile(String rootfile) throws IOException {
        File file=new File(rootfile);
        File []fileList=file.listFiles();
       for (File file1:fileList){
           getDataFromWord(file1.getPath());
       }
       return null;
    }

    public static Map<String,String> getDataFromWord(String filePath) throws IOException {
        FileInputStream fis=new FileInputStream(filePath);
        //如果是office2007  docx格式
      if (filePath.endsWith("docx")){
        XWPFDocument xwpdf=new XWPFDocument(fis);
        List<XWPFTable> tableList=xwpdf.getTables();
         XWPFTable xwpfTable=tableList.get(0);
          List<XWPFTableRow> rowList= xwpfTable.getRows();
         String text1=rowList.get(0).getCell(0).getText();
          String text2=rowList.get(0).getCell(1).getText();
          System.out.println(" text1  "+text1+"  text2  "+ text2);
      }else{
          //如果是office2003  doc格式

//          POIFSFileSystem poifsFileSystem=new POIFSFileSystem(fis);
          HWPFDocument hwpfDocument=new HWPFDocument(fis);
          Range range=hwpfDocument.getRange();
          TableIterator tableIterator=new TableIterator(range);
          while (tableIterator.hasNext()){
                  Table table=tableIterator.next();
             String docText1= table.getRow(0).getCell(1).text();
              String docText2= table.getRow(0).getCell(3).text();
              String docText3= table.getRow(0).getCell(5).text();
              String docText4= table.getRow(1).getCell(1).text();
              String docText5= table.getRow(1).getCell(3).text();
              String docText6= table.getRow(2).getCell(1).text();
              String docText7= table.getRow(2).getCell(3).text();
              String docText8= table.getRow(3).getCell(1).text();
              StringBuilder sb=new StringBuilder("");
              for(String str:docText8.trim().split("")){
                  if (!str.equals(" ")){
                      sb.append(str);
                  }
              }
              String docText9= table.getRow(5).getCell(1).text();
              String docText10= table.getRow(5).getCell(3).text();

              System.out.println(" 从  "+filePath+"  文件读取数据 ");
              System.out.println(" 姓名  "+docText1);
              System.out.println(" 性别  "+docText2);
              System.out.println(" 政治面貌  "+docText3);
              System.out.println(" 院系  "+docText4);
              System.out.println(" 专业  "+docText5);
              System.out.println(" 联系电话  "+docText6);
              System.out.println(" 住宿时间  "+docText7);
              System.out.println(" 住宿位置  "+sb.toString());
              System.out.println(" 家庭联系人  "+docText9);
              System.out.println(" 电话  "+docText10);
          }
      }
      return null;
    }
}
