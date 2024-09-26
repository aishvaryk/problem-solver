package com._1stDibs.app;

import com._1stDibs.app.entites.Admin;
import com._1stDibs.app.entites.Contestant;
import com._1stDibs.app.entites.Problem;
import com._1stDibs.app.entites.User;
import com._1stDibs.app.enums.Difficulty;
import com._1stDibs.app.enums.Role;
import com._1stDibs.app.services.LeaderboardService;
import com._1stDibs.app.services.ProblemsManager;
import com._1stDibs.app.services.SolvingAndScoringService;
import com._1stDibs.app.services.UserService;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Application {

    public static void main(String[] args) {
        System.out.println("Application started");

        final User ADMIN = new Admin("Admin", "Admin", "Admin", "admin");

        final UserService userService = new UserService();

        final ProblemsManager problemsManager = new ProblemsManager();

        final SolvingAndScoringService solvingAndScoringService = new SolvingAndScoringService(userService, problemsManager);

        Problem problem1 = new Problem(1, "ABCD", Difficulty.EASY, new HashSet<>(Arrays.asList("linkedlist", "tree", "graph")), 5);
        problemsManager.addProblem(ADMIN, problem1);

        Problem problem2 = new Problem(2, "ABCD", Difficulty.MEDIUM, new HashSet<>(Arrays.asList("tree", "graph")), 4);
        problemsManager.addProblem(ADMIN, problem2);

        problemsManager.addProblem(ADMIN, new Problem(3, "ABCD", Difficulty.MEDIUM, new HashSet<>(Arrays.asList("linkedlist", "graph")), 2));
        problemsManager.addProblem(ADMIN, new Problem(4, "ABCD", Difficulty.HARD, new HashSet<>(Arrays.asList("linkedlist", "tree")), 1));
        problemsManager.addProblem(ADMIN, new Problem(5, "ABCD", Difficulty.EASY, new HashSet<>(Arrays.asList("graph")), 7));

        System.out.println("All problems - >" + problemsManager.getAllProblems(null, "SCORE"));

        User contestant1 = userService.registerUser("aishvary", "Aishvary", "aishvary", "Engineering", Role.CONTESTANT);
        User contestant2 = userService.registerUser("sampras", "Sampras", "sampras", "HR", Role.CONTESTANT);


        HashMap<String, ArrayList<String>> filters = new HashMap<>();
        filters.put("TAGS", new ArrayList<>(Arrays.asList("tree", "graph")));
        ArrayList<Problem> filteredProblems = problemsManager.getAllProblems(filters, "DIFFICULTY");

        System.out.println("Problems filtered and sorted " + filteredProblems);

        solvingAndScoringService.solveProblem(contestant1,  problem1, 3000);
        solvingAndScoringService.solveProblem(contestant2,  problem1, 2000);
        ArrayList<Problem> recommendedProblems  = solvingAndScoringService.solveProblem(contestant1,  problem2, 2000);

        System.out.println("Recommended problems after solving problem 2 -> " + recommendedProblems);

        System.out.println("Solved By - > " + problem1.getSolvedBy().size() + ", average time taken -> " + problem1.getAverageTime());

        System.out.println("Score of Aishvary " + contestant1.getTotalScore());

        System.out.println("Current Leader - >" + LeaderboardService.getInstance().getLeader().getName());

        problemsManager.addLike(contestant1, problem1);
        problemsManager.addLike(contestant2, problem1);

        System.out.println("Top 3 liked problems - > "  + problemsManager.getTopNLikedProblems(3));
    }
}
