package StudyRoom;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Management manager = new Management();
		
		System.out.println("[LaLaLa StudyRoom]");
		System.out.println("1.����");
		System.out.println("2.����");
		System.out.println("3.������");
		System.out.println("4.����");
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
			System.exit(0);
		
		scanner.close();
	}

}
