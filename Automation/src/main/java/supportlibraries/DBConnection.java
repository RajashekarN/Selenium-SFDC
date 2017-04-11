package supportlibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Class for creating connect with the database
 * @author Vishnuvardhan
 *
 */
public class DBConnection {

	private static final PreparedStatement PreparedStatement = null;
	private Connection connection;
	private String URL;
	private String Username;
	private String Password;
	// private String sqlReturnField;
	private String sqlStatement;

	public void setURL(String uRL) {
		URL = uRL;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setSqlStatement(String sqlStatement) {
		this.sqlStatement = sqlStatement;
	}

	/*
	 * public PreparedStatement prepareStatement(String sqlStatementApha) {
	 * return PreparedStatement; }
	 */

	public Connection getConnectionCRAFT() {
		try {
			connection = DriverManager.getConnection(URL, Username, Password);
		} catch (SQLException e) {
			System.out.println("Please include Classpath  Where your DB2 Driver is located");
			e.printStackTrace();
		}
		return connection;
	}

	public Connection setConnectionCRAFT() {
		return connection;
	}

	public Connection setConnectionCRAFT(String URL, String Username, String Password) {
		try {
			connection = DriverManager.getConnection(URL, Username, Password);
		} catch (SQLException e) {
			System.out.println("Please include Classpath  Where your DB2 Driver is located");
			e.printStackTrace();
		}
		return connection;
	}

	public String getResultString(String columName) {
		List<String> result = getResultset(columName);
		return result.get(result.size() - 1);
	}

	public String getResultString(String columName, boolean Random) {
		List<String> result = getResultset(columName);
		Random randomGenerator = new Random();
		randomGenerator.nextInt(result.size());

		return result.get(randomGenerator.nextInt(result.size()));
	}

	public List<String> getResultList(String columnName) {
		return getResultset(columnName);
	}

	private List<String> getResultset(String ColumnName) {
		List<String> resultList = new ArrayList<String>();
		ResultSet rset = executeStatement();
		try {
			while (rset.next()) {
				resultList.add(rset.getString(ColumnName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultList;
	}

	public ResultSet executeStatement() {
		if(connection == null)
			connection = getConnectionCRAFT();
		ResultSet rset = null;

		try {
			PreparedStatement pstmt;
			pstmt = connection.prepareStatement(sqlStatement);
			rset = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rset;
	}

	/*
	 * public PreparedStatement prepareStatement(String sqlStatementApha) {
	 * return prepareStatement(null); }
	 */

	/**
	 * @description the code is added to update the sql using jdbc connection
	 *              class
	 * @param Index
	 * @param Value
	 */
	public int executeUpdate(int Index, String Value) {
		if(connection == null)
			connection = getConnectionCRAFT();
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sqlStatement);
			pstmt.setString(Index, Value);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		return 0;
		}

	}
}
