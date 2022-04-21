package alphaBank.createAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AddressDto {
	String country;
	String city;
	String street;
	String bldNumber;
	String flatNumber;
	String postIndex;

}
