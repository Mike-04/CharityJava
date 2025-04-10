package com.repository;

import com.domain.Donator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DonatorDBRepository implements DonatorIRepository {

    private JdbcUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public DonatorDBRepository(JdbcUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void add(Donator entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("INSERT INTO Donator VALUES (?,?,?,?)")) {
            preStmt.setString(1, entity.getId().toString());
            preStmt.setString(2, entity.getNume());
            preStmt.setString(3, entity.getAdresa());
            preStmt.setString(4, entity.getNumarTelefon());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void remove(UUID id) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM Donator WHERE id=?")) {
            preStmt.setString(1, id.toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    public void remove(Donator entity) {
        remove(entity.getId());
    }

    @Override
    public void update(Donator entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("UPDATE Donator SET nume=?, adresa=?, numarTelefon=? WHERE id=?")) {
            preStmt.setString(1, entity.getNume());
            preStmt.setString(2, entity.getAdresa());
            preStmt.setString(3, entity.getNumarTelefon());
            preStmt.setString(4, entity.getId().toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public Donator find(UUID uuid) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM Donator WHERE id=?")) {
            preStmt.setString(1, uuid.toString());
            try (var result = preStmt.executeQuery()) {
                if (result.next()) {
                    String nume = result.getString("nume");
                    String adresa = result.getString("adresa");
                    String numarTelefon = result.getString("numarTelefon");
                    Donator donator = new Donator(nume, adresa, numarTelefon);
                    donator.setId(uuid);
                    return donator;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Iterable<Donator> getAll() {
        ArrayList<Donator> donators = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM Donator")) {
            try (var result = preStmt.executeQuery()) {
                while (result.next()) {
                    UUID id = UUID.fromString(result.getString("id"));
                    String nume = result.getString("nume");
                    String adresa = result.getString("adresa");
                    String numarTelefon = result.getString("numarTelefon");
                    Donator donator = new Donator(nume, adresa, numarTelefon);
                    donator.setId(id);
                    donators.add(donator);
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return donators;
    }

    @Override
    public List<Donator> findByName(String name) {
    List<Donator> donators = new ArrayList<>();
    Connection con = dbUtils.getConnection();
    try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM Donator WHERE nume LIKE ?")) {
        preStmt.setString(1, "%" + name + "%");
        try (var result = preStmt.executeQuery()) {
            while (result.next()) {
                UUID id = UUID.fromString(result.getString("id"));
                String donatorNume = result.getString("nume");
                String adresa = result.getString("adresa");
                String numarTelefon = result.getString("numarTelefon");
                Donator donator = new Donator(donatorNume, adresa, numarTelefon);
                donator.setId(id);
                donators.add(donator);
            }
        }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return donators;
    }
}