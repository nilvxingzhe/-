# 计G191 2019322032 张胜
# 综合性实验  学生选课系统设计 
# 一、实验目的
    分析学生选课系统
    使用GUI窗体及其组件设计窗体界面
    完成学生选课过程业务逻辑编程
    基于文件保存并读取数据
    处理异常
# 二、实验要求
    1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
    2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
    3、针对操作过程中可能会出现的各种异常，做异常处理
    4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
# 三、实验流程
## 学生选课系统简单实现
    1.了解实验要求，做出初步构架
    2. 编写Person类
    声明编号、姓名、性别变量；
    3. 编写Teacher类和Student类
    Teacher类和Student类分别继承Person类，获得编号、姓名、性别变量，调用Course类。
```java
class Student extends Person{}
```
    在Teacher类和Student类中重写toString（）方法。在Teacher类使用toString() 方法将“"老师ID："+id+"老师姓名："+name+"性别："+sex +"教授课程:"+course”转为字符串返回结果。
    在Student类调用Teacher类,在Student类使用toString() 方法将“"学生ID:"+id+"学生姓名:"+name+"性别:"+sex+"老师姓名:"+teacher.getname()+" 所选课程:"+course”转为字符串返回结果。
```java
public String toString(){
		return "学生ID:"+id+"   学生姓名:"+name+"   性别:"+sex+"   老师姓名:"+teacher.getname()+"   所选课程:"+course;}
```
    在Student类中进行退课和选课的操作
```java
public Student(int id, String name, String sex, Course course,Teacher teacher) {
		super(id, name, sex);
		this.course=course;
```java		this.teacher=teacher;}

		public void putcourse(){
		if(course == null){
			System.out.println("未选科");
		}
		else{
			this.toString();
		}}

		public Course delete(){
			return course = null;}
```
    4.编写Course类
    声明变量，Course类重写toString（）方法。使用toString() 方法将“"课程号:"+number+","+"课程名称:"+title+","+"上课地点:"+coursesaddress+","+"上课时间:"+time+","+"学分:"+credit;”转为字符串返回结果。
    2.利用WILE和IF语句使文件数据每行与
    5.测试类
    将Teacher、Student、Course实例化，打印学生选课信息，打印老师对应的课程信息，退课，打印退课后的信息。
```java
Course course=new Course("303", "java语言", "jiao1021","13.30",4);
	Teacher teacher=new Teacher(303, "张老师", "男",course);
	Student student=new Student(2019322032, "张胜", "男",course,teacher);
	System.out.println(student.toString());	 
	System.out.println(teacher.toString());	
	student.delete();student.putcourse();
```
## 学生选课系统设计
    1.了解实验要求，设计GUI界面。
    ![image](https://github.com/nilvxingzhe/-/blob/master/1.png)
    2. 导包
```java
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
```
    3. 创建监听事件，定义j2为监听对象，定义J3为事件源；
## 文件输入输出    
    1.声明文件流属性，定义缓存器
    2.利用WHILE和IF语句使文件数据每行与姓名、课程对比，相等跳入下行，不等输入文件，并保存文件。
```java
try{
                        String namet=j7.getText();
                        j9.setText("学生"+ namet+" 的课程《 " +course.gettitle() +" 》 已成功退课！");

						huancun = new StringBuffer(4096);
						str = null;
						duqu = new BufferedReader(new FileReader(file)); 
						while((str = duqu.readLine())!= null){ 
						       if (!str.contains(namet)) {
						    	   huancun.append(str).append("\r\n");
							}       
						} 
						duqu.close(); 
						xieru2 = new BufferedWriter((new FileWriter(file)));
						xieru2.write(huancun.toString());
						xieru2.close();
					} catch (NullPointerException en){
                        System.out.println("字符串为空，注意检查！" + en);
                    } catch (IOException e1) {
						System.out.println("文件传输错误");
					}
				}
```
```java
try {
      		xieru1=new FileWriter(file,true);
      		xieru1.write("  "+student.getName()+ "  "+student.getCourse() +" "+ "老师姓名:"+student.getTeather()+"\n");
      		xieru1.flush();
      		xieru1.close();
		} catch (IOException e2) {
				System.out.println("文件传输错误");
		}
```
# 四、流程图
![image](https://github.com/nilvxingzhe/-/blob/master/流程图%20(1).jpg)
![image](https://github.com/nilvxingzhe/-/blob/master/流程图%20(2).jpg)
![image](https://github.com/nilvxingzhe/-/blob/master/流程图%20(3).jpg)
![image](https://github.com/nilvxingzhe/-/blob/master/流程图%20(4).jpg)
# 五、实验结果
![image](https://github.com/nilvxingzhe/-/blob/master/运行%20(1).png)
![image](https://github.com/nilvxingzhe/-/blob/master/运行%20(2).png)
![image](https://github.com/nilvxingzhe/-/blob/master/运行%20(3).png)
![image](https://github.com/nilvxingzhe/-/blob/master/运行%20(4).png)
# 六、编程感想
     通过本次Java编程实验课，令我回顾了如何使用GUI窗体及其组件设计窗体界面与事件结构的要点。使我熟练的掌握了监听器、事件结构、JFrame类的常用方法和JComponent类组件。使我学会了如何基于文件保存并读取数据。令我熟练的掌握了异常处理的try，catch方法。使我深刻的理解了程序中的逻辑关系。在实验中我发现自己程序中的不足，通过老师和同学的帮助让我更好更快的改进了自己的程序。虽然这次实验有很大的难度，但是这次实验使我清楚的认识的自己对所学知识的掌握情况，对我复习备考有很大的帮助。
