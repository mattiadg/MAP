package org.jboss.as.quickstarts.ejb.remote.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.as.quickstarts.ejb.remote.stateful.RemoteCounter;
import org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculator;

public class RemoteEJBClient {
	public static void main(String[] args) throws Exception {
		//invokeStatelessBean();
		invokeStatefulBean();
	}

	/**
	 * Looks up a stateless bean and invokes on it
	 * 
	 * @throws NamingException
	 */
	private static void invokeStatelessBean() throws NamingException {
		final RemoteCalculator statelessRemoteCalculator = lookupRemoteStatelessCalculator();
		System.out
				.println("Obtained a remote stateless calculator for invocation");
		// invoke on the remote calculator
		int a = 204;
		int b = 340;
		System.out
				.println("Adding "
						+ a
						+ " and "
						+ b
						+ " via the remote stateless calculator deployed on the server");
		int sum = statelessRemoteCalculator.add(a, b);
		System.out.println("Remote calculator returned sum = " + sum);
		if (sum != a + b) {
			throw new RuntimeException(
					"Remote stateless calculator returned an incorrect sum "
							+ sum + " ,expected sum was " + (a + b));
		}
		// try one more invocation, this time for subtraction
		int num1 = 3434;
		int num2 = 2332;
		System.out
				.println("Subtracting "
						+ num2
						+ " from "
						+ num1
						+ " via the remote stateless calculator deployed on the server");
		int difference = statelessRemoteCalculator.subtract(num1, num2);
		System.out.println("Remote calculator returned difference = "
				+ difference);
		if (difference != num1 - num2) {
			throw new RuntimeException(
					"Remote stateless calculator returned an incorrect difference "
							+ difference + " ,expected difference was "
							+ (num1 - num2));
		}
	}

	/**
	 * Looks up a stateful bean and invokes on it
	 * 
	 * @throws NamingException
	 */
	private static void invokeStatefulBean() throws NamingException {
		// Let's lookup the remote stateful counter
		final RemoteCounter statefulRemoteCounter = lookupRemoteStatefulCounter();
		System.out.println("Obtained a remote stateful counter for invocation");
		// invoke on the remote counter bean
		final int NUM_TIMES = 5;
		System.out.println("Counter will now be incremented " + NUM_TIMES
				+ " times");
		for (int i = 0; i < NUM_TIMES; i++) {
			System.out.println("Incrementing counter");
			statefulRemoteCounter.increment();
			System.out.println("Count after increment is "
					+ statefulRemoteCounter.getCount());
		}
		// now decrementing
		System.out.println("Counter will now be decremented " + NUM_TIMES
				+ " times");
		for (int i = NUM_TIMES; i > 0; i--) {
			System.out.println("Decrementing counter");
			statefulRemoteCounter.decrement();
			System.out.println("Count after decrement is "
					+ statefulRemoteCounter.getCount());
		}
	}

	/**
	 * Looks up and returns the proxy to remote stateless calculator bean
	 * 
	 * @return
	 * @throws NamingException
	 */
	private static RemoteCalculator lookupRemoteStatelessCalculator()
			throws NamingException {
		Context context = getContext();
		
		return (RemoteCalculator) context
				.lookup("ejb:/ejb_remote_server/CalculatorBean!"
						+ RemoteCalculator.class.getName());
	}

	private static Context getContext() throws NamingException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,
				"http-remoting://localhost:8080");
		// try {
		Context context = new InitialContext(jndiProperties);
		return context;
	}

	/**
	 * Looks up and returns the proxy to remote stateful counter bean
	 * 
	 * @return
	 * @throws NamingException
	 */
	private static RemoteCounter lookupRemoteStatefulCounter()
			throws NamingException {
		Context context = getContext();
		return (RemoteCounter) context
				.lookup("ejb:/ejb_remote_server/CounterBean!"
						+ RemoteCounter.class.getName() + "?stateful");
	}
}