package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
        double num = box.getArea();
        assertThat(num).isGreaterThan(1256.63d)
                .isLessThan(1256.64d);
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 10);
        double num = box.getArea();
        assertThat(num).isGreaterThan(1256.63d)
                .isLessThan(1256.64d);
    }

    @Test
    void isExistSphere() {
        Box box = new Box(0, 10);
        boolean res = box.isExist();
        assertThat(res).isTrue();
    }
}