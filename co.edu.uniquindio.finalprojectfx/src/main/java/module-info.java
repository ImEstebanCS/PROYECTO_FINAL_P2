module co.edu.uniquindio.finalprojectfx.finalprojectapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.finalprojectfx.finalprojectapp to javafx.fxml;
    exports co.edu.uniquindio.finalprojectfx.finalprojectapp;
}