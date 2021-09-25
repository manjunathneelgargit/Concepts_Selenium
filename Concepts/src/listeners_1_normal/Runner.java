package listeners_1_normal;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners_1_normal.ListenerImp.class)
public class Runner 
{
	@Test
	public void TestCase()
	{
		System.out.println("Sample Test Case");
	}
}
