package zstest2;

public class test {
	public static void main(String[] args) {
		Course course=new Course("303", "java����", "jiao1021","13.30",4);
		Teacher teacher=new Teacher(303, "����ʦ", "��",course);
		Student student=new Student(2019322032, "��ʤ", "��",course,teacher);
		System.out.println(student.toString());	 
		System.out.println(teacher.toString());	
		student.delete();
		student.putcourse();
	}
}
