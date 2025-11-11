module com.group5.navana3s_workshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group5.navana3s_workshop to javafx.fxml;
    exports com.group5.navana3s_workshop;
}