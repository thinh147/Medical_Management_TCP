/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.server.repository;

import com.gogitek.server.repository.entity.CongDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bmtnt
 */
public class CongDungDao extends DaoConnection {

    public List<CongDung> getAllByKeyword(String keyword) {
        StringBuffer builder = new StringBuffer("SELECT * FROM cong_dung ");
        builder.append("WHERE 1 = 1 and (");
        builder.append(keyword);
        builder.append(" IS NULL OR ma_cong_dung like '%");
        builder.append(keyword);
        builder.append("%' OR ten like '%");
        builder.append(keyword);
        builder.append("%' OR mota like '%");
        builder.append(keyword);
        builder.append("%')");
        String sql = builder.toString();

        List<CongDung> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CongDung congDung = new CongDung();
                congDung.setId(rs.getLong("id"));
                congDung.setMaCongDung(rs.getString("ma_cong_dung"));
                congDung.setTen(rs.getString("ten"));
                congDung.setMota(rs.getString("mota"));
                list.add(congDung);
            }
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
    }

    public boolean save(CongDung congDung) {
        String sqlInserts = "INSERT INTO cong_dung(id, ma_cong_dung, ten, mota) VALUES(?, ?, ?, ?)";
        sqlInserts += " ON DUPLICATE KEY UPDATE ma_cong_dung = VALUES(ma_cong_dung), ten = VALUES(ten), mota = VALUES(mota)";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sqlInserts, Statement.RETURN_GENERATED_KEYS);
            if (congDung.getId() != null) {
                ps.setLong(1, 0);
            } else {
                ps.setNull(1, Types.NULL);
            }
            ps.setString(2, congDung.getMaCongDung());
            ps.setString(3, congDung.getTen());
            ps.setString(4, congDung.getMota());
            ps.executeUpdate();

            connection.commit();
            return true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public void delete(Long id) {
        String sql = "delete from cong_dung where id = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
    }
}
