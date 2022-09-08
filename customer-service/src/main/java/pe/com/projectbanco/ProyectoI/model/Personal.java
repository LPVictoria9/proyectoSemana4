package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "personal")
@Data

public class Personal {
    @Id
    @BsonIgnore
    private String id;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String phone;
    private String address;
    private String typePersonal;
    private boolean vip;

  //  List<String> cuentas;

}
