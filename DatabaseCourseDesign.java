package com.cqmike.util;
		


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import com.cqmike.connect.util.DatabaseConnect;




public class DatabaseCourseDesign extends JFrame  {

	//定义组件
	JTabbedPane jtp1 = new JTabbedPane();
	JPanel jp1,jp2,jp3,jp4,jp5 = new JPanel();
	String SelectQueryFieldStr = "学号";
	
	
	
	public DatabaseCourseDesign() {
		
		StudentdataDesign studentdataDesign = new StudentdataDesign();
		ChangeDesign changeDesign = new ChangeDesign();
		RewardDesign rewardDesign = new RewardDesign();
		PunishDesign punishDesign = new PunishDesign();
		SelectStudentData selectStudentData = new SelectStudentData();
//		DatabaseConnect databaseConnect  = new DatabaseConnect();
		
		
		jtp1.addTab("学生个人信息输入界面", studentdataDesign.createpanel());
		jtp1.addTab("学籍变更情况输入界面", changeDesign.createpanel());
		jtp1.addTab("奖励情况输入界面", rewardDesign.createpanel());
		jtp1.addTab("处罚情况输入界面", punishDesign.createpanel());
		jtp1.addTab("查询", selectStudentData.createpanel());
		
		this.setBounds(50, 50, 1100, 750);
		this.setContentPane(jtp1);
		jtp1.setSelectedIndex(0);
		this.setTitle("学生管理系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);  //用户自定义大小
		this.setVisible(true);
		
		
	}
	
	
	



	public static void main(String[] args) {
		DatabaseCourseDesign dbcd =new DatabaseCourseDesign();
	}



}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	

