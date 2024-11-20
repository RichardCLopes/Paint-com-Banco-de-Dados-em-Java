package dao;

import java.sql.*;
import core.*;
import dbo.*;

public class SQLDesenhos {

	public static void incluir (SQLDesenho desenho) throws Exception
	{
		if(desenho==null)
			throw new Exception ("Desenho nao fornecido");
		
		try
		{
			String sql;
			
			sql = "INSERT INTO DESENHOS" +
				  "(IDCLIENTE,NOME,DATA_CRIACAO,DATA_ATT,DESENHO)" +
				  "VALUES " +
				  "(?,?,?,?,?)";
			
			BDSQLServer.COMANDO.prepareStatement (sql);
			
			BDSQLServer.COMANDO.setString(1, desenho.getIdcliente());
			BDSQLServer.COMANDO.setString(2, desenho.getNomedes());
			BDSQLServer.COMANDO.setString(3, desenho.getDataatual());
			BDSQLServer.COMANDO.setString(4, desenho.getDataultima());
			BDSQLServer.COMANDO.setString(5, desenho.getDesenho());
			
			BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
					
		}
		catch (SQLException erro)
		{
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir desenho");
		}	
	}
	
	public static void alterar (SQLDesenho desenho) throws Exception
	{
		if(desenho==null)
			throw new Exception ("Desenho nao fornecido");
		
		try
		{
			String sql;
			
			sql = "UPDATE DESENHOS " +
	              "SET IDCLIENTE=? " +
	              "SET NOME=? " +
	              "SET DATA_CRIACAO=? " +
	              "SET DATA_ATT=? " +
	              "SET DESENHO=? " +
	              "WHERE IDCLIENTE = ?" +
	              "AND NOME=?";
			
			BDSQLServer.COMANDO.prepareStatement (sql);
			
			BDSQLServer.COMANDO.setString(1, desenho.getIdcliente());
			BDSQLServer.COMANDO.setString(2, desenho.getNomedes());
			BDSQLServer.COMANDO.setString(3, desenho.getDataatual());
			BDSQLServer.COMANDO.setString(4, desenho.getDataultima());
			BDSQLServer.COMANDO.setString(5, desenho.getDesenho());
			BDSQLServer.COMANDO.setString(6, desenho.getIdcliente());
			BDSQLServer.COMANDO.setString(7, desenho.getNomedes());
			
			BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
					
		}
		catch (SQLException erro)
		{
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados do desenho");
		}	
	}
	
	public static SQLDesenho abriDesenho (String id, String nomed) throws Exception
	{
		SQLDesenho des = null;
		
		try
		{
			String sql;
			
			sql = "SELECT * " +
	              "FROM DESENHOS " +
	              "WHERE IDCLIENTE = ?" +
	              "AND NOME=?";
			
			BDSQLServer.COMANDO.prepareStatement (sql);
			
			BDSQLServer.COMANDO.setString(1, id);
			BDSQLServer.COMANDO.setString(2, nomed);
			
			MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
			
			if (!resultado.first())
                throw new Exception ("Nao cadastrado");
			
			des = new SQLDesenho(resultado.getString("IDCLIENTE"),
					             resultado.getString("NOME"),
					             resultado.getString("DATA_CRIACAO"),
					             resultado.getString("DATA_ATT"),
					             resultado.getString("DESENHO"));
					
		}
		catch (SQLException erro)
		{
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao procurar desenho");
		}	
		
		return des;
	}
	
}
