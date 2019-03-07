package domain;

public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String s_class;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	
	@Override
	public String toString(){
		return "Student{"
				+"id:"+id
				+",name:"+name
				+",age:"+age
				+",class"+s_class
				+ "}";
	}
}
