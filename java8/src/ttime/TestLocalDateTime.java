package ttime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {


    public static void main(String[] args) {
        TestLocalDateTime t = new TestLocalDateTime();
        t.test6();
    }
	
	//6.ZonedDate、ZonedTime、ZonedDateTime ： 带时区的时间或日期
	public void test7(){
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(ldt);//2019-06-27T20:36:27.538
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
		System.out.println(zdt);
	}
	
	public void test6(){
        //都有哪些时区呢
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.forEach(System.out::println);
        /**
         * Australia/Eucla
         * Asia/Shanghai
         * Universal
         * Europe/Zagreb
         * America/Port_of_Spain
         * Europe/Helsinki
         * 。。。
         */
	}

	
	//5. DateTimeFormatter : 解析和格式化日期或时间
	public void test5(){
//		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
		
		LocalDateTime ldt = LocalDateTime.now();
		String strDate = ldt.format(dtf);
		
		System.out.println(strDate);//2019年06月27日 20:32:39 星期四
		
		LocalDateTime newLdt = ldt.parse(strDate, dtf);
		System.out.println(newLdt);//2019-06-27T20:32:39
	}
	
	//4. TemporalAdjuster : 时间校正器
	public void test4(){
	    LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);//2019-06-27T20:25:30.716
		
		LocalDateTime ldt2 = ldt.withDayOfMonth(10);//月中的天 指定为10  （即  设置为10号）
		System.out.println(ldt2);//2019-06-10T20:25:30.716
		
		LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));//将时间调到周日
		System.out.println(ldt3);//2019-06-30T20:25:30.716
		
		//自定义：下一个工作日  （周六、周天 算休息日）
		LocalDateTime ldt5 = ldt.with((l) -> {
			LocalDateTime ldt4 = (LocalDateTime) l;
			
			DayOfWeek dow = ldt4.getDayOfWeek();
			
			if(dow.equals(DayOfWeek.FRIDAY)){
				return ldt4.plusDays(3);
			}else if(dow.equals(DayOfWeek.SATURDAY)){
				return ldt4.plusDays(2);
			}else{
				return ldt4.plusDays(1);
			}
		});
		
		System.out.println(ldt5);//2019-06-28T20:25:30.716
		
	}
	
	//3.
	//Duration : 用于计算两个“时间”间隔
	//Period : 用于计算两个“日期”间隔
	public void test3(){
		Instant ins1 = Instant.now();
		
		System.out.println("--------------------");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		Instant ins2 = Instant.now();
		
		System.out.println("所耗费时间为：" + Duration.between(ins1, ins2));//所耗费时间为：PT1S
        System.out.println(Duration.between(ins1, ins2).toMillis());//毫秒 1000
		
		System.out.println("----------------------------------");
		
		LocalDate ld1 = LocalDate.now();//2019-06-27
		LocalDate ld2 = LocalDate.of(2011, 1, 1);
		
		Period pe = Period.between(ld2, ld1);
		//相差的年月日
		System.out.println(pe.getYears());//8
		System.out.println(pe.getMonths());//5
		System.out.println(pe.getDays());//26
	}
	
	//2. Instant : 时间戳。 （使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值）
	public void test2(){
		Instant ins = Instant.now();  //默认使用 UTC 时区
		System.out.println(ins);//2019-06-27T12:13:17.694Z  --默认获取UTC时区（世界协调时间） 与我们差了8个时差
		
		OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);//2019-06-27T20:13:17.694+08:00
		
		System.out.println(ins.getNano());//694000000  （1970年1月1日 00:00:00距离现在的）
		System.out.println(ins.toEpochMilli());//现在时间 毫秒值

		Instant ins2 = Instant.ofEpochSecond(5);//加5秒
		System.out.println(ins2);//1970-01-01T00:00:05Z
	}
	
	//1. LocalDate、LocalTime、LocalDateTime
	public void test1(){
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);//2019-06-27T20:07:48.337
		
		LocalDateTime ld2 = LocalDateTime.of(2016, 11, 21, 10, 10, 10);
		System.out.println(ld2);//2016-11-21T10:10:10
		
		LocalDateTime ldt3 = ld2.plusYears(20);//加20年
		System.out.println(ldt3);//2036-11-21T10:10:10
		
		LocalDateTime ldt4 = ld2.minusMonths(2);//减2月
		System.out.println(ldt4);//2016-09-21T10:10:10
		
		System.out.println(ldt.getYear());//2019
		System.out.println(ldt.getMonthValue());//6
		System.out.println(ldt.getDayOfMonth());//27
		System.out.println(ldt.getHour());//20
		System.out.println(ldt.getMinute());//7
		System.out.println(ldt.getSecond());//48
	}

}
