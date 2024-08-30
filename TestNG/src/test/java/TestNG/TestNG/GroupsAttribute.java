package TestNG.TestNG;
import org.testng.annotations.*;
public class GroupsAttribute {

	@Test(groups="software company")
	public void Infosys()
	{
		System.out.println("Infosys");
	}
	
	@Test(groups="software company")
	public void Wipro()
	{
		System.out.println("Wipro");
	}
	
	@Test(groups="Automobile company")
	public void Tata()
	{
		System.out.println("Tata");
	}
	
	@Test(groups="Automobile company")
	public void Maruti()
	{
		System.out.println("Maruti");
	}
}
