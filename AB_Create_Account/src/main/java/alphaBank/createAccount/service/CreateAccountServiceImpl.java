package alphaBank.createAccount.service;

import java.lang.reflect.Field;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import alphaBank.createAccount.dao.AccountMongoRepository;
import alphaBank.createAccount.dto.CreateNewBankAccountDto;
import alphaBank.createAccount.dto.ResponseCreateNewBankAccountDto;
import alphaBank.createAccount.dummyServices.BuildAccountSimulation;
import alphaBank.createAccount.exceptions.AccAlreadyExistsException;
import alphaBank.createAccount.exceptions.AccCanNotBeBuiltException;
import alphaBank.createAccount.exceptions.EmptyFieldException;
import alphaBank.createAccount.model.AccountEntity;

@Service
public class CreateAccountServiceImpl implements ICreateAccountService {

	AccountMongoRepository repository;
	ModelMapper modelMapper;

	@Autowired
	public CreateAccountServiceImpl(AccountMongoRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseCreateNewBankAccountDto createAccount(CreateNewBankAccountDto createNewBankAccountDto) {
		completenessCheck(createNewBankAccountDto);
		if (repository.existsById(createNewBankAccountDto.getId())) {
			throw new AccAlreadyExistsException(createNewBankAccountDto.getId());
		}
		if (!BuildAccountSimulation.dummyFunction()) {
			throw new AccCanNotBeBuiltException(createNewBankAccountDto.getId());// checks if
		}
		AccountEntity newAccountEntity = modelMapper.map(createNewBankAccountDto, AccountEntity.class);
//		String password = BCrypt.hashpw(passwordGenerated(), BCrypt.gensalt());
		newAccountEntity.setPasswordEncoded(passwordGenerated());
		//sendPasswordToUser();
		repository.save(newAccountEntity);
		return modelMapper.map(newAccountEntity, ResponseCreateNewBankAccountDto.class);
	}

	private String passwordGenerated() {
		return "12345";
	}

	public void completenessCheck(CreateNewBankAccountDto createNewBankAccountDto) {
		for (Field f : createNewBankAccountDto.getClass().getDeclaredFields()) {
			try {
				f.setAccessible(true);
				if (f.get(createNewBankAccountDto) == null || f.get(createNewBankAccountDto) == "") {
					throw new EmptyFieldException(f.getName());
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
