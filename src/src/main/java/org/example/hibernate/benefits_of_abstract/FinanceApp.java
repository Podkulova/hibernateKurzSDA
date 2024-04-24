package org.example.hibernate.benefits_of_abstract;

import org.example.hibernate.dao.User;

public class FinanceApp {
    public static void main(String[] args) {
        FinanceApp financeApp = new FinanceApp();

        Storage storage = financeApp.getStorage(1);
        User2 karel = new User2("Karel");

        User2 jarda = new User2("Jarda");

        storage.setDeposit(karel, 2000);
        storage.setDeposit(jarda, 10000);

        storage.transfer("Karel", "Jarda", 1000);

        User2 novak = storage.findUser("Novák");
    }

    private Storage getStorage(int type){
        return switch (type)
        {
            case 1-> new MemoryStorage();
            case 2-> new DbStorage();
            //case 3-> new WebServiceStorage()
            default -> null;
        };
    }

}
