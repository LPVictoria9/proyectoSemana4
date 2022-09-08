package pe.com.projectbanco.ProyectoI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.com.projectbanco.ProyectoI.model.customer;
import pe.com.projectbanco.ProyectoI.service.IBusinessService;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;
    private IBusinessService iBusinessService;


    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<customer>> createCustomer(@RequestBody customer customer) {
        Mono<customer> p = iCustomerService.create(customer);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<customer>> findAllCustomer() {
        Flux<customer> listCustomer = iCustomerService.findAll();
        return new ResponseEntity<Flux<customer>>(listCustomer, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll/business/{ruc}", produces = "application/json")
    public ResponseEntity<Flux<customer>> findAllCustomerB(@PathVariable("ruc") String ruc) {
        Flux<customer> listCustomer = iCustomerService.findAll().filter(d-> d.getPersonal().getDni().equals(ruc));
        return new ResponseEntity<Flux<customer>>(listCustomer, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll/personal/{dni}", produces = "application/json")
    public ResponseEntity<Flux<customer>> findAllCustomerP(@PathVariable("dni") String dni) {
        Flux<customer> listCustomer = iCustomerService.findAll().filter(d-> d.getPersonal().getDni().equals(dni));
        return new ResponseEntity<Flux<customer>>(listCustomer, HttpStatus.OK);
    }

    @GetMapping("findByType/{type}")
    public  ResponseEntity<Flux<customer>> findByType(@PathVariable("type") String type){
        Flux<customer> List= iCustomerService.findByType(type);
        return new ResponseEntity<>(List,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<customer>> changeCustomer(@RequestBody customer customer) {
        Mono<customer> p = iCustomerService.update(customer);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @DeleteMapping("personal/deleteDNI/{dni}")
    public Flux<ResponseEntity<Void>> deleteCustomerDNI(@PathVariable("dni") String dni)
    {
        return iCustomerService.findByDNI(dni).flatMap(p -> {
            return iCustomerService.delete(p).then(Mono.just( new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("business/deleteRUC/{ruc}")
    public Flux<ResponseEntity<Void>> deleteCustomerRUC(@PathVariable("ruc") String ruc)
    {
        return iCustomerService.findByRUC(ruc).flatMap(p -> {
            return iCustomerService.delete(p).then(Mono.just( new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

}
