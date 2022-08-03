package ru.job4j.lsp.store;

import org.junit.Test;
import ru.job4j.lsp.store.foods.Bread;
import ru.job4j.lsp.store.foods.Food;
import ru.job4j.lsp.store.foods.Milk;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {

    @Test
    public void whenWarehouse() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                shop,
                warehouse,
                trash
        ));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR) + 2,
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 5, 10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) + 6, 10, 0);
        Food milk = new Milk("Milk", expiryDate, createDate, 60, 4);
        controlQuality.distribute(milk);
        assertThat(warehouse.getFoods(), is(List.of(milk)));
    }

    @Test
    public void whenTrash() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                shop,
                warehouse,
                trash
        ));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH) - 1,
                expiryDate.get(Calendar.DAY_OF_MONTH) + 5, 10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH) - 4,
                createDate.get(Calendar.DAY_OF_MONTH) + 6, 10, 0);
        Food bread = new Bread("Bread", expiryDate, createDate, 60, 4);
        controlQuality.distribute(bread);
        assertThat(trash.getFoods(), is(List.of(bread)));
    }

    @Test
    public void whenExpirationDateBetween25And75ToShop() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                shop,
                warehouse,
                trash
        ));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH) + 2,
                expiryDate.get(Calendar.DAY_OF_MONTH) + 5, 10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH) - 4,
                createDate.get(Calendar.DAY_OF_MONTH) + 6, 10, 0);
        Food bread = new Bread("Milk", expiryDate, createDate, 60, 4);
        controlQuality.distribute(bread);
        assertThat(shop.getFoods(), is(List.of(bread)));
    }

    @Test
    public void whenExpirationDateMore75ToShopWithNewPrice() {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                shop,
                warehouse,
                trash
        ));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH) + 1,
                expiryDate.get(Calendar.DAY_OF_MONTH) + 5, 10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH) - 4,
                createDate.get(Calendar.DAY_OF_MONTH) + 6, 10, 0);
        Food bread = new Bread("Milk", expiryDate, createDate, 60, 4);
        controlQuality.distribute(bread);
        double newPrice = shop.getFoods().get(0).getPrice();
        assertThat(newPrice, is(56.0));
    }
}