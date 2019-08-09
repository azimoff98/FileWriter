package com.education.files.util;

import com.education.files.model.Error;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileCreator {

    public static void writeExcelFile(List<Error> errorList, String excelFilePath){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        createHeaderRow(sheet);

        int rowCount = 0;

        for (Error error : errorList){
            Row row = sheet.createRow(++rowCount);
            writeError(error, row);
        }
        try(FileOutputStream outputStream = new FileOutputStream(excelFilePath)){
            workbook.write(outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void createHeaderRow(Sheet sheet){
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short)16);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cellMessage = row.createCell(1);

        cellMessage.setCellStyle(cellStyle);
        cellMessage.setCellValue("Message");

        Cell cellValue = row.createCell(2);
        cellValue.setCellStyle(cellStyle);
        cellValue.setCellValue("Value");

        Cell cellSubscriptionId = row.createCell(3);
        cellSubscriptionId.setCellStyle(cellStyle);
        cellSubscriptionId.setCellValue("Subscription ID");
    }

    public static void writeError(Error error, Row row){
        Cell cell = row.createCell(1);
        cell.setCellValue(error.getMessage());
        cell = row.createCell(2);
        cell.setCellValue(error.getValue());
        cell = row.createCell(3);
        cell.setCellValue(error.getSid());
    }
}
