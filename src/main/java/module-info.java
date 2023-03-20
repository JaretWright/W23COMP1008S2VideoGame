module com.example.w23comp1008s2videogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.w23comp1008s2videogame to javafx.fxml;
    exports com.example.w23comp1008s2videogame;
}