package StudyRoom;

import java.util.Scanner;

public class Management {
	private int currentNo;
	Customer cst[]=new Customer[10];
	SeatManage setMan = new SeatManage();
	
	Management() {
		currentNo = -1;
		for(int i = 0; i < 10; i++)
			cst[i] = new Customer("blank");
	}
	
	void setIn() {
		System.out.print("�̸��� �Է��ϼ���: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Customer nowCustomer = new Customer(name);
		System.out.println();	
		
		setMan.print();
		System.out.println("\n���� ���� �¼��� " + setMan.countEmptySeat() + "�� �Դϴ�(V: ���¼�/C:���¼�).");
		System.out.print("���ϴ� �¼��� ������: ");
		int seatNum = scanner.nextInt();
		nowCustomer.seatID = seatNum; 
		if(setMan.setSeat(nowCustomer.seatID/10, nowCustomer.seatID%10))
		{
			System.out.println("���õǾ����ϴ�.");
			cst[++currentNo] = nowCustomer;
		}
		
	}
	
	void setOut() {
		System.out.print("�̸��� �Է��ϼ���: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println();	
		int seatID = 0;
		
		for(int i = 1; i < 10; i++)
		{
			if(cst[i].name == name) {
				seatID = cst[i].seatID;
				break;
			}
		}
		
		System.out.println("����� �¼���ȣ�� " + seatID + "�Դϴ�.");
		setMan.releaseSeat(seatID / 10, seatID % 10);
		System.out.println("�����Ǿ����ϴ�.");
	}
	
	void admin(){
		System.out.println("1.���� �¼� ���� ����");
		System.out.println("2.��ü �¼� ���� �ϱ�");
		System.out.print("-->");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println();
		if(num == 1)
		{
			System.out.println("[���� �¼� ����]");
			setMan.print();
			System.out.println("\n�� �¼�: " + (10 - setMan.countEmptySeat()));
			System.out.println("���� �¼�: " + setMan.countEmptySeat());
		}
		else
		{
			setMan.clear();
			System.out.println("��� �¼��� �����Ǿ����ϴ�.");
			currentNo = -1;
			for(int i = 0; i < 10; i++)
				cst[i] = new Customer("blank");
		}

	}
}
