package zstest2;

class Teacher extends Person{
	Course course;
	public String toString(){
		return "��ʦID:"+id+"   ��ʦ����:"+name+"   �Ա�:"+sex+"   ���ڿγ�:"+course;
	}
	public Teacher(int id, String name, String sex,Course course) {
		super(id, name, sex);
		this.course = course;
	}
}
