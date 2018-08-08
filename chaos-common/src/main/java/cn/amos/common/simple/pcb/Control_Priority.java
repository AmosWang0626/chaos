package cn.amos.common.simple.pcb;

import java.util.ArrayList;
import java.util.List;

public class Control_Priority {

	// ������ �������ȼ� �����Ƿ���� ����ִ��ʱ�� ���̿�ʼʱ��
	static List<PCB> list = DAO.map;
	static int time = -1;
	static List<PCB> listEcho = null;
	static int temp = 2;

	public static void main(String[] args) {

		intiView();// ��ʼ��

		for (int i = 0; i < 20; i++) {
			time++;
			toCheck(time);
		}

		end();// ��������
	}

	public static void intiView() {
		showDetailed();
		showLine();// Draw A Line
		listEcho = toCheckStart();
	}

	public static void end() {
		showLine();// Draw A Line
		showDetailed();
	}

	// ������״̬
	public static void toCheck(int nowTime) {

		for (int i = 0; i < list.size(); i++) {
			PCB pcb_i = list.get(i);

			if (nowTime == pcb_i.getStartTime()) {
				PCB pcb_temp1 = listEcho.get(0);
				PCB pcb_temp2 = listEcho.get(1);

				// �������ȼ�������������
				if (pcb_temp1.getStartTime() == pcb_i.getStartTime()) {
					if (pcb_i.getPriority() < pcb_temp1.getPriority()) {
						continue;
					}
				}
				if (pcb_temp2.getStartTime() == pcb_i.getStartTime()) {
					if (pcb_i.getPriority() < pcb_temp2.getPriority()) {
						continue;
					}
				}

				System.out.print("��ǰʱ��:" + nowTime);
				toOpen(pcb_i);

				if (temp == i) {
					System.out.print("��ǰʱ��:" + nowTime);
					toOpen(list.get(i - 1));
				}
			}
			if (nowTime == pcb_i.getStartTime() + pcb_i.getRunTime()) {
				System.out.print("��ǰʱ��:" + nowTime);
				toOver(pcb_i);
			}
		}

	}

	// ����������
	public static List<PCB> toCheckStart() {
		List<PCB> echo_list = new ArrayList<PCB>();
		for (int i = 0; i < list.size(); i++) {
			PCB pcb_i = list.get(i);
			for (int j = list.size() - 1; j > i; j--) {
				PCB pcb_j = list.get(j);
				if (pcb_i.getStartTime() == pcb_j.getStartTime()) {
					echo_list.add(pcb_i);
					echo_list.add(pcb_j);
					System.out.println("Echo Name1: " + pcb_j.getName()
							+ " Name2: " + pcb_i.getName());
				}
			}
		}
		return echo_list;

	}

	// ���̿�ʼִ��
	public static void toOpen(PCB pcb) {
		System.out.println("--->���� " + pcb.getName() + " ��ʼִ��");
	}

	// �����ѽ���?
	public static void toOver(PCB pcb) {
		pcb.setOver(true);
		System.out.println("--->���� " + pcb.getName() + " �ѽ���!");
	}

	// ����������ϸ��Ϣ
	public static void showDetailed() {

		for (PCB pcb : list) {
			System.out.println(pcb.toString());
		}
	}

	// �����ķָ���
	public static void showLine() {
		System.out
				.println("---------------------------------------------------------");
	}

}
