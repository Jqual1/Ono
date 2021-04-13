module uno {
    requires javafx.fxml;
    requires javafx.controls;
    exports uno.gui;
    opens uno.gui;
}