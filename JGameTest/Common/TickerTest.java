package JGameTest.Common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import JGame.Common.Ticker;
import JGame.Common.Ticker.OnResponceListener;

public class TickerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Ticker ticker=new Ticker(100);
		ticker.start();
		ticker.stop();
		ticker.close();
		
	}

}
