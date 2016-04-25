package com.ttnd.springsecurity.dto;

/**
 * 
 * @author siddarth
 *
 */
public class UserResponseDTO{

	private String userId;
	
	private  String userName;
	
	
	
	

	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserResponseDTO(Boolean status, String responseMsg) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserResponseDTO [userId=" + userId + ", userName=" + userName + "]";
	}

	
}
