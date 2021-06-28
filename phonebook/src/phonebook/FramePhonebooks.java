package phonebook;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FramePhonebooks extends JFrame {

	private JPanel contentPane;
	JTextField txt;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	
	private Phonebooks pb = new Phonebooks();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePhonebooks frame = new FramePhonebooks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePhonebooks() {
		setTitle("PhoneBook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Name");
		lbl.setBounds(53, 41, 100, 14);
		contentPane.add(lbl);
		
		JLabel lbl2 = new JLabel("Phone");
		lbl2.setBounds(53, 89, 100, 14);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("Mobile");
		lbl3.setBounds(53, 133, 100, 14);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("Nickname");
		lbl4.setBounds(53, 177, 100, 14);
		contentPane.add(lbl4);
		
		JLabel lbl5 = new JLabel("Address");
		lbl5.setBounds(53, 218, 100, 14);
		contentPane.add(lbl5);
		
		JLabel lbl6 = new JLabel("Email");
		lbl6.setBounds(53, 256, 100, 14);
		contentPane.add(lbl6);
		
		JLabel lbl7 = new JLabel("Organization");
		lbl7.setBounds(53, 300, 100, 14);
		contentPane.add(lbl7);
		
		txt = new JTextField();
		txt.setBounds(163, 38, 256, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setBounds(163, 86, 256, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(163, 130, 256, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setBounds(163, 174, 256, 20);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(163, 215, 256, 20);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		txt6 = new JTextField();
		txt6.setBounds(163, 256, 256, 20);
		contentPane.add(txt6);
		txt6.setColumns(10);
		
		txt7 = new JTextField();
		txt7.setBounds(163, 297, 256, 20);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(53, 344, 154, 45);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(265, 344, 154, 45);
		contentPane.add(btnCancel);
		
		JButton btnEditSave = new JButton("Edit Save");
		btnEditSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txt.getText().isBlank()) {
					String name = txt.getText();
					String phone = txt2.getText();
					String mobile = txt3.getText();
					String nickname = txt4.getText();
					String address = txt5.getText();
					String email = txt6.getText();
					String organization = txt7.getText();
					boolean result = pb.updatePhonebooks(name, phone, mobile, nickname, address, email, organization );
					if(result) {
						JOptionPane.showMessageDialog(null, "Amjilttai Edit hiilee");
					} else {
						JOptionPane.showMessageDialog(null, "Update hiigdsengui");
					}
		
				}
			}
		});
		btnEditSave.setBounds(191, 384, 89, 23);
		contentPane.add(btnEditSave);
	}
}
