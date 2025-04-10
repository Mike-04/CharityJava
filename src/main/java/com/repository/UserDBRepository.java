package com.repository;

import com.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class UserDBRepository implements UserIRepository {

    private JdbcUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public UserDBRepository(JdbcUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void add(User entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("INSERT INTO User VALUES (?,?,?)")) {
            preStmt.setString(1, entity.getId().toString());
            preStmt.setString(2, entity.getUsername());
            preStmt.setString(3, entity.getPasswordHash());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void remove(UUID id) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM User WHERE id=?")) {
            preStmt.setString(1, id.toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void update(User entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("UPDATE User SET username=?, passwordhash=? WHERE id=?")) {
            preStmt.setString(1, entity.getUsername());
            preStmt.setString(2, entity.getPasswordHash());
            preStmt.setString(3, entity.getId().toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public User find(UUID uuid) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM User WHERE id=?")) {
            preStmt.setString(1, uuid.toString());
            try (var result = preStmt.executeQuery()) {
                if (result.next()) {
                    String username = result.getString("username");
                    String passwordhash = result.getString("passwordhash");
                    User user = new User(username, passwordhash);
                    user.setId(uuid);
                    return user;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Iterable<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM User")) {
            try (var result = preStmt.executeQuery()) {
                while (result.next()) {
                    UUID id = UUID.fromString(result.getString("id"));
                    String username = result.getString("username");
                    String passwordhash = result.getString("passwordhash");
                    User user = new User(username, passwordhash);
                    user.setId(id);
                    users.add(user);
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM User WHERE username=?")) {
            preStmt.setString(1, username);
            try (var result = preStmt.executeQuery()) {
                if (result.next()) {
                    UUID id = UUID.fromString(result.getString("id"));
                    String passwordhash = result.getString("passwordhash");
                    User user = new User(username, passwordhash);
                    user.setId(id);
                    return user;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }
}