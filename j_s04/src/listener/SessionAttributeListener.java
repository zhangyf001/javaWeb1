package listener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
//session监听器 
public class SessionAttributeListener implements HttpSessionAttributeListener{
	/**
	 * 当有设置 session时候，监听一下             (登录成功时候， 设置了session  所以用户在登录成功是就能监听到)
	 */
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		// TODO Auto-generated method stub
		System.out.println("session添加监听,添加的属性名："+httpSessionBindingEvent.getName()+","
				+ "属性值："+httpSessionBindingEvent.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		// TODO Auto-generated method stub
		System.out.println("session删除监听,删除的属性名："+httpSessionBindingEvent.getName()+
				",属性值："+httpSessionBindingEvent.getValue());
	}

	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		// TODO Auto-generated method stub
		
	}

}
