package com._1stDibs.app.entites;

import com._1stDibs.app.enums.Difficulty;

import java.util.HashSet;

public class Problem {

    private int problemId;
    private String description;

    private Difficulty difficulty;

    private HashSet<String> tags;

    private int score;

    private HashSet<User> likedBy = new HashSet<User>();

    private HashSet<User> solvedBy = new HashSet<User>();

    private double averageTime;

    public Problem(int problemId, String description, Difficulty difficulty, HashSet<String> tags, int score) {
        this.problemId = problemId;
        this.description = description;
        this.difficulty = difficulty;
        this.tags = tags;
        this.score = score;
    }

    public int getProblemId() {
        return problemId;
    }

    public String getDescription() {
        return description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public int getScore() {
        return score;
    }

    public HashSet<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(HashSet<User> likedBy ) {
        this.likedBy = likedBy;
    }

    public HashSet<User> getSolvedBy() {
        return solvedBy;
    }

    public void setSolvedBy(HashSet<User> solvedBy) {
        this.solvedBy = solvedBy;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }
}
