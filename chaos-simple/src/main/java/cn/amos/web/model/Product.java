package cn.amos.web.model;

public interface Product {
    @Override
    String toString();
}

class ProductA implements Product {
    private String type = "A";
    private double price = 25.5;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private static ProductA pro = null;

    private ProductA() {
    }

    public static ProductA getInstance() {
        if (pro == null) {
            return new ProductA();
        } else {
            return pro;
        }
    }

    @Override
    public String toString() {
        return "This Type is " + this.type + ",and this price is " + this.price;
    }

}

class ProductB implements Product {
    private String type = "B";
    private double price = 28.6;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private static ProductB pro = null;

    private ProductB() {
    }

    public static ProductB getInstance() {
        if (pro == null) {
            return new ProductB();
        } else {
            return pro;
        }
    }

    @Override
    public String toString() {
        return "This Type is " + this.type + ",and this price is " + this.price;
    }

}

class ProductC implements Product {
    private String type = "C";
    private double price = 20.0;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private static ProductC pro = null;

    private ProductC() {
    }

    public static ProductC getInstance() {
        if (pro == null) {
            return new ProductC();
        } else {
            return pro;
        }
    }

    @Override
    public String toString() {
        return "This Type is " + this.type + ",and this price is " + this.price;
    }

}
