package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import util.AesEncryption;

public class SignUPController implements javafx.fxml.Initializable {
	 @FXML
	    private JFXTextField edtEmail;

	    @FXML
	    private JFXTextField edtName;

	    @FXML
	    private JFXPasswordField edtPassword;
	    
	    @FXML
	    private JFXButton btnLogin;

	    @FXML
	    private JFXButton btnRegister;

	    @FXML
	    private JFXPasswordField edtCpassword;
	    
	    DbConnection database;
	    private static final String EMAIL_PATTERN =
	    		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	    
	    @FXML
	    void register_check(ActionEvent event) {
	    	
	    	String name =edtName.getText().trim();
	    	String email = edtEmail.getText().trim();
	    	String password = edtPassword.getText().trim();
	    	String Cpassword= edtCpassword.getText().trim();
	    	if(name.isEmpty() || email.isEmpty() || password.isEmpty() || Cpassword.isEmpty()){
	    		Alert alert = new Alert(AlertType.ERROR);
	    	    alert.setTitle("Error");
	    	    alert.setContentText("Please Enter Details");
	    	    alert.showAndWait();
	    	}
	    	else{
	    		if(password.equals(Cpassword)){
	    			if(email.matches(EMAIL_PATTERN)){
	    		//jdbc code to register user
	    		try {
	    			String encrypted_password=AesEncryption.encrypt(password);	
					Connection connection=database.connect();
					PreparedStatement ps = connection.prepareStatement("INSERT INTO `users` (`name`, `email`, `password`) VALUES(?, ?, ?)");
					
					ps.setString(1, name);
					ps.setString(2,email);
					ps.setString(3,encrypted_password);
					
					if(ps.executeUpdate()==1){
						edtName.setText("");
						edtEmail.setText("");
						edtPassword.setText("");
						edtCpassword.setText("");
						Alert alert = new Alert(AlertType.CONFIRMATION);
			    	    alert.setTitle("REGISTERATION");
			    	    alert.setContentText("You've successfully registered...."); 
			    	    alert.showAndWait();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	  		
	    	}else{
	    		Alert alert = new Alert(AlertType.ERROR);
	    	    alert.setTitle("Error");
	    	    alert.setContentText("Invalid Email....."); 
	    	    alert.showAndWait();
	    	}
	    		}
	    		else{
	    			Alert alert = new Alert(AlertType.ERROR);
		    	    alert.setTitle("Error");
		    	    alert.setContentText("Passwords not same!!!"); 
		    	    alert.showAndWait();
	    		}
	    	}	
	    }
	    
	    @FXML
	    void backToLogin(ActionEvent event) throws IOException {
	    	Parent home_page_parent = FXMLLoader.load(getClass().getResource("/ui/Login.fxml"));
	        Scene home_page_scene = new Scene(home_page_parent);
	        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        app_stage.hide(); //optional
	        app_stage.sizeToScene();
	        app_stage.setScene(home_page_scene);
	        app_stage.show(); 
	   
	    }
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			database=new DbConnection();
		}

}
