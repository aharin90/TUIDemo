package com.example.tuidemo.service;

import com.example.tuidemo.exceptions.UserNotFoundException;
import com.example.tuidemo.model.Branch;
import com.example.tuidemo.model.RepositoryInfo;
import org.kohsuke.github.GHBranch;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GitHubService {

    public List<RepositoryInfo> getRepoInfos(String name) throws UserNotFoundException {
        List<RepositoryInfo> repoInfos = new ArrayList<>();
        try {
            for (GHRepository ghRepo : getRepositoriesByUserName(name)) {
                Map<String, GHBranch> branchesMap = ghRepo.getBranches();
                List<Branch> branches = new ArrayList<>();
                for (String key : branchesMap.keySet()) {
                    GHBranch ghBranch = branchesMap.get(key);
                    branches.add(new Branch(ghBranch.getName(), ghBranch.getSHA1()));
                }
                repoInfos.add(new RepositoryInfo(ghRepo.getName(), ghRepo.getOwnerName(), branches));
            }
        } catch (IOException e) {
            throw new UserNotFoundException(name);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return repoInfos;
    }

    public List<GHRepository> getRepositoriesByUserName(String name) throws IOException {
        GitHub gitHub = GitHub.connectAnonymously();
        GHUser user = gitHub.getUser(name);
        return user.listRepositories().toList();
    }
}
