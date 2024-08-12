package core;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

	public static String[][] getTableArray(String filePath, boolean isGetFirstRow) {
		String[][] data = null;
		try {
			// doc du lieu tu file data
			FileInputStream fis = new FileInputStream(new File(filePath));

			// chuyen du lieu sang kieu workbook - workbook cung cap cac phuong thuc de lam
			// viec voi excel
			Workbook workbook = new XSSFWorkbook(fis);
			// lay sheet dau tien trong excel
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			data = new String[rows][cols];
			int startRow = 0;

			if (isGetFirstRow == false) {
				startRow = 1;
				data = new String[rows - 1][cols];
			}
			for (int r = startRow; r < rows; r++) {
				Row row = sheet.getRow(r);
				for (int c = 0; c < cols; c++) {
					Cell cell = row.getCell(c);
					if (startRow == 1) {
						data[r - 1][c] = getCellValueAsString(cell);
					} else
						data[r][c] = getCellValueAsString(cell);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		default:
			return "";
		}
	}
}
