package controller;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.InnerShadow;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.AesEncryption;
import util.UserDao;

public class LoginController implements javafx.fxml.Initializable {

	@FXML
    private JFXTextField edtEmail;

    @FXML
    private JFXPasswordField edtPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnSignUp;
   
    DbConnection database;
    
    @FXML
    void validateUser(ActionEvent event) throws IOException {
    		
    	String email= edtEmail.getText();
    	String password= edtPassword.getText();
    	if(password.equals("")){
    		Alert alert = new Alert(AlertType.ERROR);
    	    alert.setTitle("Login Error");
    	    alert.setContentText("Please Enter Password");
    	    alert.showAndWait();
    	    edtPassword.requestFocus();
    	}else

    	if(email.isEmpty()){
    		Alert alert = new Alert(AlertType.ERROR);
    	    alert.setTitle("Login Error");
    	    alert.setContentText("Please Enter Email-id");
    	    alert.showAndWait();
    	    edtEmail.requestFocus();
    	
    	}else {
    		//jdbc code to login user
    		
    		UserDao dao=new UserDao();
			int c=dao.validate_user(email, password);
    		  		if(c==1){    	
						Parent home_page_parent = FXMLLoader.load(getClass().getResource("/ui/Dashboard.fxml"));
			            Scene home_page_scene = new Scene(home_page_parent);
			            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			            app_stage.hide(); //optional
			            app_stage.sizeToScene();
			            app_stage.setScene(home_page_scene);
			            app_stage.show();	
    		  		}    		  		
    	}
    }

    @FXML
    void registerUser(ActionEvent event) throws IOException {
    	
    	Parent home_page_parent = FXMLLoader.load(getClass().getResource("/ui/SignUp.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.sizeToScene();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
    }
   
	@Override	
	public void initialize(URL location, ResourceBundle resources) {
	database=new DbConnection();
	}	
}