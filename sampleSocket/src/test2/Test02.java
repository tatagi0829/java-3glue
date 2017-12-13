package test2;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test02 {
	 List<String> list ;
	   
	   @Before
	   public void setup(){
		   list = new ArrayList<>();
	   }
	   
	   @After
	   public void close(){
		   list = null;
	   }
	   @Test
	   public void test(){
		   list.add("A");
		   list.add("B");
		   list.add("B");
		   System.out.println(list);
	   }
	   
}
