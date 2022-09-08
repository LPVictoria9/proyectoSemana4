package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.currentAccount;
import pe.com.projectbanco.ProyectoI.service.ICurrentAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/currentAccount")
public class CurrentAccountController {
    private static final Logger logger = LoggerFactory.getLogger(CurrentAccountController.class);

    @Autowired
    private ICurrentAccountService iCurrentAccountService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<currentAccount>> createCurrentAccount(@RequestBody currentAccount currentAccount) {
        logger.info("{} {}", "Start currentAccountController");
        Mono<currentAccount> p = iCurrentAccountService.create(currentAccount);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<currentAccount>> findAllcurrentAccount() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<currentAccount> p= iCurrentAccountService.findAll();
        return new ResponseEntity<Flux<currentAccount>>(p, HttpStatus.OK);
    }



}
