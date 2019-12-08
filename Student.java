package zstest2;

class Student extends Person {
	private Course course;
	private Teacher teacher;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public void putcourse(){
		try{
			if(course == null){
				System.out.println("未选科");
			}
			else{
				this.toString();
			}
		} catch (NullPointerException encourse){
			System.out.println("没有选课" + encourse);
		}

	}
	public String toString(){
		return"学生姓名:"+name+"  老师姓名:"+teacher.getname()+"   所选课程:"+course;
	}
	public Course delete(){
		return course = null;
	}
	
	public Student(int id, String name, String sex, Course course,Teacher teacher) {
		super(id, name, sex);
		this.course=course;
		this.teacher=teacher;
	}
	public String getName() {
		return name;
	}
	public String getTeather() {
		
		return teacher.getname();
	}
}