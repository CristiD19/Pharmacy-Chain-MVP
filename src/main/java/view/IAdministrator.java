package view;

import model.Rol;

import java.awt.event.ActionListener;

public interface IAdministrator {
    void btnCreareUtilizatorListener(ActionListener actionListener);

    void btnCitireUtilizatorListener(ActionListener actionListener);

    void btnStergeUtilizatorListener(ActionListener actionListener);

    void btnActualizareUtilizatorListener(ActionListener actionListener);

    void btnListaUtilizatoriListener(ActionListener actionListener);

    int getFarmacieIdInput();

    int getIdUtilizatorInput();

    String getContUtilizatorInput();

    String getParolaUtilizatorInput();

    Rol getRolUtilizatorInput();

    String getNumeUtilizatorInput();

    void setUtilizatorTabelText(Object t, int row, int col);

    public int getIdFromTable();
}
