package java8_mixins;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Main  {
	
	private static class Device {}
	 
	private static class DeviceA extends Device implements SwitchableMixin {}
	 
	private static class DeviceB extends Device implements SwitchableMixin {}
	
	@Test
	public void prova() {
		
		DeviceA a = new DeviceA();
		DeviceB b = new DeviceB();
		 
		a.setActivated(true);
		 
		assertTrue(a.isActivated());
		assertFalse(b.isActivated());
	}
}
