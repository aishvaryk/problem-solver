package com._1stDibs.app.services;

import com._1stDibs.app.entites.Problem;
import com._1stDibs.app.entites.User;
import com._1stDibs.app.enums.Role;
import com._1stDibs.app.registries.ProblemsRegistry;
import com._1stDibs.app.utils.problems.ProblemsFilter;
import com._1stDibs.app.utils.problems.ProblemsSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ProblemsManager {

    private static ProblemsManager problemsManagerService;

    public static synchronized ProblemsManager getInstance() {
        if (problemsManagerService != null) {
            return problemsManagerService;
        } else {
            return new ProblemsManager();
        }
    }


    public void addProblem(User user, Problem problem) {
        if (user.getRole() == Role.ADMIN) ProblemsRegistry.getInstance().addProblem(problem);
    }

    public ArrayList<Problem> getAllProblems(HashMap<String, ArrayList<String>> filters, String sortBy) {
        ArrayList<Problem> filteredProblems =new ArrayList<>( ProblemsRegistry.getInstance().getProblems().values());
        if (filters != null) {
            ProblemsFilter problemsFilter = new ProblemsFilter(filters);
            filteredProblems = problemsFilter.filerProblems(filteredProblems);
        }
        if (sortBy != null) {
            ProblemsSorter problemsSorter = new ProblemsSorter(sortBy);
            problemsSorter.sortProblems(filteredProblems);
        }
        return filteredProblems;
    }

    public ArrayList<Problem> getTopNLikedProblems(int n) {
        return new ArrayList<>(getAllProblems(null, "LIKES").subList(0,n));
    }

    public void addLike(User user, Problem problem) {
        HashSet<Problem> userLikedProblems = user.getLikedProblems();
        userLikedProblems.add(problem);
        user.setLikedProblems(userLikedProblems);

        HashSet<User> usersLikingProblem = problem.getLikedBy();
        usersLikingProblem.add(user);
        problem.setLikedBy(usersLikingProblem);
    }

    public void updateProblem(Problem problem, User user) {
        HashSet<User> solvedUsers = problem.getSolvedBy();
        solvedUsers.add(user);
        problem.setSolvedBy(solvedUsers);
    }

    public void updateAverageTime(Problem problem, double averageTime) {
        problem.setAverageTime(averageTime);
    }
}
