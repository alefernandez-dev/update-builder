package dev.alejandro;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public final class Product implements Serializable{
    private final UUID id;
    private final String name;
    private final String detail;
    private final BigDecimal price;

    public Product(UUID id, String name, String detail, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    public static Product New(String name, String detail, BigDecimal price) {
        return new Product(UUID.randomUUID(), name, detail, price);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }

    public static class UpdateBuilder {

        private final UUID id;
        private String name;
        private String detail;
        private BigDecimal price;


        private UpdateBuilder(Product product) {
            this.id = product.getId();
            this.name = product.getName();
            this.detail = product.getDetail();
            this.price = product.getPrice();
        }

        public static UpdateBuilder from(Product product) {
            return new UpdateBuilder(product);
        }

        public UpdateBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UpdateBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public UpdateBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product update() {
            return new Product(id, name, detail, price);
        }
    }
}
