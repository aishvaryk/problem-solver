package com._1stDibs.app.entites;

import com._1stDibs.app.enums.Role;

import java.util.HashMap;
import java.util.HashSet;

public class User {

    private String username;
    private String name;
    private String password;
    private Role role;
    private String department;
    private HashMap<Problem, Long> solvedProblems;
    private int totalScore;

    private HashSet<Problem> likedProblems;

    User(String username, String name, String department, String password) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.solvedProblems = new HashMap<>();
        this.likedProblems = new HashSet<>();
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    protected void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return this.password;
    }

    public HashMap<Problem, Long> getSolvedProblems() {
        return solvedProblems;
    }

    public void setSolvedProblems(HashMap<Problem, Long> solvedProblems) {
        this.solvedProblems = solvedProblems;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public HashSet<Problem> getLikedProblems() {
        return likedProblems;
    }

    public void setLikedProblems(HashSet<Problem> likedProblems) {
        this.likedProblems = likedProblems;
    }
}
