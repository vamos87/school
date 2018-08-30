package pl.coderslab.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public	class	DbUtil	{
    private	static DataSource ds;
    public	static Connection getConn()	throws SQLException {
        return	getInstance().getConnection();
    }
    private	static	DataSource	getInstance()	{
        if(ds	==	null)	{
            try	{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Context ctx	=	new InitialContext();
                ds	=	(DataSource)ctx.lookup("java:comp/env/jdbc/school");
            }	catch	(NamingException|ClassNotFoundException e)	{
                e.printStackTrace();}
        }
        return	ds;}
}
