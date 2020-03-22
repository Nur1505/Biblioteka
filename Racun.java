
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


public class Racun implements Serializable {
	
	
	
	
			
			
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			static int brojacRacuna=0;
						
			public static ArrayList<Racun>ListaRacuna=new ArrayList<Racun>();
			protected int brojRacuna;
			protected String imeMsterije;
			protected int brojPosudjenihKnjigaJednogRacuna=0;
			static int daLiPostojiRacun=0;
			
			
			Racun(int brojRacuna,String imeMusterije) throws IOException, ClassNotFoundException
			{	
				
				this.brojRacuna=brojRacuna;
				this.imeMsterije=imeMusterije;
				
				
				int validacija=validacijaBrojaRacuna(brojRacuna);
				if(validacija==0)
				{
				ListaRacuna.add(this);
				}
				
				
				
			}
			
			
			
			
			public int validacijaBrojaRacuna(int brojRacuna)
			{int validacija=0;
				 
				for(int i=0; i<ListaRacuna.size(); i++)
				{
					if((brojRacuna==ListaRacuna.get(i).brojRacuna)||(brojRacuna<0))
					{System.out.println("Unesen je negativan broj ili vec postojuci broj racuna.");
					;validacija=1;break;}else{continue;}
				}
			return validacija;
			}
				
			
			

			public void setBrojRacuna(int brojRacuna) {
				this.brojRacuna = brojRacuna;
			}

			public String getImeMsterije() {
				return imeMsterije;
			}

			public void setImeMsterije(String imeMsterije) {
				this.imeMsterije = imeMsterije;
			}

			public int getBrojPosudjenihKnjiga() {
				return brojPosudjenihKnjigaJednogRacuna;
			}

			public void setBrojPosudjenihKnjiga(int brojPosudjenihKnjiga) {
				this.brojPosudjenihKnjigaJednogRacuna = brojPosudjenihKnjiga;
			}
			
			public static void save() throws IOException
			{
				FileOutputStream fo=new FileOutputStream("Racuni.txt");
				ObjectOutputStream output= new ObjectOutputStream(fo);
				for(int i=0;i<ListaRacuna.size();i++)
				{
				 output.writeObject(ListaRacuna.get(i));
				}
			}
			
			public static void zapisi() throws IOException, ClassNotFoundException
			{	File file=new File ("Racuni.txt");
				
			if (!file.exists()) 
				file.createNewFile();
			
			
				FileInputStream fi= new FileInputStream ("Racuni.txt");
				ObjectInputStream input= null;
				try {
					input= new ObjectInputStream (fi);
				} catch (EOFException e) {
					return;
				}
				
				
				while(true)
			{
					try{
					
					
							ListaRacuna.add((Racun)input.readObject());
							brojacRacuna++;
									
					}catch(EOFException e){input.close();break;}
			}}
			
			
			
			public static void informacije()
			{
				for(int i=0;i<ListaRacuna.size();i++)
				{
					System.out.println("Broj racuna: "+ListaRacuna.get(i).brojRacuna);
					System.out.println("Ime korisnika: "+ListaRacuna.get(i).imeMsterije);
					
					System.out.println("");
					
				}
			}
			
			
			
			
			
		}