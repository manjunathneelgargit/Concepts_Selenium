package extentReports_Parallel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Script extends Base
{
	@Test(dataProvider = "getAllDataFromExcel")
	public void createContact(String firstName, String lastName)
	{
		ExtentConfig.createTest(getClass().getName()); //Calling createTest() of ExtentConfig class
		System.out.println(firstName+"\t"+lastName);
		ExtentConfig.getExtentTest().pass("Used data => { "+firstName+", "+lastName+"}"); //This is extent log
	}
	
	@DataProvider(parallel=true)
	public Object[][] getAllDataFromExcel()
	{
		Workbook wb = null;
		try 
		{
			FileInputStream ip = new FileInputStream("./src/extentReports_Parallel/Contacts.xlsx");
			wb = WorkbookFactory.create(ip);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		Sheet sh = wb.getSheet("Contacts");
		int rowNum = sh.getLastRowNum();
		int cellNum = sh.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowNum][cellNum];

		for(int i=0;i<rowNum;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
