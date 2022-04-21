package alphaBank.createAccount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmptyFieldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5952731424427690363L;

	public EmptyFieldException(String name) {
		super("Field " + name + " is null");
	}


}
