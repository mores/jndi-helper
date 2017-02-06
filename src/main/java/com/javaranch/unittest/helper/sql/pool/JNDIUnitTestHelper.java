package com.javaranch.unittest.helper.sql.pool;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * <p>
 * Title: JNDIUnitTestHelper
 * </p>
 * <p>
 * Description: Simple class used to simulate a JNDI DataSource for use in
 * UnitTests
 * </p>
 * Usage is Simple in setUp for your UnitTest:<br>
 * 
 * <pre>
 * if (JNDIUnitTestHelper.notInitialized()) {
 * 	JNDIUnitTestHelper.init(&quot;jndi_unit_test_helper.properties&quot;);
 * }
 * </pre>
 * 
 * <br>
 * Requires the following properties be set by this example:
 * 
 * <pre>
 *      com.javaranch.unittest.helper.sql.pools=1
 * 
 *      com.javaranch.unittest.helper.sql.pool.1.JNDIName=java/TestDB
 *      com.javaranch.unittest.helper.sql.pool.1.dbDriver=com.mysql.jdbc.Driver
 *      com.javaranch.unittest.helper.sql.pool.1.dbServer=jdbc:mysql://localhost/jugsoft
 *      com.javaranch.unittest.helper.sql.pool.1.dbLogin=juguser
 *      com.javaranch.unittest.helper.sql.pool.1.dbPassword=jugsoft
 * </pre>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * - - - - - - - - - - - - - - - - -
 * <p>
 * You are welcome to do whatever you want to with this source file provided
 * that you maintain this comment fragment (between the dashed lines). Modify
 * it, change the package name, change the class name ... personal or business
 * use ... sell it, share it ... add a copyright for the portions you add ...
 * <p>
 * 
 * My goal in giving this away and maintaining the copyright is to hopefully
 * direct developers back to JavaRanch.
 * <p>
 * 
 * The original source can be found at <a
 * href=http://www.javaranch.com>JavaRanch</a>
 * <p>
 * 
 * - - - - - - - - - - - - - - - - -
 * <p>
 * <p>
 * Company: JavaRanch
 * </p>
 * 
 * @author Carl Trusiak, Sheriff
 * @version 1.0
 */
public class JNDIUnitTestHelper {
	private static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(JNDIUnitTestHelper.class);

	private static boolean initialized;
	private static String jndiEnv;
	private static String jndiName;
	private JNDIUnitTestHelper() {
	}

	/**
	 * Intializes the pool and sets it in the InitialContext
	 * 
	 * @param fileName
	 *            Name of the properties file
	 * @throws IOException
	 */
	public static void init(String fileName) throws IOException,
			NamingException, java.net.URISyntaxException {
		log.debug("Filename: " + fileName);

		// Search the classpath for the properties file
		java.lang.ClassLoader cl = Thread.currentThread()
				.getContextClassLoader();
		java.io.InputStream istream = cl.getResourceAsStream(fileName);

		if (istream == null) {
			// Fallback to look for actual file
			java.io.File f = new java.io.File(fileName);
			istream = new FileInputStream(f);
		}

		Properties props = new Properties();
		props.load(istream);

		// Set up environment for creating initial context
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.javaranch.unittest.helper.sql.pool.SimpleContextFactory");
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"com.javaranch.unittest.helper.sql.pool.SimpleContextFactory");
		Context ctx = new InitialContext(env);

		String pools = props
				.getProperty("com.javaranch.unittest.helper.sql.pools");
		java.util.StringTokenizer st = new java.util.StringTokenizer(pools, ",");
		while (st.hasMoreTokens()) {
			String poolName = "com.javaranch.unittest.helper.sql.pool."
					+ st.nextToken();
			log.debug("Loading: " + poolName);

			SimpleDataSource source = new SimpleDataSource();

			source.dbDriver = props.getProperty(poolName + ".dbDriver");
			source.dbServer = props.getProperty(poolName + ".dbServer");
			source.dbLogin = props.getProperty(poolName + ".dbLogin");
			source.dbPassword = props.getProperty(poolName + ".dbPassword");
			jndiEnv = props.getProperty(poolName + ".JNDIEnv");
			jndiName = props.getProperty(poolName + ".JNDIName");

			log.debug("Driver: " + source.dbDriver);

			if (jndiEnv != null) {
				// Register the data source to JNDI naming service
				Context envCtx = new InitialContext(env);
				ctx.bind(jndiEnv, envCtx);
			}

			ctx.bind(jndiName, source);

		}

		String strings = props
				.getProperty("com.javaranch.unittest.helper.strings");
		st = new java.util.StringTokenizer(strings, ",");
		while (st.hasMoreTokens()) {
			String stringName = "com.javaranch.unittest.helper.string."
					+ st.nextToken();
			log.debug("Loading: " + stringName);

			String value = props.getProperty(stringName + ".value");
			jndiEnv = props.getProperty(stringName + ".JNDIEnv");
			jndiName = props.getProperty(stringName + ".JNDIName");

			log.debug("String: " + value);

			if (jndiEnv != null) {
				// Register the data source to JNDI naming service
				Context envCtx = new InitialContext(env);
				ctx.bind(jndiEnv, envCtx);
			}

			ctx.bind(jndiName, value);
		}

		initialized = true;
	}

	/**
	 * determines if the pool was successfully initialized or not.
	 * 
	 * @returns true if the pool was not successfully initialized.
	 */
	public static boolean notInitialized() {
		return !initialized;
	}

	/**
	 * shutdowns down the pool and ends the Thread that DbConnectionBroker
	 * starts.
	 * 
	 * 
	 * @throws NamingException
	 * 
	 */
	public static void shutdown() throws NamingException {

		InitialContext ctx = new InitialContext();
		ctx.unbind(jndiName);
		initialized = false;
	}

	/**
	 * Gets the name of the datasource, useful in test because this is
	 * configurable for the tests ran.
	 */

	/*
	 * public static String getJndiName() { return jndiName; }
	 * 
	 * public static String getJndiEnv() { return jndiEnv; }
	 */
}
