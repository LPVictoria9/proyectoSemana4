package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Business;
import pe.com.projectbanco.ProyectoI.repo.IBusinessRepo;
import pe.com.projectbanco.ProyectoI.service.IBusinessService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessServiceImpl implements IBusinessService {
    private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);
    @Autowired
    private IBusinessRepo iBusinessRepo;

    @Override
    public Mono<Business> create(Business obj) {
        logger.info(" Request Body: "+ obj);
        return iBusinessRepo.save(obj);
    }

    @Override
    public Mono<Business> update(Business obj) {
        return iBusinessRepo.save(obj);
    }

    @Override
    public Flux<Business> findAll() {
        return iBusinessRepo.findAll();
    }

    @Override
    public Mono<Business> listPorId(String id) {
        Mono<Business> op = iBusinessRepo.findById(id);
        return op;
    }

    @Override
    public Mono<Void> deleteById(String id) {

        return iBusinessRepo.deleteById(id);
    }


    @Override
    public Mono<Void> delete(Business Business) {
        return iBusinessRepo.delete(Business);

    }
    @Override
    public Flux<Business> findByRUC(String ruc) {
        return iBusinessRepo.findAll().filter(p->p.getRuc().equals(ruc));
    }
}
