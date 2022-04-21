package alphaBank.createAccount.service;

import alphaBank.createAccount.dto.CreateNewBankAccountDto;
import alphaBank.createAccount.dto.ResponseCreateNewBankAccountDto;

public interface ICreateAccountService {

	ResponseCreateNewBankAccountDto createAccount(CreateNewBankAccountDto createNewBankAccountDto);

}
