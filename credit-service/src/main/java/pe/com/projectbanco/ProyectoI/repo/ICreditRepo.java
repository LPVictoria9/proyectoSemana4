package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.Credit;

public interface ICreditRepo extends ReactiveMongoRepository<Credit,String> {
}
