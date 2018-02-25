package cn.amos.simple.thread;

public class StopThreadUnsafe {

	public static User user = new User();

	public static class User {
		private int id;
		private String name;

		public User() {
			super();
		}

		public User(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}

	}

	public static class ChangeObjectThread extends Thread{
		@Override
		public void run() {
			super.run();
			while(true){ // ��ѭ��,break�˳�
				synchronized(user){
					
				}
			}
		}
	}
	
}
