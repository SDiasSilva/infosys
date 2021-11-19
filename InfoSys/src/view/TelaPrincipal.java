package view;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controller.ClienteCRUD;
import javax.swing.JTabbedPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane, pnTitulo;
	private JLabel lbLogo, lbTitulo;
	private JTabbedPane tbCrud;
	private PainelInsercao pnInsercao;
	private PainelConsulta pnConsulta;
	private PainelAlteracao pnAlteracao;
	private PainelDelecao pnDelecao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnTitulo = new JPanel();
		pnTitulo.setBounds(0, 0, 600, 120);
		getContentPane().add(pnTitulo);
		pnTitulo.setLayout(null);

		lbTitulo = new JLabel("CRUD");
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setBounds(201, 36, 174, 53);
		pnTitulo.add(lbTitulo);

		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/resources/computer icon little.png")));
		lbLogo.setBounds(91, 11, 100, 100);
		pnTitulo.add(lbLogo);
		
		tbCrud = new JTabbedPane(JTabbedPane.TOP);
		tbCrud.setBounds(0, 120, 600, 240);
		contentPane.add(tbCrud);
		
		pnInsercao = new PainelInsercao();
		tbCrud.addTab("Inserir", null, pnInsercao, null);
		
		ClienteCRUD clienteCrud = new ClienteCRUD();
		pnConsulta = new PainelConsulta(clienteCrud.consultarClientes());
		tbCrud.addTab("Consultar", null, pnConsulta, null);
		
		pnAlteracao = new PainelAlteracao();
		tbCrud.addTab("Alterar", null, pnAlteracao, null);
		
		pnDelecao = new PainelDelecao();
		tbCrud.addTab("Deletar", null, pnDelecao, null);
	}

}
