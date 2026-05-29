package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public static void addStudent(Student st) {

        try {

            Connection con = DBConnection.createDBConnection();

            String query = "insert into student values(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, st.id);
            pst.setString(2, st.name);
            pst.setString(3, st.course);
            pst.setString(4, st.city);

            pst.executeUpdate();

            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewStudents() {

        try {

            Connection con = DBConnection.createDBConnection();

            String query = "select * from student";

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Course : " + rs.getString("course"));
                System.out.println("City : " + rs.getString("city"));

                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id) {

        try {

            Connection con = DBConnection.createDBConnection();

            String query = "delete from student where id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            pst.executeUpdate();

            System.out.println("Student Deleted Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateStudent(Student st) {

        try {

            Connection con = DBConnection.createDBConnection();

            String query = "update student set name=?, course=?, city=? where id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, st.name);
            pst.setString(2, st.course);
            pst.setString(3, st.city);
            pst.setInt(4, st.id);

            pst.executeUpdate();

            System.out.println("Student Updated Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void searchStudent(int id) {

        try {

            Connection con = DBConnection.createDBConnection();

            String query = "select * from student where id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Course : " + rs.getString("course"));
                System.out.println("City : " + rs.getString("city"));
            } else {
                System.out.println("No student found with this ID");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}