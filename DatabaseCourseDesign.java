package com.cqmike.util;
		


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import com.cqmike.connect.util.DatabaseConnect;




public class DatabaseCourseDesign extends JFrame  {

	//�������
	JTabbedPane jtp1 = new JTabbedPane();
	JPanel jp1,jp2,jp3,jp4,jp5 = new JPanel();
	String SelectQueryFieldStr = "ѧ��";
	
	
	
	public DatabaseCourseDesign() {
		
		StudentdataDesign studentdataDesign = new StudentdataDesign();
		ChangeDesign changeDesign = new ChangeDesign();
		RewardDesign rewardDesign = new RewardDesign();
		PunishDesign punishDesign = new PunishDesign();
		SelectStudentData selectStudentData = new SelectStudentData();
//		DatabaseConnect databaseConnect  = new DatabaseConnect();
		
		
		jtp1.addTab("ѧ��������Ϣ�������", studentdataDesign.createpanel());
		jtp1.addTab("ѧ���������������", changeDesign.createpanel());
		jtp1.addTab("��������������", rewardDesign.createpanel());
		jtp1.addTab("��������������", punishDesign.createpanel());
		jtp1.addTab("��ѯ", selectStudentData.createpanel());
		
		this.setBounds(50, 50, 1100, 750);
		this.setContentPane(jtp1);
		jtp1.setSelectedIndex(0);
		this.setTitle("ѧ������ϵͳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);  //�û��Զ����С
		this.setVisible(true);
		
		
	}
	
	
	



	public static void main(String[] args) {
		DatabaseCourseDesign dbcd =new DatabaseCourseDesign();
	}



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	

