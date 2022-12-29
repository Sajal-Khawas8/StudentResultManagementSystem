import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;

/*
    <applet code = "SRMS.class" archive = "mysql-connector.jar" width = 740 height = 720>
    </applet>
*/

public class SRMS extends Applet implements ActionListener {
    Connection connect = null;
    PreparedStatement statement = null;

    Label lbTitle, lbRollNo, lbName, lbMarks, lb1Title, lb1RollNo, lb1Name, lb1Marks, lb2Title, lb2RollNo, lb2Name,
            lb2Marks, lb3Title, lb3RollNo, lb3Name,
            lb3Marks;
    TextField txtName, txtMarks, txt1RollNo, txt1Name, txt1Marks, txt2Name, txt2Marks, txt3Name, txt3Marks;
    Choice cmbRollNo, cmbRollNo1, cmbRollNo2;
    Button btnShow, btnInsert, btnUpdate, btnDelete, btnShow1, btnShow2;

    public void init() {
        setLayout(null);
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Result");

        // Fetch
        Font titleFont = new Font("Serif", Font.BOLD, 18);
        lbTitle = new Label("Check Data from Database");
        lbTitle.setLocation(270, 20);
        lbTitle.setSize(230, 30);
        lbTitle.setFont(titleFont);
        lbRollNo = new Label("Roll No.");
        lbRollNo.setLocation(30, 98);
        lbRollNo.setSize(100, 30);
        lbName = new Label("Name");
        lbName.setLocation(270, 98);
        lbName.setSize(100, 30);
        lbMarks = new Label("Marks");
        lbMarks.setLocation(510, 98);
        lbMarks.setSize(100, 30);
        cmbRollNo = new Choice();
        cmbRollNo.setLocation(130, 100);
        cmbRollNo.setSize(100, 30);
        txtName = new TextField(20);
        txtName.setLocation(370, 100);
        txtName.setSize(100, 30);
        txtMarks = new TextField(2);
        txtMarks.setLocation(610, 100);
        txtMarks.setSize(100, 30);
        btnShow = new Button("Check Result");
        btnShow.setLocation(320, 150);
        btnShow.setSize(100, 30);

        add(lbTitle);
        add(lbRollNo);
        add(cmbRollNo);
        add(lbName);
        add(txtName);
        add(lbMarks);
        add(txtMarks);
        btnShow.addActionListener(this);
        add(btnShow);
        fillcmbRollNo();

        // Insert
        lb1Title = new Label("Insert Data to Database");
        lb1Title.setLocation(270, 200);
        lb1Title.setSize(230, 30);
        lb1Title.setFont(titleFont);
        lb1RollNo = new Label("Roll No.");
        lb1RollNo.setLocation(30, 278);
        lb1RollNo.setSize(100, 30);
        lb1Name = new Label("Name");
        lb1Name.setLocation(270, 278);
        lb1Name.setSize(100, 30);
        lb1Marks = new Label("Marks");
        lb1Marks.setLocation(510, 278);
        lb1Marks.setSize(100, 30);
        txt1RollNo = new TextField(4);
        txt1RollNo.setLocation(130, 280);
        txt1RollNo.setSize(100, 30);
        txt1Name = new TextField(20);
        txt1Name.setLocation(370, 280);
        txt1Name.setSize(100, 30);
        txt1Marks = new TextField(2);
        txt1Marks.setLocation(610, 280);
        txt1Marks.setSize(100, 30);
        btnInsert = new Button("Insert");
        btnInsert.setLocation(335, 330);
        btnInsert.setSize(60, 30);

        add(lb1Title);
        add(lb1RollNo);
        add(txt1RollNo);
        add(lb1Name);
        add(txt1Name);
        add(lb1Marks);
        add(txt1Marks);
        btnInsert.addActionListener(this);
        add(btnInsert);

        // Update
        lb2Title = new Label("Update Data in Database");
        lb2Title.setLocation(270, 380);
        lb2Title.setSize(230, 30);
        lb2Title.setFont(titleFont);
        lb2RollNo = new Label("Roll No.");
        lb2RollNo.setLocation(30, 458);
        lb2RollNo.setSize(100, 30);
        lb2Name = new Label("Name");
        lb2Name.setLocation(270, 458);
        lb2Name.setSize(100, 30);
        lb2Marks = new Label("Marks");
        lb2Marks.setLocation(510, 458);
        lb2Marks.setSize(100, 30);
        cmbRollNo1 = new Choice();
        cmbRollNo1.setLocation(130, 460);
        cmbRollNo1.setSize(100, 30);
        txt2Name = new TextField(20);
        txt2Name.setLocation(370, 460);
        txt2Name.setSize(100, 30);
        txt2Marks = new TextField(2);
        txt2Marks.setLocation(610, 460);
        txt2Marks.setSize(100, 30);
        btnShow1 = new Button("Show");
        btnShow1.setLocation(280, 510);
        btnShow1.setSize(60, 30);
        btnUpdate = new Button("Update");
        btnUpdate.setLocation(390, 510);
        btnUpdate.setSize(60, 30);

        add(lb2Title);
        add(lb2RollNo);
        add(cmbRollNo1);
        add(lb2Name);
        add(txt2Name);
        add(lb2Marks);
        add(txt2Marks);
        btnShow1.addActionListener(this);
        add(btnShow1);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        fillcmbRollNo();

        // Delete
        lb3Title = new Label("Delete Data from Database");
        lb3Title.setLocation(270, 560);
        lb3Title.setSize(230, 30);
        lb3Title.setFont(titleFont);
        lb3RollNo = new Label("Roll No.");
        lb3RollNo.setLocation(30, 638);
        lb3RollNo.setSize(100, 30);
        lb3Name = new Label("Name");
        lb3Name.setLocation(270, 638);
        lb3Name.setSize(100, 30);
        lb3Marks = new Label("Marks");
        lb3Marks.setLocation(510, 638);
        lb3Marks.setSize(100, 30);
        cmbRollNo2 = new Choice();
        cmbRollNo2.setLocation(130, 640);
        cmbRollNo2.setSize(100, 30);
        txt3Name = new TextField(20);
        txt3Name.setLocation(370, 640);
        txt3Name.setSize(100, 30);
        txt3Marks = new TextField(2);
        txt3Marks.setLocation(610, 640);
        txt3Marks.setSize(100, 30);
        btnShow2 = new Button("Show");
        btnShow2.setLocation(280, 690);
        btnShow2.setSize(60, 30);
        btnDelete = new Button("Delete");
        btnDelete.setLocation(390, 690);
        btnDelete.setSize(60, 30);

        add(lb3Title);
        add(lb3RollNo);
        add(cmbRollNo2);
        add(lb3Name);
        add(txt3Name);
        add(lb3Marks);
        add(txt3Marks);
        btnDelete.addActionListener(this);
        add(btnDelete);
        btnShow2.addActionListener(this);
        add(btnShow2);
        fillcmbRollNo();
    }

    public void actionPerformed(ActionEvent ae1) {
        if (ae1.getSource() == btnShow) {
            showData();
        }
        if (ae1.getSource() == btnInsert) {
            doInsert();
        }
        if (ae1.getSource() == btnShow1) {
            showData1();
        }
        if (ae1.getSource() == btnUpdate) {
            doUpdate();
        }
        if (ae1.getSource() == btnShow2) {
            showData2();
        }
        if (ae1.getSource() == btnDelete) {
            doDelete();
        }
    }

    void doInsert() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                    "root");
            String sql = "INSERT INTO result(RollNo, Name, Marks) values (?, ?, ?)";
            statement = connect.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(txt1RollNo.getText()));
            statement.setString(2, txt1Name.getText());
            statement.setInt(3, Integer.parseInt(txt1Marks.getText()));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
            txt1RollNo.setText("");
            txt1Name.setText("");
            txt1Marks.setText("");
        } catch (Exception e) {
            System.out.println("Some error occurred in insertion: " + e.getMessage());
        }
    }

    void doUpdate() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                    "root");
            String sql = "UPDATE result set Name=?, Marks=? where RollNo=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, txt2Name.getText());
            statement.setInt(2, Integer.parseInt(txt2Marks.getText()));
            statement.setInt(3, Integer.parseInt(cmbRollNo1.getSelectedItem()));
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Updated Successfully");
            txt2Name.setText("");
            txt2Marks.setText("");
        } catch (Exception e) {
            System.out.println("Some error occurred in updation: " + e.getMessage());
        }
    }

    void doDelete() {
        try {
            int yesno = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION);
            if (yesno == JOptionPane.YES_OPTION) {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connect = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance",
                        "root", "root");
                String sql = "DELETE from result where RollNo=?";
                statement = connect.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt(cmbRollNo1.getSelectedItem()));
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
                txt2Name.setText("");
                txt2Marks.setText("");
            }
        } catch (Exception e) {
            System.out.println("Some error occurred in deletion: " + e.getMessage());
        }
    }

    void fillcmbRollNo() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                    "root");
            String sql = "SELECT RollNo from result";
            statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cmbRollNo.add(rs.getString("RollNo"));
                cmbRollNo1.add(rs.getString("RollNo"));
                cmbRollNo2.add(rs.getString("RollNo"));
            }

        } catch (Exception e) {
            System.out.println("Some error occurred in drop-down list: " + e.getMessage());
        }
    }

    void showData() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                    "root");
            String sql = "SELECT Name, Marks FROM result where RollNo=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, cmbRollNo.getSelectedItem());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                txtName.setText(rs.getString("Name"));
                txtMarks.setText(rs.getString("Marks"));
            }
        } catch (Exception e) {
            System.out.println("Some error occurred in show: " + e.getMessage());
        }
    }

    void showData1() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                    "root");
            String sql = "SELECT Name, Marks FROM result where RollNo=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, cmbRollNo1.getSelectedItem());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                txt2Name.setText(rs.getString("Name"));
                txt2Marks.setText(rs.getString("Marks"));
            }
        } catch (Exception e) {
            System.out.println("Some error occurred in show1: " + e.getMessage());
        }
    }

    void showData2() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?characterEncoding=latin1&useConfigs=maxPerformance", "root",
                    "root");
            String sql = "SELECT Name, Marks FROM result where RollNo=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, cmbRollNo2.getSelectedItem());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                txt3Name.setText(rs.getString("Name"));
                txt3Marks.setText(rs.getString("Marks"));
            }
        } catch (Exception e) {
            System.out.println("Some error occurred in show2: " + e.getMessage());
        }
    }
}