package extentReports_In_Framework_Listeners_Scrnsht;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils 
{
	private static FileInputStream ip;
	public static String getDataFromProperties(String key)
	{
		Properties prop = null;
		try
		{
			ip = new FileInputStream(FrameworkConstants.getExtentconfigproppath());
			prop = new Properties();
			prop.load(ip);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(Objects.nonNull(ip))
			{
				try {
					ip.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(key);
	}

	//Read all data from excel and store in List
	public static List<Map<String, String>> readDataFromExcel()
	{
		Workbook wb = null;
		Sheet sh = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./src/extentReports_In_Framework_Listeners_Scrnsht/ScriptControl.xlsx");
			wb = WorkbookFactory.create(ip);
			sh = wb.getSheet("Sheet1");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		int rowCount = sh.getLastRowNum();
		int cellCount = sh.getRow(0).getLastCellNum();

		List<Map<String, String>> ls = new ArrayList<>(); //Needed to store all the maps in list
		Map<String, String> map = null; //Needed to Store the data in key value pair

		for(int i=0;i<rowCount;i++)
		{
			map = new LinkedHashMap<>();
			for(int j=0;j<cellCount;j++)
			{
				String key = sh.getRow(0).getCell(j).getStringCellValue();
				String value = sh.getRow(i+1).getCell(j).getStringCellValue();
				map.put(key, value);
			}
			ls.add(map);
		}
		return ls;
	}
}
