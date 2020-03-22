import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Knjiga implements Serializable {
	private static final long serialVersionUID = 1L;
	static int brojacRacuna=0;
				
	static int brojacKnjiga=0;
	static ArrayList<Knjiga> ListaKnjiga=new ArrayList<Knjiga>();
	int brojKnjige;
	String imeKnjige;
	boolean statusKnjige;

	
	
	


public void KreiranjeKnjige(int brojKnjige,String imeKnjige)
	{
		this.brojKnjige=brojKnjige;
		brojacKnjiga++;
		validacijaBrojaKnjige(this.brojKnjige);
		ListaKnjiga.add(this);
		
		this.imeKnjige=imeKnjige;
		
	}
	
	
	
	public void validacijaBrojaKnjige(int brojKnjige)
	{
		
		for(int i=0; i<ListaKnjiga.size(); i++)
		{
			if((brojKnjige==ListaKnjiga.get(i).brojKnjige)||(brojKnjige<0))
			{System.out.println("Unesen je negativan broj ili vec postojuci broj knjige.");
			;break;}else{continue;}
		}
	
	}
		
	
	

	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}

	
	
	public static void save() throws IOException
	{
		FileOutputStream fo=new FileOutputStream("Knjige.txt");
		ObjectOutputStream output= new ObjectOutputStream(fo);
		for(int i=0;i<ListaKnjiga.size();i++)
		{
		 output.writeObject(ListaKnjiga.get(i));
		}
	}
	
	public static void zapisi() throws IOException, ClassNotFoundException
	{	File file=new File ("Knjige.txt");
		
	if (!file.exists()) 
		file.createNewFile();
	
	
		FileInputStream fi= new FileInputStream ("Knjige.txt");
		ObjectInputStream input= null;
		try {
			input= new ObjectInputStream (fi);
		} catch (EOFException e) {
			return;
		}
		
		
		while(true)
	{
			try{
			
			
					ListaKnjiga.add((Knjiga)input.readObject());
					brojacRacuna++;
							
			}catch(EOFException e){input.close();break;}
	}}
	
	
	
	
	
	
	
	
	

}
