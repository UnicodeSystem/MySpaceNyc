package dd_util;

public class TestConfig {

	public static String server = "smtp.gmail.com";
	public static String from = "w2aispg@gmail.com";
	public static String password = "Ispg$123";
	public static String[] to = { "seleniumcoaching@gmail.com" };
	public static String subject = "Test Report";

	public static String messageBody = "TestMessage";
	public static String attachmentPath = "C:\\screenshot\\error.jpg";
	public static String attachmentName = "Error.jpeg";

	// SQL DATABASE DETAILS
	public static String driver = "net.sourceforge.jtds.jdbc.Driver";
	public static String dbConnectionUrl = "jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval";
	public static String dbUserName = "sa";
	public static String dbPassword = "$ql$!!1";

	// MYSQL DATABASE DETAILS
	public static String mysqldriver = "com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/gaurav";

}
