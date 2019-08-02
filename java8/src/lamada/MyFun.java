package lamada;

@FunctionalInterface
public interface MyFun {

	public Integer getValue(Integer num);

    public  static Integer bbbb(Integer num){
	    return 1;
    }
    default Integer cccc(Integer num){
	    return 1;
    }
	
}
