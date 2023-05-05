package view;

import java.awt.event.ActionListener;

public interface IManager {

    String getPretInput();

    String getNumeMedicamentInput();

    String getProducatorInput();

    Boolean getValabilInput();

    Boolean getDisponibilInput();

    void setClientTableText(Object t, int row, int col);

    int getIdFromTable();

    int getIdFromTableFarmacie();

    public void btnListaMedicamenteListener(ActionListener actionListener);

    public void btnCautareMedicamentListener(ActionListener actionListener);

    public void btnFiltrareMedicamenteListener(ActionListener actionListener);

    void setFarmacieTableText(Object t, int row, int col);
}
