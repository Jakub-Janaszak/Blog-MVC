module pl.polsl.lab3_v8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens pl.polsl.lab3_v8 to javafx.fxml;
    opens pl.polsl.lab3_v8.model to javafx.base;  
    opens pl.polsl.lab3_v8.kontroler to javafx.fxml; 
    
    exports pl.polsl.lab3_v8;
    exports pl.polsl.lab3_v8.model;
}
    

