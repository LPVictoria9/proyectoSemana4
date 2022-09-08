package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Movement;
import pe.com.projectbanco.ProyectoI.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/movement")
public class MovementController {
    private static final Logger logger = LoggerFactory.getLogger(MovementController.class);

    @Autowired
    private IMovementService iMovementService;

   @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Movement>> createMovement(@RequestBody Movement movement) {
        logger.info("{} {}", "Start MovementController");
        Mono<Movement> oMovement = iMovementService.create(movement);
        return new ResponseEntity<>(oMovement, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Movement>> findAllMovimiento() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<Movement> listMovement = iMovementService.findAll();
        return new ResponseEntity<Flux<Movement>>(listMovement, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Movement>> changeMovement(@RequestBody Movement movimiento) {
        Mono<Movement> oMovement = iMovementService.update(movimiento);
        return new ResponseEntity<>(oMovement, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public Flux<ResponseEntity<Void>> deleteMovemenent(@PathVariable("id") String id) {
        logger.info("Start controllerMovemenent method change Delete =>", id);
        return iMovementService.findByIdMovement(id).flatMap(res -> {
            return iMovementService.delete(res).then(Mono.just( new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("findById/{id}")
    public Flux<ResponseEntity<Movement>> findByIdCustomer(@PathVariable("id") String id){
        logger.info("Start controllerMovemenent method findByIdMovemenent =>", id);
        return iMovementService.findByIdMovement(id)
                .map(res-> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(res))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
