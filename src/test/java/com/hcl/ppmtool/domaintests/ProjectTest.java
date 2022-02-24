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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        project.setDescription("ProjectDescription");
        project.setProjectName("ProjectName");
        project.setStart_date(new Date());
        project.setEnd_date(new Date());
        projectRepository.save(project);
    }

    @AfterEach
    public void destroyAll() {
        projectRepository.deleteAll();
    }


    @Test
    void getProjectIdentifierTest() {
        assertEquals(project.getProjectIdentifier(),"12345");
    }

    @Test
    void getProjectNameTest() {
        assertEquals(project.getProjectName(),"ProjectName");
    }

    @Test
    void getDescriptionTest() {
        assertEquals(project.getDescription(),"ProjectDescription");
    }

    @Test
    void getStart_dateTest() {
        String start_date = project.getStart_date().toString();
        String expectedStart_date = new Date().toString();
        assertEquals(start_date,expectedStart_date);
    }

    @Test
    void getEnd_dateTest() {
        String end_date = project.getEnd_date().toString();
        String expectedEnd_date = new Date().toString();
        assertEquals(end_date,expectedEnd_date);
    }

    @Test
    void getCreated_AtTest() {
        String created_At = project.getCreated_At().toString();
        String expectedCreated_At = new Date().toString();
        assertEquals(created_At,expectedCreated_At);
    }


}
