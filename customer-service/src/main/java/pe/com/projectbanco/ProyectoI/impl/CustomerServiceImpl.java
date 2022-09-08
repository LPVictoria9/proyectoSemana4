package pe.com.projectbanco.ProyectoI.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.customer;
import pe.com.projectbanco.ProyectoI.repo.ICustomerRepo;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public Mono<customer> create(customer obj) {
        return iCustomerRepo.save(obj);
    }

    @Override
    public Mono<customer> update(customer obj) {
        return null;
    }

    @Override
    public Flux<customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Mono<customer> listPorId(String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return iCustomerRepo.deleteById(id);
    }

    @Override
    public Mono<Void> delete(customer obj) {
        return iCustomerRepo.delete(obj);
    }

    @Override
    public Flux<customer> findByType(String type) {
        return iCustomerRepo.findAll().filter(p-> p.getType().equals(type));
    }

    @Override
    public Flux<customer> findByRUC(String ruc) {
        return iCustomerRepo.findAll().filter(r-> r.getBusiness().getRuc().equals(ruc));
    }

    @Override
    public Flux<customer> findByDNI(String dni) {
        return iCustomerRepo.findAll().filter(d->d.getPersonal().getDni().equals(dni));
    }
}
