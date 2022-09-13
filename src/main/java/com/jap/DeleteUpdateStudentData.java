package com.jap;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class DeleteUpdateStudentData
{

    public Connection getConnection() {
        Connection connection=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql= "jdbc:mysql://localhost:3306/student";
            String user="root";
            String pass="admin";
            connection=DriverManager.getConnection(sql,user,pass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;

    }

    public void deleteStudentData(){
      // call getConnection() method
        int rows = 0;
        Connection connection = getConnection();

        String sql = "delete from studenttable where rollNo=14";
       Statement statement = null;
        try {
            statement = connection.createStatement();
            //execute delete query
            rows = statement.executeUpdate(sql);
            if(rows==1){
                System.out.println("Data Delete SuccessFully");
            }else{
                System.out.println("Data not Deleted Try again");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentData(){
        // call getConnection() method
        int row=0;
        Connection connection=getConnection();
        String sql="update  studenttable set Name = 'Rahul' where  totalMarks=678 and rollNo = 15;";
        Statement statement=null;
        try {
            statement = connection.createStatement();
            //execute update query
            row=statement.executeUpdate(sql);
            if(row==1){
                System.out.println("Row is Updated Successfully");
            }else{
                System.out.println("Row not Updated please check for error");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DeleteUpdateStudentData salesDataDemo = new DeleteUpdateStudentData();
        salesDataDemo.deleteStudentData();
        salesDataDemo.updateStudentData();
    }
}
