package com.javaranch.unittest.helper.sql.pool;

import com.javaranch.unittest.helper.sql.pool.JNDIUnitTestHelper;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.Rule;
import org.junit.Test;

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
public class TestJNDIUnitTestHelper {

	private static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(TestJNDIUnitTestHelper.class);

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		if (JNDIUnitTestHelper.notInitialized()) {
			try {
				JNDIUnitTestHelper.init("jndi_unit_test_helper.properties");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				Assert.fail("IOException thrown : " + ioe.getMessage());
			} catch (NamingException ne) {
				ne.printStackTrace();
				Assert.fail("NamingException thrown on Init : "
						+ ne.getMessage());
			} catch (java.net.URISyntaxException urie) {
				urie.printStackTrace();
				Assert.fail("URISyntaxException thrown on Init : "
						+ urie.getMessage());
			}
		}
	}

	/**
	 * Method testGetConnection Simply creates the JNDI DataSource, gets a
	 * connection and frees it. Deemed successful if no exceptions are thrown.
	 */
	@Test
	public void testGetConnection() {

		try {
			InitialContext initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java/TestDB");
			Connection conn = ds.getConnection();

			String sql = "SELECT CURRENT_TIMESTAMP FROM SYSIBM.SYSDUMMY1";
			java.sql.Statement smt = conn.createStatement();
			java.sql.ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				log.trace("Here: " + rs.getString(1));
			}

			conn.close();
		} catch (NamingException ne) {
			ne.printStackTrace();
			Assert.fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Assert.fail("SQLException thrown on lookup : " + sqle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InitialContext initCtx = new InitialContext();
			String aString = (String) initCtx.lookup("java/TestString");
			log.trace("Here: " + aString);

			if (!aString.equals("plain O string")) {
				Assert.fail("Cound not find the string I was looking for");
			}
		} catch (NamingException ne) {
			ne.printStackTrace();
			Assert.fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetEnvConnection() {

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
				log.trace("Here: " + rs.getString(1));
			}

			conn.close();
		} catch (NamingException ne) {
			ne.printStackTrace();
			Assert.fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Assert.fail("SQLException thrown on lookup : " + sqle.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			InitialContext initCtx = new InitialContext();
			javax.naming.Context envCtx = (javax.naming.Context) initCtx
					.lookup("java:comp/env");
			String aString = (String) envCtx.lookup("java/Test2String");
			log.trace("Here: " + aString);

			if (!aString.equals("plain 1 string")) {
				Assert.fail("Cound not find the string I was looking for");
			}
		} catch (NamingException ne) {
			ne.printStackTrace();
			Assert.fail("NamingException thrown on lookup : " + ne.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testNoContext() throws javax.naming.NamingException {
		InitialContext initCtx = new InitialContext();
		exception.expect(NamingException.class);
		javax.naming.Context envCtx = (javax.naming.Context) initCtx
				.lookup("not:here");
	}

	@Test
	public void testNoDataSource() throws javax.naming.NamingException {
		InitialContext initCtx = new InitialContext();
		javax.naming.Context envCtx = (javax.naming.Context) initCtx
				.lookup("java:comp/env");
		exception.expect(NamingException.class);
		DataSource ds = (DataSource) envCtx.lookup("java/TestNoDB");
	}

	/**
	 * Method tearDown
	 * 
	 * 
	 */
	@After
	public void tearDown() {

		try {
			JNDIUnitTestHelper.shutdown();
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}

}
