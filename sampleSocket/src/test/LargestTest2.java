package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Largest;

public class LargestTest2 {

	@Test
public void test(){
	//int max = Largest.largest(new int[]{7,8,9});
	//System.out.println(max);
	assertEquals(9,Largest.largest(new int[]{7,8,9}));
}
}
