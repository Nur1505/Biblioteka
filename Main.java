import java.util.Scanner;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;




public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Racun.zapisi();
		Knjiga.zapisi();
		ArrayList<Knjiga>podignuteKnjige=new ArrayList<Knjiga>();
		Scanner unos=new Scanner(System.in);
		
		
		
		for(;;)
		{
		
			System.out.println("Unosenjem navedenog broja birate opciju:  ");
			System.out.println("1=Kreirnaje novog Racuna. ");
			System.out.println("2=Unosenje nove Knjige. ");
			System.out.println("3=Podizanje Knjige. ");
			System.out.println("4=Ispis informacija racuna. ");
			System.out.println("5=Sacuvaj i zatvori.");
			int brojOpcije=unos.nextInt();
			if(brojOpcije==1)
			{
			
				System.out.println("Broj racuna: ");
				int uneseniBrojRacuna=unos.nextInt();
				int brojac=0;
		
					System.out.println("Korisnicko ime: ");
					String imeKorisnika=unos.next();
					Racun racun=new Racun(uneseniBrojRacuna,imeKorisnika);
				
					
				}
					
			else if(brojOpcije==2)
			{int kontrola=0;
				System.out.println("Naziv knjige: ");
				String imeKnjige=unos.next();
			
				System.out.println("Broj knjige: ");
				int brojKnjige=unos.nextInt(),brojac=0;
				
				Knjiga knjiga=new Knjiga ();	
				knjiga.KreiranjeKnjige(brojKnjige, imeKnjige);
				
							}
			else if(brojOpcije==3)
			{
				System.out.println("Broj knjige: ");
				int uneseniBrojKnjige1=unos.nextInt();
				System.out.println("Broj racuna: ");
				int uneseniBrojRacuna1=unos.nextInt();
				
				int kontrolaKnjiga=0,kontorlaRacuna=0;
				
				
				for(int i=0; i<Racun.ListaRacuna.size();i++)
				{
					if(Racun.ListaRacuna.get(i).brojRacuna==uneseniBrojRacuna1)
					{	kontorlaRacuna++;
					Racun.ListaRacuna.get(i).brojPosudjenihKnjigaJednogRacuna++;
						if(Racun.ListaRacuna.get(i).brojPosudjenihKnjigaJednogRacuna<=3)
						{
							for(int k=0;k<Knjiga.ListaKnjiga.size();k++)
							{
								if(Knjiga.ListaKnjiga.get(k).brojKnjige==uneseniBrojKnjige1)
								{	kontrolaKnjiga++;
									if(Knjiga.ListaKnjiga.get(k).statusKnjige==false)
									{Knjiga.ListaKnjiga.get(k).statusKnjige=true;
									podignuteKnjige.add(Knjiga.ListaKnjiga.get(k));}
									else{System.out.println("Knjiga je vec podignuta.");}
								}
								
							}	
						}
						else{System.out.println("Greska.Nemoguce je podici vise od tri knjige.Racun: "+Racun.ListaRacuna.get(i).brojRacuna);break;}
					}
				}	
				
					
				
				
				if(kontorlaRacuna==0)
				{System.out.println("Unijeli ste nepostojuci broj racuna.");}
				if(kontrolaKnjiga==0)
				{System.out.println("Unijeli ste nepostojuci broj knjige.");}
			}
			else if(brojOpcije==4)
			{
				
					Racun.informacije();
				
			}
			else if(brojOpcije==5)
			{
				new FileOutputStream("Racuni.txt").close();
				new FileOutputStream("Knjige.txt").close();
				Racun.save();
				Knjiga.save();
				break;
			}
			else {System.out.println("Unijeli ste nepostojucu oopciju.");}
		
		
		
		
		}
		
		
		
		

	}


	
		
	
	


}

