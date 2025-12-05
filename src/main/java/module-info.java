module com.group5.navana3s_workshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires itextpdf;



    opens com.group5.navana3s_workshop to javafx.fxml;
    exports com.group5.navana3s_workshop;
    opens com.group5.navana3s_workshop.Shanjana to javafx.fxml;
    exports com.group5.navana3s_workshop.Shanjana;
    opens com.group5.navana3s_workshop.Karima to javafx.fxml;
    exports com.group5.navana3s_workshop.Karima;
    opens com.group5.navana3s_workshop.Karima.modelClass to javafx.base;
    exports com.group5.navana3s_workshop.Karima.modelClass;
    opens com.group5.navana3s_workshop.Tasfia to javafx.fxml;
    exports com.group5.navana3s_workshop.Tasfia;




}