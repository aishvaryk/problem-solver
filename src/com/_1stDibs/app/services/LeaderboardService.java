package com._1stDibs.app.services;

import com._1stDibs.app.entites.User;
import com._1stDibs.app.registries.UserRegistry;

import java.util.ArrayList;

public class LeaderboardService {


    private static LeaderboardService leaderboardService;

    public static synchronized LeaderboardService getInstance() {
        if (leaderboardService != null) {
            return leaderboardService;
        } else {
            leaderboardService = new LeaderboardService();
            return leaderboardService;
        }
    }

    public User getLeader() {
        ArrayList<User> allUsers = new ArrayList<>(UserRegistry.getInstance().getUsers().values());
        int maxScore = 0;
        User leader = null;
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getTotalScore() > maxScore) {
                maxScore = allUsers.get(i).getTotalScore();
                leader = allUsers.get(i);
            }
        }
        return leader;
    }
}
