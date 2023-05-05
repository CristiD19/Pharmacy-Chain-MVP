package view;

import model.Rol;

import java.awt.event.ActionListener;

public interface ILogin {
    void btnLoginListener(ActionListener actionListener);

    void btnRegisterListener(ActionListener actionListener);

    String getNume();

    String getPassword();

    String getCont();

    Rol getRol();

    int getIdFarmacie();

}
