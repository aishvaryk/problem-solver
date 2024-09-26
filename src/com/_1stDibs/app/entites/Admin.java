package com._1stDibs.app.entites;

import com._1stDibs.app.enums.Role;

public class Admin extends User {


    public Admin(String username, String name, String department, String password) {
        super(username, name, department, password);
        this.setRole(Role.ADMIN);
    }


}
