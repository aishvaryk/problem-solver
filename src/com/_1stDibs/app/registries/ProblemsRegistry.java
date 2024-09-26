package com._1stDibs.app.registries;

import com._1stDibs.app.entites.Problem;

import java.util.HashMap;

public class ProblemsRegistry {
    private static ProblemsRegistry problemsRegistry;
    private final HashMap<Integer, Problem> problems = new HashMap<>();


    public static synchronized ProblemsRegistry getInstance() {
        if (problemsRegistry != null) {
            return problemsRegistry;
        } else {
            problemsRegistry = new ProblemsRegistry();
            return problemsRegistry;
        }
    }

    public HashMap<Integer, Problem> getProblems() {
        return problems;
    }

    public void addProblem(Problem problem) {
        problems.put(problem.getProblemId(), problem);
    }

    public Problem getProblem(int problemId) {
        return problems.get(problemId);
    }


}
