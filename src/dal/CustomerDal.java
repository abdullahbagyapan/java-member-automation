package dal;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import core.DataObjectHelper;
import interfaces.IDataAccessLayer;
import type.CustomerContract;

public class CustomerDal extends DataObjectHelper implements IDataAccessLayer<CustomerContract>{

	@Override
	public void insert(CustomerContract contract) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT customer (name,surname) VALUES ('"+contract.getName()+"','"+contract.getSurname()+"')");
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void update(CustomerContract contract) {
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();

			 int rs = statement.executeUpdate("UPDATE customer SET name ='"+contract.getName()+"',surname ='"+contract.getSurname()+"' WHERE id='"+contract.getId()+"'");			
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(CustomerContract contract) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			int rs = statement.executeUpdate("DELETE FROM `customer` WHERE id="+contract.getId());
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CustomerContract> getList() {
		List<CustomerContract> dataContract = new ArrayList<CustomerContract>();
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT *FROM customer");
			while (rs.next()) {
				CustomerContract contract = new CustomerContract();
				contract.setId(rs.getInt("id"));
				contract.setName(rs.getString("name"));
				contract.setSurname(rs.getString("surname"));
				
				dataContract.add(contract);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataContract;
	}
	
}
