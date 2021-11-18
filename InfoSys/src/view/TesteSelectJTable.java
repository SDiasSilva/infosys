package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import controller.ConexaoDB;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TesteSelectJTable extends JFrame implements ActionListener {
	// atributos
	private JButton btnSelect, btnLimpar, btnSair;
	private JPanel pnlBotoes, pnlSelect;
	private JTable tblQuery;

	// construtor
	public TesteSelectJTable() {
		super("Testado o SELECT com JTable");
		// JPanel
		pnlBotoes = new JPanel(new GridLayout(1, 3));
		pnlSelect = new JPanel(new FlowLayout());
		// JButton
		btnSelect = new JButton("Select");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		btnSelect.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnSair.addActionListener(this);
		// JTable
		tblQuery = new JTable();
		tblQuery.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblQuery.setGridColor(Color.BLACK);
		// configurar o JFrame
		setSize(500, 500);
		setLayout(new GridLayout(2, 1, 20, 20));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// adiciona componentes nos JPanel
		pnlBotoes.add(btnSelect);
		pnlBotoes.add(btnLimpar);
		pnlBotoes.add(btnSair);
		pnlSelect.add(tblQuery);
		// adiciona JPanel's no JFrame
		add(pnlBotoes);
		add(pnlSelect);
		// exibir JFrame
		setVisible(true);
	}

	// main
	public static void main(String[] args) {
		new TesteSelectJTable();
	}

	// actionPerformed
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelect) {
			try {
				String resultado = "";
				String sqlString = "SELECT * FROM cliente";
				ConexaoDB conexaoDB = new ConexaoDB();
				Connection conn = conexaoDB.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlString);
				ResultSet rs = ps.executeQuery();

				String[] campos = new String[] { "ID", "Nome", "CPF", "Telefone", "Celular", "E-Mail"};
				DefaultTableModel tabela = new DefaultTableModel(null, campos);
				while (rs.next()) {
					tabela.addRow(new String[] { "" + rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) });
				}
				conn.close();
				tblQuery.setModel(tabela);
			} catch (SQLException sqlE) {
				JOptionPane.showMessageDialog(null, "PAU NO BANCO!!!", "ERRO", JOptionPane.ERROR_MESSAGE);
				sqlE.printStackTrace();
			}
		} else if (e.getSource() == btnLimpar)
			tblQuery.setModel(new DefaultTableModel());
		else if (e.getSource() == btnSair)
			System.exit(0);
	}
}