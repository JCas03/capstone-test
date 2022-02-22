package com.hcl.ppmtool.servicesTests;

import com.hcl.ppmtool.domain.Project;
import com.hcl.ppmtool.repositories.ProjectRepository;
import com.hcl.ppmtool.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProjectServiceTest {


    ProjectService projectServiceTest = Mockito.mock(ProjectService.class);

    @MockBean
    ProjectRepository projectRepositoryTest;


    @Test
    public void findAllProjectTest(){

        long testProjId = 1;
        Project pj = new Project();
        pj.setId(testProjId);
        pj.setProjectName("Mock Proj 1");
        pj.setProjectIdentifier("MOCK1");
        pj.setDescription("Mock project 1 description");

        when(projectRepositoryTest.findAll()).thenReturn(Stream.of(pj).collect(Collectors.toList()));
        Iterable<Project> list = projectRepositoryTest.findAll();

        //Assertions.assertThat(pj.getId()).isGreaterThan(0);
    }



}
