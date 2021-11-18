package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class TelaConsulta extends JFrame {
	private JPanel contentPane;
	private JTable tbConsulta;
	private JButton btAlterar;
	private JButton btDeletar;

	public TelaConsulta(DefaultTableModel tabela) {
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tbConsulta = new JTable();
		tbConsulta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tbConsulta.setGridColor(Color.BLACK);
		tbConsulta.setModel(tabela);
		
		btAlterar = new JButton("Excluir Registro");
		btDeletar = new JButton("Alterar Registro");
		
		contentPane.add(tbConsulta, BorderLayout.CENTER);
		contentPane.add(btAlterar, BorderLayout.SOUTH);
		contentPane.add(btDeletar, BorderLayout.NORTH);
	}
}
