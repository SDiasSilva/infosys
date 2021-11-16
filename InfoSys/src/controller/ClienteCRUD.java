package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cliente;

public class ClienteCRUD {
	private Connection conn;
	private PreparedStatement pstm;

	public String inserirCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente (nmCliente, cdClienteCPF, dsClienteTelefone, dsClienteCelular, dsClienteEmail) VALUES (?,?,?,?,?)";
		String msg = "";
		ConexaoDB conexaoDB = new ConexaoDB();

		try {
			conn = conexaoDB.conectar();
			this.pstm = conn.prepareStatement(sql);
			this.pstm.setString(1, cliente.getNome());
			this.pstm.setString(2, cliente.getCpf());
			this.pstm.setString(3, cliente.getTelefone());
			this.pstm.setString(4, cliente.getCelular());
			this.pstm.setString(5, cliente.getEmail());
			this.pstm.execute();
			msg = "Cliente cadastrado com sucesso!";
			conn.close();
		} catch (SQLException sqlexc) {
			msg = "Não foi possível cadastrar cliente.\nCausa: " + sqlexc;
		}
		return msg;
	}
}
