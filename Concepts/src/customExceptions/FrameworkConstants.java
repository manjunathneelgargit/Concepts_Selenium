package customExceptions;

public final class FrameworkConstants 
{
	private static final String extentConfigPropPath = "./src/customAnnotation/extentConfig.properties";
	private static final String extentReportHtmlPath = "./extent-test-output/index";

	public static String getExtentconfigproppath() 
	{
		return extentConfigPropPath;
	}
	
	public static String getExtentFilePath() 
	{
		//Override extent report html file => Yes -> It will override the old file with new file
		if(FileUtils.getDataFromProperties("overridereports").equalsIgnoreCase("yes"))
		{
			return extentReportHtmlPath+".html";
		}
		//Override extent report html file => No -> It will not override the old file with new file, instead it will create a new file
		else
		{
			return extentReportHtmlPath+"_"+System.currentTimeMillis()+".html";
		}
	}

	public static String getExtentreporthtmlpath() {
		return extentReportHtmlPath;
	}
	
}
