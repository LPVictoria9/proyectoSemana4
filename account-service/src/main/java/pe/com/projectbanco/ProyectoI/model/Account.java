package pe.com.projectbanco.ProyectoI.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
@Data

public class Account {
    @Id
    private String id;
    private String nroAccount;
    private double balance;
    private Integer limit;
    private Integer nroTransaction;

    private Product product;
}
