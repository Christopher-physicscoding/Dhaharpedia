module com.dhaharpedia {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dhaharpedia to javafx.fxml;
    exports com.dhaharpedia;
}
