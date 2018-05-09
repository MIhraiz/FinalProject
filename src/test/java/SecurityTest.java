import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.Security;

public class SecurityTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testencrypt() {
		String s = Security.encrypt("a");
		assertEquals("b", s);	
	}

	@Test
	public void testdecrypt() {
		String s = Security.decrypt("b");
		assertEquals("a", s);
	}
}
