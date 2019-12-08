package zstest2;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

class MyFrame extends JFrame{
	public MyFrame() {
		 setTitle("Frame");  	 
         setSize(780,500);
         setVisible(true);
	}
}
class MyWindow extends WindowAdapter{

	public void windowClosing(WindowEvent e){
		Window window=(Window)e.getComponent();
		window.dispose();
		
	}
}
class MyActionListener implements ActionListener{
	
	private TextField textField;
	public MyActionListener(TextField textField) {
		super();
		this.textField = textField;
	}
	public void actionPerformed(ActionEvent e) {
			textField.setText("未 选 课");
	}
	
}
public class STU implements ActionListener  {
    public static void main(String args[]) {
    	STU demo = new STU();
    }

    public STU() {
    	 f = new MyFrame();
         j2 = new JButton("选课");
         j3 = new JButton("退课");
         j3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
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
			});

         j4 = new JPanel();
         String[] str = { "java", "python","C++"};
         j5 = new JComboBox(str);
         j5.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 if (e.getStateChange() == ItemEvent.SELECTED) {
                     // 选择的下拉框选项
                     System.out.println(e.getItem());
                     setCourseInfo();
                 }
             }
         });
         j6 = new JLabel("学生姓名");
         j7 = new JTextField();
         j8 = new JTextArea();
         j8.setLineWrap(true);

         j9 = new TextField();
         j9.setCaretPosition(2);
         j9.setBackground(Color.GREEN);//为了看出效果，设置了颜色
         j9.setEditable(false);//文本框不许编辑
         GridBagLayout layout = new GridBagLayout();
         f.setLayout(layout);
         
         myActionListener =new MyActionListener(j9);
         j2.addActionListener(this);
        
         j3.addActionListener(myActionListener);
         f.add(j2);
         f.add(j3);
         f.add(j4);
         f.add(j5);
         f.add(j6);
         f.add(j7);
         f.add(j8);
         f.add(j9);
         GridBagConstraints s= new GridBagConstraints();//定义一个GridBagConstraints，         //是用来控制添加进的组件的显示位置
         s.fill = GridBagConstraints.BOTH;
         s.gridwidth=1;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
         s.weightx = 0;//该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
         s.weighty=0;//该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
         layout.setConstraints(j2, s);
         s.gridwidth=1;
         s.weightx = 0;
         s.weighty=0;
         layout.setConstraints(j3, s);
         s.gridwidth=0;//该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
         s.weightx = 0;//不能为1，j4是占了4个格，并且可以横向拉伸，
         s.weighty=0;
         layout.setConstraints(j4, s);
         s.gridwidth=2;
         s.weightx = 0;
         s.weighty=0;
         layout.setConstraints(j5, s);
         s.gridwidth=1;
         s.weightx = 0;
         s.weighty=0;
         layout.setConstraints(j6, s);
         s.gridwidth=0;
         s.weightx = 1;
         s.weighty=0;
         layout.setConstraints(j7, s);
         s.gridwidth=2;
         s.weightx = 0;
         s.weighty=1;
         layout.setConstraints(j8, s);
         s.gridwidth=5;
         s.weightx = 0;
         s.weighty=1;
         layout.setConstraints(j9, s);
        setCourseInfo();

    }

    JButton j2;
    JButton j3;
    JPanel j4;
    JComboBox j5;
    JLabel j6;
    JTextField j7;
    JTextArea j8;
    TextField j9;
    Teacher teacher;
    Course course;
    Student student;
    MyFrame f ;
    MyActionListener myActionListener;
	
	File file= new File(".."+File.separator+"选课.txt"); 
	FileWriter xieru1;//声明写入字符的类,用于字符数据的写入
	BufferedReader duqu;//声明读去字符的缓存类,用于字符的读取
	BufferedWriter xieru2 ;//声明写的缓存,用于字符数据的缓存写入
	String str; //声明取出的一行字符串,通过while循环存入缓存中
	StringBuffer huancun ;//声明字符串缓存区,对取出的数据进行缓存
	@Override
	public void actionPerformed(ActionEvent e) {
        String name = j7.getText();
        student=new Student(1,name, "男",course,teacher);
        j9.setText("  "+student.getName()+ "  "+student.getCourse() +" "+ "老师姓名:"+student.getTeather()+"\n");
		try {
      		xieru1=new FileWriter(file,true);
      		xieru1.write("  "+student.getName()+ "  "+student.getCourse() +" "+ "老师姓名:"+student.getTeather()+"\n");
      		xieru1.flush();
      		xieru1.close();
		} catch (IOException e2) {
				System.out.println("文件传输错误");
		}
		
	}

	private void setCourseInfo(){
        String scourse =(String)j5.getSelectedItem();
        if (scourse.equals("java")){
            course=new Course("303", scourse,"jiao1021","13.30",4);
            teacher=new Teacher(1, "张世博", "男",course);
        }
        else if(scourse.equals("python")){
            course=new Course("305", scourse,"jiao1022","13.30",4);
            teacher=new Teacher(2, "王老师", "男",course);
        }
        else if(scourse.equals(("C++"))){
            course=new Course("307", scourse,"jiao1023","13.30",4);
            teacher=new Teacher(3, "李老师", "女",course);
        }
        j8.setText("课程信息: "+course.gettitle()+"\n课程时间:"+course.gettime()+
                "\n上课地点:"+course.getcoursesaddress()+"\n课程学分:"+course.getcredit()+"\n授课教师："+teacher.getname());
    }
}