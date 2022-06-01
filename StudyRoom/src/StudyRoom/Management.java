package StudyRoom;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Management {
	private int currentNo;
	Customer cst[]=new Customer[10];
	SeatManage setMan = new SeatManage();
	
	Management() {
		currentNo = -1;
		for(int i = 0; i < 10; i++) {
			cst[i] = new Customer("blank");
			cst[i].seatID = 0;
		}
	}

	void print_menu()
	{
		System.out.println("[LaLaLa StudyRoom]");
		System.out.println("1.입장");
		System.out.println("2.퇴장");
		System.out.println("3.관리자");
		System.out.println("4.종료");
		System.out.print("-->");
		
		Scanner scanner = new Scanner(System.in);
		try
		{
			int num = scanner.nextInt();
			if (num == 1)
				setIn();
			else if (num == 2)
				setOut();	
			else if (num == 3)
				admin();
			else if (num == 4)
			{
				scanner.close();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0); //시스템 종료
			}
				
			else
			{
				System.out.println("번호를 잘못 입력하셨습니다.\n");
				print_menu();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("번호를 잘못 입력하셨습니다.");
			print_menu();
		}

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
		if(setMan.setSeat(seatNum/10, seatNum%10))
		{
			System.out.println("선택되었습니다.");
			nowCustomer.seatID = seatNum; 
			cst[++currentNo] = nowCustomer;
		}
		print_menu();
	}
	
	void setOut() {
		for(int i = 0; i < 10; i++)
			System.out.println(cst[i].name);
		int seatID = 0;
		while(seatID == 0) {
			System.out.print("이름을 입력하세요: ");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			for(int i = 0; i < 10; i++) {
				if(name.equals(cst[i].name)) {
					seatID = cst[i].seatID;
					break;
				}
			}
			if (seatID == 0) { //입력한 이름과 동일한 이름을 찾을 수 없는 경우
				System.out.println("일치하는 회원을 찾을 수 없습니다. 이름을 다시 입력해주세요.");
			} else
				break;
		}
		System.out.println();	
		System.out.println("당신의 좌석번호는 " + seatID + "입니다.");
		setMan.releaseSeat(seatID / 10, seatID % 10);
		System.out.println("해제되었습니다.");
		currentNo--;
	
		print_menu();
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
			for(int i = 0; i < 10; i++) {
				cst[i] = new Customer("blank");
				cst[i].seatID = 0;
			}
				
		}
		print_menu();
	}
}
