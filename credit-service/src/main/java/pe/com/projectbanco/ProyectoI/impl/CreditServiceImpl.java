package pe.com.projectbanco.ProyectoI.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Credit;
import pe.com.projectbanco.ProyectoI.repo.ICreditRepo;
import pe.com.projectbanco.ProyectoI.service.ICreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements ICreditService {

    @Autowired
    private ICreditRepo icreditRepo;
    @Override
    public Mono<Credit> create(Credit obj) {
        return icreditRepo.save(obj);
    }

    @Override
    public Mono<Credit> update(Credit obj) {
        return icreditRepo.save(obj);
    }

    @Override
    public Flux<Credit> findAll() {
        return icreditRepo.findAll();
    }

    @Override
    public Mono<Credit> listPorId(String id) {
        return icreditRepo.findById(id);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return icreditRepo.deleteById(id);
    }

    @Override
    public Mono<Void> delete(Credit obj) {
        return icreditRepo.delete(obj);
    }
}
