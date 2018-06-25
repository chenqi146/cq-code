package com.cqmike.util;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.cqmike.connect.util.DatabaseConnect;

public class StudentdataDesign implements ActionListener{
	
	String SelectQueryFieldStr = "学号";
	DatabaseConnect databaseConnect  = new DatabaseConnect();
	Connection connection = null;
	
	JButton jb1 = null;
	JButton jb2 = null;
	JButton jb3 = null;
	JButton jb4 = null;
	JButton jb5 = null;
	JButton jb6 = null;
	
	JLabel jlsno = null;
	JLabel jlname = null;
	JLabel jlsex = null;
	JLabel jlclassno = null;
	JLabel jldepartmentno = null;
	JLabel jlbirthday = null;
	JLabel jlnative_place = null;
	JLabel jltotal = null;
	JLabel jLSelectQueryField = null;
	JLabel jLEqual = null;
	
	JTextField jtfsno = null;
	JTextField jtfname = null;
	JTextField jtfsex = null;
	JTextField jtfclassno = null;
	JTextField jtfdepartmentno = null;
	JTextField jtfbirthday = null;
	JTextField jtfnative_place = null;
	JTextField jTFQueryField = null;
	
	JComboBox<String> jCBSelectQueryField = null;//查询字段
	JPanel p0, p1,p2,p3,p4,p5,p6,p7,p8 = null;
//	DefaultTableModel studentTableModel = null;
	JTable studentJTable = null;
	JScrollPane studentJScrollPane = null;
	Vector studentVector = null;
	Vector titleVector = null;
	
	public JComponent createpanel() {
		
		p0 = new JPanel();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();

		
		jb1 = new JButton("插入");
		jb2 = new JButton("更新");
		jb3 = new JButton("查询");
		jb4 = new JButton("查询所有记录");
		jb5 = new JButton("删除当前记录");
		jb6 = new JButton("删除所有记录");
		
		jlsno = new JLabel("学号");
		jlname = new JLabel("姓名");
		jlsex = new JLabel("    性别    ");
		jlclassno = new JLabel("班级编号");
		jldepartmentno = new JLabel("院系编号");
		jlbirthday = new JLabel("生日");
		jlnative_place = new JLabel("籍贯");
		jltotal = new JLabel("学生信息表");
		jLSelectQueryField = new JLabel("选择查询字段");
		jLEqual = new JLabel(" = ");
			
		jtfsno = new JTextField(10);
		jtfname = new JTextField(10);
		jtfsex = new JTextField(10);
		jtfclassno = new JTextField(10);
		jtfdepartmentno = new JTextField(10);
		jtfbirthday = new JTextField(10);
		jtfnative_place = new JTextField(10);
		jTFQueryField = new JTextField(10);//查询字段
				
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		
		jCBSelectQueryField = new JComboBox<String>();
		
		jCBSelectQueryField.addItem("学号");  
		jCBSelectQueryField.addItem("姓名");  
		jCBSelectQueryField.addItem("性别");
		jCBSelectQueryField.addItem("班级编号");
		jCBSelectQueryField.addItem("院系编号");
		jCBSelectQueryField.addItem("生日");
		jCBSelectQueryField.addItem("籍贯");
		jCBSelectQueryField.addItemListener(new ItemListener() {//下拉框事件监听  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();  
                    System.out.println("选中：" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("取消选中：" + event.getItem());  
                    break;  
                }  
            }  
        });
		
		
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
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(1050,160));
		studentJScrollPane = new JScrollPane(studentJTable);
		//分别设置水平和垂直滚动条自动出现
		studentJScrollPane.setHorizontalScrollBarPolicy(                
	           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
		       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//为表格添加监听器 
				studentJTable.addMouseListener(new MouseAdapter()
				{ 
					public void mouseClicked(MouseEvent e) 
					{ 
						int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // 获得行位置
						System.out.println("mouseClicked(). row = " + row);
						Vector v = new Vector();
						v = (Vector) studentVector.get(row);

						jtfsno.setText((String) v.get(0));// 学号
						jtfname.setText((String) v.get(1));// 姓名
						jtfsex.setText((String) v.get(2));// 性别
						jtfclassno.setText((String) v.get(3));// 生日
						jtfdepartmentno.setText((String) v.get(4));// 院系编号			
						jtfbirthday.setText( v.get(5).toString());
						jtfnative_place.setText((String) v.get(6));// 籍贯
					}
				});
				
				
				
		p3.add(jltotal);		
		
		p4.add(studentJScrollPane);
				
		
		p5.add(jLSelectQueryField);
		p5.add(jCBSelectQueryField);
		p5.add(jLEqual);
		p5.add(jTFQueryField);
		p5.add(jb3);
		p5.add(jb4);
		
		p6.add(jlsno);
		p6.add(jtfsno);
		p6.add(jlname);
		p6.add(jtfname);
		p6.add(jlsex);
		p6.add(jtfsex);
		
		jtfsno.setPreferredSize(new Dimension(0, 28));
		jtfname.setPreferredSize(new Dimension(0, 28));
		jtfsex.setPreferredSize(new Dimension(0, 28));
		
		p7.add(jlbirthday);
		p7.add(jtfbirthday);
		p7.add(jlnative_place);
		p7.add(jtfnative_place);
		p7.add(jlclassno);
		p7.add(jtfclassno);
		p7.add(jldepartmentno);
		p7.add(jtfdepartmentno);
		
		jtfbirthday.setPreferredSize(new Dimension(0, 28));
		jtfnative_place.setPreferredSize(new Dimension(0, 28));
		jtfclassno.setPreferredSize(new Dimension(0, 28));
		jtfdepartmentno.setPreferredSize(new Dimension(0, 28));
		
		p8.add(jb1);
		p8.add(jb2);
		p8.add(jb5);
		p8.add(jb6);
				
		jb1.setPreferredSize(new Dimension(120, 40));//设置布局内组件大小
		jb2.setPreferredSize(new Dimension(120, 40));
		jb5.setPreferredSize(new Dimension(120, 40));
		jb6.setPreferredSize(new Dimension(120, 40));


		
			
		p2.setLayout(new GridLayout(4, 1));
		p5.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p6.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));		
		p7.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p8.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));//设置布局内组件位置

//		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
//		p2.setLayout(null);
//		p0.setLayout(new GridLayout(3, 1));
		
		p1.add(p3);
		p1.add(p4);

		p2.add(p5);
		p2.add(p6);
		p2.add(p7);
		p2.add(p8);
		
		p0.add(p1);
		p0.add(p2);
		
		p0.setLayout(new GridLayout(2, 1));
		
		
		
		//jb1.setBounds(325, 0, 150, 150);
		//jtfsno.setPreferredSize(new Dimension(100, 100));
		
		
		
		return p0;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("查询")  
				&& !jTFQueryField.getText().isEmpty()){
				System.out.println("actionPerformed(). 查询");
				String sQueryField = jTFQueryField.getText().trim();
				queryProcess(sQueryField);
				jTFQueryField.setText("");
			}else if(e.getActionCommand().equals("查询所有记录")) {
				System.out.println("actionPerformed(). 查询所有记录");
				queryAllProcess();
			}		else if(e.getActionCommand().equals("插入")
					&& !jtfsno.getText().isEmpty()
					&& !jtfname.getText().isEmpty()
					&& !jtfsex.getText().isEmpty()
					&& !jtfclassno.getText().isEmpty()
					&& !jtfdepartmentno.getText().isEmpty()
					&& !jtfbirthday.getText().isEmpty()
					&& !jtfnative_place.getText().isEmpty()
					){
				System.out.println("actionPerformed(). 插入");
				insertProcess();
			}else if(e.getActionCommand().equals("更新")
					&& !jtfsno.getText().isEmpty()
					&& !jtfname.getText().isEmpty()
					&& !jtfsex.getText().isEmpty()
					&& !jtfclassno.getText().isEmpty()
					&& !jtfdepartmentno.getText().isEmpty()
					&& !jtfbirthday.getText().isEmpty()
					&& !jtfnative_place.getText().isEmpty()){
				System.out.println("actionPerformed(). 更新");
				updateProcess();
			}else if(e.getActionCommand().equals("删除当前记录")){
				System.out.println("actionPerformed(). 删除当前记录");
				deleteCurrentRecordProcess();
			}else if(e.getActionCommand().equals("删除所有记录")){
				System.out.println("actionPerformed(). 删除所有记录");
				deleteAllRecordsProcess();
			}
	}
	
	
	public void queryProcess(String sQueryField)
	{
		try{
			// 建立查询条件
			String sql = "select * from student where ";
			String queryFieldStr = jCBSelectQueryFieldTransfer(SelectQueryFieldStr);
		
//			if(queryFieldStr.equals("sAge")){//int sAge.
//				sql = sql + queryFieldStr;
//				sql = sql + " = " + sQueryField;
//			}else{
				sql = sql + queryFieldStr;
				sql = sql + " = ";
				sql = sql + "'" + sQueryField + "';";
//			}
			
			System.out.println("queryProcess(). sql = " + sql);
	
			connection = databaseConnect.getConnection();
			ResultSet rs = databaseConnect.executeQuery(sql);
	
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("studentid"));
				v.add(rs.getString("name"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("classno"));
				v.add(rs.getString("department"));
				v.add(Integer.valueOf(rs.getInt("birthday")));
				v.add(rs.getString("native_place"));
				studentVector.add(v);
			}
			
			studentJTable.updateUI();

			databaseConnect.disConnection(connection);
		}catch(SQLException sqle){
			System.out.println("sqle = " + sqle);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void queryAllProcess()
	{
		try{
			// 建立查询条件
			String sql = "select * from student;";
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
				v.add(rs.getString("classno"));
				v.add(rs.getString("department"));
				v.add(Integer.valueOf(rs.getInt("birthday")));
				v.add(rs.getString("native_place"));
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
	
	public void insertProcess()
	{
		String studentid = jtfsno.getText().trim();
		String name = jtfname.getText().trim();
		String sex = jtfsex.getText().trim();
		String classno = jtfclassno.getText().trim();
		String department = jtfdepartmentno.getText().trim();
		String birthday = jtfbirthday.getText().trim();
		String native_place = jtfnative_place.getText().trim();
		
		// 建立插入条件
		String sql = "insert into student values('";
		sql = sql + studentid + "','";
		sql = sql + name + "','";
		sql = sql + sex + "','";
		sql = sql + classno + "','";
		sql = sql + department + "','";
		sql = sql + birthday + "','";
		sql = sql + native_place + "');";

		System.out.println("insertProcess(). sql = " + sql);
//		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void updateProcess()
	{
		String studentid = jtfsno.getText().trim();
		String name = jtfname.getText().trim();
		String sex = jtfsex.getText().trim();
		String classno = jtfclassno.getText().trim();
		String department = jtfdepartmentno.getText().trim();
		String birthday = jtfbirthday.getText().trim();
		String native_place = jtfnative_place.getText().trim();
		
		// 建立更新条件
		String sql = "update student set name = '";
		sql = sql + name + "', sex = '";
		sql = sql + sex + "', classno = '";
		sql = sql + classno + "', department = '";
		sql = sql + department + "', birthday = '";
		sql = sql + birthday + "', native_place = '";
		sql = sql + native_place + "'";
		sql = sql + " WHERE studentid = '" + studentid + "';";
		System.out.println("updateProcess(). sql = " + sql);
//		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("updateProcess(). update database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteCurrentRecordProcess()
	{
		String studentid = jtfsno.getText().trim();
		
		// 建立删除条件
		String sql = "delete from student where studentid = '" + studentid + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		// 建立删除所有条件
		String sql = "delete from student;";
		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
	
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("学号")){
			outputStr = "studentid";
		}else if(InputStr.equals("姓名")){
			outputStr = "name";
		}else if(InputStr.equals("性别")){
			outputStr = "sex";
		}else if(InputStr.equals("班级编号")){
			outputStr = "classno";
		}else if(InputStr.equals("院系编号")){
			outputStr = "department";
		}else if(InputStr.equals("生日")){
			outputStr = "birthday";
		}else if(InputStr.equals("籍贯")){
			outputStr = "native_place";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	

}
