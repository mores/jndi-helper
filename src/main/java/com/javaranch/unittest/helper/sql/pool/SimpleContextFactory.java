package com.javaranch.unittest.helper.sql.pool;

import javax.naming.spi.InitialContextFactory;
import javax.naming.Context;
import java.util.Hashtable;

/**
 * <p>
 * Title: SimpleContextFactory
 * </p>
 * <p>
 * Description: A very SimpleContextFactory to assist in JNDI lookups of
 * SimpleDataSource
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
public class SimpleContextFactory implements InitialContextFactory {

	private static SimpleContext instance;

	/**
	 * Method getInitialContext Returns the SimpleContext for use.
	 * 
	 * 
	 * @param environment
	 * 
	 * @return
	 * 
	 */
	public Context getInitialContext(Hashtable environment) {

		if (instance == null) {
			instance = new SimpleContext();
		}
		return instance;
	}
}
