package com.repo;

import com.domain.CazCaritabil;
import com.domain.Donatie;
import com.domain.Donator;
import com.repo.DonatieIRepository;
import com.repo.JdbcUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class DonatieDBRepository implements DonatieIRepository {

    private JdbcUtils dbUtils;
    private static final Logger logger = LogManager.getLogger();

    public DonatieDBRepository(JdbcUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void add(Donatie entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("INSERT INTO Donatie VALUES (?,?,?,?,?)")) {
            preStmt.setString(1, entity.getId().toString());
            preStmt.setString(2, entity.getDonator().getId().toString());
            preStmt.setString(3, entity.getCazCaritabil().getId().toString());
            preStmt.setDouble(4, entity.getSumaDonata());
            preStmt.setString(5, entity.getTimestamp().toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void remove(UUID id) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("DELETE FROM Donatie WHERE id=?")) {
            preStmt.setString(1, id.toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public void update(Donatie entity) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("UPDATE Donatie SET donatorId=?, cazCaritabilId=?, sumaDonata=?, timestamp=? WHERE id=?")) {
            preStmt.setString(1, entity.getDonator().getId().toString());
            preStmt.setString(2, entity.getCazCaritabil().getId().toString());
            preStmt.setDouble(3, entity.getSumaDonata());
            preStmt.setString(4, entity.getTimestamp().toString());
            preStmt.setString(5, entity.getId().toString());
            preStmt.executeUpdate();
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
    }

    @Override
    public Donatie find(UUID uuid) {
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement(
                "SELECT d.id, d.sumaDonata, d.timestamp, " +
                        "don.id as donatorId, don.nume as donatorNume, don.adresa as donatorAdresa, don.numarTelefon as donatorNumarTelefon, " +
                        "caz.id as cazId, caz.nume as cazNume, caz.sumaAdunata as cazSumaAdunata " +
                        "FROM Donatie d " +
                        "JOIN Donator don ON d.donatorId = don.id " +
                        "JOIN CazCaritabil caz ON d.cazCaritabilId = caz.id " +
                        "WHERE d.id=?")) {
            preStmt.setString(1, uuid.toString());
            try (var result = preStmt.executeQuery()) {
                if (result.next()) {
                    Donator donator = new Donator(result.getString("donatorNume"), result.getString("donatorAdresa"), result.getString("donatorNumarTelefon"));
                    donator.setId(UUID.fromString(result.getString("donatorId")));
                    CazCaritabil cazCaritabil = new CazCaritabil(result.getString("cazNume"), result.getDouble("cazSumaAdunata"));
                    cazCaritabil.setId(UUID.fromString(result.getString("cazId")));
                    Donatie donatie = new Donatie(donator, cazCaritabil, result.getDouble("sumaDonata"));
                    donatie.setId(uuid);
                    donatie.setTimestamp(result.getTimestamp("timestamp").toLocalDateTime());
                    return donatie;
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return null;
    }

    @Override
    public Iterable<Donatie> getAll() {
        ArrayList<Donatie> donatii = new ArrayList<>();
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement(
                "SELECT d.id, d.sumaDonata, d.timestamp, " +
                        "don.id as donatorId, don.nume as donatorNume, don.adresa as donatorAdresa, don.numarTelefon as donatorNumarTelefon, " +
                        "caz.id as cazId, caz.nume as cazNume, caz.sumaAdunata as cazSumaAdunata " +
                        "FROM Donatie d " +
                        "JOIN Donator don ON d.donatorId = don.id " +
                        "JOIN CazCaritabil caz ON d.cazCaritabilId = caz.id")) {
            try (var result = preStmt.executeQuery()) {
                while (result.next()) {
                    Donator donator = new Donator(result.getString("donatorNume"), result.getString("donatorAdresa"), result.getString("donatorNumarTelefon"));
                    donator.setId(UUID.fromString(result.getString("donatorId")));
                    CazCaritabil cazCaritabil = new CazCaritabil(result.getString("cazNume"), result.getDouble("cazSumaAdunata"));
                    cazCaritabil.setId(UUID.fromString(result.getString("cazId")));
                    Donatie donatie = new Donatie(donator, cazCaritabil, result.getDouble("sumaDonata"));
                    donatie.setId(UUID.fromString(result.getString("id")));
                    donatii.add(donatie);
                }
            }
        } catch (SQLException ex) {
            logger.error(ex);
            System.err.println("Error DB " + ex);
        }
        return donatii;
    }
}