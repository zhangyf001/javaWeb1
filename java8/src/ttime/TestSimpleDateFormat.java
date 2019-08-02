package ttime;

import java.util.*;
import java.util.function.Supplier;

public class TestSimpleDateFormat {

	public static void main(String[] args) throws Exception {
        Comparator<Integer> com = (a, b) -> {
            //System.out.println("aaa");
            int c = Integer.compare(a, b);
           // System.out.println(c);
            return c;
        };
        List list = new ArrayList();
        Set set = new TreeSet(com);
        list.add(1);
        list.add(5);
        list.add(3);
       list.sort(com);

        list.forEach(
                (e)-> System.out.println(e)
        );
        List<Integer> list1 = getL(10,()->(int)(Math.random()*100));
        System.out.println("a");

		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


		
		Callable<Date> task = new Callable<Date>() {

			@Override
			public Date call() throws Exception {
				return sdf.parse("20161121");
			}
			
		};

		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<Date>> results = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();*//*
		
		//解决多线程安全问题
		*//*Callable<Date> task = new Callable<Date>() {

			@Override
			public Date call() throws Exception {
				return DateFormatThreadLocal.convert("20161121");
			}
			
		};

		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<Date>> results = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();*//*
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		Callable<LocalDate> task = new Callable<LocalDate>() {

			@Override
			public LocalDate call() throws Exception {
				LocalDate ld = LocalDate.parse("20161121", dtf);
				return ld;
			}
			
		};

		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		List<Future<LocalDate>> results = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		
		for (Future<LocalDate> future : results) {
			System.out.println(future.get());
		}
		
		pool.shutdown();
	*/
    }

    public static List<Integer>getL(int num , Supplier<Integer > sub) {
        List list = new ArrayList();
        for (int i = 0; i < num; i++) {
            Integer  a = sub.get();
            list.add(a);
        }
        return list;
    }

}
