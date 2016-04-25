package com.ttnd.springsecurity.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ttnd.springsecurity.common.errors.ErrorResponse;
import com.ttnd.springsecurity.common.exceptions.UserNotFoundException;
import com.ttnd.springsecurity.dao.UserDao;
import com.ttnd.springsecurity.dto.UserResponseDTO;



/**
 * 
 * @author siddarth
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static Logger log=LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDao userDao;
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getUser() {
		log.debug("userController", "getUser", "inside the user() method");
		UserResponseDTO userResponseDTO = null;
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String name = user.getUsername();
			userResponseDTO = userDao.getUser(name);
		} catch (UserNotFoundException e) {
			//logger.error("userController", "getUser", "InvalidInputException = " + e);
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(5002, e.getMessage()), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			//logger.error("userController", "getUser", "Exception = " + e);
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(5004, e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (userResponseDTO == null) {
			//logger.error(this.getClass().getSimpleName(), "getUser", "Some Issue Occurred");
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(5005, "Some Issue Occurred"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		/*logger.debug(this.getClass().getSimpleName(), "getUser",
				"User details fetched are = " + userResponseDTO.toString());*/
		return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
	}
}
