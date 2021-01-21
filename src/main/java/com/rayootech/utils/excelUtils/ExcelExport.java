package com.rayootech.utils.excelUtils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luchunfang
 * @version 1.0
 * @created 2020/11/10 16:44
 */
public class ExcelExport {

    /**
     * 根据传入的路径，判断excel 的格式
     *
     * @param filePath
     * @return Workbook
     */
    public Workbook readExcel(String filePath) {
        System.out.println(filePath);
        Workbook wb = null;
        String extString = filePath.substring(filePath.lastIndexOf("."));
        System.out.println(extString);
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".contains(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return wb = null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将信息插入excel文件的方式
     */
//    public void insertExcel(String filePath, List<Staffinfo> list) {
//        ExcelExport excelExport = new ExcelExport();
//        Workbook wb = excelExport.readExcel(filePath);
//        System.out.println("-----------");
//        System.out.println(wb);
//        System.out.println("-----------");
//        //加载sheet
//        Sheet sheet = wb.getSheetAt(0);
//        System.out.println(sheet.getSheetName());
//        //加载行
//        Row row = sheet.getRow(1);
//        FileOutputStream out = null;
//        try {
//            out = new FileOutputStream(filePath);
//        } catch (Exception e) {
//        }
//        while (out == null) {
//            try {
//                out = new FileOutputStream(filePath);
//            } catch (Exception e) {
//            }
//        }

        //写入数据
//        for (int i = 0; i < list.size() ; i++) {
//            sheet.shiftRows(i+1, sheet.getPhysicalNumberOfRows()+1, 1,true,false);
//            row = sheet.createRow(i+1);
//            row.createCell(0).setCellValue(list.get(i).getProCode());
//            row.createCell(1).setCellValue(list.get(i).getProName());
//            row.createCell(2).setCellValue(list.get(i).getWorkerName());
//            row.createCell(3).setCellValue(list.get(i).getWorkerCode());
//            row.createCell(4).setCellValue(String.valueOf(list.get(i).getOutSour()));
//            row.createCell(5).setCellValue(list.get(i).getOutSourfirm());
//            if(list.get(i).getManagFactor()!= null){
//                row.createCell(6).setCellValue(String.valueOf(list.get(i).getManagFactor()));
//            }else{
//                row.createCell(6).setCellValue("");
//            }
//            System.out.println(list.get(i).getPosition());
//            row.createCell(7).setCellValue(list.get(i).getPosition());
//            row.createCell(8).setCellValue(String.valueOf(list.get(i).getInSalary()));
//            row.createCell(9).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getInTime()));
//            if(list.get(i).getOutTime()!=null){
//                row.createCell(10).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(list.get(i).getOutTime()));
//            }else {
//                row.createCell(10).setCellValue("");
//            }
//
//            row.createCell(12).setCellValue(list.get(i).getOutReason());
//            row.createCell(13).setCellValue(list.get(i).getInReview());
//
//        }
//        try {
//            out.flush();
//            wb.write(out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
