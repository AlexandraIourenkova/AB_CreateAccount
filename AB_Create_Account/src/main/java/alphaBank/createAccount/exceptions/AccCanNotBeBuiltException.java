package alphaBank.createAccount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)
public class AccCanNotBeBuiltException extends RuntimeException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1068040178754286537L;

	public AccCanNotBeBuiltException(String id) {
		super("Account "+ id + " did not pass exams");
	}

}
