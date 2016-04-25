package com.ttnd.springsecurity.utils;

/**
 * 
 */

import org.hibernate.SessionFactory;

/**
 * 
 * @author siddarth
 *
 */
public class SpringSecurityInputValidator {
	private SpringSecuritySessionFactory springSecuritySessionFactory;

	

	public SpringSecuritySessionFactory getSpringSecuritySessionFactory() {
		return springSecuritySessionFactory;
	}



	public void setSpringSecuritySessionFactory(SpringSecuritySessionFactory springSecuritySessionFactory) {
		this.springSecuritySessionFactory = springSecuritySessionFactory;
	}



	public SessionFactory getSessionFactory() {
		return springSecuritySessionFactory.getSessionFactory();
	}
}
