package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "currentAccount")
@Data

public class currentAccount {
    @Id
    private String id;
    private String typeCC; // ahorro (A), Account corriente(CC), plazo fijo (PF)

}
