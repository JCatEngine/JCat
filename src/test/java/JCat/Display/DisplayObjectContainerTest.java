package JCat.Display;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DisplayObjectContainerTest {

	private Sprite container;
	private Sprite child1;
	private Sprite child2;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		container=new Sprite();
		this.child1=new Sprite();
		this.child2=new Sprite();
		container.addChildAll(child1,child2);
	}

	
	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public void testAddChild() {
		Sprite sprite=new Sprite();
		container.addChild(sprite);
		assertEquals(sprite, container.getChildAt(2));
	}

	@Test
	public void testAddChildAt() {
		container.addChildAt(new Sprite(), 2);
		assertEquals(3, container.getChildCount());
		
	}

	@Test
	public void testAddChildAll() {
		container.addChildAll(new Sprite(),new Sprite());
		assertEquals(4, container.getChildCount());
	}

	@Test
	public void testSwapChildren() {
		container.swapChildren(child1, child2);
		assertEquals(child1, container.getChildAt(1));
		assertEquals(child2, container.getChildAt(0));
	}

	@Test
	public void testGetChildAt() {
		assertEquals(child2, container.getChildAt(1));
	}

	@Test
	public void testGetChildIndex() {
		assertEquals(1, container.getChildIndex(child2));
	}

	@Test
	public void testSetChildIndex() {
		container.setChildIndex(child1, 1);
		assertEquals(child1, container.getChildAt(1));
		assertEquals(child2, container.getChildAt(0));
	}

	@Test
	public void testHasChild() {
		assertEquals(true, container.hasChild(child1));
	}

	@Test
	public void testGetChildCount() {
		assertEquals(2, container.getChildCount());
	}

	@Test
	public void testRemoveChild() {
		container.removeChild(child1);
		assertEquals(false, container.hasChild(child1));
	}

	@Test
	public void testRemoveChildAt() {
		container.removeChildAt(0);
		assertEquals(1, container.getChildCount());
	}

	@Test
	public void testRemoveChildAll() {
		container.removeChildAll(child1,child2);
		assertEquals(0, container.getChildCount());
	}

	@Test
	public void testGetChilds() {
		LinkedList<DisplayObject> displayObjects=container.getChilds();
		assertEquals(child1, displayObjects.get(0));
		assertEquals(child2, displayObjects.get(1));
	}

}
