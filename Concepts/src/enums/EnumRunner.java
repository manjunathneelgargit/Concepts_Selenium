package enums;

public class EnumRunner 
{
	public static void main(String[] args) 
	{
		System.out.println(EnumWithValues.IMPLICITWAIT); //IMPLICITWAIT
		System.out.println(EnumWithValues.IMPLICITWAIT.getWaitTime());//10


		//*************ENUMS without values***********
		EnumWithoutValues actualVal = EnumWithoutValues.CRITICAL;

		if(EnumWithoutValues.valueOf("CRITICAL") == actualVal)
		{
			System.out.println("Actual Val => " + actualVal);
		}

	}

}
