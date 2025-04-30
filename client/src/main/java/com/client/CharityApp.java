package com.client;


import com.network.client.ServiceObjectProxy;
import com.service.*;
import com.repo.*;
import com.service.CazCaritabilService;
import com.service.DonatieService;
import com.service.DonatorService;
import com.service.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class CharityApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var server = new ServiceObjectProxy("127.0.0.1", 5555);

        com.client.LoginController controller = new com.client.LoginController();
        controller.setService(server);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Scene scene = new Scene(loader.load());
        controller = loader.getController();
        controller.setService(server);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }

//    public static void main(String[] args) {
//        Properties props=new Properties();
//        try {
//            props.load(new FileReader("db.config"));
//            System.out.printf("Properties: %s\n", props);
//        } catch (IOException e) {
//            System.out.println("Cannot find bd.config "+e);
//        }
//        JdbcUtils jdbcUtils = new JdbcUtils(props);
//
//        System.out.println(jdbcUtils.getConnection());




//        UserDBRepository userDBRepository = new UserDBRepository(jdbcUtils);
//        Iterable<User> users = userDBRepository.getAll();
//        //print all users and delete them
//        for(User user: users){
//            System.out.println(user);
//            userDBRepository.remove(user.getId());
//        }
//        userDBRepository.add(new User("user1", "pass1"));
//        userDBRepository.add(new User("user2", "pass2"));
//        userDBRepository.add(new User("user3", "pass3"));
//        users = userDBRepository.getAll();
//        //print all users and delete them
//        for(User user: users){
//            System.out.println(user);
//            userDBRepository.remove(user.getId());
//        }
//
//
//        DonatorDBRepository donatorDBRepository = new DonatorDBRepository(jdbcUtils);
//        Iterable<Donator> donators = donatorDBRepository.getAll();
//        //print all donators and delete them
//        for(Donator donator: donators){
//            System.out.println(donator);
//            donatorDBRepository.remove(donator);
//        }
//        donatorDBRepository.add(new Donator("donator1", "adresa1", "numarTelefon1"));
//        donatorDBRepository.add(new Donator("donator2", "adresa2", "numarTelefon2"));
//        donatorDBRepository.add(new Donator("donator3", "adresa3", "numarTelefon3"));
//
//        CazCaritabilDBRepository cazCaritabilDBRepository = new CazCaritabilDBRepository(jdbcUtils);
//        Iterable<CazCaritabil> cazuriCaritabile = cazCaritabilDBRepository.getAll();
//        //print all cazuriCaritabile and delete them
//        for(CazCaritabil cazCaritabil: cazuriCaritabile){
//            System.out.println(cazCaritabil);
//            cazCaritabilDBRepository.remove(cazCaritabil.getId());
//        }
//        cazCaritabilDBRepository.add(new CazCaritabil("cazCaritabil1", 100));
//        cazCaritabilDBRepository.add(new CazCaritabil("cazCaritabil2", 200));
//        cazCaritabilDBRepository.add(new CazCaritabil("cazCaritabil3", 300));
//
//        DonatieDBRepository donatieDBRepository = new DonatieDBRepository(jdbcUtils);
//        Iterable<Donatie> donatii = donatieDBRepository.getAll();
//        //print all donatii and delete them
//        for(Donatie donatie: donatii){
//            System.out.println(donatie);
//            donatieDBRepository.remove(donatie.getId());
//        }
//
//        //get all donators and cazuriCaritabile
//        donators = donatorDBRepository.getAll();
//        cazuriCaritabile = cazCaritabilDBRepository.getAll();
//        //add 3 different donatii
//        Iterator<Donator> donatorIterator = donators.iterator();
//        Iterator<CazCaritabil> cazCaritabilIterator = cazuriCaritabile.iterator();
//
//        Donator donator1 = donatorIterator.next();
//        Donator donator2 = donatorIterator.next();
//        Donator donator3 = donatorIterator.next();
//        CazCaritabil cazCaritabil1 = cazCaritabilIterator.next();
//        CazCaritabil cazCaritabil2 = cazCaritabilIterator.next();
//        CazCaritabil cazCaritabil3 = cazCaritabilIterator.next();
//        donatieDBRepository.add(new Donatie(donator1, cazCaritabil1, 10));
//        donatieDBRepository.add(new Donatie(donator2, cazCaritabil2, 20));
//        donatieDBRepository.add(new Donatie(donator3, cazCaritabil3, 30));
//        donatii = donatieDBRepository.getAll();
//        //print all donatii and delete them
//        for(Donatie donatie: donatii){
//            System.out.println(donatie);
//            donatieDBRepository.remove(donatie.getId());
//        }
//
//
//        cazuriCaritabile = cazCaritabilDBRepository.getAll();
//        //print all cazuriCaritabile and delete them
//        for(CazCaritabil cazCaritabil: cazuriCaritabile){
//            System.out.println(cazCaritabil);
//            cazCaritabilDBRepository.remove(cazCaritabil.getId());
//        }
//
//
//        donators = donatorDBRepository.getAll();
//        //print all donators and delete them
//        for(Donator donator: donators){
//            System.out.println(donator);
//            donatorDBRepository.remove(donator);
//        }
//
//
//
//
//
//
//
//





    }

