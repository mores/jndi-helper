package com.javaranch.unittest.helper.sql.pool;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * <p>
 * Title: TestJNDIUnitTestHelper
 * </p>
 * <p>
 * Description: What would be the sense of a UnitTest Helper without a UnitTest
 * </p>
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
public class TestJNDIUnitTestHelper extends TestCase {

	/**
	 * Constructor TestJNDIUnitTestHelper
	 * 
	 * 
	 * @param method
	 * 
	 */
	public TestJNDIUnitTestHelper(String method) {
		super(method);
	}

	/**
	 * Method testGetConnection Simply creates the JNDI DataSource, gets a
	 * connection and frees it. Deemed successful if no exceptions are thrown.
	 */
	public void testGetConnection() {

		// ok so this code usually goes in the setUp but...
		if (JNDIUnitTestHelper.notInitialized()) {
			try {
				JNDIUnitTestHelper.init("jndi_unit_test_helper.properties");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				fail("IOException thrown : " + ioe.getMessage());
			} catch (NamingException ne) {
				ne.printStackTrace();
				fail("NamingException thrown on Init : " + ne.getMessage());
			} catch (java.net.URISyntaxException urie) {
				urie.printStackTrace();
				fail("URISyntaxException thrown on Init : " + urie.getMessage());
			}
		}
		try {
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java/TestDB");
			Connection conn = ds.getConnection();

			String sql = "SELECT CURRENT_TIMESTAMP FROM SYSIBM.SYSDUMMY1";
			java.sql.Statement smt = conn.createStatement();
			java.sql.ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Here: " + rs.getString(1));
			}

			conn.close();
		} catch (NamingException ne) {
			ne.printStackTrace();
			fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			fail("SQLException thrown on lookup : " + sqle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InitialContext initCtx = new InitialContext();
			String aString = (String) initCtx.lookup("java/TestString");
			System.out.println("Here: " + aString);

			if (!aString.equals("plain O string")) {
				fail("Cound not find the string I was looking for");
			}
		} catch (NamingException ne) {
			ne.printStackTrace();
			fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testGetEnvConnection() {

		// ok so this code usually goes in the setUp but...
		if (JNDIUnitTestHelper.notInitialized()) {
			try {
				JNDIUnitTestHelper.init("jndi_unit_test_helper.properties");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				fail("IOException thrown : " + ioe.getMessage());
			} catch (NamingException ne) {
				ne.printStackTrace();
				fail("NamingException thrown on Init : " + ne.getMessage());
			} catch (java.net.URISyntaxException urie) {
				urie.printStackTrace();
				fail("URISyntaxException thrown on Init : " + urie.getMessage());
			}
		}
		try {
			InitialContext initCtx = new InitialContext();
			javax.naming.Context envCtx = (javax.naming.Context) initCtx
					.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("java/Test2DB");
			Connection conn = ds.getConnection();

			String sql = "SELECT CURRENT_TIMESTAMP FROM SYSIBM.SYSDUMMY1";
			java.sql.Statement smt = conn.createStatement();
			java.sql.ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Here: " + rs.getString(1));
			}

			conn.close();
		} catch (NamingException ne) {
			ne.printStackTrace();
			fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			fail("SQLException thrown on lookup : " + sqle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InitialContext initCtx = new InitialContext();
			javax.naming.Context envCtx = (javax.naming.Context) initCtx
					.lookup("java:comp/env");
			String aString = (String) envCtx.lookup("java/Test2String");
			System.out.println("Here: " + aString);

			if (!aString.equals("plain 1 string")) {
				fail("Cound not find the string I was looking for");
			}
		} catch (NamingException ne) {
			ne.printStackTrace();
			fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method tearDown
	 * 
	 * 
	 */
	public void tearDown() {

		try {
			JNDIUnitTestHelper.shutdown();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}

	/**
	 * Method suite
	 * 
	 * 
	 * @return TestSuite to be ran.
	 * 
	 */
	public static Test suite() {

		TestSuite suite = new TestSuite();
		suite.addTest(new TestJNDIUnitTestHelper("testGetConnection"));
		suite.addTest(new TestJNDIUnitTestHelper("testGetEnvConnection"));
		return suite;
	}

	/**
	 * Method main
	 * 
	 * 
	 * @param args
	 * 
	 */
	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}
}
