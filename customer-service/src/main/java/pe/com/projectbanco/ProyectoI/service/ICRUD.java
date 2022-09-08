package pe.com.projectbanco.ProyectoI.service;

import pe.com.projectbanco.ProyectoI.model.Business;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<T, V> {

    Mono <T> create(T obj);
    Mono <T> update(T obj);
    Flux <T> findAll();
    Mono <T> listPorId(V id);

    Mono <Void> deleteById(V id);
    Mono <Void> delete (T obj);
}