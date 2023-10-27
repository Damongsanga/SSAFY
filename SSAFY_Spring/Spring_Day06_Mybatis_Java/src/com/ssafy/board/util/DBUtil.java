package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Mysql DB �뿰寃� 媛앹껜瑜� �젣怨듯빐二쇨퀬, �궗�슜�뻽�뜕 �옄�썝�쓣 �빐�젣�븯�뒗 湲곕뒫�쓣 �젣怨듯븯�뒗 �겢�옒�뒪�엯�땲�떎.
 */
public class DBUtil {
	/**
	 * DB �젒�냽�뿉 �븘�슂�븳 url�쓣 �옉�꽦�븳�떎. url��
	 * jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]�삎�깭濡�
	 * �옉�꽦�븳�떎. serverTimezone=UTC �꽕�젙�씠 �뾾�쑝硫� �삤瑜섍� 諛쒖깮�븯誘�濡� 二쇱쓽�븳�떎.
	 */
	// DB�� �뿰寃고븯湲곗쐞�빐 �븘�슂�븳 DB�쓽 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	// DB�쓽 USER �씠由�
	private final String username = "root";
	// �쐞 USER�쓽 PASSWORD
	private final String password = "ssafy";
	// Mysql �뱶�씪�씠踰� �겢�옒�뒪 �씠由�
	private final String driverName = "com.mysql.cj.jdbc.Driver";

	/**
	 * Singleton Design Pattern�쓣 �쟻�슜�빐以��떎.
	 */
	private static DBUtil instance = new DBUtil();

	private DBUtil() {
		// JDBC �뱶�씪�씠踰꾨�� 濡쒕뵫�븳�떎. �뱶�씪�씠踰� 濡쒕뵫�� 媛앹껜 �깮�꽦 �떆 �븳踰덈쭔 吏꾪뻾�븯�룄濡� �븯�옄.
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DBUtil getInstance() {
		return instance;
	}

	/**
	 * DriverManager瑜� �넻�빐 Connection�쓣 �깮�꽦�븯怨� 諛섑솚�븳�떎.
	 *
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * �궗�슜�븳 由ъ냼�뒪�뱾�쓣 �젙由ы븳�떎. Connection, Statement, ResultSet 紐⑤몢 AutoCloseable ���엯�씠�떎. ... �쓣
	 * �씠�슜�븯誘�濡� �븘�슂�뿉 �뵲�씪�꽌 select 怨꾩뿴 �샇異� �썑�뒗 ResultSet, Statement, Connection dml �샇異� �썑�뒗
	 * Statement, Connection �벑 �떎�뼇�븳 議고빀�쑝濡� �궗�슜�븷 �닔 �엳�떎.
	 *
	 * @param closeables
	 */
	public void close(AutoCloseable... closeables) {
		for (AutoCloseable c : closeables) {
			if (c != null) {
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}