package com.zyf.helloWorld;
import static org.junit.Assert.*;
import org.junit.Test;
public class HelloWorldTest {
	@Test
	public  void testSayHello(){
		HelloWorld hw = new HelloWorld();
		String result = hw.sayHello();
		assertEquals("hello Maven",result);
	}
	
}
