import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PAddContact extends JPanel {
	public JLabel lname, lsurname, ladd, lhome, lcell, lwork;
	public JTextField tname, tsurname, tadd, thome, tcell, twork,
			tSmartSearch_Name, tSmartSearch_Phone;
	private JButton bacontact;
	private static final long serialVersionUID = 1L;

	public PAddContact() {
		setLayout(null);

		lname = new JLabel("Name");
		lname.setBounds(120, 70, 80, 15);
		add(lname);

		tname = new JTextField();
		tname.setBounds(220, 70, 80, 15);
		add(tname);
		tname.setColumns(10);

		lsurname = new JLabel("Surname");
		lsurname.setBounds(120, 90, 80, 15);
		add(lsurname);

		tsurname = new JTextField();
		tsurname.setBounds(220, 90, 80, 15);
		add(tsurname);
		tsurname.setColumns(10);

		ladd = new JLabel("Address");
		ladd.setBounds(120, 110, 80, 15);
		add(ladd);

		tadd = new JTextField();
		tadd.setBounds(220, 110, 80, 15);
		add(tadd);
		tadd.setColumns(10);

		lhome = new JLabel("Home Phone");
		lhome.setBounds(120, 130, 80, 15);
		add(lhome);

		thome = new JTextField();
		thome.setBounds(220, 130, 80, 15);
		add(thome);
		thome.setColumns(10);

		lcell = new JLabel("Cell Phone");
		lcell.setBounds(120, 150, 80, 15);
		add(lcell);

		tcell = new JTextField();
		tcell.setBounds(220, 150, 80, 15);
		add(tcell);
		tcell.setColumns(10);

		lwork = new JLabel("Work Phone");
		lwork.setBounds(120, 170, 80, 15);
		add(lwork);

		twork = new JTextField();
		twork.setBounds(220, 170, 80, 15);
		add(twork);
		twork.setColumns(10);

		bacontact = new JButton("Add Contact");
		bacontact.setBounds(155, 200, 110, 15);
		add(bacontact);
		bacontact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (thome.getText().equals(tcell.getText())
							|| thome.getText().equals(twork.getText())
							|| tcell.getText().equals(twork.getText())) {

					} else {
						People.addPerson(tname.getText().toLowerCase(), tsurname.getText().toLowerCase(),
								tadd.getText().toLowerCase(), thome.getText(),
								tcell.getText(), twork.getText());
						JOptionPane.showMessageDialog(
								null,
								"Contact created succesfully with the following information;\n"
										+ "Name : " + tname.getText().toLowerCase() + "\n"
										+ "Surname : " + tsurname.getText().toLowerCase()
										+ "\n" + "Address: " + tadd.getText().toLowerCase()
										+ "\n" + "Home Phone : "
										+ thome.getText() + "\n"
										+ "Cell Phone : " + tcell.getText()
										+ "\n" + "Work Phone : "
										+ twork.getText() + "\n");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				//TODO Update JPanel

			}
		});
	}

	public static void errorDialog(String warn) {
		JOptionPane.showMessageDialog(null, warn);
	}

}
