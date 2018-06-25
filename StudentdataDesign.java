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
	
	String SelectQueryFieldStr = "ѧ��";
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
	
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
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

		
		jb1 = new JButton("����");
		jb2 = new JButton("����");
		jb3 = new JButton("��ѯ");
		jb4 = new JButton("��ѯ���м�¼");
		jb5 = new JButton("ɾ����ǰ��¼");
		jb6 = new JButton("ɾ�����м�¼");
		
		jlsno = new JLabel("ѧ��");
		jlname = new JLabel("����");
		jlsex = new JLabel("    �Ա�    ");
		jlclassno = new JLabel("�༶���");
		jldepartmentno = new JLabel("Ժϵ���");
		jlbirthday = new JLabel("����");
		jlnative_place = new JLabel("����");
		jltotal = new JLabel("ѧ����Ϣ��");
		jLSelectQueryField = new JLabel("ѡ���ѯ�ֶ�");
		jLEqual = new JLabel(" = ");
			
		jtfsno = new JTextField(10);
		jtfname = new JTextField(10);
		jtfsex = new JTextField(10);
		jtfclassno = new JTextField(10);
		jtfdepartmentno = new JTextField(10);
		jtfbirthday = new JTextField(10);
		jtfnative_place = new JTextField(10);
		jTFQueryField = new JTextField(10);//��ѯ�ֶ�
				
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		
		jCBSelectQueryField = new JComboBox<String>();
		
		jCBSelectQueryField.addItem("ѧ��");  
		jCBSelectQueryField.addItem("����");  
		jCBSelectQueryField.addItem("�Ա�");
		jCBSelectQueryField.addItem("�༶���");
		jCBSelectQueryField.addItem("Ժϵ���");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItem("����");
		jCBSelectQueryField.addItemListener(new ItemListener() {//�������¼�����  
            public void itemStateChanged(ItemEvent event) {  
                switch (event.getStateChange()) {  
                case ItemEvent.SELECTED:  
                	SelectQueryFieldStr = (String) event.getItem();  
                    System.out.println("ѡ�У�" + SelectQueryFieldStr);  
                    break;  
                case ItemEvent.DESELECTED:  
                    System.out.println("ȡ��ѡ�У�" + event.getItem());  
                    break;  
                }  
            }  
        });
		
		
		studentVector = new Vector();
		titleVector = new Vector();
		
		// �����ͷ
		titleVector.add("ѧ��");
		titleVector.add("����");
		titleVector.add("�Ա�");
		titleVector.add("�༶���");
		titleVector.add("Ժϵ���");
		titleVector.add("����");
		titleVector.add("����");
		//studentTableModel = new DefaultTableModel(tableTitle, 15);
		studentJTable = new JTable(studentVector, titleVector);
		studentJTable.setPreferredScrollableViewportSize(new Dimension(1050,160));
		studentJScrollPane = new JScrollPane(studentJTable);
		//�ֱ�����ˮƽ�ʹ�ֱ�������Զ�����
		studentJScrollPane.setHorizontalScrollBarPolicy(                
	           JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		studentJScrollPane.setVerticalScrollBarPolicy(                
		       JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//Ϊ�����Ӽ����� 
				studentJTable.addMouseListener(new MouseAdapter()
				{ 
					public void mouseClicked(MouseEvent e) 
					{ 
						int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint()); // �����λ��
						System.out.println("mouseClicked(). row = " + row);
						Vector v = new Vector();
						v = (Vector) studentVector.get(row);

						jtfsno.setText((String) v.get(0));// ѧ��
						jtfname.setText((String) v.get(1));// ����
						jtfsex.setText((String) v.get(2));// �Ա�
						jtfclassno.setText((String) v.get(3));// ����
						jtfdepartmentno.setText((String) v.get(4));// Ժϵ���			
						jtfbirthday.setText( v.get(5).toString());
						jtfnative_place.setText((String) v.get(6));// ����
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
				
		jb1.setPreferredSize(new Dimension(120, 40));//���ò����������С
		jb2.setPreferredSize(new Dimension(120, 40));
		jb5.setPreferredSize(new Dimension(120, 40));
		jb6.setPreferredSize(new Dimension(120, 40));


		
			
		p2.setLayout(new GridLayout(4, 1));
		p5.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p6.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));		
		p7.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		p8.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));//���ò��������λ��

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
		if(e.getActionCommand().equals("��ѯ")  
				&& !jTFQueryField.getText().isEmpty()){
				System.out.println("actionPerformed(). ��ѯ");
				String sQueryField = jTFQueryField.getText().trim();
				queryProcess(sQueryField);
				jTFQueryField.setText("");
			}else if(e.getActionCommand().equals("��ѯ���м�¼")) {
				System.out.println("actionPerformed(). ��ѯ���м�¼");
				queryAllProcess();
			}		else if(e.getActionCommand().equals("����")
					&& !jtfsno.getText().isEmpty()
					&& !jtfname.getText().isEmpty()
					&& !jtfsex.getText().isEmpty()
					&& !jtfclassno.getText().isEmpty()
					&& !jtfdepartmentno.getText().isEmpty()
					&& !jtfbirthday.getText().isEmpty()
					&& !jtfnative_place.getText().isEmpty()
					){
				System.out.println("actionPerformed(). ����");
				insertProcess();
			}else if(e.getActionCommand().equals("����")
					&& !jtfsno.getText().isEmpty()
					&& !jtfname.getText().isEmpty()
					&& !jtfsex.getText().isEmpty()
					&& !jtfclassno.getText().isEmpty()
					&& !jtfdepartmentno.getText().isEmpty()
					&& !jtfbirthday.getText().isEmpty()
					&& !jtfnative_place.getText().isEmpty()){
				System.out.println("actionPerformed(). ����");
				updateProcess();
			}else if(e.getActionCommand().equals("ɾ����ǰ��¼")){
				System.out.println("actionPerformed(). ɾ����ǰ��¼");
				deleteCurrentRecordProcess();
			}else if(e.getActionCommand().equals("ɾ�����м�¼")){
				System.out.println("actionPerformed(). ɾ�����м�¼");
				deleteAllRecordsProcess();
			}
	}
	
	
	public void queryProcess(String sQueryField)
	{
		try{
			// ������ѯ����
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
	
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void queryAllProcess()
	{
		try{
			// ������ѯ����
			String sql = "select * from student;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			connection = databaseConnect.getConnection();
			ResultSet rs = databaseConnect.executeQuery(sql);

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
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
		
		// ������������
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
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
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
		
		// ������������
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
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteCurrentRecordProcess()
	{
		String studentid = jtfsno.getText().trim();
		
		// ����ɾ������
		String sql = "delete from student where studentid = '" + studentid + "';";
		System.out.println("deleteCurrentRecordProcess(). sql = " + sql);
		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("deleteCurrentRecordProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}

	public void deleteAllRecordsProcess()
	{
		// ����ɾ����������
		String sql = "delete from student;";
		System.out.println("deleteAllRecordsProcess(). sql = " + sql);
		try{
			if (databaseConnect.executeUpdate(sql) < 1) {
				System.out.println("deleteAllRecordsProcess(). delete database failed.");
			}
		}catch(Exception e){
			System.out.println("e = " + e);
			JOptionPane.showMessageDialog(null,
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
		queryAllProcess();
	}
	
	public String jCBSelectQueryFieldTransfer(String InputStr)
	{
		String outputStr = "";
		System.out.println("jCBSelectQueryFieldTransfer(). InputStr = " + InputStr);
		
		if(InputStr.equals("ѧ��")){
			outputStr = "studentid";
		}else if(InputStr.equals("����")){
			outputStr = "name";
		}else if(InputStr.equals("�Ա�")){
			outputStr = "sex";
		}else if(InputStr.equals("�༶���")){
			outputStr = "classno";
		}else if(InputStr.equals("Ժϵ���")){
			outputStr = "department";
		}else if(InputStr.equals("����")){
			outputStr = "birthday";
		}else if(InputStr.equals("����")){
			outputStr = "native_place";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	

}
