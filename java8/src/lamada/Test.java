package lamada;

import java.util.*;

public class Test {
    //原来的匿名内部类
    public void test1(){
        Comparator<String> com = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        TreeSet<String> ts = new TreeSet<>(com);

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }

        });
    }
    public  static  void test2(){
        Comparator<String> com = (x, y) -> Integer.compare(x.length(), y.length());
        TreeSet<String> ts = new TreeSet<>(com);
        ts.add("a");
        ts.add("abc");
        ts.add("ab");
        for (String s : ts) {
            System.out.print(s + "\t");
        }
    }

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //需求：获取公司中年龄小于 35 的员工信息
    public List<Employee> filterEmployeeAge(List<Employee> emps){
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getAge() <= 35){
                list.add(emp);
            }
        }

        return list;
    }
    //需求：获取公司中工资大于 5000 的员工信息
    public List<Employee> filterEmployeeSalary(List<Employee> emps){
        List<Employee> list = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getSalary() >= 5000){
                list.add(emp);
            }
        }

        return list;
    }

    public static List<Employee> filterEmployee(List<Employee> emps, MyPredicate<Employee> mp){
        List<Employee> list = new ArrayList<>();

        for (Employee employee : emps) {
            if(mp.test(employee)){
                list.add(employee);
            }
        }

        return list;
    }


    //优化方式二：匿名内部类
    public  static void test5(List emps){
        List<Employee> list = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee t) {
                return t.getAge() <= 35;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    public static void test6(List emps){
        List<Employee> list = filterEmployee(emps, (e) -> e.getAge() <= 35);
        list.forEach(System.out::println);

        System.out.println("------------------------------------------");

        List<Employee> list2 = filterEmployee(emps, (e) -> e.getSalary() >= 5000);
        list2.forEach(System.out::println);
    }
    //优化方式四：Stream API
    public static void test7(List<Employee> emps){
        emps.stream()
                .filter((e) -> e.getAge() <= 35)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");

        emps.stream()
                .map(Employee::getName)
                .limit(2)
              //  .sorted()
                .forEach(System.out::println);
    }
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
                new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );
        test7(emps);
    }
}
