package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.ClienteCRUD;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelConsulta extends JPanel {
	private JTable tbConsulta;
	private JButton btRecarregar;

	public PainelConsulta(DefaultTableModel tabela) {
		setLayout(new BorderLayout(0, 0));
		tbConsulta = new JTable();
		tbConsulta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tbConsulta.setGridColor(Color.BLACK);
		tbConsulta.setModel(tabela);
		tbConsulta.setBounds(600,300,0,0);
		add(tbConsulta);
		
		btRecarregar = new JButton("Recarregar");
		add(btRecarregar, BorderLayout.SOUTH);
		btRecarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteCRUD clienteCrud = new ClienteCRUD();
				tbConsulta.setModel(clienteCrud.consultarClientes());
			}
		});
	}
}
