package test;

import action.CodeAction;
import util.BeanUtil;

public class Test {
	public static void main(String[] args) {
		CodeAction codeAction = BeanUtil.getBean("codeAction", CodeAction.class);
		
		/*CodeDaoImpl codeDao = BeanUtil.getBean("codeDaoImpl", CodeDaoImpl.class);
		List<Code> list  = codeDao.findCodes();
		for(Code e:list){
			System.out.println(e);
		}*/
		
//		Code code = new Code(5, "职务", "副总监");
//		codeAction.add(code);
		//codeAction.query();
		//codeAction.queryById(80);
		codeAction.find(new Object[]{"1"});
		//codeAction.queryForInt();
		//codeAction.queryForObject(new Object[]{1});
		//codeAction.insert(new Object[]{6,"职务","财务"});
	}
}
