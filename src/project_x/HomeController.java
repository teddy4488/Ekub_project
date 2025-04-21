
package project_x;

import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.sql.*;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;


public class HomeController implements Initializable{

    @FXML
    private Button homeButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button listButton;
    @FXML
    private Button lotteryButton;
    @FXML
    private Button aboutUsButton;
    @FXML
    private Pane homePane;
    @FXML
    private Pane registerPane;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField woredaTF;
    @FXML
    private TextField cityTF;
    @FXML
    private TextField regionTF;
    @FXML
    private TextField houseNumberTF;
    @FXML
    private TextField phoneNumberTF;
    @FXML
    private ChoiceBox<String> genderCB;
    @FXML
    private Button submitButton;
    @FXML
    private Pane listPane;
    @FXML
    private Pane lotteryPane;
    @FXML
    private Pane aboutusPane;
    @FXML
    private Label registerLabel;
    @FXML
    private TableView<TableViewDemo> table;
    @FXML
    private TableColumn<TableViewDemo, String> firstName;
    @FXML
    private TableColumn<TableViewDemo, String> lastName;
    @FXML
    private TableColumn<TableViewDemo, String> phoneNumber;
    @FXML
    private TableColumn<TableViewDemo, String> gender;
    @FXML
    private TableColumn<TableViewDemo, String> region;
    @FXML
    private TableColumn<TableViewDemo, String> city;
    @FXML
    private TableColumn<TableViewDemo, String> woreda;
    @FXML
    private TableColumn<TableViewDemo, String> houseNumber;
    ObservableList<TableViewDemo> listview=FXCollections.observableArrayList();
    ObservableList<TableViewDemo> listview1=FXCollections.observableArrayList(); 
   @FXML
    private TableColumn<TableViewDemo, Integer> id;
    @FXML
    private Button randButton;
    private Pane adminPane;
    @FXML
    private TextField searchTF;
    @FXML
    private Label lotteryTF;
    @FXML
    private Label lotteryTF3;
    @FXML
    private Label lotteryTF1;
    @FXML
    private Label lotteryTF2;
    @FXML
    private Label congratulationTF;
    @FXML
    private Label lotteryTF4;
    @FXML
    private Label lotteryTF5;
    @FXML
    private Label lotteryTF6;
    @FXML
    private Label lotteryTF7;
    @FXML
    private TableView<TableViewDemo> table1;
    @FXML
    private TableColumn<TableViewDemo, Integer> id1;
    @FXML
    private TableColumn<TableViewDemo, String> firstName1;
    @FXML
    private TableColumn<TableViewDemo, String>  lastName1;
    @FXML
    private TableColumn<TableViewDemo, String>  gender1;
    @FXML
    private TableColumn<TableViewDemo, String>  phoneNumber1;
    @FXML
    private TableColumn<TableViewDemo, String>  region1;
    @FXML
    private TableColumn<TableViewDemo, String>  city1;
    @FXML
    private TableColumn<TableViewDemo, String>  woreda1;
    @FXML
    private TableColumn<TableViewDemo, String>  houseNumber1;
    @FXML
    private Pane congratulationPane;
    @FXML
    private Pane tableLotteryPane;

 
        
    
    
   @FXML
    private void toHome(ActionEvent event) {
         registerLabel.setText("");
         homePane.setVisible(true);
        registerPane.setVisible(false);
        listPane.setVisible(false);
        lotteryPane.setVisible(false);
        aboutusPane.setVisible(false);
    //    adminPane.setVisible(false);
    }


    @FXML
    private void toRegister(ActionEvent event) {
         registerLabel.setText("");
         homePane.setVisible(false);
        registerPane.setVisible(true);
        listPane.setVisible(false);
        lotteryPane.setVisible(false);
        aboutusPane.setVisible(false);
        //adminPane.setVisible(false);
    }

    @FXML
    private void toList(ActionEvent event) {
         registerLabel.setText("");
         homePane.setVisible(false);
        registerPane.setVisible(false);
        listPane.setVisible(true);
        lotteryPane.setVisible(false);
        aboutusPane.setVisible(false);
//        adminPane.setVisible(false);
    
    }

    @FXML
    private void toLottery(ActionEvent event) {
         registerLabel.setText("");
         homePane.setVisible(false);
        registerPane.setVisible(false);
        listPane.setVisible(false);
        lotteryPane.setVisible(true);
        aboutusPane.setVisible(false);
//        adminPane.setVisible(false);
        tableLotteryPane.setVisible(true);
       congratulationPane.setVisible(false);
         try {
          table1.getItems().clear();;
            firstName1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            gender1.setCellValueFactory(new PropertyValueFactory<>("gender"));
            phoneNumber1.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            region1.setCellValueFactory(new PropertyValueFactory<>("region"));
            city1.setCellValueFactory(new PropertyValueFactory<>("city"));
            woreda1.setCellValueFactory(new PropertyValueFactory<>("woreda"));
            houseNumber1.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
            id1.setCellValueFactory(new PropertyValueFactory<>("id"));
            DatabaseConectivity dbc=new DatabaseConectivity();
            Connection conn=dbc.databaseConnectivity();
            String query="SELECT * FROM USERS1";
            
            PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
            
                listview1.add(new TableViewDemo(
                  rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString( "Gender"), 
                        rs.getString("phoneNumber"),
                        rs.getString( "Region") ,
                        rs.getString( "city"),
                        rs.getString( "woreda"),
                        rs.getString("houseNumber")));
              
                
            }
            table1.setItems(listview1);  
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @FXML
    private void about(ActionEvent event) {
         registerLabel.setText("");
         homePane.setVisible(false);
        registerPane.setVisible(false);
        listPane.setVisible(false);
        lotteryPane.setVisible(false);
        aboutusPane.setVisible(true);
       // adminPane.setVisible(false);
    }
    private void toAdmin(ActionEvent event) {
         registerLabel.setText("");
        homePane.setVisible(false);
        registerPane.setVisible(false);
        listPane.setVisible(false);
        lotteryPane.setVisible(false);
        aboutusPane.setVisible(false);
      //  adminPane.setVisible(true);
    }
   
    @FXML
  public void databaseConnectivity(ActionEvent event) throws Exception{
      if(firstNameTF.getText().isEmpty() || lastNameTF.getText().isEmpty()
      || genderCB.getValue().isEmpty() || phoneNumberTF.getText().isEmpty() || regionTF.getText().isEmpty()
      || cityTF.getText().isEmpty() || woredaTF.getText().isEmpty() || houseNumberTF.getText().isEmpty()){
        registerLabel.setText("");
          registerLabel.setText("Fill All Fields Correctly");
        }
      else{
        DatabaseConectivity db = new DatabaseConectivity();
        Connection conn = db.databaseConnectivity();
        String query = "insert into users (firstName,lastName,Gender,phoneNumber,Region,city,woreda,houseNumber) values(?,?,?,?,?,?,?,?)";
         String query1= "insert into users1 (firstName,lastName,Gender,phoneNumber,Region,city,woreda,houseNumber) values(?,?,?,?,?,?,?,?)";
         PreparedStatement pst = conn.prepareStatement(query);
         PreparedStatement pst1=conn.prepareStatement(query1);
          pst.setString(1, firstNameTF.getText());
          pst.setString(2, lastNameTF.getText());
          pst.setString(3, genderCB.getValue());
          pst.setString(4, phoneNumberTF.getText());
          pst.setString(5, regionTF.getText());
          pst.setString(6, cityTF.getText());
          pst.setString(7, woredaTF.getText());
          pst.setString(8, houseNumberTF.getText());
        int row = pst.executeUpdate();
        System.out.println(row+" row/s is affected");
           
        
          pst1.setString(1, firstNameTF.getText());
          pst1.setString(2, lastNameTF.getText());
          pst1.setString(3, genderCB.getValue());
          pst1.setString(4, phoneNumberTF.getText());
          pst1.setString(5, regionTF.getText());
          pst1.setString(6, cityTF.getText());
          pst1.setString(7, woredaTF.getText());
          pst1.setString(8, houseNumberTF.getText());
        int row1 = pst1.executeUpdate();
        System.out.println(row1+" row/s is affected");
     
        registerLabel.setText("you are successfully registered");
          UIManager.put("OptionPane.minimumSize",new Dimension(750,450));
          UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial",Font.ITALIC,50)));
       
          
         JOptionPane.showMessageDialog(null, "User Added Successfully");
         toList(event);
        firstNameTF.setText("");
        lastNameTF.setText("");
        cityTF.setText("");
        phoneNumberTF.setText("");
        houseNumberTF.setText("");
        woredaTF.setText("");
        regionTF.setText("");
         try {
          table.getItems().clear();;
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            region.setCellValueFactory(new PropertyValueFactory<>("region"));
            city.setCellValueFactory(new PropertyValueFactory<>("city"));
            woreda.setCellValueFactory(new PropertyValueFactory<>("woreda"));
            houseNumber.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            DatabaseConectivity dbc=new DatabaseConectivity();
            Connection connn=dbc.databaseConnectivity();
            String query2="SELECT * FROM USERS";
            
            PreparedStatement pst2=connn.prepareStatement(query2);
            ResultSet rs=pst2.executeQuery();
            while(rs.next()){
                listview.add(new TableViewDemo(
                  rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString( "Gender"), 
                        rs.getString("phoneNumber"),
                        rs.getString( "Region") ,
                        rs.getString( "city"),
                        rs.getString( "woreda"),
                        rs.getString("houseNumber")));
              
                
            }
            table.setItems(listview);
            FilteredList<TableViewDemo> filteredData=new FilteredList<>(listview, b->true);
           searchTF.textProperty().addListener((observable,oldValue,newValue)->{
              filteredData.setPredicate(TableViewDemo->{
                if(newValue==null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter=newValue.toLowerCase();
                if(TableViewDemo.getFirstName().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                    return true;
                
                else if(TableViewDemo.getLastName().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                         
                    return true;
                else
                  return false;
                
           });
               SortedList<TableViewDemo> sortedData =new SortedList<>(filteredData);
               sortedData.comparatorProperty().bind(table.comparatorProperty());
               table.setItems(sortedData);
            
            
            
            });
   
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
          
            firstName1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            gender1.setCellValueFactory(new PropertyValueFactory<>("gender"));
            phoneNumber1.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            region1.setCellValueFactory(new PropertyValueFactory<>("region"));
            city1.setCellValueFactory(new PropertyValueFactory<>("city"));
            woreda1.setCellValueFactory(new PropertyValueFactory<>("woreda"));
            houseNumber1.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
            id1.setCellValueFactory(new PropertyValueFactory<>("id"));
            DatabaseConectivity dbc=new DatabaseConectivity();
            Connection con=dbc.databaseConnectivity();
            String query2="SELECT * FROM USERS1";
            
            PreparedStatement pst3=con.prepareStatement(query2);
            ResultSet rs=pst3.executeQuery();
            while(rs.next()){
            
                listview1.add(new TableViewDemo(
                  rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString( "Gender"), 
                        rs.getString("phoneNumber"),
                        rs.getString( "Region") ,
                        rs.getString( "city"),
                        rs.getString( "woreda"),
                        rs.getString("houseNumber")));
              
                
            }
            table1.setItems(listview1);  
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }       
          /* Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
       Stage  stage=(Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene=new Scene(root);
         stage.setScene(scene);
         stage.show();
        */
          
      }
      
  }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
        
      
        try {
          
            firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
            phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            region.setCellValueFactory(new PropertyValueFactory<>("region"));
            city.setCellValueFactory(new PropertyValueFactory<>("city"));
            woreda.setCellValueFactory(new PropertyValueFactory<>("woreda"));
            houseNumber.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            DatabaseConectivity dbc=new DatabaseConectivity();
            Connection conn=dbc.databaseConnectivity();
            String query="SELECT * FROM USERS";
            
            PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                listview.add(new TableViewDemo(
                  rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString( "Gender"), 
                        rs.getString("phoneNumber"),
                        rs.getString( "Region") ,
                        rs.getString( "city"),
                        rs.getString( "woreda"),
                        rs.getString("houseNumber")));
              
                
            }
            table.setItems(listview);
            FilteredList<TableViewDemo> filteredData=new FilteredList<>(listview, b->true);
           searchTF.textProperty().addListener((observable,oldValue,newValue)->{
              filteredData.setPredicate(TableViewDemo->{
                if(newValue==null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter=newValue.toLowerCase();
                if(TableViewDemo.getFirstName().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                    return true;
                
                else if(TableViewDemo.getLastName().toLowerCase().indexOf(lowerCaseFilter)!=-1)
                         
                    return true;
                else
                  return false;
                
           });
               SortedList<TableViewDemo> sortedData =new SortedList<>(filteredData);
               sortedData.comparatorProperty().bind(table.comparatorProperty());
               table.setItems(sortedData);
            
            
            
            });
   
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }       genderCB.getItems().add("Male");
        genderCB.getItems().add("Female");
        genderCB.setValue("Male");
     try {
          
            firstName1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            lastName1.setCellValueFactory(new PropertyValueFactory<>("lastName"));
            gender1.setCellValueFactory(new PropertyValueFactory<>("gender"));
            phoneNumber1.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            region1.setCellValueFactory(new PropertyValueFactory<>("region"));
            city1.setCellValueFactory(new PropertyValueFactory<>("city"));
            woreda1.setCellValueFactory(new PropertyValueFactory<>("woreda"));
            houseNumber1.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
            id1.setCellValueFactory(new PropertyValueFactory<>("id"));
            DatabaseConectivity dbc=new DatabaseConectivity();
            Connection conn=dbc.databaseConnectivity();
            String query="SELECT * FROM USERS1";
            
            PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
            
                listview1.add(new TableViewDemo(
                  rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString( "Gender"), 
                        rs.getString("phoneNumber"),
                        rs.getString( "Region") ,
                        rs.getString( "city"),
                        rs.getString( "woreda"),
                        rs.getString("houseNumber")));
              
                
            }
            table1.setItems(listview1);  
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }       
    } 

    @FXML
    private void randomNumberGenerator(ActionEvent event) throws Exception {
     DatabaseConectivity dbc=new DatabaseConectivity();
            Connection conn=dbc.databaseConnectivity();
            String lotteryQuery="select * from users1 order by rand() limit 0,1;";
            PreparedStatement pst=conn.prepareStatement(lotteryQuery);
            ResultSet rs=pst.executeQuery();
           
        //    id=rs.getInt("id");
            int id;
            String fname="";
            String lname="";
            String gender="";
            String phoneNumber="";
            while(rs.next()){
                
                    lotteryTF.setText("");
                    congratulationTF.setText("");
//                    lotteryTF1.setText("");
                    lotteryTF2.setText("");
                    lotteryTF3.setText("");
                    lotteryTF4.setText("");
                    lotteryTF5.setText("");
                    lotteryTF6.setText("");
                    id=rs.getInt("id");
                fname=rs.getString("firstName");
                       lname= rs.getString("lastName");
                       gender= rs.getString( "Gender"); 
                       phoneNumber= rs.getString("phoneNumber");
                       lotteryTF4.setText("firstname");
                       lotteryTF5.setText("lastname");
                       lotteryTF6.setText("gender");
                       lotteryTF7.setText("phonenumber");
                       congratulationTF.setText(" Congratulation!");
                       lotteryTF.setText(fname);
                      lotteryTF1.setText(lname);
                       lotteryTF2.setText(gender);
                       lotteryTF3.setText(phoneNumber);
                    
                       
                           System.out.println(id); 
                           System.out.println(rs.getString("firstName"));
                           System.out.println(rs.getString("lastName"));
                           System.out.println(rs.getString("Gender"));
                             String deleteQuery="delete from users1 where id="+id+"";
                           PreparedStatement pst1=conn.prepareStatement(deleteQuery);
                        //   pst1.setInt(1, id);
                         
                           
                          int row= pst1.executeUpdate(deleteQuery);
                          System.out.println(row+" row/s affected");
                         /* System.out.println(rs.getString("phoneNumber"));
                          System.out.println(rs.getString("Region"));
                          System.out.println(rs.getString("city"));
                          System.out.println(rs.getString("woreda"));
                          System.out.println(rs.getString("houseNUmber"));*/
                       
            }
           tableLotteryPane.setVisible(false);
           congratulationPane.setVisible(true);            
            
            
       
      /*  int random=0;
        
            
            String query="select count(id) from user1";
            DatabaseConectivity dbc=new DatabaseConectivity();
            Connection conn=dbc.databaseConnectivity();
              PreparedStatement pst=conn.prepareStatement(query);
              //String deleteQuery="delete from user1 where id=?";
        
              
            ResultSet rs=  pst.executeQuery();
            while(rs.next()){
                 random=rs.getInt("count(id)");
           }
        Random rand=new Random();
      int random1=  rand.nextInt(random+1);  
    //  if()
          String lotteryQuery="SELECT firstName,lastName,Gender,phoneNumber FROM USERS where id="+random1+"" ;
               PreparedStatement pst1=conn.prepareStatement(lotteryQuery);
//pst.setInt(1, random1);
ResultSet rs1=pst1.executeQuery();
String data="";
int id=0;
//while(rs.next()){
while(rs.next()){
   id=rs1.getInt("id");
   
    data=rs1.getString("firstName");
   System.out.println(data);
    //+rs1.getString("lastName")+rs1.getString("Gender")+rs1.getString("Phone Number");
}
Integer.toString(id);
String data1=id+data;



lotteryTF.setText(data1);
    //  System.out.println(random1);
    //  System.out.println(random);  
          // System.out.println(id);
                //System.out.println(data);
                  //   System.out.println(data1);  
     //  pst1.setInt(1, random1);
      //int row= pst1.executeUpdate();
    //  System.out.println(row+" row/s are affected");
      
      
   */
    }


    
 
      
}

