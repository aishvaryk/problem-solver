package com._1stDibs.app.entites;

import com._1stDibs.app.enums.Role;

import java.util.HashMap;

public class Contestant extends User {

    private String department;
    private HashMap<Problem, Integer> problemsSolved;


    public Contestant(String username, String name, String department,  String password) {
        super(username, name, department, password);
        this.setRole(Role.CONTESTANT);
    }

    public HashMap<Problem, Integer> getProblemsSolved() {
        return problemsSolved;
    }

    public void setProblemsSolved(HashMap<Problem, Integer> problemsSolved) {
        this.problemsSolved = problemsSolved;
    }
}
