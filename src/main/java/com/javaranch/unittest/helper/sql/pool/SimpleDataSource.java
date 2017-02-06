package com.javaranch.unittest.helper.sql.pool;

import javax.sql.DataSource;
import javax.naming.Reference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * <p>
 * Title: SimpleDataSource
 * </p>
 * <p>
 * Description: A very simple datasource. Creates a new Connection to the
 * database everytime it's ask for one so....
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
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */
class SimpleDataSource extends Reference implements DataSource {

	String dbDriver;
	String dbServer;
	String dbLogin;
	String dbPassword;
	SimpleDataSource() {
		super(SimpleDataSource.class.getName());
	}

	/**
	 * Method getConnection creates Connection to the database.
	 * 
	 * 
	 * @return New Connection each time.
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public Connection getConnection() throws java.sql.SQLException {

		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException cnfe) {
			throw new java.sql.SQLException(cnfe.getMessage());
		}
		return DriverManager.getConnection(dbServer, dbLogin, dbPassword);
	}

	/**
	 * Method getConnection
	 * 
	 * 
	 * @param parm1
	 * @param parm2
	 * 
	 * @return
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public Connection getConnection(String parm1, String parm2)
			throws java.sql.SQLException {
		return getConnection();
	}

	/**
	 * Method getLogWriter not yet implemented.
	 * 
	 * 
	 * @return
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public PrintWriter getLogWriter() throws java.sql.SQLException {

		/** @todo: Implement this javax.sql.DataSource method */
		throw new java.lang.UnsupportedOperationException(
				"Method getLogWriter() not yet implemented.");
	}

	/**
	 * Method getLoginTimeout not yet implemented.
	 * 
	 * 
	 * @return
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public int getLoginTimeout() throws java.sql.SQLException {

		/** @todo: Implement this javax.sql.DataSource method */
		throw new java.lang.UnsupportedOperationException(
				"Method getLoginTimeout() not yet implemented.");
	}

	/**
	 * Method setLogWriter not yet implemented.
	 * 
	 * 
	 * @param parm1
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public void setLogWriter(PrintWriter parm1) throws java.sql.SQLException {

		/** @todo: Implement this javax.sql.DataSource method */
		throw new java.lang.UnsupportedOperationException(
				"Method setLogWriter() not yet implemented.");
	}

	/**
	 * Method setLoginTimeout not yet implemented.
	 * 
	 * 
	 * @param parm1
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public void setLoginTimeout(int parm1) throws java.sql.SQLException {

		/** @todo: Implement this javax.sql.DataSource method */
		throw new java.lang.UnsupportedOperationException(
				"Method setLoginTimeout() not yet implemented.");
	}

	/**
	 * Method getParentLogger() not yet implemented.
	 * 
	 * 
	 * @return
	 * 
	 * @throws java.sql.SQLException
	 * 
	 */
	public Logger getParentLogger()
			throws java.sql.SQLFeatureNotSupportedException {

		/** @todo: Implement this javax.sql.DataSource method */
		throw new java.lang.UnsupportedOperationException(
				"Method getParentLogger() not yet implemented.");
	}

	public boolean isWrapperFor(java.lang.Class what) {
		return (false);
	}

	public Object unwrap(java.lang.Class that) {
		Object o = new Object();
		return (o);
	}
}
