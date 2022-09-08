package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.customer;

public interface ICustomerRepo  extends ReactiveMongoRepository<customer,String> {
}
