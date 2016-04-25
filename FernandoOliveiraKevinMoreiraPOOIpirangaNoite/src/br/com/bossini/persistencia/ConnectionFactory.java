package br.com.bossini.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static final String usuario = "admin_cfp";
	private static final String senha = "senha_admin_cfp";
	public static Connection getConnection () throws Exception{
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", usuario, senha);
	}
}
