package com._1stDibs.app.services;

import com._1stDibs.app.entites.Problem;
import com._1stDibs.app.entites.User;
import com._1stDibs.app.registries.ProblemsRegistry;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemRecommendationService {

    private int calculateSimilarityScore(Problem problem1, Problem problem2) {
        int sharedTags = 0;
        for (String tag1 : problem1.getTags()) {
            for (String tag2 : problem2.getTags()) {
                if (tag1.equals(tag2)) {
                    sharedTags++;
                }
            }
        }
        return sharedTags * 2 + problem2.getLikedBy().size();
    }

    public ArrayList<Problem> recommendProblems(User user, Problem solvedProblem, int n) {
        ArrayList<Problem> allProblems = new ArrayList<Problem>(ProblemsRegistry.getInstance().getProblems().values());
        HashMap<Problem, Integer> similarityMap = new HashMap<>();
        for (Problem problem : allProblems) {
            similarityMap.put(problem, calculateSimilarityScore(solvedProblem, problem));
        }
        allProblems.sort((problem1, problem2) -> Integer.compare(similarityMap.get(problem2), similarityMap.get(problem2)));
        return new ArrayList<>(allProblems.subList(0, n));
    }
}
