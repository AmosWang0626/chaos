package cn.amos.common.simple.pcb;

public class PCB {

	private String name; // ��������
	private int priority; // ���ȼ�
	private boolean isOver; // �Ƿ����н���
	private int runTime; // ����ʱ��
	private int startTime; // ��ʼ����ʱ��

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}


	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "[����:" + name + ",���ȼ�=" + priority + ",���к�ʱ=" + runTime
				+ ",��ʼʱ��=" + startTime + ",�ѽ���?" + isOver + "]";
	}

}
