package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import controller.Data;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class DashboardController implements javafx.fxml.Initializable {
	   

	
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
    private TableView<Data> table;

    @FXML
    private TableColumn<Data, String> username;

    @FXML
    private TableColumn<Data, String> password;

    @FXML
    private TableColumn<Data, String> website;

    @FXML
    private JFXButton btn;

    DbConnection db;
    public ObservableList<Data> data;
    
    @FXML
    void onClick(ActionEvent event) {

    	Connection con=db.connect();
    	data=FXCollections.observableArrayList();
    	try {
    		ResultSet resultSet=con.createStatement().executeQuery("SELECT * FROM passwords");
    		while(resultSet.next()){
    			data.add(new Data(resultSet.getString(2), resultSet.getString(3),resultSet.getString(4)));
    		}
    		
    	} catch (SQLException e1) {
    		// TODO Auto-generated catch block

    		System.out.println(e1);
    	}
    	username.setCellValueFactory(new PropertyValueFactory<>("name"));
    	password.setCellValueFactory(new PropertyValueFactory<>("pass"));
    	website.setCellValueFactory(new PropertyValueFactory<>("website"));
    	table.setItems(data);
    	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		db=new DbConnection();
		
		try {
			VBox box = FXMLLoader.load(getClass().getResource("/ui/Drawer.fxml"));
			drawer.setSidePane(box);
			
			for(Node node: box.getChildren()){
				if(node.getId()!=null){
					node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e)->{
						
						switch(node.getId()){
						
						case "logout":
							Parent home_page_parent;
							try {
								home_page_parent = FXMLLoader.load(getClass().getResource("/ui/Login.fxml"));
							 
				            Scene home_page_scene = new Scene(home_page_parent);
				            Stage app_stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
				            app_stage.hide(); //optional
				            app_stage.sizeToScene();
				            app_stage.setScene(home_page_scene);
				            app_stage.show(); 
							}catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						case "edtprofile":
						System.out.println("hello I am Profile");
						break;
						case "mngpassword":
						System.out.println("manage password");
						
						break;
						
						}
						
					});	
					
				}
				
				
			}
			
			
			HamburgerBackArrowBasicTransition burgerTask2 = new HamburgerBackArrowBasicTransition(hamburger);
			burgerTask2.setRate(-1);
			hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
				
				burgerTask2.setRate(burgerTask2.getRate() * -1);
				burgerTask2.play();
				if(drawer.isShown()){
					drawer.close();
				}
				else{
					drawer.open();
				}
			});
			
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
