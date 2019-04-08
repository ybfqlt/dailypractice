package com.openhome;

import java.io.*;
import java.sql.*;
import java.util.*;

public class GuestBookBean implements Serializable {
    private String jdbcUrl="jdbc:mysql://localhost:3306/demo";
    private String username="root";
    private String password="tian787604";
    public GuestBookBean(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }
    public void setMessage(Message message){
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;
        try{
            conn = DriverManager.getConnection(jdbcUrl,username,password);
            statement = conn.createStatement();
            statement.executeUpdate(
                    "INSERT INTO t_message(name,email,msg) VALUES ('"
                    +message.getName()+"','"
                    +message.getEmail()+"','"
                    +message.getMsg()+"')");
        }catch(SQLException e){
            ex=e;
        }finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    if(ex == null) {
                        ex = e;
                    }
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    if (ex == null) {
                        ex = e;
                    }
                }
            }
            if (ex != null) {
                throw new RuntimeException(ex);
            }
        }
    }
    public List<Message> getMessages(){
        Connection conn = null;
        Statement statement = null;
        ResultSet result = null;
        SQLException ex = null;
        List<Message> messages = null;
        try{
            conn = DriverManager.getConnection(jdbcUrl,username,password);
            statement = conn.createStatement();
            result = statement.executeQuery("SELECT * FROM t_message");
            messages = new ArrayList<Message>();
            while(result.next()){
                Message message = new Message();
                message.setId(result.getLong(1));
                message.setName(result.getString(2));
                message.setEmail(result.getString(3));
                message.setMsg(result.getString(4));
                messages.add(message);
            }
        }catch(SQLException e){
            ex=e;
        }finally{
            if(statement != null){
                try{
                    statement.close();
                }catch(SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(ex != null){
                throw new RuntimeException(ex);
            }
        }
        return messages;
    }
}
