package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "movement")

public class Movement {
    @Id
    @BsonIgnore
    private String id;
    private String typeMovement;
    private double amount; // monto
    private String date;
    @Valid
    private Account account;

}

