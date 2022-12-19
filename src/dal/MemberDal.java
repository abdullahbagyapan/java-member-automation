package dal;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import core.DataObjectHelper;
import core.UserObjectHelper;
import interfaces.IUserAccessLayer;
import type.CustomerContract;
import type.MemberContract;

public class MemberDal extends UserObjectHelper implements IUserAccessLayer<MemberContract>{

	@Override
	public boolean login(MemberContract contract) {
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT *FROM user WHERE username = '"+contract.getUserName()+"' and  password = '"+contract.getPassword()+"' ");

			if (rs.next()) {
				statement.close();
				connection.close();
				return true;
			}
			else {
				statement.close();
				connection.close();
				return false;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	

	@Override
	public boolean register(MemberContract contract) {
		Connection connection = getConnection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT *FROM user WHERE username = '"+contract.getUserName()+"'");
						
			if (rs.next()) {
				statement.close();
				connection.close();
				
				return false;
			}
			else {
				statement.executeUpdate("INSERT user (name,surname,username,password) VALUES ('"+contract.getName()+"','"+contract.getSurname()+"','"+contract.getUserName()+"','"+contract.getPassword()+"')");
				
				statement.close();
				connection.close();
				
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<MemberContract> showAdmin() {
		List<MemberContract> dataContract = new ArrayList<MemberContract>();
		
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT *FROM user");
			while (rs.next()) {
				MemberContract contract = new MemberContract();
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
