package control;

import java.time.LocalDate;

public class ConditionalPrac {

	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		String dayOfWeek = now.getDayOfWeek().toString();
		int dayOfWeekValue = now.getDayOfWeek().getValue();
		System.out.println(dayOfWeek);
		System.out.println(dayOfWeekValue);

//		dayOfWeekValue = 7;
		String result = "";

		if (dayOfWeekValue == 1 || dayOfWeekValue == 2 || dayOfWeekValue == 3 || dayOfWeekValue == 4) {
			result = "주말이 아니고 평일";
		} else if (dayOfWeekValue == 5) {
			result = "불금";
		} else if (dayOfWeekValue == 6 || dayOfWeekValue == 7) {
			result = "주말";
		}

		System.out.println(result);

		switch (dayOfWeekValue) {
		case 1:
		case 2:
		case 3:
		case 4:
			result = "주말이 아니고 평일";
			break;
		case 5:
			result = "불금";
			break;
		case 6:
		case 7:
			result = "주말";
			break;
		default:
			result = "모르는 요일";
		}
		
		System.out.println(result);
		
		
	}
}
