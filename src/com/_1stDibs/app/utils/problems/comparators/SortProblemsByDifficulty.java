package com._1stDibs.app.utils.problems.comparators;

import com._1stDibs.app.entites.Problem;

import java.util.Comparator;

public class SortProblemsByDifficulty implements Comparator<Problem> {

    @Override
    public int compare(Problem problem1, Problem problem2) {
        return problem1.getDifficulty().ordinal() - problem2.getDifficulty().ordinal();
    }
}
