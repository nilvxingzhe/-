package zstest2;

public class Person {
	int id;
	String name;
	String sex;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
	public String toString(){
		return id +name + sex ;
	}
	public Person(int id,String name,String sex){
		this.id=id;
		this.name=name;
		this.sex=sex;
	}
}
