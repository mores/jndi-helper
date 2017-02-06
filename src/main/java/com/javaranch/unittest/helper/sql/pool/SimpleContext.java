package com.javaranch.unittest.helper.sql.pool;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.NameParser;
import java.util.Hashtable;

/**
 * <p>
 * Title: SimpleContext
 * </p>
 * <p>
 * Description: A very thin Context for use by JNDIUnitTestHelper
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
public class SimpleContext implements Context {

	private Hashtable table = new Hashtable();

	/**
	 * Method lookup not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Object lookup(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method lookup() not yet implemented.");
	}

	/**
	 * Method lookup Returns the SimpleDataSource.
	 * 
	 * 
	 * @param name
	 * 
	 * @return A copy of the SimpleDataSource class
	 * 
	 * @throws NamingException
	 * 
	 */
	public Object lookup(String name) throws NamingException {
		return table.get(name);
	}

	/**
	 * Method bind not yet implemented.
	 * 
	 * 
	 * @param name
	 * @param obj
	 * 
	 * @throws NamingException
	 * 
	 */
	public void bind(Name name, Object obj) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method bind() not yet implemented.");
	}

	/**
	 * Method bind the SimpleDataSource for use.
	 * 
	 * 
	 * @param name
	 * @param obj
	 * 
	 * @throws NamingException
	 * 
	 */
	public void bind(String name, Object obj) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		table.put(name, obj);
	}

	/**
	 * Method rebind not yet implemented.
	 * 
	 * 
	 * @param name
	 * @param obj
	 * 
	 * @throws NamingException
	 * 
	 */
	public void rebind(Name name, Object obj) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method rebind() not yet implemented.");
	}

	/**
	 * Method rebind not yet implemented.
	 * 
	 * 
	 * @param name
	 * @param obj
	 * 
	 * @throws NamingException
	 * 
	 */
	public void rebind(String name, Object obj) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method rebind() not yet implemented.");
	}

	/**
	 * Method unbind not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @throws NamingException
	 * 
	 */
	public void unbind(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method unbind() not yet implemented.");
	}

	/**
	 * Method unbind not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @throws NamingException
	 * 
	 */
	public void unbind(String name) throws NamingException {
		table.remove(name);
	}

	/**
	 * Method rename not yet implemented.
	 * 
	 * 
	 * @param oldName
	 * @param newName
	 * 
	 * @throws NamingException
	 * 
	 */
	public void rename(Name oldName, Name newName) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method rename() not yet implemented.");
	}

	/**
	 * Method rename not yet implemented.
	 * 
	 * 
	 * @param oldName
	 * @param newName
	 * 
	 * @throws NamingException
	 * 
	 */
	public void rename(String oldName, String newName) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method rename() not yet implemented.");
	}

	/**
	 * Method list not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public NamingEnumeration list(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method list() not yet implemented.");
	}

	/**
	 * Method list not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public NamingEnumeration list(String name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method list() not yet implemented.");
	}

	/**
	 * Method listBindings not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public NamingEnumeration listBindings(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method listBindings() not yet implemented.");
	}

	/**
	 * Method listBindings not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public NamingEnumeration listBindings(String name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method listBindings() not yet implemented.");
	}

	/**
	 * Method destroySubcontext not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @throws NamingException
	 * 
	 */
	public void destroySubcontext(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method destroySubcontext() not yet implemented.");
	}

	/**
	 * Method destroySubcontext not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @throws NamingException
	 * 
	 */
	public void destroySubcontext(String name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method destroySubcontext() not yet implemented.");
	}

	/**
	 * Method createSubcontext not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Context createSubcontext(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method createSubcontext() not yet implemented.");
	}

	/**
	 * Method createSubcontext not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Context createSubcontext(String name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method createSubcontext() not yet implemented.");
	}

	/**
	 * Method lookupLink not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Object lookupLink(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method lookupLink() not yet implemented.");
	}

	/**
	 * Method lookupLink not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Object lookupLink(String name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method lookupLink() not yet implemented.");
	}

	/**
	 * Method getNameParser not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public NameParser getNameParser(Name name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method getNameParser() not yet implemented.");
	}

	/**
	 * Method getNameParser not yet implemented.
	 * 
	 * 
	 * @param name
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public NameParser getNameParser(String name) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method getNameParser() not yet implemented.");
	}

	/**
	 * Method composeName not yet implemented.
	 * 
	 * 
	 * @param name
	 * @param prefix
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Name composeName(Name name, Name prefix) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method composeName() not yet implemented.");
	}

	/**
	 * Method composeName not yet implemented.
	 * 
	 * 
	 * @param name
	 * @param prefix
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public String composeName(String name, String prefix)
			throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method composeName() not yet implemented.");
	}

	/**
	 * Method addToEnvironment not yet implemented.
	 * 
	 * 
	 * @param propName
	 * @param propVal
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Object addToEnvironment(String propName, Object propVal)
			throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method addToEnvironment() not yet implemented.");
	}

	/**
	 * Method removeFromEnvironment not yet implemented.
	 * 
	 * 
	 * @param propName
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Object removeFromEnvironment(String propName) throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method removeFromEnvironment() not yet implemented.");
	}

	/**
	 * Method getEnvironment not yet implemented.
	 * 
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public Hashtable getEnvironment() throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method getEnvironment() not yet implemented.");
	}

	/**
	 * Method close not yet implemented.
	 * 
	 * 
	 * @throws NamingException
	 * 
	 */
	public void close() throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method close() not yet implemented.");
	}

	/**
	 * Method getNameInNamespace not yet implemented.
	 * 
	 * 
	 * @return
	 * 
	 * @throws NamingException
	 * 
	 */
	public String getNameInNamespace() throws NamingException {

		/** @todo: Implement this javax.naming.Context method */
		throw new java.lang.UnsupportedOperationException(
				"Method getNameInNamespace() not yet implemented.");
	}
}
