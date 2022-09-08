package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Personal;
import pe.com.projectbanco.ProyectoI.repo.IPersonalRepo;
import pe.com.projectbanco.ProyectoI.service.IPersonalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PersonalServiceImpl implements IPersonalService {
    private static final Logger logger = LoggerFactory.getLogger(PersonalServiceImpl.class);

    @Autowired
    private IPersonalRepo iPersonalRepo;

   @Override
    public Mono<Personal> create(Personal obj) {
        logger.info(" Request Body: "+ obj);
        return iPersonalRepo.save(obj);
    }

    @Override
    public Mono<Personal> update(Personal obj) {
        return iPersonalRepo.save(obj);
    }

    @Override
    public Flux<Personal> findAll() {
        return iPersonalRepo.findAll();
    }

    @Override
    public Mono<Personal> listPorId(String id) {
        Mono<Personal> op = iPersonalRepo.findById(id);
        return op;
    }

    @Override
    public Mono<Void> deleteById(String dni) {
        return iPersonalRepo.deleteById(dni);
    }

    @Override
    public Mono<Void> delete(Personal obj) {
       return iPersonalRepo.delete(obj);

    }

    @Override
    public Flux<Personal> findByDNI(String dni) {
        return iPersonalRepo.findAll().filter(buscar -> buscar.getDni().equals(dni));
    }

    @Override
    public Flux<Personal> findByTypePersonal(String typePersonal) {
        return iPersonalRepo.findAll().filter(typeP -> typeP.getTypePersonal().equals(typePersonal));
    }
}