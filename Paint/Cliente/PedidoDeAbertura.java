package Cliente;

public class PedidoDeAbertura extends Comunicado
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idCliente; // vai ser o ip
    private String nome; // so isso para abrir um novo desenho
    private String data;
    private String dataultat;
    
    public PedidoDeAbertura (String idCliente, String nome)
    {
        this.idCliente = idCliente;
        this.nome = nome;
    }
    
    public String getIdCliente ()
    {
        return this.idCliente;
    }
    
    public void setIdCliente (String idCliente) throws Exception
    {
    	this.idCliente = idCliente;
    }
    
    public String getNome ()
    {
        return this.nome;
    }
    
    public void setNome (String nome) throws Exception
    {
        this.nome = nome;
    }
    
    public String getData()
    {
    	return this.data;
    }
    
    public void setData(String data)
    {
    	this.data = data;
    }
    
    public String getDataUltat()
    {
    	return this.dataultat;
    }
    
    public void setDataUltat(String dataultat)
    {
    	this.data = dataultat;
    }
    
}
