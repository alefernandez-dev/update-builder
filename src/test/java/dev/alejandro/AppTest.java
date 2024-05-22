package dev.alejandro;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void createAndUpdateProduct() {

        var travel = Product.New(
                "EcoTraveler Kit",
                "A complete set of eco-friendly travel essentials",
                BigDecimal.valueOf(49.99));

        assertEquals("EcoTraveler Kit", travel.getName());
        assertTrue(travel.getDetail().contains("essentials"));


        var updatedTravel = Product.UpdateBuilder.from(travel)
                .withName("GreenExplorer Backpack")
                .withDetail("The ultimate eco-friendly backpack for adventurers")
                .withPrice(BigDecimal.valueOf(79.99))
                .update();

        assertEquals(travel.getId(), updatedTravel.getId());
        assertEquals("GreenExplorer Backpack", updatedTravel.getName());
        assertTrue(updatedTravel.getDetail().contains("adventurers"));

    }

}