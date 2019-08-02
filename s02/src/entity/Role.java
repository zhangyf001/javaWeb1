package entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="role")//相当于xml方式定义bean中的id 不写@Component 默认为类名并且首字母小写
public class Role {
	
	@Value("123")//这里 id是long型 spring注入时候会为其转型
	private Long id;
	
	@Value("role_name_1")
	private String roleName;
	
	@Value("note1")
	private String note;
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
