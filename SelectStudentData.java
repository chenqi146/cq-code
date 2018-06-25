package com.cqmike.util;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.cqmike.connect.util.DatabaseConnect;

public class SelectStudentData implements ActionListener{

	String SelectQueryFieldStr = "学号";
	DatabaseConnect databaseConnect  = new DatabaseConnect();
	Connection connection = null;
	
	JButton jb1 = null;
	
	JPanel p0, p1, p2 = null;
	
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
	public JComponent createpanel() {
		
		jb1 = new JButton("查询所有信息");
		
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		
		jb1.addActionListener(this);
		
		studentVector = new Vector();
		titleVector = new Vector();
		
		// 定义表头
		titleVector.add("学号");
		titleVector.add("姓名");
		titleVector.add("性别");
		titleVector.add("班级编号");
		titleVector.add("院系编号");
		titleVector.add("生日");
		titleVector.add("籍贯");
		titleVector.add("学籍变更");
		titleVector.add("时间");
		titleVector.add("奖学金记录");
		titleVector.add("时间");
		titleVector.add("处罚");
		titleVector.add("时间");
		titleVector.add("生效");
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(1050,300));
		studentJScrollPane = new JScrollPane(studentJTable);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane.setHorizontalScrollBarPolicy(                
	           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
		       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		p0.add(studentJScrollPane);
		p0.add(jb1);
		
		
		return p0;
		
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("查询所有信息")) {
			System.out.println("actionPerformed(). 查询所有信息");
			queryAllProcess();
		}
	}
	
	
	public void queryAllProcess()
	{
		try{
			// 建立查询条件
			String sql = "select student.studentid, student.name, student.sex, class.name, department.name, student.birthday, student.native_place , change_code.description ,changedata.rec_time , reward_levels.description ,reward.rec_time ,punish_levels.description , punishment.rec_time ,punishment.enable\r\n" + 
					"from student left join changedata on student.studentid=changedata.studentid left join reward on student.studentid=reward.studentid left join punishment on student.studentid=punishment.studentid left join change_code on changedata.change_code=change_code.code left join reward_levels on reward.levels=reward_levels.code left join class on student.classno=class.id left join department on student.department=department.id left join punish_levels on punishment.levels=punish_levels.code\r\n" + 
					"order by student.studentid asc;\r\n" + 
					"";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			connection = databaseConnect.getConnection();
			ResultSet rs = databaseConnect.executeQuery(sql);

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("studentid"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("class.name"));
				v.add(rs.getString("department.name"));
				v.add(Integer.valueOf(rs.getInt("birthday")));
				v.add(rs.getString("native_place"));
				v.add(rs.getString("change_code.description"));
				v.add(rs.getString("changedata.rec_time"));
				v.add(rs.getString("reward_levels.description"));
				v.add(rs.getString("reward.rec_time"));
				v.add(rs.getString("punish_levels.description"));
				v.add(rs.getString("punishment.rec_time"));
				v.add(rs.getString("punishment.enable"));
				studentVector.add(v);
			}
			
			studentJTable.updateUI();

			databaseConnect.disConnection(connection);
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	

}
