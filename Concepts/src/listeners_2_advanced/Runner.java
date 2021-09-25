package listeners_2_advanced;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Runner 
{
	@BeforeSuite public void bs() { System.out.println("Script before suite");}
	
	@BeforeClass public void bc() { System.out.println("Script before class");}
	
	@BeforeMethod public void bm(){System.out.println("Script before Method");}
	
	@AfterMethod public void am(){System.out.println("Script after method");}
	
	@AfterClass public void ac(){System.out.println("Script after class");}
	
	@AfterSuite public void as(){System.out.println("Script after suite");}
	
	@Test public void testCase1() {System.out.println("Test Case 1");};
	
	@Test public void testCase2() {System.out.println("Test Case 2");};
	
	@Test public void testCase3() {System.out.println("Test Case 3");};
	
}
