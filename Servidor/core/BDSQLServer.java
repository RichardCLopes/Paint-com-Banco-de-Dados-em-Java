package core;

import dao.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
    		"com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://DESKTOP-L83NG6O\\SQLEXPRESS;databasename=master",
            "rlopes","lopes123");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); // aborta o programa
        }
        
        COMANDO = comando;
    }
}