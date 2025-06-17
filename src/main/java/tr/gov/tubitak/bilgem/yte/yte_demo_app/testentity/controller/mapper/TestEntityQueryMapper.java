package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.controller.mapper;

import org.mapstruct.Mapper;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.controller.dto.TestEntityQueryResponseDTO;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;

@Mapper(componentModel = "spring")
public interface TestEntityQueryMapper {

    TestEntityQueryResponseDTO toDto(TestEntity entity);

}
