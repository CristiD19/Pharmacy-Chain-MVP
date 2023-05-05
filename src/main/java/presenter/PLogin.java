package presenter;

import model.*;
import view.ILogin;

public class PLogin {
    private ILogin iLogin;
    UtilizatorPersistent utilizatorPersistent = new UtilizatorPersistent();
    FarmaciePersistent farmaciePersistent = new FarmaciePersistent();


    public PLogin(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public Utilizator inregistrare(){
        Rol rol = iLogin.getRol();

        if(rol.equals(Rol.ADMINISTRATOR)){
            Administrator administrator = new Administrator(iLogin.getNume(), iLogin.getCont(), iLogin.getPassword());
            utilizatorPersistent.creareUtilizator(administrator);
            return administrator;
        }
        if(rol.equals(Rol.ANGAJAT)){
            Farmacie farmacie = farmaciePersistent.cautareFarmacieDupaId(iLogin.getIdFarmacie());
            Angajat angajat = new Angajat(iLogin.getNume(), iLogin.getCont(), iLogin.getPassword(), farmacie);
            utilizatorPersistent.creareUtilizator(angajat);
            return angajat;
        }
        if(rol.equals(Rol.MANAGER)){
            Manager manager = new Manager(iLogin.getNume(), iLogin.getCont(), iLogin.getPassword());
            utilizatorPersistent.creareUtilizator(manager);
            return manager;
        }

        return null;
    }

    public Utilizator login(){
        Utilizator utilizator = utilizatorPersistent.cautareUtilizatorDupaCont(iLogin.getCont(), iLogin.getPassword());
        return utilizator;
    }

}
