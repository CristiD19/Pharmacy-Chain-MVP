package main;

import model.*;
import org.hibernate.Session;
import presenter.PAngajat;
import view.IAngajat;
import view.LoginView;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
         loginView.setVisible(true);
    }
}
