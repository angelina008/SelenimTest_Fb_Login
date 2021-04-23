package login.checkups;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	private static String email;
	private static String pass;
	private static String URL = "https://www.facebook.com/";

	@Test  //T1
	public void test() {
		email = "aGD@HASD.SAB";
		pass = "ajhsgfudvC";
		assertEquals(AppLogin.login(email,pass), "Succesful Login " + URL);
	}
	@Test  //T2
	public void test2() {
		email = null;
		pass = "jsuefuyWE";
		assertEquals(AppLogin.login(email,pass), "Succesful Login" + URL);
	}
	@Test  //T3
	public void test3() {
		email = "valid_email@gmail.com";
		pass = "ValidPass12#";
		URL = "https://www.facebook.com/";
		String []tmp = AppLogin.login(email,pass).split(" ");
		assertEquals(tmp[2], URL);
	}

}
