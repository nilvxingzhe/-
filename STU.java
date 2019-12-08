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
			textField.setText("δ ѡ ��");
	}
	
}
public class STU implements ActionListener  {
    public static void main(String args[]) {
    	STU demo = new STU();
    }

    public STU() {
    	 f = new MyFrame();
         j2 = new JButton("ѡ��");
         j3 = new JButton("�˿�");
         j3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				    try{
                        String namet=j7.getText();
                        j9.setText("ѧ��"+ namet+" �Ŀγ̡� " +course.gettitle() +" �� �ѳɹ��˿Σ�");

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
                        System.out.println("�ַ���Ϊ�գ�ע���飡" + en);
                    } catch (IOException e1) {
						System.out.println("�ļ��������");
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
                     // ѡ���������ѡ��
                     System.out.println(e.getItem());
                     setCourseInfo();
                 }
             }
         });
         j6 = new JLabel("ѧ������");
         j7 = new JTextField();
         j8 = new JTextArea();
         j8.setLineWrap(true);

         j9 = new TextField();
         j9.setCaretPosition(2);
         j9.setBackground(Color.GREEN);//Ϊ�˿���Ч������������ɫ
         j9.setEditable(false);//�ı�����༭
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
         GridBagConstraints s= new GridBagConstraints();//����һ��GridBagConstraints��         //������������ӽ����������ʾλ��
         s.fill = GridBagConstraints.BOTH;
         s.gridwidth=1;//�÷������������ˮƽ��ռ�õĸ����������Ϊ0����˵��������Ǹ��е����һ��
         s.weightx = 0;//�÷����������ˮƽ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
         s.weighty=0;//�÷������������ֱ��������ȣ����Ϊ0��˵�������죬��Ϊ0�����Ŵ�������������죬0��1֮��
         layout.setConstraints(j2, s);
         s.gridwidth=1;
         s.weightx = 0;
         s.weighty=0;
         layout.setConstraints(j3, s);
         s.gridwidth=0;//�÷������������ˮƽ��ռ�õĸ����������Ϊ0����˵��������Ǹ��е����һ��
         s.weightx = 0;//����Ϊ1��j4��ռ��4���񣬲��ҿ��Ժ������죬
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
	
	File file= new File(".."+File.separator+"ѡ��.txt"); 
	FileWriter xieru1;//����д���ַ�����,�����ַ����ݵ�д��
	BufferedReader duqu;//������ȥ�ַ��Ļ�����,�����ַ��Ķ�ȡ
	BufferedWriter xieru2 ;//����д�Ļ���,�����ַ����ݵĻ���д��
	String str; //����ȡ����һ���ַ���,ͨ��whileѭ�����뻺����
	StringBuffer huancun ;//�����ַ���������,��ȡ�������ݽ��л���
	@Override
	public void actionPerformed(ActionEvent e) {
        String name = j7.getText();
        student=new Student(1,name, "��",course,teacher);
        j9.setText("  "+student.getName()+ "  "+student.getCourse() +" "+ "��ʦ����:"+student.getTeather()+"\n");
		try {
      		xieru1=new FileWriter(file,true);
      		xieru1.write("  "+student.getName()+ "  "+student.getCourse() +" "+ "��ʦ����:"+student.getTeather()+"\n");
      		xieru1.flush();
      		xieru1.close();
		} catch (IOException e2) {
				System.out.println("�ļ��������");
		}
		
	}

	private void setCourseInfo(){
        String scourse =(String)j5.getSelectedItem();
        if (scourse.equals("java")){
            course=new Course("303", scourse,"jiao1021","13.30",4);
            teacher=new Teacher(1, "������", "��",course);
        }
        else if(scourse.equals("python")){
            course=new Course("305", scourse,"jiao1022","13.30",4);
            teacher=new Teacher(2, "����ʦ", "��",course);
        }
        else if(scourse.equals(("C++"))){
            course=new Course("307", scourse,"jiao1023","13.30",4);
            teacher=new Teacher(3, "����ʦ", "Ů",course);
        }
        j8.setText("�γ���Ϣ: "+course.gettitle()+"\n�γ�ʱ��:"+course.gettime()+
                "\n�Ͽεص�:"+course.getcoursesaddress()+"\n�γ�ѧ��:"+course.getcredit()+"\n�ڿν�ʦ��"+teacher.getname());
    }
}