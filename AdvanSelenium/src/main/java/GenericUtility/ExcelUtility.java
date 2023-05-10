package GenericUtility;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getExceldata(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet1 = book.getSheet("Organisation");
		Row row = sheet1.getRow(1);
		Cell cel = row.getCell(2);
		String Exceldata = cel.getStringCellValue();
		return Exceldata;
	}
	
	public String getExcelDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		 FileInputStream fes=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	        Workbook book = WorkbookFactory.create(fes);
	        DataFormatter format=new DataFormatter();
	       String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	        return data;
		
}

}
