package cn.amos.web.model;

public class Test {

    public static void main(String[] args) {

        Factory fac = new FactoryA();
        Product pro = fac.showProduct();
        System.out.println(pro);

        Product proo = new FactoryB().showProduct();
        System.out.println(proo);

        Product prooo = new FactoryC().showProduct();
        System.out.println(prooo);
    }
}

interface Factory {
    /**
     * 展示商品
     *
     * @return Product
     */
    Product showProduct();
}

class FactoryA implements Factory {
    @Override
    public Product showProduct() {
        return ProductA.getInstance();
    }
}

class FactoryB implements Factory {
    @Override
    public Product showProduct() {
        return ProductB.getInstance();
    }
}

class FactoryC implements Factory {
    @Override
    public Product showProduct() {
        return ProductC.getInstance();
    }
}