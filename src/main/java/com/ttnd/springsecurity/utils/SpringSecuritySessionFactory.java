package com.ttnd.springsecurity.utils;


import org.hibernate.SessionFactory;

/**
 * 
 * @author siddarth
 *
 */
public class SpringSecuritySessionFactory {
	
	private SessionFactory springsecuritySessionFactoryBean;

	

	/**
	 * @return the springsecuritySessionFactoryBean
	 */
	public SessionFactory getSpringsecuritySessionFactoryBean() {
		return springsecuritySessionFactoryBean;
	}



	/**
	 * @param springsecuritySessionFactoryBean the springsecuritySessionFactoryBean to set
	 */
	public void setSpringsecuritySessionFactoryBean(SessionFactory springsecuritySessionFactoryBean) {
		this.springsecuritySessionFactoryBean = springsecuritySessionFactoryBean;
	}



	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return springsecuritySessionFactoryBean;
	}
			
	
}
