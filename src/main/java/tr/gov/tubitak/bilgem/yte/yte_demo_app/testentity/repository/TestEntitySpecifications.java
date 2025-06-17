package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.repository;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.PageRequestDTO;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.SpecificationMapper;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity_;

@UtilityClass
public class TestEntitySpecifications {

    public static Specification<TestEntity> byPageRequestDTO(PageRequestDTO pageRequestDTO) {
        return SpecificationMapper.SpecificationBuilder
                .newBuilder()
                .forCriteriaDTO(pageRequestDTO)
                .with(TestEntity_.id)
                .with(TestEntity_.name)
                .build();
    }

}
