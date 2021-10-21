module products {
    requires javafx.controls;
    requires javafx.fxml;
	requires ormlib;
	requires java.sql;

    opens de.lubowiecki.products to javafx.fxml;
    
    exports de.lubowiecki.products;
}
