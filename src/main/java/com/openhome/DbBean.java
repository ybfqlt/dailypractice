package com.openhome;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbBean implements Serializable {
    private String jdbcUrl/*="jdbc:mysql://localhost:3306/demo"*/;
    private String username/*="root"*/;
    private String password/*="tian787604"*/;

    public DbBean(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); //动态加载驱动程序类
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public boolean isConnectedOk(){
        boolean ok = false;
        Connection conn = null;
        SQLException ex = null;
        try{
            conn = DriverManager.getConnection(jdbcUrl,username,password);
            if(!conn.isClosed()){
                ok=true;
            }
        }catch(SQLException e){
            ex=e;
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    if(ex == null){
                        ex=e;
                    }
                }
            }
            if(ex != null){
                throw  new RuntimeException(ex);
            }
        }
        return ok;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setJDbcUrl(String jdbcUrl){
        this.jdbcUrl = jdbcUrl;
    }
    public void setUsername(String username){
        this.username=username;
    }
}
