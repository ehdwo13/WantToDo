package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DatabaseConnection;

public class CheckDuplicationService {
	
	public boolean checkId(String id) {
		String sql = "SELECT COUNT(*) FROM USER WHERE ID = ?";

	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, id);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                return count > 0 ? true : false;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean checkNickName(String nickName) {
		String sql = "SELECT COUNT(*) FROM USER WHERE nick_name = ?";

	    try (Connection connection = DatabaseConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	        preparedStatement.setString(1, nickName);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                int count = resultSet.getInt(1);
	                return count > 0 ? true : false;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
