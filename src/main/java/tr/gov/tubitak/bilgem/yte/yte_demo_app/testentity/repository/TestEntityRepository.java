package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;

@Repository
public interface TestEntityRepository extends PagingAndSortingRepository<TestEntity, Long>, JpaSpecificationExecutor<TestEntity> {

}
