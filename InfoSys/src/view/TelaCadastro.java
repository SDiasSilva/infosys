package view;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import controller.ClienteCRUD;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {
	private JLabel lbLogo, lbTitulo;
	private JButton btGravar, btLimpar, btConsultar;
	private JPanel contentPane, pnProduto, pnServico, pnTecnico, pnTitulo, pnButtons;
	private TelaCliente pnCliente;
	private TelaConsulta telaConsulta;
	private JTabbedPane tbTela;
	private String msg;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return this.msg;
	}
	
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		pnTitulo = new JPanel();
		pnTitulo.setLocation(0, 0);
		pnTitulo.setSize(536, 126);
		getContentPane().add(pnTitulo);
		pnTitulo.setLayout(null);

		lbTitulo = new JLabel("Cadastro");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setBounds(201, 36, 174, 53);
		pnTitulo.add(lbTitulo);

		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/resources/computer icon little.png")));
		lbLogo.setBounds(91, 11, 100, 100);
		pnTitulo.add(lbLogo);

		tbTela = new JTabbedPane(JTabbedPane.TOP);
		tbTela.setLocation(0, 126);
		tbTela.setSize(536, 200);
		getContentPane().add(tbTela);

		pnCliente = new TelaCliente();
		tbTela.addTab("Clientes", null, pnCliente, null);

		pnProduto = new JPanel();
		tbTela.addTab("Produtos", null, pnProduto, null);

		pnServico = new JPanel();
		tbTela.addTab("Servi\u00E7os", null, pnServico, null);

		pnTecnico = new JPanel();
		tbTela.addTab("T\u00E9cnico", null, pnTecnico, null);

		pnButtons = new JPanel();
		pnButtons.setLocation(0, 329);
		pnButtons.setSize(536, 60);
		pnButtons.setBorder(null);
		getContentPane().add(pnButtons);
		pnButtons.setLayout(new GridLayout(1, 3));
		btGravar = new JButton("Gravar");
		btLimpar = new JButton("Limpar");
		btConsultar = new JButton("Consultar Todos");
		pnButtons.add(btGravar);
		pnButtons.add(btLimpar);
		pnButtons.add(btConsultar);
		
		
		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteCRUD clienteCRUD = new ClienteCRUD();
				telaConsulta = new TelaConsulta(clienteCRUD.consultarClientes());
				telaConsulta.setVisible(true);
			}
		});


		btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbTela.getSelectedIndex() == 0)
					setMsg(pnCliente.gravarCliente());
				else if (tbTela.getSelectedIndex() == 1)
					System.out.println("Produto");
				else if (tbTela.getSelectedIndex() == 2)
					System.out.println("Serviços");
				else if (tbTela.getSelectedIndex() == 3)
					System.out.println("Técnico");
				JOptionPane.showMessageDialog(null, getMsg());
			}
		});

		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tbTela.getSelectedIndex() == 0)
					pnCliente.limparCamposCliente();
				else if (tbTela.getSelectedIndex() == 1)
					System.out.println("Produto");
				else if (tbTela.getSelectedIndex() == 2)
					System.out.println("Serviços");
				else if (tbTela.getSelectedIndex() == 3)
					System.out.println("Técnico");
			}
		});
	}
}
