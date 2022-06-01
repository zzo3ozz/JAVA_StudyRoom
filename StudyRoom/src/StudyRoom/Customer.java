package StudyRoom;

public class Customer extends Person {
	Customer(String name) {
		super(name);
		seatID = 0;
		startTime = 0;
		endTime = 0;
		foodPay = 0;
	}
	int seatID;
	long startTime;
	long endTime;
	int foodPay;
}