package com.hcl.ppmtool.domaintests;

import com.hcl.ppmtool.domain.Project;
import com.hcl.ppmtool.repositories.ProjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class ProjectTest {

    @Autowired
    private ProjectRepository projectRepository;
    Project project = new Project();

    @BeforeEach
    void initUseCase() {
        project.setProjectIdentifier("12345");
        project.setDescription("setDescription");
        project.setProjectName("setProjectName");
        projectRepository.save(project);
    }

    @AfterEach
    public void destroyAll() {
        projectRepository.deleteAll();
    }


    @Test
    void getIdTest() {
        assertEquals(project.getId(), 1L);
    }
}
