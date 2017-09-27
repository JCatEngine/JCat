package JCatTest.Common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import JCat.RenderSystem.RenderSystem;
import JCat.RenderSystem.Display.Calculation.Transform;
import JCat.RenderSystem.Math.Vector2;

public class TransformTest {

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
		
		
		
		Transform transform=new Transform(1, 1, 45, 1, 1);
		Vector2 vector2=new Vector2(1, 0);
		vector2=transform.apply(vector2);
		
		
		
		assertEquals("[x=1.7071067811865475 y=1.7071067811865475]", vector2.toString());
		
		
	}

}
