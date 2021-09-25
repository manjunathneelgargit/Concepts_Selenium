package dataProviders;

import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutColumnNames 
{

	@Test(dataProvider = "readAllDataExcel")
	public void testScript(Map<String, Object> map)
	{
		System.out.println(map.get("Prod_Name"));
	}
	
	@DataProvider
	/* Read all data from excel with Hash map */
	public static Object[] readAllDataExcel()
	{
		Workbook wb = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./testDataFiles/TestData.xlsx");
			wb = WorkbookFactory.create(ip);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		Sheet sh = wb.getSheet("Products");
		int rowNum = sh.getLastRowNum();
		int cellNum = sh.getRow(0).getLastCellNum();

		Object[] data = new Object[rowNum];
		Map<String, Object> map;

		for(int i=0;i<rowNum;i++)
		{
			map = new LinkedHashMap<>(); //Create new map object for every row
			for(int j=0;j<cellNum;j++)
			{
				String key = sh.getRow(0).getCell(j).getStringCellValue();//get every column names and store as key
				String value = sh.getRow(i+1).getCell(j).getStringCellValue();//get every row data and store as a values
				map.put(key, value);// insert key and value in map
				data[i] = map; //load map object which has key and value in array
			}
		}
		return data;
	}
}
