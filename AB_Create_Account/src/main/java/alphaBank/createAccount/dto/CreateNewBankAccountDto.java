package alphaBank.createAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CreateNewBankAccountDto {
	
	String id;
	String firstName;
	String lastName;
	String maritialStatus;
	String employmentStatus;
	AddressDto address;
	ContactDetailsDto contactDetails;
	int balance;
	
}
