/**
 * 
 */
package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Manohar.Khot
 *
 */
public class ReadWriteExcelFile {

	public static List<List<String>> ReadExcelFile(String filePath, String fileName, String sheetName) throws IOException {

		/// filePath =
		/// "F:\\ManoharK\\ProjectWork\\Seleniumworkspace\\i2QAutomation\\src\\test\\resources\\DataFiles";

		// filePath = System.getProperty("user.dir") +
		// "\\src\\test\\resources\\DataFiles";
		// fileName = "i2QMasterData.xlsx";
		// sheetName = "Area";

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {

			guru99Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {

			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet MasterData = guru99Workbook.getSheet(sheetName);
		List<List<String>> arrOfList = new ArrayList<List<String>>();
		
		int rowCount = MasterData.getLastRowNum() - MasterData.getFirstRowNum();
		
		
		for (int i = 0; i < rowCount + 1; i++) {

			Row row = MasterData.getRow(i);
			List<String> arrName = new ArrayList<String>();
			for (int j = 0; j < row.getLastCellNum(); j++) {

				if (row.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					arrName.add(String.valueOf(row.getCell(j).getNumericCellValue()));	
				}
				else if (row.getCell(j).getCellType()==Cell.CELL_TYPE_STRING)
				{
					arrName.add(row.getCell(j).getStringCellValue());	
				}
				else 
				{
					arrName.add(row.getCell(j).getStringCellValue());	
				}
				//System.out.print(row.getCell(j).getStringCellValue() + "|| ");
				
			}
			System.out.println(" ");
			//System.out.println(arrName);
			System.out.println("Size of the arrayList: "+arrOfList.size() + ">>" + arrName.size());
			arrOfList.add(arrName);
			
		}
		
		/* Working:: Loop excel using iterator
		 Iterator<Row> rowIterator = MasterData.iterator();
         while (rowIterator.hasNext()) 
         {
             Row row = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = row.cellIterator();

             while (cellIterator.hasNext()) 
             {
                 Cell cell = cellIterator.next();
                 //Check the cell type and format accordingly
                 switch (cell.getCellType()) 
                 {
                     case Cell.CELL_TYPE_NUMERIC:
                         System.out.print(cell.getNumericCellValue() + "||" + "\t");

                         break;
                     case Cell.CELL_TYPE_STRING:
                         System.out.print(cell.getStringCellValue() +  "||" + "\t");
                         break;
                 }
             }
             System.out.println("");
         }*/
		
		
		/*Working:: Loop excel using for
		for (int i = 1; i < arrOfList.size(); i++) {
			for (int j = 0; j < arrOfList.get(i).size(); j++) { 
                System.out.print(arrOfList.get(i).get(j) + " ");
			  } 
			System.out.println(); 
		} */
			
		
		return arrOfList;
		
	}

	public static void ReadExcelFile22(String filePath, String fileName, String sheetName) throws IOException {

		/// filePath =
		/// "F:\\ManoharK\\ProjectWork\\Seleniumworkspace\\i2QAutomation\\src\\test\\resources\\DataFiles";

		// filePath = System.getProperty("user.dir") +
		// "\\src\\test\\resources\\DataFiles";
		// fileName = "i2QMasterData.xlsx";
		// sheetName = "Area";

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {

			guru99Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {

			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

		int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();
		for (int i = 1; i < rowCount + 1; i++) {

			Row row = guru99Sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}
			System.out.println(" ");

		}

	}

	public void WriteExcelFile(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

		filePath = "";
		fileName = "";
		sheetName = "";

		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {

			guru99Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {

			guru99Workbook = new HSSFWorkbook(inputStream);
		}

		// Read excel sheet by sheet name
		Sheet sheet = guru99Workbook.getSheet(sheetName);

		// Get the current count of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	}

}
