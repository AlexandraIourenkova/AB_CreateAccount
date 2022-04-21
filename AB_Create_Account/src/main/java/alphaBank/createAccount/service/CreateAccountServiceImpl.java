package alphaBank.createAccount.service;

import java.lang.reflect.Field;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		AccountEntity newAccountEntity = repository.save(modelMapper.map(createNewBankAccountDto, AccountEntity.class));
		
		return modelMapper.map(newAccountEntity, ResponseCreateNewBankAccountDto.class);
	}

	private void completenessCheck(CreateNewBankAccountDto createNewBankAccountDto) {
		for (Field f : createNewBankAccountDto.getClass().getDeclaredFields()) {
			try {
				if (f.get(createNewBankAccountDto) == null) {
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
