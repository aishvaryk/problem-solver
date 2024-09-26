package com._1stDibs.app.utils.problems;

import com._1stDibs.app.entites.Problem;
import com._1stDibs.app.utils.problems.comparators.SortProblemsByAverageTIme;
import com._1stDibs.app.utils.problems.comparators.SortProblemsByDifficulty;
import com._1stDibs.app.utils.problems.comparators.SortProblemsByLikes;
import com._1stDibs.app.utils.problems.comparators.SortProblemsByScore;

import java.util.ArrayList;

public class ProblemsSorter {
    private String sortBy;

    public ProblemsSorter(String sortBy) {
        this.sortBy = sortBy;
    }

    public ArrayList<Problem> sortProblems(ArrayList<Problem> problems) {
        switch (sortBy) {
            case "LIKES":
                problems.sort(new SortProblemsByLikes());
                break;
            case "SCORE":
                problems.sort(new SortProblemsByScore());
                break;
            case "DIFFICULTY":
                problems.sort(new SortProblemsByDifficulty());
                break;
            case "AVERAGE_TIME":
                problems.sort(new SortProblemsByAverageTIme());
                break;
            default:
                problems.sort(new SortProblemsByDifficulty());
                break;

        }
        return problems;
    }
}
