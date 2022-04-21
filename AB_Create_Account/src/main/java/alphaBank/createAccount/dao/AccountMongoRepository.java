package alphaBank.createAccount.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import alphaBank.createAccount.model.AccountEntity;

public interface AccountMongoRepository extends MongoRepository<AccountEntity, String> {

}
