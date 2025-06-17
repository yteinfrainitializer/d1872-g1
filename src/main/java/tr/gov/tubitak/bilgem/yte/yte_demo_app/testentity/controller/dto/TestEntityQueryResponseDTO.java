package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.controller.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class TestEntityQueryResponseDTO implements Serializable {

    private Long id;
    private String name;

}
