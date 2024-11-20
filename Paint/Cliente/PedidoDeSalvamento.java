package Cliente;

public class PedidoDeSalvamento extends Comunicado
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
    private String desenho;

    
    public PedidoDeSalvamento (String des, String nome)
    {
        this.desenho = des;
        this.nome = nome;
    }
    
    public String getNome ()
    {
        return this.nome;
    }
   
    public void setNome (String nome) 
    {
    	this.nome = nome;
    }
    
    public String getDesenho ()
    {
        return this.desenho;
    }
    
    public void setDesenho(String des)
    {
    	this.desenho = des;
    }
    
    public String toString ()
    {
        return (""+this.nome+this.desenho);
    }    
}
