package ru.job4j.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    private static final String INDENTED = "    ";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo item : menu) {
            int count = item.getNumber().split("\\.").length - 1;
            System.out.println(INDENTED.repeat(count)
                    + item.getNumber()
                    + item.getName());
        }
    }
}
