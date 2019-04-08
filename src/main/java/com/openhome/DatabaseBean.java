package com.openhome;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseBean implements Serializable {
    private DataSource dataSource;

    public DatabaseBean(){
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/demo");
        }catch(NamingException ex){
            throw new RuntimeException(ex);
        }
    }
    public boolean isConnectedOK(){
        boolean ok = false;
        Connection conn = null;
        SQLException ex = null;
        try{
            conn = dataSource.getConnection();
            if(!conn.isClosed()){
                ok = true;
            }
        }catch(SQLException e){
            ex = e;
        }finally{
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
        return ok;
    }
}