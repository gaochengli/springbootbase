/**
 * 
 */
package 深入浅出mybatis.第1章MyBatis简介;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author clgao
 *
 */
public class JdbcExample {

	private Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=convertToNull";
			String user = "root";
			String pwd = "root";
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
			return null;
		}
		return connection;
	}
	
	public Role getRole(Long id) {
		Connection connection = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement("select id,role_name from role where id = ?");
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Long roleId = rs.getLong("id");
				String roleName = rs.getString("role_name");
				Role role = new Role();
				role.setId(roleId);
				role.setRoleName(roleName);
				return role;
			}
		} catch (SQLException e) {
			Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			this.close(rs,ps,connection);
		}
		return null;
	}
	
	private void close(ResultSet rs,Statement ps,Connection connection) {
		try {
			if(rs !=null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
		}
		
		try {
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
		}
		
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(JdbcExample.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public static void main(String[] args) {
		JdbcExample example = new JdbcExample();
		Role role = example.getRole(1L);
		System.out.println("role_name:"+role.getRoleName());
	}
	
}
