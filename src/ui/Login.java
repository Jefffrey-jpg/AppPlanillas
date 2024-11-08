package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Empleado;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	JTextField txtDni;
    JPasswordField txtPasswordd;
    JButton btnIniciar, btnCancelar;

    Empleado empleado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 300);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);

		JPanel pnlLogo = new JPanel();
		pnlLogo.setBounds(0, 0, 400, 50);
		pnlLogo.setBackground(new Color(94, 17, 90));
		getContentPane().add(pnlLogo);
		
		JLabel imgLogo = new JLabel(new ImageIcon(Login.class.getResource("/ui/img/logo.png")));
		imgLogo.setBounds(96, 4, 208, 43);
		pnlLogo.add(imgLogo);

		JLabel imgSalir = new JLabel(new ImageIcon(Login.class.getResource("/ui/img/salir.png")));
		imgSalir.setBounds(370, 12, 24, 34);
		pnlLogo.add(imgSalir);

		JLabel lblDni = new JLabel("Dni :");
		lblDni.setBounds(75, 100, 80, 30);
		getContentPane().add(lblDni);

		JLabel lblPasswordd = new JLabel("Contraseña :");
		lblPasswordd.setBounds(75, 150, 80, 30);
		getContentPane().add(lblPasswordd);

		txtDni = new JTextField();
		txtDni.setBounds( 155, 100, 60, 30);
		txtDni.setMargin( new Insets(5, 5, 5, 5) );
		getContentPane().add(txtDni);

		txtPasswordd = new JPasswordField();
		txtPasswordd.setBounds( 155, 150, 60, 30);
		txtPasswordd.setMargin( new Insets(5, 5, 5, 5) );
		getContentPane().add(txtPasswordd);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds( 75, 220, 100, 30);
		btnIniciar.setBackground(new Color(94, 17, 90));
		btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnIniciar.setMnemonic('a');
		btnIniciar.setBorderPainted(false);
		btnIniciar.setFocusPainted(false);
		btnIniciar.setForeground(Color.WHITE);
		getContentPane().add(btnIniciar);

        btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds( 225, 220, 100, 30);
		btnCancelar.setBackground(new Color(94, 17, 90));
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelar.setMnemonic('n');
		btnCancelar.setBorderPainted(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setForeground(Color.WHITE);
		getContentPane().add(btnCancelar);

		imgSalir.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {imgSalir_mouseClicked();}});

		imgSalir.addMouseListener(new MouseAdapter() {
			@Override public void mouseClicked(MouseEvent e) {imgSalir_mouseClicked();}});

		txtDni.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) {txt_focusGained(txtDni);}
			@Override public void focusLost(FocusEvent e) {txt_focusLost(txtDni);}});

		txtPasswordd.addFocusListener(new FocusAdapter() {
			@Override public void focusGained(FocusEvent e) {txt_focusGained(txtPasswordd);}
			@Override public void focusLost(FocusEvent e) {txt_focusLost(txtPasswordd);}});

		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered(MouseEvent e) {btn_mouseEntered(btnIniciar);}
			@Override public void mouseExited(MouseEvent e) {btn_mouseExited(btnIniciar);}});

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override public void mouseEntered(MouseEvent e) {btn_mouseEntered(btnCancelar);}
			@Override public void mouseExited(MouseEvent e) {btn_mouseExited(btnCancelar);}});
		
		btnIniciar.addFocusListener(new FocusListener() {
			@Override public void focusGained(FocusEvent e) {btn_mouseEntered(btnIniciar);}
			@Override public void focusLost(FocusEvent e) {btn_mouseExited(btnIniciar);}});

		btnCancelar.addFocusListener(new FocusListener() {
			@Override public void focusGained(FocusEvent e) {btn_mouseEntered(btnCancelar);}
			@Override public void focusLost(FocusEvent e) {btn_mouseExited(btnCancelar);}});
		
		btnIniciar.addActionListener(e -> btnIniciar_actionPerformed());
        btnCancelar.addActionListener(e -> btnCancelar_actionPerformed());
	
	}

	protected void imgSalir_mouseClicked() {
		if (JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION)
			System.exit(0);
	}

	protected void txt_focusGained(JTextField txt) {
		txt.setBackground(new Color(205, 236, 250));
	}

	protected void txt_focusLost(JTextField txt) {
		txt.setBackground(Color.WHITE);
	}
	
	protected void btn_mouseEntered(JButton btn) {
		btn.setBackground(Color.BLACK);
	}
	
	protected void btn_mouseExited(JButton btn) {
		btn.setBackground(new Color(94, 17, 90));
	}

    protected void btnIniciar_actionPerformed() {
    }

    protected void btnCancelar_actionPerformed() {
    }
}