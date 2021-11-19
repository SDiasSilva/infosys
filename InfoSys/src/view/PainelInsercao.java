package view;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.ClienteCRUD;
import model.Cliente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelInsercao extends JPanel {
	private JLabel lbCliNome, lbCliCPF, lbCliTelefone, lbCliCelular, lbCliEmail;
	private JTextField txtCliNome, txtCliCPF, txtCliTelefone, txtCliCelular, txtCliEmail;
	private JButton btLimpar, btCadastrar;
	
	public PainelInsercao() {
		setLayout(null);
		lbCliNome = new JLabel("Nome:");
		lbCliNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliNome.setBounds(52, 31, 65, 20);
		add(lbCliNome);
		
		lbCliCPF = new JLabel("CPF:");
		lbCliCPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliCPF.setBounds(52, 57, 65, 20);
		add(lbCliCPF);
		
		lbCliTelefone = new JLabel("Telefone: ");
		lbCliTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliTelefone.setBounds(52, 82, 65, 20);
		add(lbCliTelefone);
		
		lbCliCelular = new JLabel("Celular:");
		lbCliCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliCelular.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliCelular.setBounds(52, 107, 65, 20);
		add(lbCliCelular);

		lbCliEmail = new JLabel("E-mail:");
		lbCliEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCliEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbCliEmail.setBounds(52, 132, 65, 20);
		add(lbCliEmail);
		
		txtCliNome = new JTextField();
		txtCliNome.setBounds(124, 32, 251, 20);
		add(txtCliNome);
		txtCliNome.setColumns(10);
		txtCliNome.requestFocus();

		txtCliCPF = new JTextField();
		txtCliCPF.setBounds(124, 57, 251, 20);
		add(txtCliCPF);
		txtCliCPF.setColumns(10);

		txtCliTelefone = new JTextField();
		txtCliTelefone.setBounds(124, 82, 251, 20);
		add(txtCliTelefone);
		txtCliTelefone.setColumns(10);

		txtCliCelular = new JTextField();
		txtCliCelular.setBounds(124, 107, 251, 20);
		add(txtCliCelular);
		txtCliCelular.setColumns(10);

		txtCliEmail = new JTextField();
		txtCliEmail.setBounds(124, 132, 251, 20);
		add(txtCliEmail);
		txtCliEmail.setColumns(10);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(146, 163, 89, 23);
		add(btLimpar);
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(245, 163, 99, 23);
		add(btCadastrar);
		
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCamposCliente();
			}
		});
		
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = gravarCliente();
				JOptionPane.showMessageDialog(null, msg);
				limparCamposCliente();
			}
		});
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
