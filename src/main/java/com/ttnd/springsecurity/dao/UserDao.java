package com.ttnd.springsecurity.dao;

import com.ttnd.springsecurity.common.exceptions.UserNotFoundException;
import com.ttnd.springsecurity.dto.UserResponseDTO;

public interface UserDao {


	public UserResponseDTO getUser(String token) throws UserNotFoundException;

}
