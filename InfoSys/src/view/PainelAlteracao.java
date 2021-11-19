package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import controller.ClienteCRUD;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelAlteracao extends JPanel {
	private JTextField txtId;
	private JTextField txtInfo;
	private JLabel lbId, lbColuna;
	private JComboBox cbColuna;
	private JButton btAlterar;
	private String[] colunas =  {"Nome", "CPF", "Telefone",  "Celular", "E-Mail"};

	public PainelAlteracao() {
		setLayout(null);
		lbId = new JLabel("ID:");
		lbId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbId.setBounds(141, 55, 49, 20);
		add(lbId);
		
		txtId = new JTextField();
		txtId.setBounds(198, 55, 96, 20);
		add(txtId);
		txtId.setColumns(10);
		
		cbColuna = new JComboBox();
		cbColuna.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbColuna.setBounds(198, 85, 96, 22);
		for (int i = 0; i < colunas.length; i++)
			cbColuna.addItem(colunas[i]);
		add(cbColuna);
		
		lbColuna = new JLabel("Coluna:");
		lbColuna.setHorizontalAlignment(SwingConstants.RIGHT);
		lbColuna.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbColuna.setBounds(141, 85, 49, 22);
		add(lbColuna);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(151, 115, 187, 20);
		add(txtInfo);
		txtInfo.setColumns(10);
		
		btAlterar = new JButton("Alterar");
		btAlterar.setBounds(198, 145, 89, 23);
		add(btAlterar);
		resetar();
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteCRUD clienteCrud = new ClienteCRUD();
				int id = Integer.parseInt(txtId.getText());
				String info = txtInfo.getText();
				String msg = "";
				
				if (cbColuna.getSelectedIndex() == 0)
					msg = clienteCrud.alterarCliente(id, "nmCliente", info);
				else if (cbColuna.getSelectedIndex() == 1)
					msg = clienteCrud.alterarCliente(id, "cdClienteCPF", info);
				else if (cbColuna.getSelectedIndex() == 2)
					msg = clienteCrud.alterarCliente(id, "dsClienteTelefone", info);
				else if (cbColuna.getSelectedIndex() == 3)
					msg = clienteCrud.alterarCliente(id, "dsClienteCelular", info);
				else if (cbColuna.getSelectedIndex() == 4)
					msg = clienteCrud.alterarCliente(id, "dsClienteEmail", info);
				JOptionPane.showMessageDialog(null, msg);
				resetar();
			}
		});
	}
	public void resetar() {
		txtId.setText("");
		txtInfo.setText("");
		txtId.requestFocus();
	}
}
