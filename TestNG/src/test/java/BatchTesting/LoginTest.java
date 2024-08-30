package BatchTesting;

import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void LoginByMobileNumber() 
	{
		System.out.println("Login by mobile passed");
	}
	
	@Test
	public void LoginByEmail() 
	{
		System.out.println("Login by email passed");
	}
	
	
}
