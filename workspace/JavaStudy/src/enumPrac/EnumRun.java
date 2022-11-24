package enumPrac;

import java.util.Calendar;

enum DayOfWeek{Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday}

enum Week {
	Sunday("sun",11),
	Monday("mon",22),
	Tuesday("tue",22),
	Wednesday("wed",22),
	Thursday("thu",22),
	Friday("fri",22),
	Saturday("sat",22);
	
	private final String name;
	private final int ord;
	
	private Week(String name, int ord) {
		this.name=name;
		this.ord=ord;
	}
	public String getName() {
		return this.name;
	}
	public int getOrd() {
		return this.ord;
	}
}

public class EnumRun {

	enum Season{봄,여름,가을,겨울};
	public DayOfWeek today;
	
	public static void main(String[] args) {
		System.out.println(DayOfWeek.Sunday);
		System.out.println(Season.봄);
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.DAY_OF_WEEK);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(week);
		if(week==6) {
			System.out.println(DayOfWeek.Friday);
		}
		Season season = Season.가을;
		System.out.println(season);
		
		EnumRun er = new EnumRun();
		er.today = DayOfWeek.Friday;
		
		System.out.println(er.today);
		
		
		//values 열거체를 배열형태로 바꿔준다
		for(DayOfWeek day:DayOfWeek.values()) {
			System.out.print(day+" ");
		}
		System.out.println();
		
		//ordinal() 순번을 붙여준다 0부터 시작한다 몇번째인지
		System.out.println(season.ordinal());
		
		System.out.println(Season.valueOf("가을"));
		System.out.println(season.name());
		Season season2 = Season.겨울;
		System.out.println(season.compareTo(season2));
		System.out.println(season2.compareTo(season));
		
		for(Week week1:Week.values()) {
			System.out.println(week1);
			System.out.println(week1.getName());
			System.out.println(week1.getOrd());
			System.out.println(week1.ordinal());
		}
		System.out.println(Week.valueOf("Friday").name());
		System.out.println(Week.Monday.compareTo(Week.Sunday));
		
	}

}
