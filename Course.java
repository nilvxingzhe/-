package zstest2;

public class Course {
	 private String   number;
	 private String   coursesaddress;
	 private String   title;
	 private String   time;
	 private int      credit;

public String toString(){
	 return "�γ̺�:"+number+","+"�γ�����:"+title+","+"�Ͽεص�:"+coursesaddress+","+"�Ͽ�ʱ��:"+time+","+"   ѧ��:"+credit;
	 }
	 public Course(String number,String title,String coursesaddress,String time,int credit){
		this.number=number;
		this.title=title;
		this.coursesaddress=coursesaddress;
		this.time=time;
		this.credit=credit;
	}
				
	public String getnumber() {
		return number;
	}
	public void setnumber(String number) {
		this.number = number;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title= title;
	}
	public String getcoursesaddress() {
			return coursesaddress;
	}
	public void setshangkedd(String coursesaddress) {
		this.coursesaddress = coursesaddress;
	}
	public String gettime() {
		return time;
	}
	public void settime(String time) {
		this.time = time;
	}
	public int getcredit() {
			return credit;
	}
	public void setcredit(int credit) {
		this.credit = credit;
	}

}
