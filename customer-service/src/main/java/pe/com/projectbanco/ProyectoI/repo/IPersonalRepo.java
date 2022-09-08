package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.Personal;

public interface IPersonalRepo extends ReactiveMongoRepository <Personal, String> {
}
