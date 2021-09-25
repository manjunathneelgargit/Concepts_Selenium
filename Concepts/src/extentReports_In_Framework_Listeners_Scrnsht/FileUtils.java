package extentReports_In_Framework_Listeners_Scrnsht;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils 
{
	public static String getDataFromProperties(String key)
	{
		Properties prop = null;
		try
		{
			FileInputStream ip = new FileInputStream(FrameworkConstants.getExtentconfigproppath());
			prop = new Properties();
			prop.load(ip);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
