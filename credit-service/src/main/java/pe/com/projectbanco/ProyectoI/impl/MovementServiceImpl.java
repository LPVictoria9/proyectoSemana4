package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Movement;
import pe.com.projectbanco.ProyectoI.repo.IMovementRepo;
import pe.com.projectbanco.ProyectoI.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MovementServiceImpl implements IMovementService {
    private static final Logger logger = LoggerFactory.getLogger(MovementServiceImpl.class);

    @Autowired
    private IMovementRepo iMovRepo;

    @Override
    public Mono<Movement> create(Movement obj) {
        logger.info(" Request Body: "+ obj);
        return iMovRepo.save(obj);
    }

    @Override
    public Mono<Movement> update(Movement obj) {
        return iMovRepo.save(obj);
    }

    @Override
    public Flux<Movement> findAll() {

        return iMovRepo.findAll();
    }

    @Override
    public Mono<Movement> listPorId(String id) {

        return iMovRepo.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Movement obj) {

        return iMovRepo.delete(obj);
    }

    @Override
    public Flux<Movement> findByIdMovement(String id) {
        return iMovRepo.findAll().filter(p-> p.getId().equals(id));
    }
}
