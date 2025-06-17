package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity;

import lombok.Getter;
import lombok.Setter;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "TEST_ENTITY")
public class TestEntity extends AbstractEntity {

    @Column(name = "NAME")
    private String name;
}
