package dataProviders;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//https://www.youtube.com/watch?v=NOZ5JQOskxA&list=PL9ok7C7Yn9A_JZFMrhrgEwfqQGiuyvSkB&index=19
public class JSONDataprovider 
{
	@Test(dataProvider = "getData")
	public void testScript(Map<String, Object> map)
	{
		//map.forEach((k,v)->System.out.println(k+" : "+v));
		
						//OR
		
		for(Map.Entry<String, Object> m : map.entrySet())
		{
			System.out.println(m.getKey()+" : "+m.getValue());
		}
	}
	
	@DataProvider
	public Object[] getData() throws Exception
	{
		HashMap<String, Object> map = new ObjectMapper()
				.readValue(new File("./src/dataProviders/JSONFile.json"), 
						new TypeReference<HashMap<String, Object>>() {});
		
		return new Object[] {map};
	}
}
