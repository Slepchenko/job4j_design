package ru.job4j.isp.menu;

import java.io.*;

public class TODOApp {
    public static final ActionDelegate STUB_ACTION = System.out::println;

    private static final String MENU_ADD = "1";
    private static final String MENU_SELECT = "2";
    private static final String MENU_PRINT = "3";
    private static final String MENU_CLOSE = "4";
    private static final String MENU = "Введите команду: "
            + "1.Добавить пункт, 2.Добавить подпункт, 3.Печать, 4.Выход";
    private static final String ADD_SUBITEM = "Добавить подпункт:";
    private static final String WRIT_NAME = "Введите название пункта:";
    private static final String SELECT_ITEM = "Введите пункт:";


    public static void main(String[] args) {

        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new SimpleMenuPrinter();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean run = true;
            while (run) {
                System.out.println(MENU);
                String in = reader.readLine();
                if (in.equals(MENU_ADD)) {
                    System.out.println(WRIT_NAME);
                    menu.add(menu.ROOT, reader.readLine(), STUB_ACTION);
                } else if (in.equals(MENU_SELECT)) {
                    menuPrinter.print(menu);
                    System.out.println(SELECT_ITEM);
                    in = reader.readLine();
                    System.out.println(ADD_SUBITEM);
                    menu.add(in, reader.readLine(), STUB_ACTION);
                } else if (in.equals(MENU_PRINT)) {
                    menuPrinter.print(menu);
                } else if (in.equals(MENU_CLOSE)) {
                    run = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
