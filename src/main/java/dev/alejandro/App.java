package dev.alejandro;

import java.math.BigDecimal;

public class App 
{
    public static void main( String[] args )
    {
        var product = Product.New("EcoTraveler Kit", "A complete set of eco-friendly travel essentials", BigDecimal.valueOf(49.99));
        var updatedProduct = Product
                .UpdateBuilder
                .from(product)
                .withName("GreenExplorer Backpack")
                .withDetail("The ultimate eco-friendly backpack for adventurers")
                .withPrice(BigDecimal.valueOf(79.99))
                .update();
        System.out.println(product);
        System.out.println(updatedProduct);
    }
}
