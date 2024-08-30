package BatchTesting;
import org.testng.annotations.*;
public class HomeScreenTest {

	@Test
	public void LaunchApplication() 
	{
		System.out.println("Application launch passed");
	}
	
	@Test
	public void VerifyTitle() 
	{
		System.out.println("Verify title passed");
	}
	
	@Test
	public void VerifyLogo() 
	{
		System.out.println("Verify Logo passed");
	}
	
	
}
