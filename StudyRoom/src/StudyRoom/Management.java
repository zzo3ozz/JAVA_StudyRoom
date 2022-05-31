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
		System.out.print("이름을 입력하세요: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		Customer nowCustomer = new Customer(name);
		System.out.println();	
		
		setMan.print();
		System.out.println("\n현재 남은 좌석은 " + setMan.countEmptySeat() + "석 입니다(V: 빈좌석/C:찬좌석).");
		System.out.print("원하는 좌석을 고르세요: ");
		int seatNum = scanner.nextInt();
		nowCustomer.seatID = seatNum; 
		if(setMan.setSeat(nowCustomer.seatID/10, nowCustomer.seatID%10))
		{
			System.out.println("선택되었습니다.");
			cst[++currentNo] = nowCustomer;
		}
		scanner.close();
	}
	
	void setOut() {
		System.out.print("이름을 입력하세요: ");
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
		
		System.out.println("당신의 좌석번호는 " + seatID + "입니다.");
		setMan.releaseSeat(seatID / 10, seatID % 10);
		System.out.println("해제되었습니다.");
	
		scanner.close();
	}
	
	void admin(){
		System.out.println("1.현재 좌석상태 보기");
		System.out.println("2.전체 좌석 리셋 하기");
		System.out.print("-->");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println();
		if(num == 1)
		{
			System.out.println("[현재 좌석 상태]");
			setMan.print();
			System.out.println("\n찬 좌석: " + (10 - setMan.countEmptySeat()));
			System.out.println("남은 좌석: " + setMan.countEmptySeat());
		}
		else
		{
			setMan.clear();
			System.out.println("모든 좌석이 해제되었습니다.");
			currentNo = -1;
			for(int i = 0; i < 10; i++)
				cst[i] = new Customer("blank");
		}
		scanner.close();
	}
}
