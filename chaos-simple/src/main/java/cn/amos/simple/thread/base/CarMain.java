package cn.amos.simple.thread.base;

public class CarMain {

    public static void main(String[] args) {
        Car car = new Car(new BaseCar());
        car.move();
    }
}
