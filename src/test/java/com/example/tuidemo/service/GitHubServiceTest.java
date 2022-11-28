package com.example.tuidemo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GitHubServiceTest {

    private GitHubService gitHubService;

    @BeforeAll
    public void setup() throws IOException {

        gitHubService = Mockito.spy(GitHubService.class);

        GHBranch ghBranch = Mockito.mock(GHBranch.class);
        GHBranch ghBranch2 = Mockito.mock(GHBranch.class);
        GHBranch ghBranch3 = Mockito.mock(GHBranch.class);
        GHRepository repository = Mockito.mock(GHRepository.class);


        when(ghBranch.getName()).thenReturn("branch");
        when(ghBranch2.getName()).thenReturn("branch2");
        when(ghBranch3.getName()).thenReturn("branch3");

        when(ghBranch.getSHA1()).thenReturn("sha");
        when(ghBranch2.getSHA1()).thenReturn("sha3");
        when(ghBranch3.getSHA1()).thenReturn("sha2");

        Map<String, GHBranch> branchMap = new HashMap<>();
        branchMap.put("key1", ghBranch);
        branchMap.put("key2", ghBranch2);
        branchMap.put("key3", ghBranch3);
        when(repository.getBranches()).thenReturn(branchMap);
        Mockito.doReturn(List.of(repository))
                .when(gitHubService)
                .getRepositoriesByUserName("name");
    }

    @Test
    public void testService() throws IOException {
        List<GHRepository> name = gitHubService.getRepositoriesByUserName("name");
        System.out.println(name);
        Assertions.assertThat(name).isNotNull();
        Assertions.assertThat(name.size()).isEqualTo(1);
        Assertions.assertThat(name.get(0)).isNotNull();
        Assertions.assertThat(name.get(0).getBranches()).isNotNull();
        Assertions.assertThat(name.get(0).getBranches().size()).isEqualTo(3);
        Assertions.assertThat(name.get(0).getBranches().get("key1")).isNotNull();
        Assertions.assertThat(name.get(0).getBranches().get("key1").getName()).isEqualTo("branch");
        Assertions.assertThat(name.get(0).getBranches().get("key1").getSHA1()).isEqualTo("sha");
    }
}