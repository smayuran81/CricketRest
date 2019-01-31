package com.myProject.Cricket.web.exception;

public class ApiError {
	
	public ApiError(int status, String message, String devMessage) {
		
		this.status = status;
		this.message=message;
		this.developerMessage=devMessage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((developerMessage == null) ? 0 : developerMessage.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + status;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiError other = (ApiError) obj;
		if (developerMessage == null) {
			if (other.developerMessage != null)
				return false;
		} else if (!developerMessage.equals(other.developerMessage))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	private int status;
	private String message;
	private String developerMessage;

}
