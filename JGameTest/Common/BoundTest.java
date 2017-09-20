package JGameTest.Common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import JGame.RenderSystem.Display.Calculation.Bound;
import JGame.RenderSystem.Math.Vector2;

public class BoundTest {

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
	public void test1() {
		
		Bound bound=new Bound();
		bound.addVector2(new Vector2(100, 100));
		bound.addVector2(new Vector2(-100, 100));
		bound.addVector2(new Vector2(0, -100));
		
		assertEquals("Bound [x=-100.0, y=-100.0, width=200.0, height=200.0]", bound.toString());
	}
	
	
	@Test
	public void test2() {
	
		Bound bound=new Bound();
		bound.addVector2(new Vector2(100, 100));
		bound.addVector2(new Vector2(-100, 100));
		
		Bound bound2=new Bound();
		bound2.addVector2(new Vector2(300, 300));
		
		bound.addBound(bound2.toRect());
		
		assertEquals("Bound [x=-100.0, y=0.0, width=400.0, height=300.0]", bound.toString());
	}

}
