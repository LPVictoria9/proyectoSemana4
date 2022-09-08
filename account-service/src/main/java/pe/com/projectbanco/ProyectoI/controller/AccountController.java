package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.service.IAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private IAccountService iAccountService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Account>> createAccount(@RequestBody Account account) {
        logger.info("{} {}", "Start Controller");
        Mono<Account> p = iAccountService.create(account);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Account>> findAllAccount() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<Account> listAccount = iAccountService.findAll();
        return new ResponseEntity<Flux<Account>>(listAccount, HttpStatus.OK);
    }

}
