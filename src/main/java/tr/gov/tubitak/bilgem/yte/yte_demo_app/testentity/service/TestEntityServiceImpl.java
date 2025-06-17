package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.PageRequestDTO;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.configuration.annotation.ReadReplica;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity_;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.repository.TestEntityRepository;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.repository.TestEntitySpecifications;

@Service
@RequiredArgsConstructor
public class TestEntityServiceImpl implements TestEntityService {

    private final TestEntityRepository testEntityRepository;

    @Override
    @ReadReplica
    @Transactional(readOnly = true)
    public Page<TestEntity> query(PageRequestDTO pageRequestDTO) {
        Specification<TestEntity> querySpecification = TestEntitySpecifications.byPageRequestDTO(pageRequestDTO);

        PageRequest pageRequest = PageRequestDTO.PageRequestBuilder.of(pageRequestDTO)
                .withSort(TestEntity_.id)
                .build();

        return testEntityRepository.findAll(querySpecification, pageRequest);
    }

}
