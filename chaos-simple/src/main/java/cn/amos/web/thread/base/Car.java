package cn.amos.web.thread.base;

public class Car implements CarInterface {

    private CarInterface interCar;

    public Car(CarInterface interCar) {
        this.interCar = interCar;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        System.out.println("汽车启动……");
        System.out.println("出发咯");
        interCar.move();
        long endTime = System.currentTimeMillis();
        System.out.println("停车\t" + "[一共行驶" + (endTime - startTime) + "毫秒]");
    }
}
