module co.edu.uniquindio.marketplace.marketplaceapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.finalprojectfx.finalprojectapp to javafx.fxml;
    exports co.edu.uniquindio.finalprojectfx.finalprojectapp;
}