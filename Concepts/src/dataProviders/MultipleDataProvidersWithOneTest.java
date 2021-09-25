package dataProviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleDataProvidersWithOneTest 
{
	@Test(dataProvider = "dataProviderMethod")
	public void TestCase1(String str)
	{
		System.out.println("String =>"+str);
	}

	@Test(dataProvider = "dataProviderMethod")
	public void TestCase2(Integer num1)
	{
		System.out.println("Num 1 =>" + num1);
	}

	@DataProvider
	public Object[] dataProviderMethod(Method m)//Method is a class from JAVA Reflection with the help of which we can read the properties of method in runtime
	{
		if(m.getName().equals("TestCase1"))
		{
			String[] data = new String[3];
			data[0] = "Hi";
			data[1] = "Hello";
			data[2] = "Bye";
			return data;
		}
		else if(m.getName().equals("TestCase2"))
		{
			Integer[] data = new Integer[3];
			data[0] = 1;
			data[1] = 2;
			data[2] = 3;
			return data;
		}
		return null;
			
	}
}
