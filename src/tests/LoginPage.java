package tests;

import org.testng.annotations.Test;
import base.Base;

public class LoginPage extends Base {

public LoginPage() {
	super.setup();
}

@Test
	public void goTo() {
		driver.get(properties.getProperty("url"));
	}

}