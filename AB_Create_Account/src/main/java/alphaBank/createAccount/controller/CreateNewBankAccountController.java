package alphaBank.createAccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alphaBank.createAccount.dto.CreateNewBankAccountDto;
import alphaBank.createAccount.dto.ResponseCreateNewBankAccountDto;
import alphaBank.createAccount.service.ICreateAccountService;

@RestController
@RequestMapping("/alphaBank")

public class CreateNewBankAccountController {

	ICreateAccountService service;
	
	@Autowired
	public CreateNewBankAccountController(ICreateAccountService service) {
		this.service = service;
	}
	
	@PostMapping("/registerNewAccount")
	public ResponseCreateNewBankAccountDto createAccount(@RequestBody CreateNewBankAccountDto createNewBankAccountDto) {
		return service.createAccount(createNewBankAccountDto);
	}
	
	
}
