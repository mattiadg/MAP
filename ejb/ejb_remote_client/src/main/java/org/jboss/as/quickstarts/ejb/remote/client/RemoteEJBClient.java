package org.jboss.as.quickstarts.ejb.remote.client;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.as.quickstarts.ejb.remote.stateful.RemoteCounter;
import org.jboss.as.quickstarts.ejb.remote.stateless.RemoteCalculator;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

public class RemoteEJBClient {
	public static void main(String[] args) throws Exception {
		invokeStatelessBean();
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
		/*
		 * final Hashtable jndiProperties = new Hashtable();
		 * jndiProperties.put(Context.URL_PKG_PREFIXES,
		 * "org.jboss.ejb.client.naming"); final Context context = new
		 * InitialContext(jndiProperties);
		 */
		// The JNDI lookup name for a stateless session bean has the syntax of:
		// ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
		//
		// <appName> The application name is the name of the EAR that the EJB is
		// deployed in
		// (without the .ear). If the EJB JAR is not deployed in an EAR then
		// this is
		// blank. The app name can also be specified in the EAR's
		// application.xml
		//
		// <moduleName> By the default the module name is the name of the EJB
		// JAR file (without the
		// .jar suffix). The module name might be overridden in the ejb-jar.xml
		//
		// <distinctName> : WildFly allows each deployment to have an (optional)
		// distinct name.
		// This example does not use this so leave it blank.
		//
		// <beanName> : The name of the session been to be invoked.
		//
		// <viewClassName>: The fully qualified classname of the remote
		// interface. Must include
		// the whole package name.
		// let's do the lookup
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