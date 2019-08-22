package com.hillel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UsersHolderInCsv {
    private List<User> userList = new ArrayList<>();

    public UsersHolderInCsv() {
        loadAll();
    }

    public List<User> loadAll() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("/Users/mac/IdeaProjects/HomeWorkOne/src/users.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext()) {
            String row = scanner.next();
            String[] columns = row.split(",");
            int id = Integer.parseInt(columns[0]);
            String email = columns[1];
            String name = columns[2];
            String role = columns[3];

            User user = new User(id, email, name, role);
            userList.add(user);
        }
        return userList;
    }

    public User findUserById(int id) {
        for (User user: userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }
}
