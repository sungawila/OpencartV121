package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static XSSFCellStyle style;
	String path;
	
	public ExcelUtility(String path) {
		
		this.path=path;
	}
	
	public int getRowCount(String xlsheet) throws IOException {

		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;


	}

	public int getCellCount(String xlsheet, int rownum) throws IOException {

		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;


	}
	public String getCellData(String xlsheet, int rownum, int column) throws IOException {

		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(column);


		String data;

		try 
		{


			//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
			data=formatter.formatCellValue(cell); //Returns a formatted value of a cell as regardless of the cell type
		}
		catch (Exception e) 
		{

			data="";
		}

		wb.close();
		fi.close();
		return data;

	}
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		wb=new XSSFWorkbook();
		fo=new FileOutputStream(path);
		wb.write(fo);
		}
				
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
			
		if(wb.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			wb.createSheet(sheetName);
		ws=wb.getSheet(sheetName);
					
		if(ws.getRow(rownum)==null)   // If row not exists then create new Row
				ws.createRow(rownum);
		row=ws.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}


	public void fillGreenColur(String xlsheet, int rownum, int column) throws IOException {

		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(column);

		style=wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();


	}
	public void fillRedColur(String xlsheet, int rownum, int column) throws IOException {

		fi =new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(column);

		style=wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();


	}

}
