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
				System.out.println("δѡ��");
			}
			else{
				this.toString();
			}
		} catch (NullPointerException encourse){
			System.out.println("û��ѡ��" + encourse);
		}

	}
	public String toString(){
		return"ѧ������:"+name+"  ��ʦ����:"+teacher.getname()+"   ��ѡ�γ�:"+course;
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