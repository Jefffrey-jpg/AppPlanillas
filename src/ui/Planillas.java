package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Empleado;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Planillas extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	JLabel lblMensaje, lblEmpleado, lblPC, lblIP, lblFecha, lblHora;
	
	Empleado empleado = new Empleado();
	Thread thHora;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planillas frame = new Planillas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Planillas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 768);
		setLayout(null);
		setLocationRelativeTo(null);
        setUndecorated(true);
        
        JPanel pnlPlanillas = new JPanel();
        pnlPlanillas.setBounds(0, 0, 1024, 60);
        pnlPlanillas.setBackground( new Color(94, 17, 90) );
        pnlPlanillas.setLayout( null );
        getContentPane().add(pnlPlanillas);

        JLabel imgLogo = new JLabel( new ImageIcon( Login.class.getResource("/ui/img/logo.png")) );
        imgLogo.setBounds(10, 7, 208, 44);
        pnlPlanillas.add(imgLogo);

        JLabel imgSalir = new JLabel( new ImageIcon( Login.class.getResource("/ui/img/salir.png")) );
        imgSalir.setBounds(980, 13, 24, 34);
        pnlPlanillas.add(imgSalir);
        
        JLabel imgFondo = new JLabel( new ImageIcon( Login.class.getResource("/ui/img/fondoApp.png")) );
        imgFondo.setBounds(0, 100, 1024, 628);
        getContentPane().add(imgFondo);
        
        lblMensaje = new JLabel();
		lblMensaje.setBounds(20, 65, 1024, 39);
		getContentPane().add(lblMensaje);  
		
		lblEmpleado = new JLabel();
		lblEmpleado.setBounds(20, 728, 150, 40);
		getContentPane().add(lblEmpleado);  
		
		lblPC = new JLabel();
		lblPC.setBounds(300, 728, 150, 40);
		getContentPane().add(lblPC);  
		
		lblIP = new JLabel();
		lblIP.setBounds(450, 728, 150, 40);
		getContentPane().add(lblIP);  
		
		lblFecha = new JLabel();
		lblFecha.setBounds(600, 728, 150, 40);
		getContentPane().add(lblFecha);
		
		lblHora = new JLabel();
		lblHora.setBounds(750, 728, 500, 40);
		getContentPane().add(lblHora);
		
		JButton btnTrabajadores = new JButton("Trabajadores");
		btnTrabajadores.setBounds( 250, 0, 150, 60);
		btnTrabajadores.setBackground( new Color(94, 17, 90) );
		btnTrabajadores.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnTrabajadores.setBorderPainted(false);
		btnTrabajadores.setFocusPainted(false);
		btnTrabajadores.setForeground( Color.WHITE );
		getContentPane().add(btnTrabajadores);
		
		JButton btnPlanillas = new JButton("Planillas");
		btnPlanillas.setBounds( 400, 0, 150, 60);
		btnPlanillas.setBackground( new Color(94, 17, 90) );
		btnPlanillas.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnPlanillas.setBorderPainted(false);
		btnPlanillas.setFocusPainted(false);
		btnPlanillas.setForeground( Color.WHITE );
		getContentPane().add(btnPlanillas);
		
		JButton btnInformes = new JButton("Planillas");
		btnInformes.setBounds( 550, 0, 150, 60);
		btnInformes.setBackground( new Color(94, 17, 90) );
		btnInformes.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnInformes.setBorderPainted(false);
		btnInformes.setFocusPainted(false);
		btnInformes.setForeground( Color.WHITE );
		pnlPlanillas.add(btnInformes);
		
        addWindowListener(new WindowAdapter( ) {
        	@Override public void windowOpened(WindowEvent e) {form_windowOpened();}});
        
        imgSalir.addMouseListener(new MouseAdapter() {
        	@Override public void mouseClicked(MouseEvent e) {imgSalir_mouseClicked();}});
       
        btnTrabajadores.addMouseListener( new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn_mouseEntered( btnTrabajadores ); } 
            @Override public void mouseExited(MouseEvent e) { btn_mouseExited( btnTrabajadores ); } } );

        btnPlanillas.addMouseListener( new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn_mouseEntered( btnPlanillas ); } 
            @Override public void mouseExited(MouseEvent e) { btn_mouseExited( btnPlanillas ); } } );
        
        btnInformes.addMouseListener( new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { btn_mouseEntered( btnInformes ); } 
            @Override public void mouseExited(MouseEvent e) { btn_mouseExited( btnInformes ); } } );
        
        btnTrabajadores.addActionListener(e -> btn_actionPerformed());
        btnPlanillas.addActionListener(e -> btn_actionPerformed());
        btnInformes.addActionListener(e -> btn_actionPerformed());
	}
	

	protected void form_windowOpened() {
		lblMensaje.setText("Hola " + empleado.getApellidoPaterno() + ", Bienvenido al sistema de planillas");
		lblEmpleado.setText(String.format("Empleado: %s %s %s", empleado.getNombres(), empleado.getApellidoPaterno()));
		lblPC.setText("PC: ");
		lblIP.setText("IP: ");
		lblFecha.setText(new SimpleDateFormat("'Fecha: ' dd/MM/yyyy").format(new Date()));
		thHora = new Thread(this);
		thHora.start();
	}

	public void setEmpleado (Empleado empleado) {
		this.empleado = empleado;
	}
	
	protected void imgSalir_mouseClicked() {
		if ( JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Salir", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION ) {
            thHora.interrupt();
			System.exit(0);
		}
	}
	
	@Override
	public void run() {
		SimpleDateFormat df = new SimpleDateFormat("'Hora: 'hh:mm:ss");
		while (true) {
			lblHora.setText(df.format(new Date()));
			try {Thread.sleep(1000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
    protected void btn_mouseEntered(JButton btn) {
        btn.setBackground( Color.BLACK );
    }

    protected void btn_mouseExited(JButton btn) {
        btn.setBackground( new Color(94, 17, 90 ) );
    }
}
