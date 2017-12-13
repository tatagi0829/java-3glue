package test;

import junit.framework.TestCase;
import util.Largest;

public class LargestTest3 extends TestCase {

	public LargestTest3(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		System.out.println("setUp()");
	}

	protected void tearDown() throws Exception {
		System.out.println("tearDown()");
	}

	public void testSimple(){
		System.out.println("testSimple()");
		assertEquals(9, Largest.largest(new int[]{9,8,7}));
	}
	public void testOrder(){
		System.out.println("testOrder()");
		assertEquals(9, Largest.largest(new int[]{9,8,7}));
		assertEquals(9, Largest.largest(new int[]{8,9,7}));
		assertEquals(9, Largest.largest(new int[]{8,7,9}));
	}
	public void testDups(){
		System.out.println("testDups()");
		assertEquals(9, Largest.largest(new int[]{9,8,9,7}));
		assertEquals(9, Largest.largest(new int[]{8,9,8,8,7}));
		assertEquals(9, Largest.largest(new int[]{8,7,9,9}));
	}
	public void testNegative(){
		assertEquals(-7, Largest.largest(new int[]{-9,-8,-9,-7}));
		assertEquals(-7, Largest.largest(new int[]{-8,-9,-8,-8,-7}));
		assertEquals(0, Largest.largest(new int[]{-8,-7,0,-9}));
	}
	public void testOne(){
		assertEquals(-7, Largest.largest(new int[]{-7}));
		assertEquals(-8, Largest.largest(new int[]{-8}));
		assertEquals(0, Largest.largest(new int[]{0}));
	}
	public void testEmpty(){
		System.out.println("testEmpty");
		try{
		Largest.largest(new int[]{});
		fail("should be thrown Exception");
		}catch(RuntimeException e){
			assertTrue(true);
		}
	}
}
