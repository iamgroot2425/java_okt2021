package de.lubowiecki.products;

import java.io.IOException;
import java.sql.SQLException;

import de.lubowiecki.orm.Mapper;
import de.lubowiecki.products.model.Product;
import de.lubowiecki.products.model.ProductMapper;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {
	
	@FXML // Die Annotation macht dieses Element für FXML-Verfügbar
	private TextField txtName;
	
	@FXML
	private TextField txtPrice;
	
	@FXML
	private CheckBox chAvailable;
	
	@FXML
	private TextArea output;
	
	private Mapper<Product> mapper = new ProductMapper();
	
    @FXML
    private void save() throws IOException {
        
    	Product p = new Product();
    	p.setName(txtName.getText());
    	p.setPrice(Double.parseDouble(txtPrice.getText()));
    	p.setAvailable(chAvailable.isSelected());
    	
    	try {
    		mapper.save(p);
    		showProducts();
    	}
    	catch(SQLException e) {
    		// TODO: in  GUI ausgeben
    		System.out.println(e.getMessage());
    	}
    }
    
    private void showProducts() {
    	
    	try {
    		StringBuilder sb = new StringBuilder();
    		
    		for(Product p : mapper.find()) {
    			sb.append("Name: ")
    				.append(p.getName())
    				.append(", ID: ")
    				.append(p.getId())
    				.append(", Price: ")
    				.append(p.getPrice())
    				.append(", ")
    				.append(p.isAvailable() ? "available" : "not available")
    				.append("\n");
    		}
    		
    		output.setText(sb.toString());
    	}
    	catch(SQLException e) {
    		// TODO: in  GUI ausgeben
    		System.out.println(e.getMessage());
    	}
    	
    	
    }
}
