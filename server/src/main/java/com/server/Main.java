package com.server;

import com.repo.*;
import com.service.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        try{
        Properties props=new Properties();
        try {
            props.load(new FileReader("db.config"));
            System.out.printf("Properties: %s\n", props);
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }
        JdbcUtils jdbcUtils = new JdbcUtils(props);

        UserIRepository userDBRepository = new UserDBRepository(jdbcUtils);
        UserService userService = new UserService(userDBRepository);
        DonatieIRepository donatieDBRepository = new DonatieDBRepository(jdbcUtils);
        DonatieService donatieService = new DonatieService(donatieDBRepository);
        DonatorIRepository donatorDBRepository = new DonatorDBRepository(jdbcUtils);
        DonatorService donatorService = new DonatorService(donatorDBRepository);
        CazCaritabilIRepository cazCaritabilDBRepository = new CazCaritabilDBRepository(jdbcUtils);
        CazCaritabilService cazCaritabilService = new CazCaritabilService(cazCaritabilDBRepository);
        Service service = new Service(userService, cazCaritabilService, donatorService, donatieService);

        // Initialize the server
        int port = 5555;
        String host = "127.0.0.1";

        Server server = new Server(host, port, new ServiceImpl(service));
        server.start();
        System.out.println("Server started on " + host + ":" + port);
        System.out.println("Press Ctrl+C to stop the server...");
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}