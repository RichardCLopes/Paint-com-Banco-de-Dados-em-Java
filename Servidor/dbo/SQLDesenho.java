package dbo;

public class SQLDesenho implements Cloneable 
{
	private String idcliente;
    private String nomedes;
    private String dataatual;
    private String dataultima;
    private String desenho;
    
    public SQLDesenho (String idcliente, String nomedes, String dataatual, String dataultima, String desenho) {
        this.setIdcliente(idcliente);
        this.setNomedes(nomedes);
        this.setDataatual(dataatual);
        this.setDataultima(dataultima);
        this.setDesenho(desenho);
    }
    
    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomedes() {
        return nomedes;
    }

    public void setNomedes(String nomedes) {
        this.nomedes = nomedes;
    }

    public String getDataatual() {
        return dataatual;
    }

    public void setDataatual(String dataatual) {
        this.dataatual = dataatual;
    }

    public String getDataultima() {
        return dataultima;
    }

    public void setDataultima(String dataultima) {
        this.dataultima = dataultima;
    }

    public String getDesenho() {
        return desenho;
    }

    public void setDesenho(String desenho) {
        this.desenho = desenho;
    }
    
    public String toString()
    {
    	String ret = "";
    	
    	ret += "Id Cliente: " +this.idcliente+"\n";
    	ret += "Nome" +this.nomedes+"\n";
    	ret += "Data atual" +this.dataatual+"\n";
    	ret += "Data Ultima Salvamento" +this.dataultima+"\n";
    	ret += "Desenho" +this.desenho+"\n";
    	
    	return ret;
    }
    
    public boolean equals (Object obj)
    {
    	if (this==obj)
            return true;
    	
    	if (obj==null)
            return false;
    	
    	if (!(obj instanceof SQLDesenho))
            return false;
    	
    	SQLDesenho d = (SQLDesenho)obj;
    	
    	if(this.idcliente!=d.idcliente)
    		return false;
    	
    	if(this.nomedes!=d.nomedes)
    		return false;
    	
    	if(this.dataatual!=d.dataatual)
    		return false;
    	
    	if(this.dataultima!=d.dataultima)
    		return false;
    	
    	if(this.desenho!=d.desenho)
    		return false;
    	
    	return true;
    }
	
}
