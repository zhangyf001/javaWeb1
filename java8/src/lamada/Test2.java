package lamada;

public class Test2 {
    //对两long数据处理
    public  static  void  op(Long one,Long two,MyFunc<Long,Long> myFunc) {
        System.out.println(myFunc.getVVV(one,two));
    }
    public static void main(String[] args) {
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }
}
