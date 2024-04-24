package org.example.hibernate.benefits_of_abstract;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StorageTest {
    @Test
    public void testMemoryStorage() {
        Storage storage = new MemoryStorage();
        testInternal(storage);
    }
    @Test
    public void testDbStorage() {
        Storage storage = new DbStorage();
        testInternal(storage);
    }


    private void testInternal(Storage storage) {
        User2 karel = new User2("Karel");
        User2 jarda = new User2("Jarda");

        storage.addUser(karel);
        storage.addUser(jarda);

        storage.setDeposit(karel, 2000);
        storage.setDeposit(jarda, 10000);

        storage.transfer("Karel", "Jarda", 1000);

        Assertions.assertEquals(1000, storage.findUser("Karel").getDeposit());
        Assertions.assertEquals(11000, storage.findUser("Jarda").getDeposit());
    }
}