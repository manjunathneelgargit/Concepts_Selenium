package enums;

public enum EnumWithValues 
{
	IMPLICITWAIT(10), EXPLICITWAIT(20);
	
	// The compiler will treat both above statements as below
	//	private static final Wait IMPLICITWAIT = new WAIT(10);
	//	private static final Wait EXPLICITWAIT = new WAIT(20);
		
	private int waitTime;
	
	private EnumWithValues(int time)
	{
		waitTime = time;
	}
	
	public int getWaitTime()
	{
		return waitTime;
	}
}
