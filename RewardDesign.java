package com.cqmike.util;

import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class RewardDesign implements ActionListener{
	
	String SelectQueryFieldStr = "记录号";
	DatabaseConnect databaseConnect  = new DatabaseConnect();
	Connection connection = null;
	
	JButton jb1 = null;
	JButton jb2 = null;
	JButton jb3 = null;
	JButton jb4 = null;
	JButton jb5 = null;
	JButton jb6 = null;
	
	JLabel jlno = null;
	JLabel jlsno = null;
	JLabel jllevels = null;
	JLabel jltime = null;
	JLabel jldescription = null;
	JLabel jltotal = null;
	JLabel jLSelectQueryField = null;
	JLabel jLEqual = null;
	
	JTextField jtfno = null;
	JTextField jtfsno = null;
	JTextField jtflevels = null;
	JTextField jtftime = null;
	JTextField jtfdescription = null;
	JTextField jTFQueryField = null;
	
	JComboBox<String> jCBSelectQueryField = null;//查询字段
	JPanel p0, p1,p2,p3,p4,p5,p6,p7,p8,p9 = null;
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
		p9 = new JPanel();
		
		
		jb1 = new JButton("插入");
		jb2 = new JButton("更新");
		jb3 = new JButton("查询");
		jb4 = new JButton("查询所有记录");
		jb5 = new JButton("删除当前记录");
		jb6 = new JButton("删除所有记录");
		
		jlno = new JLabel("记录号    ");
		jlsno = new JLabel("学号        ");
		jllevels = new JLabel("级别代码");
		jltime = new JLabel("记录时间");
		jldescription = new JLabel("描述        ");
		jltotal = new JLabel("奖励记录情况表");
		jLSelectQueryField = new JLabel("选择查询字段");
		jLEqual = new JLabel(" = ");
		
		jtfno = new JTextField(25);
		jtfsno = new JTextField(25);
		jtflevels = new JTextField(25);
		jtftime = new JTextField(25);
		jtfdescription = new JTextField(25);
		jTFQueryField = new JTextField(10);//查询字段
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		
		
		jCBSelectQueryField = new JComboBox<String>();
		
		jCBSelectQueryField.addItem("记录号");  
		jCBSelectQueryField.addItem("学号");  
		jCBSelectQueryField.addItem("级别代码");
		jCBSelectQueryField.addItem("记录时间");
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
		titleVector.add("记录号");
		titleVector.add("学号");
		titleVector.add("级别代码");
		titleVector.add("记录时间");
		titleVector.add("描述");
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

						jtfno.setText((String) v.get(0));// 记录号
						jtfsno.setText((String) v.get(1));// 学号
						jtflevels.setText((String) v.get(2));// 变更代码
						jtftime.setText((String) v.get(3));// 记录时间
						jtfdescription.setText((String) v.get(4));// 描述
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
		
		p6.add(jlno);
		p6.add(jtfno);
		p6.add(jlsno);
		p6.add(jtfsno);
		
		p7.add(jllevels);
		p7.add(jtflevels);
		p7.add(jltime);
		p7.add(jtftime);
		
		p8.add(jldescription);
		p8.add(jtfdescription);
		
		jtfno.setPreferredSize(new Dimension(0, 28));
		jtfsno.setPreferredSize(new Dimension(0, 28));
		jtflevels.setPreferredSize(new Dimension(0, 28));
		jtftime.setPreferredSize(new Dimension(0, 28));
		jtfdescription.setPreferredSize(new Dimension(0, 28));
		
		
		p9.add(jb1);
		p9.add(jb2);
		p9.add(jb5);
		p9.add(jb6);
		jb1.setPreferredSize(new Dimension(120, 40));
		jb2.setPreferredSize(new Dimension(120, 40));
		jb5.setPreferredSize(new Dimension(120, 40));
		jb6.setPreferredSize(new Dimension(120, 40));
		
		
		
		p2.setLayout(new GridLayout(5, 1));
		p5.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p6.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p7.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p8.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p9.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		
		
		p1.add(p3);
		p1.add(p4);
		
		p2.add(p5);
		p2.add(p6);
		p2.add(p7);
		p2.add(p8);
		p2.add(p9);
		
		p0.setLayout(new GridLayout(2, 1));
		p0.add(p1);
		p0.add(p2);
	

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
			}else if(e.getActionCommand().equals("插入")
					&& !jtfno.getText().isEmpty()
					&& !jtfsno.getText().isEmpty()
					&& !jtflevels.getText().isEmpty()
					&& !jtftime.getText().isEmpty()
					&& !jtfdescription.getText().isEmpty()
					){
				System.out.println("actionPerformed(). 插入");
				insertProcess();
			}else if(e.getActionCommand().equals("更新")
					&& !jtfno.getText().isEmpty()
					&& !jtfsno.getText().isEmpty()
					&& !jtflevels.getText().isEmpty()
					&& !jtftime.getText().isEmpty()
					&& !jtfdescription.getText().isEmpty()
					){
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
			String sql = "select * from reward where ";
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
				v.add(rs.getString("id"));
				v.add(rs.getString("studentid"));
				v.add(rs.getString("levels"));
				v.add(rs.getString("rec_time"));
				v.add(rs.getString("description"));
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
			String sql = "select * from reward;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			connection = databaseConnect.getConnection();
			ResultSet rs = databaseConnect.executeQuery(sql);

			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			studentVector.clear();
			while(rs.next()){
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("studentid"));
				v.add(rs.getString("levels"));
				v.add(rs.getString("rec_time"));
				v.add(rs.getString("description"));
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
		String id = jtfno.getText().trim();
		String studentid = jtfsno.getText().trim();
		String levels = jtflevels.getText().trim();
		String time = jtftime.getText().trim();
		String description = jtfdescription.getText().trim();
		
		// 建立插入条件
		String sql = "insert into reward(id ,studentid ,levels ,description) values('";
		sql = sql + id + "','";
		sql = sql + studentid + "','";
		sql = sql + levels + "','";
//		sql = sql + time + "','";
		sql = sql + description + "');";

		System.out.println("insertProcess(). sql = " + sql);
//		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("insertProcess(). insert database failed.");
//			}
//		}catch(Exception e){
//			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"无该生信息","错误",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void updateProcess()
	{
		String id = jtfno.getText().trim();
		String studentid = jtfsno.getText().trim();
		String levels = jtflevels.getText().trim();
		String time = jtftime.getText().trim();
		String description = jtfdescription.getText().trim();
		
		deleteCurrentRecordProcess();
		insertProcess();
//		// 建立更新条件
//		String sql = "update reward set id = '";
//		sql = sql + id + "', levels = '";
//		sql = sql + levels + "', rec_time = '";
//		sql = sql + time + "', description = '";
//		sql = sql + description + "'";
//		sql = sql + " WHERE studentid = '" + studentid + "';";
//		System.out.println("updateProcess(). sql = " + sql);
////		try{
//			if (databaseConnect.executeUpdate(sql) < 1) {
//				System.out.println("updateProcess(). update database failed.");
////			}
////		}catch(Exception e){
////			System.out.println("e = " + e);
//			JOptionPane.showMessageDialog(null,
//				"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
//		}
		queryAllProcess();
	}

	public void deleteCurrentRecordProcess()
	{
		String studentid = jtfsno.getText().trim();
		
		// 建立删除条件
		String sql = "delete from reward where studentid = '" + studentid + "';";
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
		String sql = "delete from reward;";
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
		
		if(InputStr.equals("记录号")){
			outputStr = "id";
		}else if(InputStr.equals("学号")){
			outputStr = "studentid";
		}else if(InputStr.equals("级别代码")){
			outputStr = "levels";
		}else if(InputStr.equals("记录时间")){
			outputStr = "rec_time";
		}else if(InputStr.equals("描述")){
			outputStr = "description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	
	
}
