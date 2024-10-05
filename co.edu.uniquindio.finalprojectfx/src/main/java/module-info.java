module co.edu.uniquindio.finalprojectfx.finalprojectapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.compiler;


    opens co.edu.uniquindio.finalprojectfx.finalprojectapp to javafx.fxml;
    exports co.edu.uniquindio.finalprojectfx.finalprojectapp;

    opens co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;
    exports co.edu.uniquindio.finalprojectfx.finalprojectapp.controller;

    opens co.edu.uniquindio.finalprojectfx.finalprojectapp.model;
    exports co.edu.uniquindio.finalprojectfx.finalprojectapp.model;

    opens co.edu.uniquindio.finalprojectfx.finalprojectapp.viewcontroller;
    exports co.edu.uniquindio.finalprojectfx.finalprojectapp.viewcontroller;

}