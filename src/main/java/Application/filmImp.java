package Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class filmImp {
    private static Connection conn = null;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=ashu123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int addDetails(film q) {
        PreparedStatement pstmt = null;
        String query = "insert into film_info values(?,?,?,?,?)";
        int count = 0;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 0);
            pstmt.setString(2, q.getFname());
            pstmt.setInt(3, q.getFyear());
            pstmt.setString(4, q.getFlang());
            pstmt.setInt(5, q.getFrating());

            count = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;

    }

    public int updateDetails(film q, int fId) {
        PreparedStatement pstmt = null;
        String query = "update film_info set fyear =? where fid = ?";
        int count = 0;
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, q.getFyear());
            pstmt.setInt(2, fId);

            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<film> displayDetails() {

        String selectQuery = "select * from film_info where Frating >3";
        List<film> filmList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                film q = new film();
                q.setFid(rs.getInt(1));
                q.setFname(rs.getString(2));
                q.setFyear(rs.getInt(3));
                q.setFlang(rs.getString(4));
                q.setFrating(rs.getInt(5));


                filmList.add(q);
            }
        } catch (SQLException e) {
            System.out.println(e);

        }

        return filmList;
    }

    public List<film> oscarnomination() {

        String selectQuery = "select * from film_info where Frating >=4";
        List<film> filmList = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                film q = new film();
                q.setFid(rs.getInt(1));
                q.setFname(rs.getString(2));
                q.setFyear(rs.getInt(3));
                q.setFlang(rs.getString(4));
                q.setFrating(rs.getInt(5));


                filmList.add(q);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return filmList;
    }
}

