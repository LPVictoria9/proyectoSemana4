package pe.com.projectbanco.ProyectoI.service;

import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Movement;
import reactor.core.publisher.Flux;

public interface IMovementService  extends ICRUD<Movement,String> {

    @Query("{'id':?0}")
    Flux<Movement> findByIdMovement(String id);
}
