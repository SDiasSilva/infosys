package view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import controller.ClienteCRUD;
import model.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelDelecao extends JPanel {
	private JLabel lbId, lbNome, lbInfoNome, lbCpf, lbInfoCpf, lbTelefone, lbInfoTelefone, lbCelular, lbInfoCelular,
			lbEmail, lbInfoEmail;
	private JPanel pnInfo, pnBotoes;
	private JButton btConsultar, btResetar, btDeletar;
	private JTextField txtId;

	public PainelDelecao() {
		setLayout(new BorderLayout(0, 0));

		pnInfo = new JPanel();
		add(pnInfo, BorderLayout.CENTER);
		pnInfo.setLayout(new GridLayout(6, 2, 0, 0));

		lbId = new JLabel("ID: ");
		lbId.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lbId);
		txtId = new JTextField();
		pnInfo.add(txtId);

		lbNome = new JLabel("Nome:");
		lbNome.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lbNome);

		lbInfoNome = new JLabel("");
		pnInfo.add(lbInfoNome);

		lbCpf = new JLabel("CPF:");
		lbCpf.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lbCpf);

		lbInfoCpf = new JLabel("");
		pnInfo.add(lbInfoCpf);

		lbTelefone = new JLabel("Telefone: ");
		lbTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lbTelefone);

		lbInfoTelefone = new JLabel("");
		pnInfo.add(lbInfoTelefone);

		lbCelular = new JLabel("Celular: ");
		lbCelular.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lbCelular);

		lbInfoCelular = new JLabel("");
		pnInfo.add(lbInfoCelular);

		lbEmail = new JLabel("E-Mail: ");
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		pnInfo.add(lbEmail);

		lbInfoEmail = new JLabel("");
		pnInfo.add(lbInfoEmail);

		pnBotoes = new JPanel();
		add(pnBotoes, BorderLayout.SOUTH);
		pnBotoes.setLayout(new GridLayout(0, 3, 0, 0));

		btResetar = new JButton("Resetar");
		pnBotoes.add(btResetar);
		btResetar.setEnabled(false);
		
		btConsultar = new JButton("Consultar");
		pnBotoes.add(btConsultar);
		
		btDeletar = new JButton("Deletar");
		pnBotoes.add(btDeletar);
		btDeletar.setEnabled(false);

		resetar();
		btResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetar();
			}
		});
		
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(txtId.getText());
					ClienteCRUD clienteCrud = new ClienteCRUD();
					Cliente cliente = clienteCrud.consultarCliente(id);
					lbInfoNome.setText(cliente.getNome());
					lbInfoCpf.setText(cliente.getCpf());
					lbInfoTelefone.setText(cliente.getTelefone());
					lbInfoCelular.setText(cliente.getCelular());
					lbInfoEmail.setText(cliente.getEmail());
					txtId.setEnabled(false);
					btResetar.setEnabled(true);
					btDeletar.setEnabled(true);
					btConsultar.setEnabled(false);
				} catch (NumberFormatException exc) {
					resetar();
					JOptionPane.showMessageDialog(null, "Digite apenas números!");
				}
			}
		});
		btDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(txtId.getText());
				ClienteCRUD clienteCrud = new ClienteCRUD();
				String msg = clienteCrud.excluirCliente(id);
				JOptionPane.showMessageDialog(null, msg);
				resetar();
			}
		});
	}
	public void resetar() {
		txtId.setEnabled(true);
		txtId.setText("");
		txtId.requestFocus();
		btResetar.setEnabled(false);
		btConsultar.setEnabled(true);
		btDeletar.setEnabled(false);
		lbInfoNome.setText("");
		lbInfoCpf.setText("");
		lbInfoTelefone.setText("");
		lbInfoCelular.setText("");
		lbInfoEmail.setText("");
	}

}
