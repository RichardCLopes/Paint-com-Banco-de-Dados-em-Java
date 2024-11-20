package serv;
import java.io.*;
import java.net.*;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;

import core.*;
import dao.*;
import dbo.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SupervisoraDeConexao extends Thread
{
    private Parceiro            usuario;
    private Socket              conexao;
    private ArrayList<Parceiro> usuarios;
    private String 				nome;
    private String 				de;

    public SupervisoraDeConexao
    (Socket conexao, ArrayList<Parceiro> usuarios)
    throws Exception
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (usuarios==null)
            throw new Exception ("Usuarios ausentes");

        this.conexao  = conexao;
        this.usuarios = usuarios;
    }

    public void run ()
    {

        ObjectOutputStream transmissor;
        try
        {
            transmissor =
            new ObjectOutputStream(
            this.conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            return;
        }
        
        ObjectInputStream receptor=null;
        try
        {
            receptor=
            new ObjectInputStream(
            this.conexao.getInputStream());
        }
        catch (Exception err0)
        {
            try
            {
                transmissor.close();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread
            
            return;
        }

        try
        {
            this.usuario =
            new Parceiro (this.conexao,
                          receptor,
                          transmissor);
        }
        catch (Exception erro)
        {} // sei que passei os parametros corretos

        try
        {
            synchronized (this.usuarios)
            {
                this.usuarios.add (this.usuario);
            }


            for(;;)
            {
                Comunicado comunicado = this.usuario.envie ();
                
                if (comunicado==null)
                    return;
                else if (comunicado instanceof PedidoDeSalvamento)
                {
                	System.out.print("no salvamento");
                	/*
                	SQLDesenhos.incluir(new SQLDesenho("ipDaMaquina","nome","dStr","dStr","de"));
                	PedidoDeSalvamento pedidodeSalvamento = (PedidoDeSalvamento)comunicado;
                	nome = pedidodeSalvamento.getNome();
                	de = pedidodeSalvamento.getDesenho();
                	java.util.Date d = new Date();
                	String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
                	String ipDaMaquina = InetAddress.getLocalHost().getHostAddress();
                	SQLDesenhos.incluir(new SQLDesenho("ipDaMaquina","nome","dStr","dStr","de"));
                	usuario.adeus();
                	*/
                }
                else if (comunicado instanceof PedidoDeAbertura)
                {
                	System.out.print("na abetura");
                	/*
                	PedidoDeAbertura pedidodeAbertura = (PedidoDeAbertura)comunicado;
                	nome = pedidodeAbertura.getNome();
                	id = pedidodeAbertura.getIdCliente();
                	SQLDesenho dese;
                	dese = SQLDesenhos.abriDesenho(id,nome);
             	    usuario.receba(new Desenho(dese.getDesenho()));
             	    */
                }             
            }
        }
        catch (Exception erro)
        {
            try
            {
                transmissor.close ();
                receptor   .close ();
            }
            catch (Exception falha)
            {} // so tentando fechar antes de acabar a thread

            return;
        }
    }
}
