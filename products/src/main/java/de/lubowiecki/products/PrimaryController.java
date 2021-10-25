package de.lubowiecki.products;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import de.lubowiecki.orm.Mapper;
import de.lubowiecki.products.model.Product;
import de.lubowiecki.products.model.ProductMapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {
	
	@FXML // Die Annotation macht dieses Element für FXML-Verfügbar
	private TextField txtName;
	
	@FXML
	private TextField txtPrice;
	
	@FXML
	private CheckBox chAvailable;
	
	@FXML
	private TableView<Product> tblOutput;
	
//	@FXML
//	private TextArea output;
	
	private Mapper<Product> mapper = new ProductMapper();
	
	private Product cur = new Product();
	
    @FXML
    private void save() throws IOException {
        
    	// Leeres Produkt wird mit Formulardaten belegt
    	cur.setName(txtName.getText());
    	cur.setPrice(Double.parseDouble(txtPrice.getText()));
    	cur.setAvailable(chAvailable.isSelected());
    	
    	try {
    		// Das Produkt wir gespeichert
    		mapper.save(cur);
    		
    		// Formular leeren
    		clearForm();
    		
    		// Update für die Ausgabe in der GUI
    		showProducts();
    	}
    	catch(SQLException e) {
    		// TODO: in  GUI ausgeben
    		System.out.println(e.getMessage());
    	}
    }
    
    private void showProducts() {
    	
    	// Ausgabe wird als String zusammengesetzt
    	try {
    		List<Product> list = mapper.find();
    		tblOutput.setItems(FXCollections.observableList(list));
    		
    		// oder so
    		//tblOutput.setItems(FXCollections.observableList(mapper.find()));
    		
//    		StringBuilder sb = new StringBuilder();
//    		
//    		for(Product p : mapper.find()) {
//    			sb.append("Name: ")
//    				.append(p.getName())
//    				.append(", ID: ")
//    				.append(p.getId())
//    				.append(", Price: ")
//    				.append(p.getPrice())
//    				.append(", ")
//    				.append(p.isAvailable() ? "available" : "not available")
//    				.append("\n");
//    		}
//    		
//    		output.setText(sb.toString());
    	}
    	catch(SQLException e) {
    		// TODO: in  GUI ausgeben
    		System.out.println(e.getMessage());
    	}
    }
    
    @FXML
    public void delete() {
    	try {
    		Product p = tblOutput.getSelectionModel().getSelectedItem();
    		mapper.delete(p);
    		showProducts();
    	}
    	catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e.getMessage());
		}
    }
    
    @FXML
    public void edit() {
    	cur = tblOutput.getSelectionModel().getSelectedItem();
    	txtName.setText(cur.getName());
    	txtPrice.setText(cur.getPrice() + "");
    	chAvailable.setSelected(cur.isAvailable());
    }
    
    @FXML
    public void cancel() {
    	clearForm();
    }
    
    private void clearForm() {
    	txtName.clear();
    	txtPrice.clear();
    	chAvailable.setSelected(false);
    	cur = new Product();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showProducts();
	}
}
