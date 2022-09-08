package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
@Data
public class customer {

    @Id
    private String id;
    private String type; //Bussiness (B) Personal (P)

    @Valid
    private Personal personal;

    @Valid
    private Business business;
}
