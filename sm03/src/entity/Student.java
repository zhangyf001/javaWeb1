package entity;

public class Student {
	private int id;
	private String name;
	private PageParams pageParams = null;
	
	
	public PageParams getPageParams() {
		return pageParams;
	}
	public void setPageParams(PageParams pageParams) {
		this.pageParams = pageParams;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
