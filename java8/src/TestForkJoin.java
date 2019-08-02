import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;



public class TestForkJoin {


    public static void main(String[] args) {
        TestForkJoin t = new TestForkJoin();
        t.test1();
        t.test2();
        t.test3();



	}
	public void  test1() {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 10000000000L);//数值不可过大 超过范围 不可计算
        long sum = pool.invoke(task);
        System.out.println(sum);//50000005000000
        long end = System.currentTimeMillis();
        System.out.println("耗费的时间为: " + (end - start)); //耗费的时间为: 30


    }
    //普通for
	public void test2(){
        long start = System.currentTimeMillis();

        long sum = 0L;

        for (long i = 0L; i <= 10000000000L; i++) {
            sum += i;
        }

        System.out.println(sum);

        long end = System.currentTimeMillis();

        System.out.println("耗费的时间为: " + (end - start));
    }
	
    //并行流 方式 充分利用CPU 用时最少
	public void test3(){
		long start = System.currentTimeMillis();
		
		Long sum = LongStream.rangeClosed(0L, 10000000000L)
							 .parallel()
							 .sum();
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		
		System.out.println("耗费的时间为: " + (end - start)); //2061-2053-2086-18926
	}

}
