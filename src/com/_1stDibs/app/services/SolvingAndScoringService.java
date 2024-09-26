package com._1stDibs.app.services;

import com._1stDibs.app.entites.Problem;
import com._1stDibs.app.entites.User;

import java.util.ArrayList;
import java.util.HashSet;

public class SolvingAndScoringService {

    private final UserService userService;
    private final ProblemsManager problemsManager;

    private final int RECOMMENDED_PROBLEMS_COUNT = 5;

    public SolvingAndScoringService(UserService userService, ProblemsManager problemManagementService) {
        this.userService = userService;
        this.problemsManager = problemManagementService;
    }

    public ArrayList<Problem> solveProblem(User user, Problem problem, long timeTaken) {
        int score = calculateScore(problem, timeTaken);
        // Update user solved problems and score
        userService.addSolvedProblem(user, problem, timeTaken, score);
        // Update problem statistics
        problemsManager.updateProblem(problem, user);
        problemsManager.updateAverageTime(problem, calculateAverageTime(problem));

        return recommendProblems(user, problem, RECOMMENDED_PROBLEMS_COUNT);
    }

    private int calculateScore(Problem problem, long timeTaken) {
        return problem.getScore() - (int) Math.ceil(timeTaken / 1000);
    }

    private double calculateAverageTime(Problem problem) {
        Long totalTime = totalTimeTaken(problem);
        return totalTime / (double) problem.getSolvedBy().size();
    }

    private long totalTimeTaken(Problem problem) {
        long totalTimeTaken = 0;
        HashSet<User> users = problem.getSolvedBy();
        for (User user : users) {
            totalTimeTaken += user.getSolvedProblems().get(problem);
        }
        return totalTimeTaken;
    }


    private ArrayList<Problem> recommendProblems(User user, Problem solvedProblem, int n) {
        ProblemRecommendationService problemRecommendationService = new ProblemRecommendationService();
        return problemRecommendationService.recommendProblems(user, solvedProblem, n);
    }
}

