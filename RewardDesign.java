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
	
	String SelectQueryFieldStr = "��¼��";
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
	
	JComboBox<String> jCBSelectQueryField = null;//��ѯ�ֶ�
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
		
		
		jb1 = new JButton("����");
		jb2 = new JButton("����");
		jb3 = new JButton("��ѯ");
		jb4 = new JButton("��ѯ���м�¼");
		jb5 = new JButton("ɾ����ǰ��¼");
		jb6 = new JButton("ɾ�����м�¼");
		
		jlno = new JLabel("��¼��    ");
		jlsno = new JLabel("ѧ��        ");
		jllevels = new JLabel("�������");
		jltime = new JLabel("��¼ʱ��");
		jldescription = new JLabel("����        ");
		jltotal = new JLabel("������¼�����");
		jLSelectQueryField = new JLabel("ѡ���ѯ�ֶ�");
		jLEqual = new JLabel(" = ");
		
		jtfno = new JTextField(25);
		jtfsno = new JTextField(25);
		jtflevels = new JTextField(25);
		jtftime = new JTextField(25);
		jtfdescription = new JTextField(25);
		jTFQueryField = new JTextField(10);//��ѯ�ֶ�
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		jb5.addActionListener(this);
		jb6.addActionListener(this);
		
		
		
		jCBSelectQueryField = new JComboBox<String>();
		
		jCBSelectQueryField.addItem("��¼��");  
		jCBSelectQueryField.addItem("ѧ��");  
		jCBSelectQueryField.addItem("�������");
		jCBSelectQueryField.addItem("��¼ʱ��");
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
		titleVector.add("��¼��");
		titleVector.add("ѧ��");
		titleVector.add("�������");
		titleVector.add("��¼ʱ��");
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

						jtfno.setText((String) v.get(0));// ��¼��
						jtfsno.setText((String) v.get(1));// ѧ��
						jtflevels.setText((String) v.get(2));// �������
						jtftime.setText((String) v.get(3));// ��¼ʱ��
						jtfdescription.setText((String) v.get(4));// ����
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
		
		if(e.getActionCommand().equals("��ѯ")  
				&& !jTFQueryField.getText().isEmpty()){
				System.out.println("actionPerformed(). ��ѯ");
				String sQueryField = jTFQueryField.getText().trim();
				queryProcess(sQueryField);
				jTFQueryField.setText("");
			}else if(e.getActionCommand().equals("��ѯ���м�¼")) {
				System.out.println("actionPerformed(). ��ѯ���м�¼");
				queryAllProcess();
			}else if(e.getActionCommand().equals("����")
					&& !jtfno.getText().isEmpty()
					&& !jtfsno.getText().isEmpty()
					&& !jtflevels.getText().isEmpty()
					&& !jtftime.getText().isEmpty()
					&& !jtfdescription.getText().isEmpty()
					){
				System.out.println("actionPerformed(). ����");
				insertProcess();
			}else if(e.getActionCommand().equals("����")
					&& !jtfno.getText().isEmpty()
					&& !jtfsno.getText().isEmpty()
					&& !jtflevels.getText().isEmpty()
					&& !jtftime.getText().isEmpty()
					&& !jtfdescription.getText().isEmpty()
					){
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
	
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
			String sql = "select * from reward;";
			System.out.println("queryAllProcess(). sql = " + sql);
	
			connection = databaseConnect.getConnection();
			ResultSet rs = databaseConnect.executeQuery(sql);

			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
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
				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void insertProcess()
	{
		String id = jtfno.getText().trim();
		String studentid = jtfsno.getText().trim();
		String levels = jtflevels.getText().trim();
		String time = jtftime.getText().trim();
		String description = jtfdescription.getText().trim();
		
		// ������������
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
				"�޸�����Ϣ","����",JOptionPane.ERROR_MESSAGE);
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
//		// ������������
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
//				"���ݲ�������","����",JOptionPane.ERROR_MESSAGE);
//		}
		queryAllProcess();
	}

	public void deleteCurrentRecordProcess()
	{
		String studentid = jtfsno.getText().trim();
		
		// ����ɾ������
		String sql = "delete from reward where studentid = '" + studentid + "';";
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
		String sql = "delete from reward;";
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
		
		if(InputStr.equals("��¼��")){
			outputStr = "id";
		}else if(InputStr.equals("ѧ��")){
			outputStr = "studentid";
		}else if(InputStr.equals("�������")){
			outputStr = "levels";
		}else if(InputStr.equals("��¼ʱ��")){
			outputStr = "rec_time";
		}else if(InputStr.equals("����")){
			outputStr = "description";
		}
		System.out.println("jCBSelectQueryFieldTransfer(). outputStr = " + outputStr);
		return outputStr;
	}
	
	
}
