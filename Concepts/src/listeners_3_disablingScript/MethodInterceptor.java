package listeners_3_disablingScript;

import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor
{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> method, ITestContext arg1) {
		
		//return null; return null if you son't want to disable any scripts
		
		List<IMethodInstance> ins = new ArrayList<IMethodInstance>();
		ins.add(method.get(0)); //It runs only 1st method of all methods
		return ins;
		
	}

}
