package com.flower.server.view;

import javax.swing.table.AbstractTableModel;

import com.flower.server.DAO.OrderDAO;

@SuppressWarnings("serial")
public class OrderDataModel extends AbstractTableModel {
	Object[][] data = new OrderDAO().getObject();
	
	String[] columnName = { "주문코드", "주문회원", "예약시간", "전화번호", "메세지", "제품명", "제품가격", "수령확인" };
	
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
