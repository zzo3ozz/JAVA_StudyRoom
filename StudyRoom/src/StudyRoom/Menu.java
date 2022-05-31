package StudyRoom;

import java.util.Scanner;

public class Menu {
	static void print_menu(Management manager)
	{
		System.out.println("[LaLaLa StudyRoom]");
		System.out.println("1.입장");
		System.out.println("2.퇴장");
		System.out.println("3.관리자");
		System.out.println("4.종료");
		System.out.print("-->");
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		if (num == 1)
			manager.setIn();
		else if (num == 2)
			manager.setOut();	
		else if (num == 3)
			manager.admin();
		else
		{
			System.out.println("번호를 잘못 입력하셨습니다.\n");
			print_menu(manager);
		}
		scanner.close();
	}
	
	
	
	public static void main(String[] args) {
		Management manager = new Management();
		print_menu(manager);
	}

}
