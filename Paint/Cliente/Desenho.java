package Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Desenho extends Comunicado 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String desenho;
    
  public Desenho(String des)
  {
    this.desenho = des;
  }

  public String getDesenho ()
  {
    return this.desenho;
  }
  
  public void setDesenho (String de)
  {
    this.desenho = de;
  }
  
  public String toString ()
  {
		return (""+this.desenho);
	}

}

