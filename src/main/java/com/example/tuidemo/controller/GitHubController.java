package com.example.tuidemo.controller;


import com.example.tuidemo.model.RepositoryInfo;
import com.example.tuidemo.service.GitHubService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "git")
//@ApiOperation("Products API")
public class GitHubController{

    final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "User with specified ID not found")
    })
    @GetMapping(path = "{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RepositoryInfo> getUsersData(@PathVariable("name")
                                                 @ApiParam(name = "name", value = "GitHub user name", example = "sampleUser")
                                                 String name)  {

        try {
            List<RepositoryInfo> repoInfos = gitHubService.getRepoInfos(name);
            return repoInfos;
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
