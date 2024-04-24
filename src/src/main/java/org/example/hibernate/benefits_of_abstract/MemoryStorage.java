package org.example.hibernate.benefits_of_abstract;

import java.util.ArrayList;
import java.util.List;

public class MemoryStorage extends Storage{

    List<User2> users = new ArrayList<>();

    @Override
    public User2 findUser(String name) {
        return users.stream().filter(u -> u.getName().equals(name)).findAny().get();
    }

    @Override
    public void addUser(User2 user) {
        users.add(user);
    }

    @Override
    public void setDeposit(User2 user, int amount) {
        findUser(user.getName()).setDeposit(amount);
    }
}
