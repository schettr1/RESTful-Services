package com.sbc.projects.RESTfulServices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


// Return response status: 404 and error: NOT_FOUND when there is UserNotFoundException. 
// This will also prevent server from crashing.
// Always extend to RuntimeException which is unchecked exception. This is because checked exception will ask for surround
// Try/Catch block, will not return the messege to client and will also bring the server down.


@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeleteUserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteUserException(String messege) {
		super(messege);

	}
}



