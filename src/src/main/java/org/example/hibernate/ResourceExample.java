package org.example.hibernate;

import java.io.InputStream;
import java.util.Scanner;

public class ResourceExample {
    public static void main(String[] args) {

        InputStream resourceAsStream =
                ResourceExample.class.getResourceAsStream("/lines.txt");

        Scanner scanner = new Scanner(resourceAsStream);

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
