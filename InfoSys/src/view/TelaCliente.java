package view;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controller.ClienteCRUD;
import model.Cliente;

public class TelaCliente extends JPanel {
	private JLabel lbCliNome, lbCliCPF, lbCliTelefone, lbCliCelular, lbCliEmail;
	private JTextField txtCliNome, txtCliCPF, txtCliTelefone, txtCliCelular, txtCliEmail;
	
	public TelaCliente() {
		setLayout(null);
		lbCliNome = new JLabel("Nome:");
		lbCliNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliNome.setBounds(76, 24, 65, 20);
		add(lbCliNome);
		
		lbCliCPF = new JLabel("CPF:");
		lbCliCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliCPF.setBounds(76, 50, 65, 20);
		add(lbCliCPF);
		
		lbCliTelefone = new JLabel("Telefone: ");
		lbCliTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliTelefone.setBounds(76, 75, 65, 20);
		add(lbCliTelefone);
		
		lbCliCelular = new JLabel("Celular:");
		lbCliCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliCelular.setBounds(76, 100, 65, 20);
		add(lbCliCelular);

		lbCliEmail = new JLabel("E-mail:");
		lbCliEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliEmail.setBounds(76, 125, 65, 20);
		add(lbCliEmail);
		
		txtCliNome = new JTextField();
		txtCliNome.setBounds(148, 25, 251, 20);
		add(txtCliNome);
		txtCliNome.setColumns(10);
		txtCliNome.requestFocus();

		txtCliCPF = new JTextField();
		txtCliCPF.setBounds(148, 50, 251, 20);
		add(txtCliCPF);
		txtCliCPF.setColumns(10);

		txtCliTelefone = new JTextField();
		txtCliTelefone.setBounds(148, 75, 251, 20);
		add(txtCliTelefone);
		txtCliTelefone.setColumns(10);

		txtCliCelular = new JTextField();
		txtCliCelular.setBounds(148, 100, 251, 20);
		add(txtCliCelular);
		txtCliCelular.setColumns(10);

		txtCliEmail = new JTextField();
		txtCliEmail.setBounds(148, 125, 251, 20);
		add(txtCliEmail);
		txtCliEmail.setColumns(10);
	}
	
	public void limparCamposCliente() {
		txtCliNome.setText("");
		txtCliCPF.setText("");
		txtCliTelefone.setText("");
		txtCliCelular.setText("");
		txtCliEmail.setText("");
		txtCliNome.requestFocus();
	}

	public String gravarCliente() {
		String nome = txtCliNome.getText();
		String cpf = txtCliCPF.getText();
		String telefone = txtCliTelefone.getText();
		String celular = txtCliCelular.getText();
		String email = txtCliEmail.getText();
		ClienteCRUD clienteCRUD = new ClienteCRUD();
		limparCamposCliente();
		return clienteCRUD.inserirCliente(new Cliente(nome, cpf, telefone, celular, email));
	}
}
