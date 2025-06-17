package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.PageRequestDTO;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity_;

import java.util.List;
import java.util.Map;

@DataJpaTest
class TestEntityRepositoryTest {

    @Autowired
    private TestEntityRepository testEntityRepository;

    private PageRequestDTO pageRequestDTO;

    @BeforeEach
    void setUp() {
        pageRequestDTO = PageRequestDTO.builder()
                .page(0)
                .size(20)
                .build();
    }

    @Test
    void queryByNameTest(){
        Map<String, Object> criteriaEqMap = Map.of(TestEntity_.NAME, "first name");
        pageRequestDTO.setEq(criteriaEqMap);

        List<TestEntity> testEntityList = testEntityRepository.findAll(TestEntitySpecifications.byPageRequestDTO(pageRequestDTO));
        Assertions.assertEquals(1, testEntityList.size());
        Assertions.assertEquals("first name", testEntityList.get(0).getName());
    }
}