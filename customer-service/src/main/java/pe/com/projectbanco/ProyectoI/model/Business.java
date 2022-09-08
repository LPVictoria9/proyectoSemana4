package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Business {
    @Id
    private String id;
    private String ruc;
    private String companyName;
    private List<String> legalRepresentative; //Titulares 1 o +
    private Integer nroLegalRepresentative;
    private List<String> signatory; // firmante 0 o +
    private boolean pyme;

}
