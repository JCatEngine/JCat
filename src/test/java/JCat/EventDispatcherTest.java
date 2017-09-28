package JCat;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import JCat.Event.EventDispatcher;

public class EventDispatcherTest {

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
	public void addRemoveTest() {
		
		EventDispatcher eventDispatcher=new EventDispatcher();
		eventDispatcher.addEventListener("test",e->System.out.println(e),0);
		eventDispatcher.addEventListener("test",e->System.out.println(e),2);
		
		int result=eventDispatcher.removeEventListener("test");
		
		assertEquals(2, result);
	}

}
