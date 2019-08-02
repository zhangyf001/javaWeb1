package test;

import action.CodeAction;
import util.BeanUtil;
//使用spring事物，添加多条记录测试事物
public class Test {
	public static void main(String[] args) {
		CodeAction codeAction = BeanUtil.getBean("codeAction", CodeAction.class);
//		Code code = new Code(1, "职务", "总监");
//		codeAction.add(code);
		codeAction.addMuch(5);
	}
}
