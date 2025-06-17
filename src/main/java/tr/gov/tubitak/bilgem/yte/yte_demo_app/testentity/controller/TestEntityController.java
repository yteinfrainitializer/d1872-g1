package tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.PageRequestDTO;
import tr.gov.tubitak.bilgem.yte.infra.data.jpa.PageResultDTO;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.controller.mapper.TestEntityQueryMapper;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.entity.TestEntity;
import tr.gov.tubitak.bilgem.yte.yte_demo_app.testentity.service.TestEntityService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/testEntity")
public class TestEntityController {

    private final TestEntityService testEntityService;
    private final TestEntityQueryMapper testEntityQueryMapper;

    @ApiOperation("Performs the test entity query according to the request criteria.")
    @PostMapping("/query")
    public PageResultDTO query(@RequestBody PageRequestDTO pageRequestDTO) {
        Page<TestEntity> testEntityPage = testEntityService.query(pageRequestDTO);
        return new PageResultDTO(testEntityPage, testEntityQueryMapper::toDto);
    }
}
