package cn.amos.simple.pcb;

public class testNum {
	public static int num[] = new int[] { 1, 3, 5, 2, 9 };

	public static void main(String[] args) {
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		for (int i : num) {
			System.out.println(i);
		}
	}

}
