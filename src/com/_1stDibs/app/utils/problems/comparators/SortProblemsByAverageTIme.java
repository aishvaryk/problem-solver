package com._1stDibs.app.utils.problems.comparators;

import com._1stDibs.app.entites.Problem;

import java.util.Comparator;

public class SortProblemsByAverageTIme implements Comparator<Problem> {

    @Override
    public int compare(Problem problem1, Problem problem2) {
        return (int) (problem1.getAverageTime() - problem2.getAverageTime());
    }
}
