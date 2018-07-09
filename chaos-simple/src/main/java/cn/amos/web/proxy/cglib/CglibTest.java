package cn.amos.web.proxy.cglib;

public class CglibTest {

	public static void main(String[] args) {
		CglibProxy proxy = new CglibProxy();
		
		Train train = (Train) proxy.getProxy(Train.class);

		train.move();
	}

}
