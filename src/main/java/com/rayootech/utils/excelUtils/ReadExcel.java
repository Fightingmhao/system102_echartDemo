package com.rayootech.utils.excelUtils;


import com.rayootech.bean.Organization;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/13 12:12
 */
public class ReadExcel {
//    private Logger logger = LoggerFactory.getLogger(ReadExcel.class);
    private Workbook wb;
    private Sheet sheet;
    private Row row;

    public ReadExcel(MultipartFile file) {
        String filepath = file.getOriginalFilename();
        if(filepath==null){
            return;
        }
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = file.getInputStream();
            if(".xls".equals(ext)){
                wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(ext)){
                wb = new XSSFWorkbook(is);
            }else{
                wb=null;
            }
        } catch (FileNotFoundException e) {
//            logger.error("FileNotFoundException", e);
            System.out.println("没有找到该文件");
        } catch (IOException e) {
            System.out.println("出错了");
//            logger.error("IOException", e);
        }
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        // 以下是判断数据的类型
        switch (cell.getCellType()) {
            case 0: // 数字
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                } else {
                    DataFormatter dataFormatter = new DataFormatter();
                    cellValue = dataFormatter.formatCellValue(cell);
                }
                break;
            case 1: // 字符串
                cellValue = cell.getStringCellValue();
                break;
            case 4: // Boolean
                cellValue = cell.getBooleanCellValue() + "";
                break;
            case 2: // 公式
                cellValue = cell.getCellFormula() + "";
                break;
            case 3: // 空值
                cellValue = "";
                break;
            case 5: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public List<Organization> getValue() throws ParseException {
        List<String> list = null;
        List<Organization> list2 = new ArrayList<>();
        Organization Organization = null;

        if (wb != null) {
            //获取Excel表的数量
            int numberOfSheets = wb.getNumberOfSheets();
            //遍历Excel表
            for (int i = 0; i < numberOfSheets; i++) {
                sheet = wb.getSheetAt(i);
                //获取Excel表中的行数
                int numberOfRows = sheet.getPhysicalNumberOfRows();
                //遍历行
                for (int j = 1; j < numberOfRows; j++) {
                    row = sheet.getRow(j);
                    //获取每行的列数
                    //int numberOfCells = row.getPhysicalNumberOfCells();
                    int numberOfCells = row.getLastCellNum() + 1;
                    list = new ArrayList<String>();
                    //遍历列
                    for (int k = 0; k < numberOfCells; k++) {
                        String value = "";
                        try{
                            value = ReadExcel.getCellValue(row.getCell(k));
                            list.add(value);
                        }catch (Exception e){

                        }


                    }
                    System.out.println("list:" + list);

                    Organization = new Organization(list.get(0),list.get(1),list.get(2),list.get(3),list.get(4),list.get(5),list.get(6),list.get(7));

                    list2.add(Organization);
//                    System.out.println("list2:"+list2);

                }
            }
        }
        return list2;
    }



}
