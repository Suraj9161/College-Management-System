package com.util.CMS;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
   

    public static void saveDataToExcel(String sheetName, String[] columnNames, Object[][] data) {
        try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\College_Management_System\\College.xlsx")) {
            Sheet sheet = workbook.createSheet(sheetName);

            // Create header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columnNames.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnNames[i]);
            }

            // Fill data rows
            for (int i = 0; i < data.length; i++) {
                Row row = sheet.createRow(i + 1);
                for (int j = 0; j < data[i].length; j++) {
                    Cell cell = row.createCell(j);
                    if (data[i][j] instanceof String) {
                        cell.setCellValue((String) data[i][j]);
                    } else if (data[i][j] instanceof Integer) {
                        cell.setCellValue((Integer) data[i][j]);
                    } else if (data[i][j] instanceof Long) {
                        cell.setCellValue((Long) data[i][j]);
                    } else if (data[i][j] instanceof Double) {
                        cell.setCellValue((Double) data[i][j]);
                    } else if (data[i][j] instanceof Date) {
                        cell.setCellValue((Date) data[i][j]);
                        CellStyle cellStyle = workbook.createCellStyle();
                        CreationHelper createHelper = workbook.getCreationHelper();
                        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));
                        cell.setCellStyle(cellStyle);
                    }
                }
            }

            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[][] readDataFromExcel(String sheetName) {
    	String filePath = "C:\\Users\\Admin\\eclipse-workspace\\College_Management_System\\College.xlsx";

        try (FileInputStream fileIn = new FileInputStream(filePath); 
        		Workbook workbook = new XSSFWorkbook(fileIn)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet with name '" + sheetName + "' does not exist.");
                return new Object[0][0];
            }
            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount <= 1) {
                // No data to read
                return new Object[0][0];
            }
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue; // Skip empty rows
                }
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        data[i - 1][j] = null;
                        continue;
                    }
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                data[i - 1][j] = cell.getDateCellValue();
                            } else {
                                data[i - 1][j] = cell.getNumericCellValue();
                            }
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = cell.getBooleanCellValue();
                            break;
                        default:
                            data[i - 1][j] = null;
                            break;
                    }
                }
            }

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }
}
