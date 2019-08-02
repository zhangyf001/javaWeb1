package entity;

public class Code {
	private int id;
	private String type;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Code(int id, String type, String text) {
		super();
		this.id = id;
		this.type = type;
		this.text = text;
	}
	public Code() {
		super();
	}
	@Override
	public String toString() {
		return "Code [id=" + id + ", type=" + type + ", text=" + text + "]";
	}
	
}
