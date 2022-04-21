package alphaBank.createAccount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)
public class AccAlreadyExistsException extends RuntimeException {/**
	 * 
	 */
	private static final long serialVersionUID = -5020383371146649347L;

	public AccAlreadyExistsException(String accId) {
		super("Account exists" + accId);
	}
	
}
