package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Personal;
import pe.com.projectbanco.ProyectoI.service.IPersonalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/personal")
public class PersonalController {

    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);

    @Autowired
    private IPersonalService IPersonalService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Personal>> createPersonal(@RequestBody Personal personal) {
        logger.info("{} {}", "Start PersonalController");
        Mono<Personal> p = IPersonalService.create(personal);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Personal>> findAllPersonal() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<Personal> listPersonal = IPersonalService.findAll();
        return new ResponseEntity<Flux<Personal>>(listPersonal, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Personal>> changePersonal(@RequestBody Personal personal) {
        Mono<Personal> p = IPersonalService.update(personal);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{dni}")
    public Flux<ResponseEntity<Void>> deletePersonal(@PathVariable("dni") String dni)
    {
        return IPersonalService.findByDNI(dni).flatMap(p -> {
            return IPersonalService.delete(p).then(Mono.just( new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("findByNroDNI/{dni}")
    public  ResponseEntity<Flux<Personal>> findByRUC(@PathVariable("dni") String dni){
        logger.info("Start controllerPersonal method findByDNI =>", dni);
        Flux<Personal> ListPersonal= IPersonalService.findByDNI(dni);
        return new ResponseEntity<>(ListPersonal,HttpStatus.OK);
    }

    @GetMapping("findByTypePersonal/{type}")
    public  ResponseEntity<Flux<Personal>> findByTypePersonal(@PathVariable("typePersonal") String typePersonal){
        logger.info("Start controllerPersonal method findByDNI =>", typePersonal);
        Flux<Personal> ListPersonal= IPersonalService.findByTypePersonal(typePersonal);
        return new ResponseEntity<>(ListPersonal,HttpStatus.OK);
    }


}
