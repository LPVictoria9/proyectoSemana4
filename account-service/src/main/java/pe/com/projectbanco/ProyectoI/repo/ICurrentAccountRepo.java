package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.currentAccount;

public interface ICurrentAccountRepo extends ReactiveMongoRepository<currentAccount, String> {
}
