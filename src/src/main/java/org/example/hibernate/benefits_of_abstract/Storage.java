package org.example.hibernate.benefits_of_abstract;


public abstract class Storage {
    public abstract User2 findUser(String name);
    public abstract void addUser(User2 user);

    public abstract void setDeposit(User2 user, int amount);
    public  void transfer(String fromUser, String toUser, int value) {
        User2 from = findUser(fromUser);
        User2 to = findUser(toUser);
        setDeposit(from,from.getDeposit() - value);
        setDeposit(to,to.getDeposit() + value);
    }

    public void withDraw(String user, int amount) {
        User2 user1 = findUser(user);
        setDeposit(user1, user1.getDeposit() - amount);
    }

}
