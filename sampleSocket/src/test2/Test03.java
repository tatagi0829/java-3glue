package test2;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Test03 {
	   String key;
	    String data;
	    @Parameters
	    public static Collection data(){
	    	return Arrays.asList(new Object[][]{
	    		{"key1","value1"},
	    		{"key2","value2"},
	    		{"key3","value3"},
	    		{"key4","value4"}
	    	} );
	    }
		public Test03(String key, String data) {
			this.key = key;
			this.data = data;
		}
		@Test
		public void dataPrint(){
			System.out.println(key+":"+data);
			
		}
		
}
