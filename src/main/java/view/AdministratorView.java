package view;

import model.Angajat;
import model.Rol;
import model.Utilizator;
import presenter.PAdministrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.List;

public class AdministratorView extends JFrame implements IAdministrator {

    private JPanel contentPane;
    private JTable table;
    private JTextField numeUtilizatorTextField ;
    private JTextField contUtilizatorTextField ;
    private JTextField parolaUtilizatorTextField ;
    private JTextField farmacieIdField;
    private JButton btnCreareUtilizator;
    private JButton btnCitireUtilizator;
    private JButton btnStergeUtilizator;
    private JButton btnActualizareUtilizator;
    private JButton btnListaUtilizatori;
    private JComboBox rolOptions;
    private JLabel lblid;
    private JTextField idField;



    public AdministratorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tabel Administrator");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(324, 10, 239, 54);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Rol_utilizator", "Id", "Cont", "Nume", "Parola"},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "Rol_utilizator", "Id", "Cont", "Nume", "Parola"
                }
        ));
        table.setBounds(24, 74, 441, 291);
        contentPane.add(table);

        btnCreareUtilizator = new JButton("Creare Utilizator");
        btnCreareUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCreareUtilizator.setBounds(10, 397, 170, 35);
        contentPane.add(btnCreareUtilizator);

        btnCitireUtilizator = new JButton("Citire Utilizator");
        btnCitireUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCitireUtilizator.setBounds(190, 397, 179, 35);
        contentPane.add(btnCitireUtilizator);

        btnStergeUtilizator = new JButton("Sterge Utilizator");
        btnStergeUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnStergeUtilizator.setBounds(550, 397, 147, 35);
        contentPane.add(btnStergeUtilizator);

        btnActualizareUtilizator = new JButton("Actualizare Utilizator");
        btnActualizareUtilizator.setFont(new Font("Calibri", Font.BOLD, 14));
        btnActualizareUtilizator.setBounds(379, 397, 161, 35);
        contentPane.add(btnActualizareUtilizator);

        JLabel clientNameLabel = new JLabel("Nume:");
        clientNameLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientNameLabel.setBounds(520, 88, 83, 28);
        contentPane.add(clientNameLabel);

        JLabel clientAddressLabel = new JLabel("Cont:");
        clientAddressLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAddressLabel.setBounds(520, 126, 83, 28);
        contentPane.add(clientAddressLabel);

        JLabel clientEmailLabel = new JLabel("Parola:");
        clientEmailLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientEmailLabel.setBounds(520, 164, 83, 28);
        contentPane.add(clientEmailLabel);

        JLabel clientAgeLabel = new JLabel("Rol:");
        clientAgeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAgeLabel.setBounds(520, 202, 83, 28);
        contentPane.add(clientAgeLabel);

        numeUtilizatorTextField = new JTextField();
        numeUtilizatorTextField .setBounds(705, 85, 125, 31);
        contentPane.add(numeUtilizatorTextField );
        numeUtilizatorTextField .setColumns(10);

        contUtilizatorTextField = new JTextField();
        contUtilizatorTextField.setBounds(705, 123, 125, 31);
        contentPane.add(contUtilizatorTextField);
        contUtilizatorTextField.setColumns(10);

        parolaUtilizatorTextField = new JTextField();
        parolaUtilizatorTextField.setBounds(705, 161, 125, 31);
        contentPane.add(parolaUtilizatorTextField);
        parolaUtilizatorTextField.setColumns(10);

        btnListaUtilizatori = new JButton("Lista Utilizatori");
        btnListaUtilizatori.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnListaUtilizatori.setFont(new Font("Calibri", Font.BOLD, 14));
        btnListaUtilizatori.setBounds(707, 397, 161, 35);
        contentPane.add(btnListaUtilizatori);


        Rol[] rolChoice = new Rol[] {Rol.ANGAJAT, Rol.ADMINISTRATOR, Rol.MANAGER};
        rolOptions = new JComboBox<Rol>(rolChoice);
        rolOptions.setFont(new Font("Calibri", Font.BOLD, 18));
        rolOptions.setBounds(705, 200, 125, 28);
        contentPane.add(rolOptions);

        JLabel lblFarmacieid = new JLabel("FarmacieId:");
        lblFarmacieid.setFont(new Font("Calibri", Font.BOLD, 14));
        lblFarmacieid.setBounds(520, 253, 83, 28);
        contentPane.add(lblFarmacieid);

        farmacieIdField = new JTextField();
        farmacieIdField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        farmacieIdField.setColumns(10);
        farmacieIdField.setBounds(705, 247, 125, 31);
        contentPane.add(farmacieIdField);

        lblid = new JLabel("Id:");
        lblid.setFont(new Font("Calibri", Font.BOLD, 14));
        lblid.setBounds(520, 303, 83, 28);
        contentPane.add(lblid);

        idField = new JTextField();
        idField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        idField.setColumns(10);
        idField.setBounds(705, 297, 125, 31);
        contentPane.add(idField);

        PAdministrator pAdministrator = new PAdministrator(this);

        pAdministrator.creareUtilizator();

        pAdministrator.afisareListaUtilizatori();

        pAdministrator.citireUtilizator();

        pAdministrator.actualizareUtilizator();

        pAdministrator.stergereUtilizator();

    }

    public void btnCreareUtilizatorListener(ActionListener actionListener) {
        this.btnCreareUtilizator.addActionListener(actionListener);
    }

    public void btnListaUtilizatoriListener(ActionListener actionListener) {
        this.btnListaUtilizatori.addActionListener(actionListener);
    }

    public void btnCitireUtilizatorListener(ActionListener actionListener){
        this.btnCitireUtilizator.addActionListener(actionListener);
    }

    public void btnStergeUtilizatorListener(ActionListener actionListener){
        this.btnStergeUtilizator.addActionListener(actionListener);
    }

    public void btnActualizareUtilizatorListener(ActionListener actionListener){
        this.btnActualizareUtilizator.addActionListener(actionListener);
    }

    public String getContUtilizatorInput(){
        return this.contUtilizatorTextField.getText();
    }

    public String getParolaUtilizatorInput(){
        return this.parolaUtilizatorTextField.getText();
    }

    public Rol getRolUtilizatorInput(){
        return (Rol)this.rolOptions.getSelectedItem();
    }

    public String getNumeUtilizatorInput(){
        return this.numeUtilizatorTextField.getText();
    }

    public int getIdUtilizatorInput(){
        return Integer.parseInt(this.idField.getText());
    }

    public int getFarmacieIdInput(){
        return Integer.parseInt(this.farmacieIdField.getText());
    }

    public void setUtilizatorTabelText(Object t, int row, int col) {
        table.getModel().setValueAt(t, row, col);
    }

    public int getIdFromTable(){
        int value;
        int column = 1;
        int row = table.getSelectedRow();
        value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
        return value;
    }


}

