package extentReports_In_Framework_Listeners_Scrnsht;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

// Used to execute only selected scripts (methods which are added in List<IMethodInstance> will only be executed)
public class MethodInterceptor implements IMethodInterceptor
{
	//IMethodInterceptor will be called only once for entire suite, 
	//that is why it is providing us List<IMethodInstance> and that's why we need to read all methods at once

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext arg1) {

		//return null; return null if you don't want to disable any scripts

		List<IMethodInstance> result = new ArrayList<IMethodInstance>(); //This List will store which all scripts to be executed in runtime

		List<Map<String, String>> list = FileUtils.readDataFromExcel();
		System.out.println(list);
		for(int i=0; i<methods.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestCaseName")))
				{
					//Enable those scripts which are defined as Yes in excel
					if(list.get(j).get("Execute?").equalsIgnoreCase("Yes"))
					{
						//Set Invocation count
						methods.get(i).getMethod().setDescription(list.get(j).get("Description"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Invocation count")));
						result.add(methods.get(i)); //add the script
					}
				}
			}
		}
		return result;
	}

}
