package com.hcl.ppmtool.domaintests;

import com.hcl.ppmtool.domain.Project;
import com.hcl.ppmtool.domain.User;
import com.hcl.ppmtool.repositories.ProjectRepository;
import com.hcl.ppmtool.repositories.UserRepository;
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

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserTest {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    Project project = new Project();
    User user = new User();

    @BeforeEach
    void initUseCase() {
        project.setProjectIdentifier("12345");
        project.setDescription("ProjectDescription");
        project.setProjectName("ProjectName");
        project.setStart_date(new Date());
        project.setEnd_date(new Date());

        user.setId(1L);
        user.setUsername("email@email.com");
        user.setPassword("Password");
        user.setFullName("FullName");

        projectRepository.save(project);
        userRepository.save(user);

    }

    @AfterEach
    public void destroyAll() {
        projectRepository.deleteAll();
    }

    @Test
    void getFullNameTest() {
        assertEquals(user.getFullName(), "FullName");
    }

    @Test
    void getCreate_AtTest() {
        user.setCreate_At(new Date());
        assertEquals(user.getCreate_At(), new Date());
    }

}
