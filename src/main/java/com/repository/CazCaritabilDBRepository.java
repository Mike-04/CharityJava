package com.repository;

import com.domain.CazCaritabil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class CazCaritabilDBRepository implements CazCaritabilIRepository {

    private JdbcUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public CazCaritabilDBRepository(JdbcUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void add(CazCaritabil entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("INSERT INTO CazCaritabil VALUES (?,?,?)")) {
            preStmt.setString(1, entity.getId().toString());
            preStmt.setString(2, entity.getNume());
            preStmt.setDouble(3, entity.getSumaAdunata());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void remove(UUID id) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM CazCaritabil WHERE id=?")) {
            preStmt.setString(1, id.toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void update(CazCaritabil entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("UPDATE CazCaritabil SET nume=?, sumaAdunata=? WHERE id=?")) {
            preStmt.setString(1, entity.getNume());
            preStmt.setDouble(2, entity.getSumaAdunata());
            preStmt.setString(3, entity.getId().toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public CazCaritabil find(UUID uuid) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM CazCaritabil WHERE id=?")) {
            preStmt.setString(1, uuid.toString());
            try (var result = preStmt.executeQuery()) {
                if (result.next()) {
                    String nume = result.getString("nume");
                    double sumaAdunata = result.getDouble("sumaAdunata");
                    CazCaritabil cazCaritabil = new CazCaritabil(nume, sumaAdunata);
                    cazCaritabil.setId(uuid);
                    return cazCaritabil;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Iterable<CazCaritabil> getAll() {
        ArrayList<CazCaritabil> cazuriCaritabile = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("SELECT * FROM CazCaritabil")) {
            try (var result = preStmt.executeQuery()) {
                while (result.next()) {
                    UUID id = UUID.fromString(result.getString("id"));
                    String nume = result.getString("nume");
                    double sumaAdunata = result.getDouble("sumaAdunata");
                    CazCaritabil cazCaritabil = new CazCaritabil(nume, sumaAdunata);
                    cazCaritabil.setId(id);
                    cazuriCaritabile.add(cazCaritabil);
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return cazuriCaritabile;
    }
}