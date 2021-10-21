module products {
    requires javafx.controls;
    requires javafx.fxml;
	requires de.lubowiecki.orm;
	requires java.sql;

    opens de.lubowiecki.products to javafx.fxml;
    exports de.lubowiecki.products;
}
