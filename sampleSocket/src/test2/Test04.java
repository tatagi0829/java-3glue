package test2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import util.Largest;

@RunWith(Parameterized.class)
public class Test04 {
	 int result;
	    int[] params;
	    
	    @Parameters
	    public static Collection data(){
	    	return Arrays.asList(new Object[][]{
	    		{2222,new int[]{5,66,88,44,55,99,2222}},
	    		{-5,new int[]{-5,-66,-88,-44,-55,-99,-2222}},
	    		{2222,new int[]{2222,66,88,44,55,99,2222}}
	    	} );
	    }
		
		public Test04(int result, int[] params) {
			this.result = result;
			this.params = params;
		}

		@Test
		public void largestTest(){
			System.out.println(result);
			System.out.println(Arrays.toString(params));
			assertEquals(result,Largest.largest(params));
		}

}
