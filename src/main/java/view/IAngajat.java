package view;

import java.awt.event.ActionListener;

public interface IAngajat {

    String getPretInput();

    String getNumeMedicamentInput();

    String getProducatorInput();

    Boolean getValabilInput();

    Boolean getDisponibilInput();

    void setMedicamentTableText(Object t, int row, int col);

    int getIdFromMedicament();

    void setMedicamentInFarmacieTableText(Object t, int row, int col);

    int getIdFromMedicamentInFarmacie();

    void btnAdaugaMedicamentListener(ActionListener actionListener) ;

    void btnAcutalizareMedicamentListener(ActionListener actionListener);

    void btnListaMedicamenteListener(ActionListener actionListener);

    int getStocInput();

   void btnStergeMedicamentListener(ActionListener actionListener);

    void btnCautareMedicamentListener(ActionListener actionListener);

    void btnFiltrareMedicamenteListener(ActionListener actionListener);



}
