module Morpion_FXML.FXML_Morpion {
    requires javafx.controls;
    requires javafx.fxml;

    opens Morpion_FXML.FXML_Morpion to javafx.fxml;
    exports Morpion_FXML.FXML_Morpion;
}