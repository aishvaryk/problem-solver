package com._1stDibs.app.services;

import com._1stDibs.app.entites.Admin;
import com._1stDibs.app.entites.Contestant;
import com._1stDibs.app.entites.Problem;
import com._1stDibs.app.entites.User;
import com._1stDibs.app.enums.Role;
import com._1stDibs.app.registries.UserRegistry;

import java.util.HashMap;
import java.util.Objects;

public class UserService {

    public User login(String username, String password) throws RuntimeException {
        HashMap<String, User> users = UserRegistry.getInstance().getUsers();
        User user = null;
        try {

            if (!users.containsKey(username)) {
                throw new RuntimeException("Wrong username");
            } else {
                if (!Objects.equals(users.get(username).getPassword(), password)) {
                    throw new RuntimeException("Wrong password");
                } else {
                    user = users.get(username);
                }
            }


        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User registerUser(String username, String name, String password, String department, Role role) {
        User user = null;
        if (role == Role.ADMIN) {
            user = new Admin(username, name, department, password);
        } else if (role == Role.CONTESTANT) {
            user = new Contestant(username, name, department, password);
        }
        UserRegistry.getInstance().addUser(user);
        return user;
    }

    public void addSolvedProblem(User user, Problem problem, long timeTaken, int score) {
        user.setTotalScore(user.getTotalScore() + score);
        HashMap<Problem, Long> userSolvedProblems = user.getSolvedProblems();
        userSolvedProblems.put(problem, timeTaken);
        user.setSolvedProblems(userSolvedProblems);
    }

}
