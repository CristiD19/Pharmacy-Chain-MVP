package presenter;

import model.*;
import view.IAdministrator;
import view.IAngajat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PAngajat {
    MedicamentPersistent medicamentPersistent = new MedicamentPersistent();
    private IAngajat iAngajat;
    private Angajat angajat;
    FarmaciePersistent farmaciePersistent = new FarmaciePersistent();

    public PAngajat(IAngajat iAngajat, Angajat angajat) {
        this.iAngajat = iAngajat;
        this.angajat = angajat;
    }

    public PAngajat(){}

    public void creareMedicamentInFarmacie(){

                Farmacie farmacie = angajat.getFarmacie();
                Medicament medicament = medicamentPersistent.cautareMedicamentDupaId(iAngajat.getIdFromMedicament());
                MedicamentInFarmacie medicamentInFarmacie = farmacie.adaugareMedicament(medicament, iAngajat.getStocInput());
                farmaciePersistent.creareMedicamentInFarmacie(medicamentInFarmacie);

       // angajat.getFarmacie().adaugareMedicament(medicamentInFarmacie);
    }

    public void stergeMedicamentInFarmacie(){
        iAngajat.btnStergeMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Farmacie farmacie = angajat.getFarmacie();
                int idFromMedicamentInFarmacie = iAngajat.getIdFromMedicamentInFarmacie();
                farmacie.stergeMedicament(farmaciePersistent.cautareMedicamentInFarmacieDupaId(idFromMedicamentInFarmacie));
                farmaciePersistent.stergeMedicamentInFarmacie(idFromMedicamentInFarmacie);

            }
     });
    }

    public void actualizareMedicamentInFarmacie(){
        iAngajat.btnAcutalizareMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean disponibil = iAngajat.getDisponibilInput();
                String nume = iAngajat.getNumeMedicamentInput();
                int pret = Integer.parseInt(iAngajat.getPretInput());
                String producator = iAngajat.getProducatorInput();
                Boolean valabil = iAngajat.getValabilInput();
                int id = iAngajat.getIdFromMedicamentInFarmacie();
                int stoc = iAngajat.getStocInput();
                farmaciePersistent.actualizareMedicamentInFarmacie(disponibil, nume, pret, producator, valabil, stoc, id);

            }
        });

    }

    public void filtrareMedicamentInFarmacie(){
        iAngajat.btnFiltrareMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.filtrareMedicamente(angajat.getFarmacie().getId());

                for(int i = 0; i < medicamentInFarmacieList.size(); i++){
                    // String s = Reflection.retrieveProperties(utilizatorList.get(i));
                    //String[] string = s.split(System.lineSeparator());
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getId(), i+1, 0);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().isDisponibil().toString(), i+1, 1);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().getNume(), i+1, 2);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().getPret(), i+1, 3);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().getProducator(), i+1, 4);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().isValabil(), i+1, 5);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getStoc(), i+1, 6);
                }

                for(int i = medicamentInFarmacieList.size(); i < 13; i++){
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 0);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 1);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 2);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 3);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 4);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 5);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 6);
                }
            }
        });
    }

    public void citireMedicamentInFarmacie(){
        iAngajat.btnCautareMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicamentInFarmacie medicamentInFarmacie = farmaciePersistent.cautareMedicamentDupaNume(iAngajat.getNumeMedicamentInput(), angajat.getFarmacie().getId());

                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getId(), 1, 0);
                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getMedicament().isDisponibil().toString(), 1, 1);
                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getMedicament().getNume(), 1, 2);
                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getMedicament().getPret(), 1, 3);
                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getMedicament().getProducator(), 1, 4);
                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getMedicament().isValabil(), 1, 5);
                iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacie.getStoc(), 1, 6);

                for(int i = 1; i < 12; i++){
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 0);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 1);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 2);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 3);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 4);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 5);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 6);
                }
            }
        });
    }

    public List<MedicamentInFarmacie> listaMedicamentInFarmacie(){
       // return medicamentInFarmaciePersistent.listaMedicamentInFarmacie();
        List<MedicamentInFarmacie> medicamentInFarmacieList = new ArrayList<>();
        iAngajat.btnListaMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.listaMedicamente(angajat.getFarmacie().getId());

                for(int i = 0; i < medicamentInFarmacieList.size(); i++){
                    // String s = Reflection.retrieveProperties(utilizatorList.get(i));
                    //String[] string = s.split(System.lineSeparator());
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getId(), i+1, 0);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().isDisponibil().toString(), i+1, 1);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().getNume(), i+1, 2);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().getPret(), i+1, 3);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().getProducator(), i+1, 4);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getMedicament().isValabil(), i+1, 5);
                    iAngajat.setMedicamentInFarmacieTableText(medicamentInFarmacieList.get(i).getStoc(), i+1, 6);
                }

                for(int i = medicamentInFarmacieList.size(); i < 13; i++){
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 0);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 1);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 2);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 3);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 4);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 5);
                    iAngajat.setMedicamentInFarmacieTableText("", i+1, 6);
                }


            }
        });
        return medicamentInFarmacieList;

    }

    public List<Medicament> listaMedicamente(){
        List<Medicament> medicamentList =  medicamentPersistent.listaMedicament();
        int length = medicamentList.size();

        for(int i = 0; i < length; i++){
            // String s = Reflection.retrieveProperties(utilizatorList.get(i));
            //String[] string = s.split(System.lineSeparator());
            iAngajat.setMedicamentTableText(medicamentList.get(i).getId(), i+1, 0);
            iAngajat.setMedicamentTableText(medicamentList.get(i).isDisponibil().toString(), i+1, 1);
            iAngajat.setMedicamentTableText(medicamentList.get(i).getNume(), i+1, 2);
            iAngajat.setMedicamentTableText(medicamentList.get(i).getPret(), i+1, 3);
            iAngajat.setMedicamentTableText(medicamentList.get(i).getProducator(), i+1, 4);
            iAngajat.setMedicamentTableText(medicamentList.get(i).isValabil(), i+1, 5);
        }
        return medicamentList;
    }

}
