package com.ttnd.springsecurity.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ttnd.springsecurity.common.exceptions.UserNotFoundException;
import com.ttnd.springsecurity.dao.UserDao;
import com.ttnd.springsecurity.dto.UserResponseDTO;
import com.ttnd.springsecurity.entities.User;
import com.ttnd.springsecurity.utils.HibernateUtil;
import com.ttnd.springsecurity.utils.SpringSecurityInputValidator;
@Repository
public class UserDaoImpl implements UserDao {

	private SpringSecurityInputValidator springSecurityInputValidator;
	

	/**
	 * @param springSecurityInputValidator the springSecurityInputValidator to set
	 */
	public void setSpringSecurityInputValidator(SpringSecurityInputValidator springSecurityInputValidator) {
		this.springSecurityInputValidator = springSecurityInputValidator;
	}

	@Override
	public UserResponseDTO getUser(String token) throws UserNotFoundException {
		Session session = null;
		UserResponseDTO userResponseDTO = null;
		boolean problem = false;
		String problemType = null;
		try {
			session =  HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("userName", token));
			User user = (User) cr.uniqueResult();

			if (user != null) {
				userResponseDTO = createUserResponseDTO(user);
				//userResponseDTO.setuName("asdas");
			} else {
				problem = true;
				problemType = "UserNotFound";
			}
			session.getTransaction().commit();

		} catch (DataAccessException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			} finally {
			session.close();
		}
		if (problem) {
			if ("UserNotFound".equals(problemType)) {
				throw new UserNotFoundException("Not a valid user");
			}
		}

		return userResponseDTO;
	}
	
	public UserResponseDTO createUserResponseDTO(User user) {
		UserResponseDTO userResponseDTO = new UserResponseDTO();

		userResponseDTO.setUserName(user.getUserName());
		userResponseDTO.setUserId(user.getUserId());

		return userResponseDTO;
	}
	


}
