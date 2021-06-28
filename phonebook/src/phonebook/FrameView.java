package phonebook;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameView {

	private JFrame frmPhonebook;
	private JTable table;
	
	private FramePhonebooks pb = new FramePhonebooks();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameView window = new FrameView();
					window.frmPhonebook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPhonebook = new JFrame();
		frmPhonebook.setTitle("PhoneBook");
		frmPhonebook.setBounds(100, 100, 453, 434);
		frmPhonebook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmPhonebook.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Contacts");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Edit");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		frmPhonebook.getContentPane().setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(10, 296, 131, 41);
		frmPhonebook.getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 417, 262);
		frmPhonebook.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = table.getValueAt(table.getSelectedRow(), 0).toString();
				pb.txt.setText(name);
			}
		});
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(628);
		scrollPane.setColumnHeaderView(table);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Phonebooks pb = new Phonebooks();
				ResultSet rset = pb.getProductInfo();
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				// Хүснэгтийн мөрийг тэглэх
				model.setRowCount(0);				

				try {
					while(rset.next()) {
						model.addRow(new Object[] {rset.getString(1) });
					}
				} catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "add hiigdsengui");
				}
			}
		});
		btnEdit.setBounds(151, 296, 131, 41);
		frmPhonebook.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(296, 296, 131, 41);
		frmPhonebook.getContentPane().add(btnDelete);
	}
}
