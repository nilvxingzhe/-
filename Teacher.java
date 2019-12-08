package zstest2;

class Teacher extends Person{
	Course course;
	public String toString(){
		return "教师ID:"+id+"   教师姓名:"+name+"   性别:"+sex+"   教授课程:"+course;
	}
	public Teacher(int id, String name, String sex,Course course) {
		super(id, name, sex);
		this.course = course;
	}
}
