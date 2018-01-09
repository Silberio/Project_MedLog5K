package com.silberio.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.silberio.control.DataAccesObject;
import com.silberio.model.Patient;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Initializes main GUI frame
	 */
	private GridBagLayout grid = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private boolean isEdit;
	private static InputField fname, lname, address, dob, phone, presc, sig;
	private static InputField ofname, olname, oaddress, odob, ophone, opresc, osig;
	private static JTextArea prescreason, oprescreason;

	public MainWindow() {
		String title = "MedLog System 5000 : : by SilbTech";
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1100, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.add(container());

		this.pack();
		this.setVisible(true);
	}

	/**
	 * Main GUI panel
	 * 
	 * @return
	 */
	private JPanel container() {
		JPanel container = new JPanel();

		container.setLayout(new BorderLayout());
		container.add(west(), BorderLayout.WEST);
		container.add(east(), BorderLayout.EAST);
		container.add(center(), BorderLayout.CENTER);

		// center.setBackground(new Color(232, 192, 132));

		return container;
	}

	/*
	 * PANELS
	 */

	/**
	 * West panel initialization
	 * <p>
	 * Contains all methods and elements pertaining the action of inputting a
	 * patient
	 * </p>
	 * 
	 * @return
	 */
	private JPanel west() {
		JPanel west = new JPanel();

		west.setLayout(grid);

		gbc.insets = new Insets(5, 1, 2, 2);

		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		west.add(new JLabel("Name: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		west.add(fname = new InputField("fname"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		west.add(lname = new InputField("lname"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		west.add(new JLabel("Address: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		west.add(address = new InputField("address"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		west.add(new JLabel("D.O.B.: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		west.add(dob = new InputField("dob"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		west.add(new JLabel("Phone: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		west.add(phone = new InputField("phone"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		west.add(new JLabel("Prescription: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		west.add(presc = new InputField("prescription"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 6;
		west.add(new JLabel("Prescription Reason: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 7;
		west.add(prescreason = new JTextArea(10, 15), gbc);

		gbc.gridx = 0;
		gbc.gridy = 8;
		west.add(new JLabel("Signed by: "), gbc);
		gbc.gridx = 1;
		gbc.gridy = 8;
		west.add(sig = new InputField("signature"), gbc);

		gbc.gridx = 0;
		gbc.gridy = 9;
		west.add(new JCheckBox("Set Priority"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 9;
		west.add(inputPatientBtn(), gbc);

		return west;
	}

	/**
	 * eastern panel initialization
	 * <p>
	 * Contains methods and elements pertaining the output of patient information
	 * </p>
	 * 
	 * @return
	 */
	private JPanel east() {
		JPanel east = new JPanel();

		east.setLayout(grid);

		gbc.insets = new Insets(5, 1, 2, 20);

		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		east.add(ofname = new InputField("fname"), gbc);
		ofname.setEditable(false);

		gbc.gridx = 0;
		gbc.gridy = 1;
		east.add(olname = new InputField("lname"), gbc);
		olname.setEditable(false);

		gbc.insets = new Insets(10, 1, 2, 20);

		gbc.gridx = 0;
		gbc.gridy = 2;
		east.add(oaddress = new InputField("address"), gbc);
		oaddress.setEditable(false);

		gbc.gridx = 0;
		gbc.gridy = 3;
		east.add(odob = new InputField("dob"), gbc);
		odob.setEditable(false);

		gbc.gridx = 0;
		gbc.gridy = 4;
		east.add(ophone = new InputField("phone"), gbc);
		ophone.setEditable(false);

		gbc.gridx = 0;
		gbc.gridy = 5;
		east.add(opresc = new InputField("prescription"), gbc);
		opresc.setEditable(false);

		gbc.gridx = 0;
		gbc.gridy = 7;
		east.add(oprescreason = new JTextArea(10, 15), gbc);
		oprescreason.setEditable(false);

		gbc.gridx = 0;
		gbc.gridy = 8;
		east.add(osig = new InputField("signature"), gbc);
		osig.setEditable(false);

		gbc.insets = new Insets(10, 1, 2, 20);

		gbc.gridx = 0;
		gbc.gridy = 9;
		east.add(retrievePatientBtn(), gbc);

		gbc.gridx = 0;
		gbc.gridy = 10;

		gbc.insets = new Insets(10, 1, 15, 20);

		gbc.gridx = 0;
		gbc.gridy = 11;
		east.add(removePatientBtn(), gbc);

		return east;
	}

	/**
	 * Center panel with list
	 * 
	 * @return
	 */
	private JPanel center() {
		JPanel center = new JPanel();

		center.setLayout(grid);

		gbc.insets = new Insets(5, 1, 2, 20);

		gbc.fill = GridBagConstraints.BOTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		center.add(queueList(), gbc);

		return center;
	}

	/*
	 * BUTTONS
	 */

	private JButton inputPatientBtn() {
		JButton btn = new JButton("Input Patient");
		btn.addActionListener(e -> inputPatient());
		return btn;
	}

	private JButton retrievePatientBtn() {
		JButton btn = new JButton("Retrieve Patient");
		btn.addActionListener(e -> retrievePatient(btn));
		return btn;
	}

	private JButton editPatientBtn() {
		JButton btn = new JButton("Edit Patient");
		btn.addActionListener(e -> editPatient());
		return btn;
	}


	private JButton removePatientBtn() {
		JButton btn = new JButton("Remove Patient");
		btn.addActionListener(e -> removePatient());
		return btn;
	}

	/*
	 * ELEMENTS
	 */

	/**
	 * GUI List element
	 * 
	 * @return
	 */
	private JScrollPane queueList() {
		DefaultListModel<Patient> model = new DefaultListModel<Patient>();
		JList<Patient> list = new JList<Patient>(model);
		JScrollPane pane = new JScrollPane(list);

		return pane;
	}

	/*
	 * BSNS LOGIC
	 */

	private void populateOutputFields(Patient p) {
		ofname.setText(p.getFirstName());
		olname.setText(p.getLastName());
		oaddress.setText(p.getAddress());
		odob.setText(p.getDateOfBirth());
		ophone.setText(p.getTelephone());
		opresc.setText(p.getPrescription());
		oprescreason.setText(p.getPrescriptionReason());
		osig.setText(p.getSignature());
	}

	private void setPanelsEditable(boolean b) {
		ofname.setEditable(b);
		olname.setEditable(b);
		oaddress.setEditable(b);
		ophone.setEditable(b);
		odob.setEditable(b);
		opresc.setEditable(b);
		oprescreason.setEditable(b);
		osig.setEditable(b);
	};

	/*
	 * DAO CONTROL
	 */
	private DataAccesObject dao = null;

	public DataAccesObject getDao() {
		return dao;
	}

	public void setDao(DataAccesObject dao) {
		this.dao = dao;
	}

	private void inputPatient() {
		Patient p = new Patient();

		p.setFirstName(fname.getText());
		p.setLastName(lname.getText());
		p.setAddress(address.getText());
		p.setTelephone(phone.getText());
		p.setDateOfBirth(dob.getText());
		p.setPrescription(presc.getText());
		p.setPrescriptionReason(prescreason.getText());
		p.setSignature(sig.getText());

		System.out.println(p.getLastName() + " Initialized by " + p.getSignature());

		dao.inputPatient(dao.objectToDocument(p));
	}

	private void retrievePatient(JButton btn) {
		Patient p = dao.retrievePatient();
		populateOutputFields(p);
		btn.setEnabled(false);
	}

	private void editPatient(JButton btn) {
		btn.setEnabled(false);
	}

	private void savePatient(JButton btn) {
		
	}

	private void removePatient() {
		dao.removePatient();
	}

}
