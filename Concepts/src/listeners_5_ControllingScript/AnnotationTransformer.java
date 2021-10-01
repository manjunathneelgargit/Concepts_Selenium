package listeners_5_ControllingScript;

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

		for(int i=0;i<list.size();i++){

			if(testMethod.getName().equalsIgnoreCase(list.get(i).get("TestCaseName"))){

				if(list.get(i).get("Execute?").equalsIgnoreCase("No")){

					annotation.setEnabled(false);// it is like @Test(enabled="false")
				}
				else{

					//Set Invocation count
					annotation.setDescription(list.get(i).get("Description"));

					//Set Invocation count
					annotation.setInvocationCount(Integer.parseInt(list.get(i).get("Invocation count")));

					//Set Groups
					String[] strArray = null;
					String groups = list.get(i).get("Groups").replaceAll(" ", "");
					if(groups.contains(",")) {
						strArray = groups.split(",");
					}
					else {
						strArray = new String[1];
						strArray[0] = groups;
					}
					annotation.setGroups(strArray);
				}
				break;

			}
		}
	}


}
