package timePack;

import java.time.*; // 안에 있는 모든걸 사용할때 *
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;

public class TimeRun {

	public static void main(String[] args) {
		// java.time 기본 클래스
		// LocalDate(날짜), LocalTime(시간), LocalDateTime(날짜,시간)
		// ZonedDateTime(KST 등 시간대)
		// 기간차이 Period(날짜간차이), Duration(시간간차이)
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		date = LocalDate.of(2022, 8, 04);
		time = LocalTime.of(12, 11, 30);
		dateTime = LocalDateTime.of(date, time);
		zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("America/New_York"));

		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		System.out.println(zonedDateTime);
		System.out.println();
		// 값 받아오기
		System.out.println("연도:" + date.getYear()); // 연도
		System.out.println("월:" + date.getMonthValue()); // 월
		System.out.println("월(영문):" + date.getMonth()); // 월(영문)
		System.out.println("일:" + date.getDayOfMonth()); // 일
		System.out.println("일(연도365):" + date.getDayOfYear()); // 일(연도365)
		System.out.println("요일:" + date.getDayOfWeek()); // 요일
		System.out.println("요일값:" + date.getDayOfWeek().getValue()); // 요일값
		System.out.println("달의 총일수:" + date.lengthOfMonth());// 달의 총일수
		System.out.println("년의 총일수:" + date.lengthOfYear()); // 년의 총일수
		System.out.println("윤년:" + date.isLeapYear()); // 윤년
		System.out.println();

		System.out.println("시:" + time.getHour()); // 시
		System.out.println("분:" + time.getMinute()); // 분
		System.out.println("초:" + time.getSecond()); // 초
		System.out.println("나노초:" + time.getNano()); // 나노초
		System.out.println();

		// 값을 변경
		System.out.println(date.withYear(2002));
		System.out.println(date.withMonth(12));
		System.out.println(date.withDayOfMonth(25));
		System.out.println(date.withDayOfYear(120));
		System.out.println(date);
		System.out.println();
		System.out.println(time);
		System.out.println(time.withHour(1));
		System.out.println(time.withMinute(30));
		System.out.println(time.withSecond(30));
		System.out.println(time.withNano(1234));
		System.out.println();
		LocalDate date2 = date.withYear(2002);
		System.out.println(date2);
		System.out.println(date2.plusYears(20));
		System.out.println(date2.plusWeeks(1));
		System.out.println(date2.plusMonths(5));
		System.out.println(date2.plusDays(7));
		System.out.println();
		System.out.println(date2);
		System.out.println(date2.minusYears(2));
		System.out.println(date2.minusWeeks(1));
		System.out.println(date2.minusMonths(2));
		System.out.println(date2.minusDays(7));
		System.out.println();

		LocalTime time2 = LocalTime.now();
		String sAmpm;
		if (time2.get(ChronoField.AMPM_OF_DAY) == 0) {
			sAmpm = "오전";
		} else {
			sAmpm = "오후";
		}
		System.out
				.println("지금 " + sAmpm + " " + time2.getHour() + "시/ " + time2.get(ChronoField.HOUR_OF_AMPM) + "시입니다.");

		String sAmpm1 = (time2.get(ChronoField.AMPM_OF_DAY) == 0) ? "오전" : "오후";
		System.out.println("지금 " + sAmpm1 + " " + time2.get(ChronoField.HOUR_OF_AMPM) + "시입니다.");
		System.out.println();

		// YEAR 연도
		System.out.println("연도:" + dateTime.get(ChronoField.YEAR));

		// MONTH_OF_YEAR 월
		System.out.println("월:" + dateTime.get(ChronoField.MONTH_OF_YEAR));

		// DAY_OF_MONTH 일
		System.out.println("일:" + dateTime.get(ChronoField.DAY_OF_MONTH));

		// DAY_OF_WEEK 요일 (월요일:1. 화요일:2, ..., 일요일:7)
		System.out.println("요일:" + dateTime.get(ChronoField.DAY_OF_WEEK));

		// AMPM_OF_DAY 오전/오후
		System.out.println("오전/오후:" + dateTime.get(ChronoField.AMPM_OF_DAY));

		// HOUR_OF_DAY 시(0~23)
		System.out.println("시(0~23):" + dateTime.get(ChronoField.HOUR_OF_DAY));

		// CLOCK_HOUR_OF_DAY 시(1~24)
		System.out.println("시(1~24):" + dateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));

		// HOUR_OF_AMPM 시(0~11)
		System.out.println("시(0~11):" + dateTime.get(ChronoField.HOUR_OF_AMPM));

		// CLOCK_HOUR_OF_AMPM 시(1~12)
		System.out.println("시(1~12):" + dateTime.get(ChronoField.CLOCK_HOUR_OF_AMPM));

		// MINUTE_OF_HOUR 분
		System.out.println("분:" + dateTime.get(ChronoField.MINUTE_OF_HOUR));

		// SECOND_OF_MINUTE 초
		System.out.println("초:" + dateTime.get(ChronoField.SECOND_OF_MINUTE));

		// DAY_OF_YEAR 해당 연도의 몇 번쨰 날 (1~356, 윤년이면 366)
		System.out.println("해당 연도의 몇 번쨰 날 (1~356,윤년이면366):" + dateTime.get(ChronoField.DAY_OF_YEAR));
		System.out.println();

		// isAfter() isBefore() isEqual()
		LocalDate date3 = LocalDate.of(2015, 06, 15);
		LocalDate date4 = LocalDate.of(2015, 05, 15);

		System.out.println(date3.isAfter(date4));
		System.out.println(date3.isBefore(date4));
		System.out.println(date3.isEqual(date4));

		LocalTime time3 = LocalTime.of(15, 30, 30);
		LocalTime time4 = LocalTime.of(15, 30, 30);

		System.out.println(time3.isAfter(time4));
		System.out.println(time3.isBefore(time4));
		System.out.println();

		// Date, Time 합쳐서 LocalDateTime
		System.out.println(date3);
		System.out.println(time3);
		LocalDateTime dateTime2 = LocalDateTime.of(date3, time3);
		System.out.println(dateTime2);
		LocalDateTime dateTime3 = date3.atTime(time3);
		System.out.println(dateTime3);
		LocalDateTime dateTime4 = time3.atDate(date3);
		System.out.println(dateTime4);
		System.out.println();

		// LocalDateTime -> LocalDate / LocalTime
		LocalDate date5 = dateTime4.toLocalDate();
		LocalTime time5 = dateTime4.toLocalTime();
		System.out.println(date5);
		System.out.println(time5);

		// TemporalAdjusters
		LocalDateTime dt = LocalDateTime.now();
		LocalDateTime nextYear = dt.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println("현재 날짜와 시간:" + dt);
		System.out.println("내년 첫날:" + nextYear);
		LocalDateTime nextMon = dt.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("다음달 첫날:" + nextMon);
		LocalDateTime nextMon2 = dt.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("이번달 마지막날:" + nextMon2);
		LocalDateTime dow = dt.with(TemporalAdjusters.firstInMonth(DayOfWeek.THURSDAY));
		System.out.println("이번달 첫번쨰주 목요일:" + dow);
		LocalDateTime dow2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
		System.out.println("이번달 마지막주 목요일:"+dow2);
		LocalDateTime dow3 = dt.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
		System.out.println("저번주 목요일:"+dow3);
		LocalDateTime dow4 = dt.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
		System.out.println("같거나 저번주 목요일:"+dow4);
		LocalDateTime dow5 = dt.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		System.out.println("다음주 목요일:"+dow5);
		LocalDateTime dow6 = dt.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
		System.out.println("같거나 다음주 목요일:"+dow6);
		LocalDateTime dow7 = dt.with(TemporalAdjusters.dayOfWeekInMonth(3,DayOfWeek.THURSDAY));
		System.out.println("이번달 3번쨰주 목요일:"+dow7);
		System.out.println();
		
		//Period 날짜 Duration 시간
		LocalDate lDate1 = LocalDate.of(2002, 7, 8);
		LocalDate lDate2 = LocalDate.of(2018, 7, 8);
		LocalTime lTime1 = LocalTime.of(8, 30, 12);
		LocalTime lTime2 = LocalTime.of(15, 16, 22);
		Period p = Period.between(lDate1, lDate2);
		Duration d = Duration.between(lTime1, lTime2);
		
		System.out.println(p.getYears());
		System.out.println(p.getMonths());
		System.out.println(p.getDays());
		
		System.out.println(d.getSeconds());
		System.out.println(LocalTime.of(0, 0, 0));
		LocalTime se = LocalTime.of(0, 0, 0).plusSeconds(d.getSeconds());
		System.out.println(se.getHour());
		System.out.println(se.getMinute());
		System.out.println(se.getSecond());
		
		Period p2 = lDate1.until(lDate2);
		System.out.println(p2.getYears());
		System.out.println(p2.getMonths());
		System.out.println(p2.getDays());
		System.out.println(lDate1.until(lDate2, ChronoUnit.YEARS));
		System.out.println(lTime1.until(lTime2, ChronoUnit.HOURS));
		System.out.println(p);
		System.out.println(d);
		System.out.println(p.withYears(1));
		System.out.println(d.withSeconds(100));
		
		LocalDate lDate3 = LocalDate.of(2002, 7, 8);
		LocalDate lDate4 = LocalDate.of(2018, 7, 8);
		LocalTime lTime3 = LocalTime.of(8, 30, 12);
		LocalTime lTime4 = LocalTime.of(15, 16, 22);
		
		Period p3 = Period.between(lDate3, lDate4);
		Duration d3 = Duration.between(lTime3, lTime4);
		System.out.println(p3);
		System.out.println(d3);
		System.out.println(p3.toTotalMonths());
		System.out.println(d3.toMinutes());
		System.out.println();
		
		LocalDateTime ldt = LocalDateTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 E요일 a HH시 mm분")
				.withLocale(Locale.forLanguageTag("us"));
		System.out.println(ldt.format(formatter));
	}

}
