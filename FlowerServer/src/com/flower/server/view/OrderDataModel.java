package com.flower.server.view;

import javax.swing.table.AbstractTableModel;

import com.flower.server.DAO.OrderDAO;

@SuppressWarnings("serial")
public class OrderDataModel extends AbstractTableModel {
	Object[][] data = new OrderDAO().getObject();
	
	String[] columnName = { "�ֹ��ڵ�", "�ֹ�ȸ��", "����ð�", "��ȭ��ȣ", "�޼���", "��ǰ��", "��ǰ����", "����Ȯ��" };
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return data[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnName[column];
	}

}
