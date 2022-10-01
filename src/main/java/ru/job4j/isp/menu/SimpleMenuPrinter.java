package ru.job4j.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            String number = menuItemInfo.getNumber();
            int point = number.length() - number.replaceAll("\\.", "").length();
            if (point > 1) {
                for (int i = 1; i < point; i++) {
                    System.out.print("    ");
                }
            }
            System.out.println(menuItemInfo.getNumber() + menuItemInfo.getName());
        }
    }
}
