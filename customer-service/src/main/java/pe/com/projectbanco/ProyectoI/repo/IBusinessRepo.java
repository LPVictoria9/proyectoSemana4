package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.Business;

public interface IBusinessRepo extends ReactiveMongoRepository<Business,String> {


}
