package pe.com.projectbanco.ProyectoI.service;

import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Business;
import pe.com.projectbanco.ProyectoI.model.customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService extends ICRUD <customer, String>{
    @Query("{'type':?0}")
    Flux<customer> findByType(String type);

    @Query("{'ruc':?0}")
    Flux<customer> findByRUC(String ruc);

    @Query("{'dni':?0}")
    Flux<customer> findByDNI(String dni);
}
