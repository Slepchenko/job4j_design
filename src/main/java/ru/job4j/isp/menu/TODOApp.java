package ru.job4j.isp.menu;

import java.io.*;

public class TODOApp {
    public static final ActionDelegate STUB_ACTION =
            () -> System.out.println("Действие пункта ");
    private static final Menu MENU = new SimpleMenu();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Выберите команду: 1.добавить, 2.получить, 3.печать, 4.выход");
            String str = reader.readLine();
            while (!str.equals("4")) {
                if (str.equals("1")) {
                    System.out.println("Добавить пункт");
                    System.out.print("Введите название пункта:");
                    str = reader.readLine();
                   if (findItem(str)) {
                       System.out.println("Выбран пункт - " + str + ". Введите подпункт");
                       MENU.add(str, reader.readLine(), STUB_ACTION);
                   } else {
                       System.out.println("пункт добавлен");
                       MENU.add(MENU.ROOT, str, STUB_ACTION);
                   }
                }

                if (str.equals("2")) {
                    System.out.println("Выберите пункт:");
                    print();
                    MENU.select(reader.readLine()).get().getActionDelegate().delegate();
                }

                if (str.equals("3")) {
                   print();
                }
                System.out.println("Выберите команду: 1.добавить, 2.получить, 3.печать, 4.выход");
                str = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean findItem(String name) {
        for (Menu.MenuItemInfo menu : MENU) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void print() {
        MenuPrinter menuPrinter = new SimpleMenuPrinter();
        menuPrinter.print(MENU);
    }
}
