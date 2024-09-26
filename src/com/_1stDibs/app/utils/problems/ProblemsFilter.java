package com._1stDibs.app.utils.problems;

import com._1stDibs.app.entites.Problem;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemsFilter {

    private HashMap<String, ArrayList<String>> filters;

    public ProblemsFilter(HashMap<String, ArrayList<String>> filters) {
        this.filters = filters;
    }

    public ArrayList<Problem> filerProblems(ArrayList<Problem> problems) {
        if (filters==null) return problems;
        ArrayList<Problem> filteredProblems = new ArrayList<>();
        for (String filter: filters.keySet()) {
            switch (filter) {
                case "TAGS":
                    ArrayList<String> filterTags = filters.get(filter);
                    for (Problem problem : problems) {
                        boolean hasAllTags = true;

                        for (String filterTag : filterTags) {
                            if (!problem.getTags().contains(filterTag)) {
                                hasAllTags = false;
                                break;
                            }
                        }

                        if (hasAllTags) {
                            filteredProblems.add(problem);
                        }
                    }
                    break;
                case "DIFFICULTY":
                    ArrayList<String> filterDifficulties = filters.get(filter);
                    for (Problem problem : problems) {
                        if (filterDifficulties.contains(problem.getDifficulty())) {
                            filteredProblems.add(problem);
                        }
                    }
                    break;
                default:
                    filteredProblems = problems;
                    break;

            }
        }

        return filteredProblems;
    }

}
