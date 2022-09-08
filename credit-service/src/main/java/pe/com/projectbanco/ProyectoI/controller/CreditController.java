package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Credit;
import pe.com.projectbanco.ProyectoI.service.ICreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/credit")
public class CreditController {

    private static final Logger logger = LoggerFactory.getLogger(CreditController.class);

    @Autowired(required=true)
    private ICreditService iCreditService;


    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Credit>> createCredit(@RequestBody Credit credit) {
        logger.info("{} {}", "Start Controller");
        Mono<Credit> p = iCreditService.create(credit);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Credit>> findAllCredit() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<Credit> p = iCreditService.findAll();
        return new ResponseEntity<Flux<Credit>>(p, HttpStatus.OK);
    }
}
