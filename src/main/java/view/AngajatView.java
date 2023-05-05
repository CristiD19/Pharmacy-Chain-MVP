package view;

import model.Angajat;
import model.Medicament;
import model.Utilizator;
import presenter.PAngajat;
import view.IAngajat;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.List;

public class AngajatView extends JFrame implements IAngajat {

    private JPanel contentPane;
    private JTable table;
    private JTextField numeMedicamentTextField ;
    private JTextField pretTextField ;
    private JButton btnAdaugaMedicament;
    private JButton btnAcutalizareMedicament;
    private JButton btnListaMedicamente;
    private JButton btnStergeMedicament;
    private JButton btnFiltrareMedicamente;
    private JLabel producatorLabel_1;
    private JTextField producatorTextField;
    private JLabel clientNameLabel;
    private JCheckBox disponibilCheckBox;
    private JCheckBox valabilCheckBox;
    private JTable table_1;
    private JTextField stocTextField;
    private JButton btnCautareMedicament;




    public AngajatView(Angajat angajat) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1150, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Tabel Angajat");
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(324, 10, 239, 54);
        contentPane.add(lblNewLabel);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate"
                }
        ));
        table.setBounds(24, 74, 345, 291);
        contentPane.add(table);

        btnAdaugaMedicament = new JButton("Adauga Medicament");
        btnAdaugaMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnAdaugaMedicament.setBounds(10, 397, 170, 35);
        contentPane.add(btnAdaugaMedicament);

        btnAcutalizareMedicament = new JButton("Acutalizare Medicament");
        btnAcutalizareMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnAcutalizareMedicament.setBounds(190, 397, 179, 35);
        contentPane.add(btnAcutalizareMedicament);

        btnListaMedicamente = new JButton("Lista Medicamente");
        btnListaMedicamente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnListaMedicamente.setBounds(550, 397, 147, 35);
        contentPane.add(btnListaMedicamente);

        btnStergeMedicament = new JButton("Sterge Medicament");
        btnStergeMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnStergeMedicament.setBounds(379, 397, 161, 35);
        contentPane.add(btnStergeMedicament);

        clientNameLabel = new JLabel("Nume:");
        clientNameLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientNameLabel.setBounds(853, 69, 83, 28);
        contentPane.add(clientNameLabel);

        JLabel clientAddressLabel = new JLabel("Disponibil:");
        clientAddressLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAddressLabel.setBounds(853, 118, 83, 28);
        contentPane.add(clientAddressLabel);

        JLabel clientEmailLabel = new JLabel("Valabil:");
        clientEmailLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientEmailLabel.setBounds(853, 172, 83, 28);
        contentPane.add(clientEmailLabel);

        JLabel clientAgeLabel = new JLabel("Pret:");
        clientAgeLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        clientAgeLabel.setBounds(853, 224, 83, 28);
        contentPane.add(clientAgeLabel);

        numeMedicamentTextField = new JTextField();
        numeMedicamentTextField .setBounds(977, 66, 125, 31);
        contentPane.add(numeMedicamentTextField );
        numeMedicamentTextField .setColumns(10);

        pretTextField = new JTextField();
        pretTextField.setBounds(977, 221, 125, 31);
        contentPane.add(pretTextField);
        pretTextField.setColumns(10);

        btnFiltrareMedicamente = new JButton("Filtrare Medicament");
        btnFiltrareMedicamente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnFiltrareMedicamente.setFont(new Font("Calibri", Font.BOLD, 14));
        btnFiltrareMedicamente.setBounds(725, 397, 161, 35);
        contentPane.add(btnFiltrareMedicamente);

        disponibilCheckBox = new JCheckBox("");
        disponibilCheckBox.setBounds(974, 118, 93, 35);
        contentPane.add(disponibilCheckBox);

        valabilCheckBox = new JCheckBox("");
        valabilCheckBox.setBounds(974, 172, 93, 21);
        contentPane.add(valabilCheckBox);

        producatorLabel_1 = new JLabel("Producator:");
        producatorLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
        producatorLabel_1.setBounds(853, 280, 83, 28);
        contentPane.add(producatorLabel_1);

        producatorTextField = new JTextField();
        producatorTextField.setColumns(10);
        producatorTextField.setBounds(977, 277, 125, 31);
        contentPane.add(producatorTextField);

        JLabel stocLabel = new JLabel("Stoc:");
        stocLabel.setFont(new Font("Calibri", Font.BOLD, 14));
        stocLabel.setBounds(853, 337, 83, 28);
        contentPane.add(stocLabel);

        stocTextField = new JTextField();
        stocTextField.setColumns(10);
        stocTextField.setBounds(977, 334, 125, 31);
        contentPane.add(stocTextField);

        table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                        {"Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate","Stoc"},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Id", "Disponibilitate", "Nume", "Pret", "Producator", "Valabilitate","Stoc"
                }
        ));
        table_1.setBounds(379, 74, 420, 291);
        contentPane.add(table_1);

        btnCautareMedicament = new JButton("Cautare Medicament");
        btnCautareMedicament.setFont(new Font("Calibri", Font.BOLD, 14));
        btnCautareMedicament.setBounds(906, 397, 161, 35);
        contentPane.add(btnCautareMedicament);

        PAngajat pAngajat = new PAngajat(this, angajat);

        pAngajat.listaMedicamente();

        btnAdaugaMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            pAngajat.creareMedicamentInFarmacie();
            }
     });

        pAngajat.listaMedicamentInFarmacie();

        pAngajat.stergeMedicamentInFarmacie();

        pAngajat.citireMedicamentInFarmacie();

        pAngajat.filtrareMedicamentInFarmacie();

        pAngajat.actualizareMedicamentInFarmacie();

    }


    public void btnAdaugaMedicamentListener(ActionListener actionListener) {
        this.btnAdaugaMedicament.addActionListener(actionListener);
    }

    public void btnFiltrareMedicamenteListener(ActionListener actionListener){
        this.btnFiltrareMedicamente.addActionListener(actionListener);
    }

    public void btnCautareMedicamentListener(ActionListener actionListener) {
        this.btnCautareMedicament.addActionListener(actionListener);
    }

    public void btnAcutalizareMedicamentListener(ActionListener actionListener){
        this.btnAcutalizareMedicament.addActionListener(actionListener);
    }

    public void btnListaMedicamenteListener(ActionListener actionListener){
        this.btnListaMedicamente.addActionListener(actionListener);
    }

    public void btnStergeMedicamentListener(ActionListener actionListener){
        this.btnStergeMedicament.addActionListener(actionListener);
    }


    public String getPretInput(){
        return this.pretTextField.getText();
    }

    public String getNumeMedicamentInput(){
        return this.numeMedicamentTextField.getText();
    }

    public String getProducatorInput(){
        return this.producatorTextField.getText();
    }

    public Boolean getValabilInput(){
        return this.valabilCheckBox.isSelected();
    }

    public Boolean getDisponibilInput(){
        return this.disponibilCheckBox.isSelected();
    }

    public int getStocInput(){
        return Integer.parseInt(this.stocTextField.getText());
    }


    public void setMedicamentTableText(Object t, int row, int col) {
        table.getModel().setValueAt(t, row, col);
    }

    public void setMedicamentInFarmacieTableText(Object t, int row, int col) {
        table_1.getModel().setValueAt(t, row, col);
    }

    public int getIdFromMedicament(){
        int value;
        int column = 0;
        int row = table.getSelectedRow();
        value = Integer.parseInt(table.getModel().getValueAt(row, column).toString());
        return value;
    }

    public int getIdFromMedicamentInFarmacie(){
        int value;
        int column = 0;
        int row = table_1.getSelectedRow();
        value = Integer.parseInt(table_1.getModel().getValueAt(row, column).toString());
        return value;
    }


}

