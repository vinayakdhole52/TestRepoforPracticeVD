package TestNG.TestNG;

import org.testng.annotations.DataProvider;

public class DataProviderMethod {

		@DataProvider(name="searchDataSet")
		public Object[][] searchdata()
		{
			Object[][] searchkeyword=new Object[3][2];
			searchkeyword[0][0]="India";
			searchkeyword[0][1]="Qutub Minar";
			
			searchkeyword[1][0]="Agra";
			searchkeyword[1][1]="taj Mahal";
			
			searchkeyword[2][0]="Hyderabad";
			searchkeyword[2][1]="Charminar";
			
			return searchkeyword;
		}

	
	
}
