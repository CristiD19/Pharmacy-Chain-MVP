package presenter;

import model.*;
import view.IAdministrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PAdministrator {
    UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();
    private IAdministrator iAdministrator;
    FarmaciePersistent farmaciePersistent = new FarmaciePersistent();

    public PAdministrator(IAdministrator iAdministrator) {
        this.iAdministrator = iAdministrator;
    }

    public PAdministrator(){}

    public void creareUtilizator(){
        iAdministrator.btnCreareUtilizatorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilizator utilizator = checkRol(iAdministrator.getRolUtilizatorInput());
                utilizatorPersistent.creareUtilizator(utilizator);
            }
        });


    }

    public void  citireUtilizator(){
        iAdministrator.btnCitireUtilizatorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Utilizator utilizator = utilizatorPersistent.cautareUtilizatorDupaId(iAdministrator.getIdUtilizatorInput());
                iAdministrator.setUtilizatorTabelText(utilizator.getClass().getSimpleName().toString(), 1, 0);
                iAdministrator.setUtilizatorTabelText(Integer.toString(utilizator.getId()), 1, 1);
                iAdministrator.setUtilizatorTabelText(utilizator.getCont(), 1, 2);
                iAdministrator.setUtilizatorTabelText(utilizator.getNume(), 1, 3);
                iAdministrator.setUtilizatorTabelText(utilizator.getParola(), 1, 4);

                for(int i = 1; i < 15; i++){
                    iAdministrator.setUtilizatorTabelText("", i+1, 0);
                    iAdministrator. setUtilizatorTabelText("", i+1, 1);
                    iAdministrator. setUtilizatorTabelText("", i+1, 2);
                    iAdministrator. setUtilizatorTabelText("", i+1, 3);
                    iAdministrator. setUtilizatorTabelText("", i+1, 4);
                }
            }
        });

    }

    public void actualizareUtilizator(){
        iAdministrator.btnActualizareUtilizatorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utilizator utilizator = checkRol(iAdministrator.getRolUtilizatorInput());
                utilizatorPersistent.actualizareUtilizator(iAdministrator.getNumeUtilizatorInput(), iAdministrator.getContUtilizatorInput(), iAdministrator.getParolaUtilizatorInput(), iAdministrator.getIdFromTable());
            }
        });
    }

    public void stergereUtilizator(){
        iAdministrator.btnStergeUtilizatorListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilizatorPersistent.stergeUtilizator(iAdministrator.getIdFromTable());
            }
        });

    }

    public void afisareListaUtilizatori(){
        iAdministrator.btnListaUtilizatoriListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Utilizator> utilizatorList = utilizatorPersistent.listaUtilizatori();
                int length = utilizatorList.size();
                for(int i = 0; i < length; i++){
                    // String s = Reflection.retrieveProperties(utilizatorList.get(i));
                    //String[] string = s.split(System.lineSeparator());
                    iAdministrator.setUtilizatorTabelText(utilizatorList.get(i).getClass().getSimpleName().toString(), i+1, 0);
                    iAdministrator.setUtilizatorTabelText(Integer.toString(utilizatorList.get(i).getId()), i+1, 1);
                    iAdministrator.setUtilizatorTabelText(utilizatorList.get(i).getCont(), i+1, 2);
                    iAdministrator.setUtilizatorTabelText(utilizatorList.get(i).getNume(), i+1, 3);
                    iAdministrator. setUtilizatorTabelText(utilizatorList.get(i).getParola(), i+1, 4);
                }

                for(int i = utilizatorList.size(); i < 15; i++){
                    iAdministrator.setUtilizatorTabelText("", i+1, 0);
                    iAdministrator.setUtilizatorTabelText("", i+1, 1);
                    iAdministrator.setUtilizatorTabelText("", i+1, 2);
                    iAdministrator.setUtilizatorTabelText("", i+1, 3);
                    iAdministrator.setUtilizatorTabelText("", i+1, 4);
                }
            }
        });
    }

    public Utilizator checkRol(Rol rol) {
        if (rol.equals(Rol.ADMINISTRATOR)) {
            Administrator administrator = new Administrator(iAdministrator.getNumeUtilizatorInput(), iAdministrator.getContUtilizatorInput(), iAdministrator.getParolaUtilizatorInput());
            return administrator;
        }
        if (rol.equals(Rol.ANGAJAT)) {
            Farmacie farmacie = farmaciePersistent.cautareFarmacieDupaId(iAdministrator.getFarmacieIdInput());
            Angajat angajat = new Angajat(iAdministrator.getNumeUtilizatorInput(), iAdministrator.getContUtilizatorInput(), iAdministrator.getParolaUtilizatorInput(), farmacie);

            return angajat;
        }
        if (rol.equals(Rol.MANAGER)) {
            Manager manager = new Manager(iAdministrator.getNumeUtilizatorInput(), iAdministrator.getContUtilizatorInput(), iAdministrator.getParolaUtilizatorInput());
            return manager;
        }
        return null;
    }
}
