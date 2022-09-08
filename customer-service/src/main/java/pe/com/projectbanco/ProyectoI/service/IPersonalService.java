package pe.com.projectbanco.ProyectoI.service;


import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Business;
import pe.com.projectbanco.ProyectoI.model.Personal;
import reactor.core.publisher.Flux;

import javax.print.DocFlavor;

public interface IPersonalService extends ICRUD<Personal, String> {

    @Query("{'dni':?0}")
    Flux<Personal> findByDNI(String ruc);

    @Query("{'typePersonal':?0}")
    Flux<Personal> findByTypePersonal(String typePersonal);
}
