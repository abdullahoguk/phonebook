import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PHome extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton howto;
	private JButton credits;
	private JButton contact;
	private JButton exit;
	private ImageIcon imageofsuccess;
	private JLabel imageholder;

	public PHome() {
		setLayout(null);
		setBackground(new Color(0, 153, 102));

		imageofsuccess = new ImageIcon(getClass().getResource("ios.png"));

		imageholder = new JLabel(imageofsuccess);
		add(imageholder);
		imageholder.setBounds(10, 5,236, 300);

		howto = new JButton("How To Use");
		add(howto);
		howto.setBounds(450, 195, 110, 20);

		howto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Home Panel : "
										+ "There are information about dev team in home page.\n"
										+ "Smart Search Panel : "
										+ "You can search for a contact both with name or his/her phone with the help of Smart Search.\n"
										+ "Create Contact : "
										+ "You can add new contacts to the phonebook.\n"
										+ "List All : "
										+ "Lists all contacts in an alphabetical order.");
			}
		});

		credits = new JButton("Credits");
		add(credits);
		credits.setBounds(450, 220, 110, 20);

		credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Ahmet KAÞÝF\nAbdullah ÖÐÜK\nMustafa ÖZDEMÝR\n");
			}
		});

		contact = new JButton("Contact");
		add(contact);
		contact.setBounds(450, 245, 110, 20);

		contact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showMessageDialog(
								null,
								" Ahmet KAÞÝF\n e - mail: ahmetkasif1995@gmail.com\n Abdullah ÖÐÜK\n e - mail: abdullahoguk@outlook.com\n Mustafa ÖZDEMÝR\n e - mail: mustafa_ozdemir_91@hotmail.com\n");
			}
		});

		exit = new JButton("Exit");
		add(exit);
		exit.setBounds(450, 270, 110, 20);

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showMessageDialog(null, "Thanks For Using Us...");
				try {
					People.saveData();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});

	}
}
