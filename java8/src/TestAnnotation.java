import java.lang.reflect.Method;

public class TestAnnotation {
    @MyAnnotation("ccc")
    @MyAnnotation("bbb")
    public  void aa(@MyAnnotation("ddddd") String str){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method m1 = clazz.getMethod("aa");
        MyAnnotation[] myAnnotations = m1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation e:myAnnotations){
            System.out.println(e.value());
        }
    }
}
