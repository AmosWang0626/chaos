package cn.amos.simple.pcb;

import java.util.ArrayList;
import java.util.List;

public class DAO {

	// ������ �������ȼ� �����Ƿ���� ����ִ��ʱ�� ���̿�ʼʱ��
	static List<PCB> map = new ArrayList<PCB>();
	static {
		PCB pcb1 = new PCB();
		PCB pcb2 = new PCB();
		PCB pcb3 = new PCB();
		PCB pcb4 = new PCB();
		PCB pcb5 = new PCB();

		pcb1.setName("PCB--1");
		pcb1.setPriority(5);
		pcb1.setOver(false);
		pcb1.setRunTime(7);
		pcb1.setStartTime(0);

		pcb2.setName("PCB--2");
		pcb2.setPriority(1);
		pcb2.setOver(false);
		pcb2.setRunTime(1);
		pcb2.setStartTime(1);

		pcb3.setName("PCB--3");
		pcb3.setPriority(4);
		pcb3.setOver(false);
		pcb3.setRunTime(3);
		pcb3.setStartTime(1);

		pcb4.setName("PCB--4");
		pcb4.setPriority(3);
		pcb4.setOver(false);
		pcb4.setRunTime(5);
		pcb4.setStartTime(2);

		pcb5.setName("PCB--5");
		pcb5.setPriority(2);
		pcb5.setOver(false);
		pcb5.setRunTime(4);
		pcb5.setStartTime(4);

		// ������ӵ�����
		DAO.add(pcb1);
		DAO.add(pcb2);
		DAO.add(pcb3);
		DAO.add(pcb4);
		DAO.add(pcb5);
	}

	public static void add(PCB pcb) {
		map.add(pcb);
	}

}
