package com.group5.navana3s_workshop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static com.group5.navana3s_workshop.HelloApplication.stage;
import static com.group5.navana3s_workshop.User.userList;

public class loginController
{
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> userComboBox;
    @FXML
    private CheckBox showPass;
    @FXML
    private PasswordField passLogIn;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private Label loginInfo;
    @FXML
    private Label createInfo;
    @FXML
    private TextField userField;

    @FXML
    public void initialize() {
        userComboBox.getItems().addAll("Customer", "Customer Service Advisor", "Accounts Officer", "Customer Support Executive", "Technician", "Spare Parts Manager", "Workshop Manager", "Sales Executive");
    }

    @FXML
    public void forgetPassword(ActionEvent actionEvent) {
        loginInfo.setText("Try to remember your password!");
    }

    @FXML
    public void createAccount(ActionEvent actionEvent) {
        if (userField.getText().isEmpty() || password.getText().isEmpty()){
            createInfo.setText("Please Fill all the fields.");
            return;
        }
        if (!password.getText().equals(confirmPassword.getText())){
            createInfo.setText("Password doesn't match! Enter correct password.");
            return;
        }
        for (User u: userList){
            if (u.getUserName().equals(userField.getText())){
                createInfo.setText("This user already exists!");
                return;
            }
        }

        User user = new User(
                userField.getText(),
                password.getText()
        );

        userList.add(user);
        userComboBox.getItems().add(userField.getText());
        createInfo.setText("New account created successfully!");
    }

    @FXML
    public void Login(ActionEvent actionEvent) throws IOException {
        if ((userComboBox.getValue() == null || (passLogIn.getText().isEmpty()))){
            loginInfo.setText("Please Fill all the fields.");
            return;
        }
//        for (User u: userList){
//            if (u.getUserName().equals(userComboBox.getValue()) && u.getPassword().equals(passLogIn.getText())){
//                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UserDashboard.fxml"));
//                Scene scene = new Scene(fxmlLoader.load());
//
//                Stage stage = (Stage) loginInfo.getScene().getWindow();
//                stage.setScene(scene);
//                return;
//            }
//        }

        if ((userComboBox.getValue().equals("Customer")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/Customer.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Customer Dashboard");
            stage.setScene(scene);

        } else if ((userComboBox.getValue().equals("Customer Service Advisor")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Customer Service Advisor Dashboard");
            stage.setScene(scene);
        } else if ((userComboBox.getValue().equals("Accounts Officer")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Accounts Officer Dashboard");
            stage.setScene(scene);
        } else if ((userComboBox.getValue().equals("Customer Support Executive")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Customer Support Executive Dashboard");
            stage.setScene(scene);
        } else if ((userComboBox.getValue().equals("Technician")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Tasfia/user5.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Technician Dashboard");
            stage.setScene(scene);
        } else if ((userComboBox.getValue().equals("Spare Parts Manager")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Spare Parts Manager Dashboard");
            stage.setScene(scene);
        } else if ((userComboBox.getValue().equals("Workshop Manager")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Karima/manager_dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Workshop Manager Dashboard");
            stage.setScene(scene);
        } else if ((userComboBox.getValue().equals("Sales Executive")) && (passLogIn.getText().equals("12345"))) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/group5/navana3s_workshop/Shanjana/csa.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = null;
            stage = (Stage) loginInfo.getScene().getWindow();
            stage.setTitle("Sales Executive Dashboard");
            stage.setScene(scene);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Invalid credentials");
            alert.setContentText("Please check your ID and password.");
            alert.showAndWait();
        }
    }

    @FXML
    public void showPassword(ActionEvent actionEvent) {
        if (showPass.isSelected()){
            if (passLogIn.getText().isEmpty()){
                loginInfo.setText("Enter Password");
                return;
            }
            loginInfo.setText(passLogIn.getText());
        } else {
            loginInfo.setText("");
        }
    }
}