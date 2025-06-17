package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.service;

import org.springframework.data.domain.Page;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.PageRequestDTO;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;

public interface TestEntityService {

    Page<TestEntity> query(PageRequestDTO pageRequestDTO);
}
