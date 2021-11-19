package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoDB {
	// atributos
	private String sgbd, server, porta, banco, user, pw, strCnx;

	// construtor
	public ConexaoDB() {
		sgbd = "mysql";
		server = "localhost";
		porta = "3306";
		banco = "crud";
		user = "root";
		pw = "database";
		strCnx = "jdbc:" + sgbd + "://" + server + ":" + porta + "/" + banco;
	}

	public Connection conectar() throws SQLException {
		return DriverManager.getConnection(strCnx, user, pw);
	}
}