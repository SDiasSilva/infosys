package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Result;

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

	public void alterarCliente(int idCliente) {

	}

	public void excluirCliente() {

	}

	public Cliente consultarCliente(int id) {
		String sql = "SELECT * FROM cliente WHERE cdCliente = ?";
		Cliente cliente = null;
		ConexaoDB conexaoDB = new ConexaoDB();
		ResultSet rs = null;
		try {
			conn = conexaoDB.conectar();
			this.pstm = conn.prepareStatement(sql);
			this.pstm.setString(1, "" + id);
			rs = this.pstm.executeQuery();
			rs.next();
			cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			conn.close();
		} catch (SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return cliente;
	}

	public DefaultTableModel consultarClientes() {
		String sql = "SELECT * FROM cliente";
		ConexaoDB conexaoDB = new ConexaoDB();
		ResultSet rs = null;
		String[] campos = { "ID", "Nome", "CPF", "Telefone", "Celular", "E-Mail" };
		DefaultTableModel tabela = new DefaultTableModel(null, campos);

		try {
			this.conn = conexaoDB.conectar();
			this.pstm = conn.prepareStatement(sql);
			rs = this.pstm.executeQuery();
			tabela.addRow(campos);
			while (rs.next()) {
				tabela.addRow(new String[] { "" + rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
			}
			conn.close();
		} catch (SQLException sqlexc) {
			System.out.println(sqlexc.getMessage());
		}
		return tabela;
	}
}
