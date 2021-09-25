package listeners_RetryAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer
{
	//IAnnotationTransformer will be called everytime when a test method is called and 
	//it will give only one method at once
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		List<Map<String, String>> list = ReadDataFromExcel.readDataFromExcel();
		
		for(int i=0;i<list.size();i++)
		{
			if(testMethod.getName().equalsIgnoreCase(list.get(i).get("TestCaseName")))
			{
				if(list.get(i).get("Execute?").equalsIgnoreCase("No"))
				{
					annotation.setEnabled(false);// it is like @Test(enabled="false") 
				}
				else
				{
					//Set Invocation count
					//methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Invocation count")));
					annotation.setRetryAnalyzer(Retry.class); //Setting Retry analyzer
				}
				
			}
		}
	}

	
}
