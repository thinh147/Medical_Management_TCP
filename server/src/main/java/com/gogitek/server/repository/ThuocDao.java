/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gogitek.server.repository;

import com.gogitek.server.repository.entity.Thuoc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bmtnt
 */
public class ThuocDao extends DaoConnection{
    public List<Thuoc> getAllByKeyword(String keyword, Long congDungId) {
        StringBuffer builder = new StringBuffer("SELECT * FROM thuoc ");
        builder.append("WHERE 1 = 1 and (");
        builder.append(keyword);
        builder.append(" IS NULL OR ma_thuoc like '%");
        builder.append(keyword);
        builder.append("%' OR ten like '%");
        builder.append(keyword);
        builder.append("%' OR mota like '%");
        builder.append(keyword);
        builder.append("%')");
        builder.append("AND (");
        builder.append(congDungId);
        builder.append(" IS NULL OR cong_dung_id = ");
        builder.append(congDungId);
        builder.append(")");
        String sql = builder.toString();
        List<Thuoc> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setId(rs.getLong("thuoc_id"));
                thuoc.setTenThuoc(rs.getString("ten"));
                thuoc.setMaThuoc(rs.getString("ma_thuoc"));
                thuoc.setDangThuoc(rs.getString("dang_thuoc"));
                thuoc.setGiaThuoc(rs.getDouble("gia_thuoc"));
                thuoc.setCongDungId(rs.getLong("cong_dung_id"));
                list.add(thuoc);
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

    public boolean save(Thuoc thuoc) {
        String sqlInserts = "INSERT INTO thuoc(thuoc_id, ma_thuoc, ten, dang_thuoc, gia_thuoc, cong_dung_id) VALUES(?, ?, ?, ?, ?, ?)";
        sqlInserts += " ON DUPLICATE KEY UPDATE ma_thuoc = VALUES(ma_thuoc), ten = VALUES(ten), dang_thuoc = VALUES(dang_thuoc), gia_thuoc = VALUES(gia_thuoc), cong_dung_id = VALUES(cong_dung_id)";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sqlInserts, Statement.RETURN_GENERATED_KEYS);
            if (thuoc.getId() != null) {
                ps.setLong(1, 0);
            } else {
                ps.setNull(1, Types.NULL);
            }
            ps.setString(2, thuoc.getMaThuoc());
            ps.setString(3, thuoc.getTenThuoc());
            ps.setString(4, thuoc.getDangThuoc());
            ps.setDouble(5, thuoc.getGiaThuoc());
            ps.setLong(6, thuoc.getCongDungId());
            ps.executeUpdate();

            connection.commit();
            return true;
        } catch (Exception e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    return false;
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
        return false;
    }

    public boolean delete(Long id) {
        String sql = "delete from thuoc where id = ?";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
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
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
