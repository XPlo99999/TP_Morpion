module Morpion_FXML.FXML_Morpion {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens Morpion_FXML.FXML_Morpion to javafx.fxml;
    exports Morpion_FXML.FXML_Morpion;
}