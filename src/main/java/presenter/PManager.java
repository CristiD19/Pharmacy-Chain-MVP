package presenter;

import model.*;
import view.IAdministrator;
import view.IAngajat;
import view.IManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PManager {
    MedicamentPersistent medicamentPersistent = new MedicamentPersistent();
    private IManager iManager;
    FarmaciePersistent farmaciePersistent = new FarmaciePersistent();


    public PManager(IManager iManager) {
        this.iManager = iManager;
    }

    public void afisareFarmacii() {
        List<Farmacie> farmacieList = farmaciePersistent.listaFarmacii();
        for (int i = 0; i < farmacieList.size(); i++) {
            // String s = Reflection.retrieveProperties(utilizatorList.get(i));
            //String[] string = s.split(System.lineSeparator());
            iManager.setFarmacieTableText(farmacieList.get(i).getId(), i + 1, 0);
            iManager.setFarmacieTableText(farmacieList.get(i).getName(), i + 1, 1);
        }
    }

    public void afisareMedicamenteInFarmacie() {

        iManager.btnListaMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.listaMedicamenteManager(iManager.getIdFromTableFarmacie());
                for (int i = 0; i < medicamentInFarmacieList.size(); i++) {
                    // String s = Reflection.retrieveProperties(utilizatorList.get(i));
                    //String[] string = s.split(System.lineSeparator());
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getId(), i + 1, 0);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().isDisponibil().toString(), i + 1, 1);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().getNume(), i + 1, 2);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().getPret(), i + 1, 3);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().getProducator(), i + 1, 4);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().isValabil(), i + 1, 5);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getStoc(), i + 1, 6);
                }

                for (int i = medicamentInFarmacieList.size(); i < 13; i++) {
                    iManager.setClientTableText("", i + 1, 0);
                    iManager.setClientTableText("", i + 1, 1);
                    iManager.setClientTableText("", i + 1, 2);
                    iManager.setClientTableText("", i + 1, 3);
                    iManager.setClientTableText("", i + 1, 4);
                    iManager.setClientTableText("", i + 1, 5);
                    iManager.setClientTableText("", i + 1, 6);
                }
            }

        });
    }

    public void filtrareMedicamentInFarmacie(){
        iManager.btnFiltrareMedicamenteListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<MedicamentInFarmacie> medicamentInFarmacieList = farmaciePersistent.filtrareMedicamente(iManager.getIdFromTableFarmacie());

                for (int i = 0; i < medicamentInFarmacieList.size(); i++) {
                    // String s = Reflection.retrieveProperties(utilizatorList.get(i));
                    //String[] string = s.split(System.lineSeparator());
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getId(), i + 1, 0);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().isDisponibil().toString(), i + 1, 1);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().getNume(), i + 1, 2);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().getPret(), i + 1, 3);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().getProducator(), i + 1, 4);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getMedicament().isValabil(), i + 1, 5);
                    iManager.setClientTableText(medicamentInFarmacieList.get(i).getStoc(), i + 1, 6);
                }

                for (int i = medicamentInFarmacieList.size(); i < 13; i++) {
                    iManager.setClientTableText("", i + 1, 0);
                    iManager.setClientTableText("", i + 1, 1);
                    iManager.setClientTableText("", i + 1, 2);
                    iManager.setClientTableText("", i + 1, 3);
                    iManager.setClientTableText("", i + 1, 4);
                    iManager.setClientTableText("", i + 1, 5);
                    iManager.setClientTableText("", i + 1, 6);
                }
            }
        });
    }

    public void cautareMedicamentDupaNume(){

        iManager.btnCautareMedicamentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicamentInFarmacie medicamentInFarmacie = farmaciePersistent.cautareMedicamentDupaNume(iManager.getNumeMedicamentInput(), iManager.getIdFromTableFarmacie());

                iManager.setClientTableText(medicamentInFarmacie.getId(),  1, 0);
                iManager.setClientTableText(medicamentInFarmacie.getMedicament().isDisponibil().toString(),  1, 1);
                iManager.setClientTableText(medicamentInFarmacie.getMedicament().getNume(),  1, 2);
                iManager.setClientTableText(medicamentInFarmacie.getMedicament().getPret(),  1, 3);
                iManager.setClientTableText(medicamentInFarmacie.getMedicament().getProducator(),  1, 4);
                iManager.setClientTableText(medicamentInFarmacie.getMedicament().isValabil(),  1, 5);
                iManager.setClientTableText(medicamentInFarmacie.getStoc(),  1, 6);

                for (int i = 1; i < 13; i++) {
                    iManager.setClientTableText("", i + 1, 0);
                    iManager.setClientTableText("", i + 1, 1);
                    iManager.setClientTableText("", i + 1, 2);
                    iManager.setClientTableText("", i + 1, 3);
                    iManager.setClientTableText("", i + 1, 4);
                    iManager.setClientTableText("", i + 1, 5);
                    iManager.setClientTableText("", i + 1, 6);
                }
            }
        });
    }

}
