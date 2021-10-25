module products {
    requires javafx.controls;
    requires javafx.fxml;
	requires ormlib;
	requires java.sql;

    opens de.lubowiecki.products to javafx.fxml;
    opens de.lubowiecki.products.model to javafx.base;
    
    exports de.lubowiecki.products;
}
