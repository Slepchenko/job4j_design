package ru.job4j.lsp.store;

import org.junit.Test;
import ru.job4j.lsp.store.foods.Bread;
import ru.job4j.lsp.store.foods.Food;
import ru.job4j.lsp.store.foods.Milk;
import ru.job4j.lsp.store.foods.Sausage;

import java.util.Calendar;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {

    @Test
    public void whenWarehouse() {
        ControlQuality cq = new ControlQuality();
        Calendar dateCreate = Calendar.getInstance();
        dateCreate.set(2022, Calendar.APRIL, 8);
        Calendar dateExpiry = Calendar.getInstance();
        dateExpiry.set(2024, Calendar.AUGUST, 7);
        Food food = new Milk("Milk", dateExpiry, dateCreate, 60, 4);
        cq.distribute(food);
        assertThat(cq.getStores().get(2).getList().size(), is(1));
    }

    @Test
    public void whenTrash() {
        ControlQuality cq = new ControlQuality();
        Calendar dateCreate = Calendar.getInstance();
        dateCreate.set(2022, Calendar.APRIL, 8);
        Calendar dateExpiry = Calendar.getInstance();
        dateExpiry.set(2022, Calendar.JULY, 7);
        Food food = new Bread("Bread", dateExpiry, dateCreate, 60, 4);
        cq.distribute(food);
        assertThat(cq.getStores().get(1).getList().size(), is(1));
    }

    @Test
    public void whenExpirationDateBetween25And75ToShop() {
        ControlQuality cq = new ControlQuality();
        Calendar dateCreate = Calendar.getInstance();
        dateCreate.set(2022, Calendar.APRIL, 8);
        Calendar dateExpiry = Calendar.getInstance();
        dateExpiry.set(2022, Calendar.DECEMBER, 7);
        Food food = new Bread("Bread", dateExpiry, dateCreate, 60, 4);
        cq.distribute(food);
        assertThat(cq.getStores().get(0).getList().size(), is(1));
    }

    @Test
    public void whenExpirationDateMore75ToShopWithNewPrice() {
        ControlQuality cq = new ControlQuality();
        Calendar dateCreate = Calendar.getInstance();
        dateCreate.set(2022, Calendar.APRIL, 8);
        Calendar dateExpiry = Calendar.getInstance();
        dateExpiry.set(2022, Calendar.SEPTEMBER, 7);
        Food bread = new Bread("Bread", dateExpiry, dateCreate, 60, 4);
        cq.distribute(bread);
        double newPrise = cq.getStores().get(0).getList().get(0).getPrice();
        assertThat(newPrise, is(56.0));
    }

    @Test
    public void whenMilkToTrashAndSausageToWarehouse() {
        ControlQuality cq = new ControlQuality();
        Calendar dateCreate = Calendar.getInstance();
        dateCreate.set(2022, Calendar.APRIL, 8);
        Calendar dateExpiryMilk = Calendar.getInstance();
        dateExpiryMilk.set(2022, Calendar.JUNE, 7);
        Calendar dateExpirySausage = Calendar.getInstance();
        dateExpirySausage.set(2024, Calendar.JUNE, 7);
        Food milk = new Milk("Milk", dateExpiryMilk, dateCreate, 60, 4);
        Food sausage = new Sausage("Sausage", dateExpirySausage, dateCreate, 360, 4);
        cq.distribute(milk);
        cq.distribute(sausage);
        assertThat(cq.getStores().get(1).getList().size(), is(1));
        assertThat(cq.getStores().get(2).getList().size(), is(1));
    }
}