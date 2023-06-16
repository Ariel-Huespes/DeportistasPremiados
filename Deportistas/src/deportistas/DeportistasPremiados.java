package deportistas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class DeportistasPremiados {

	private TreeMap<Integer, ArrayList<String>> premiados;

	public DeportistasPremiados() {
		
		this.premiados = new TreeMap<Integer, ArrayList<String>>();
	}
	
	public void leerDerportistas(String archivo) {
		Integer anio;
		String torneoTenista;
		ArrayList<String> l;
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split(",");
				anio = Integer.parseInt(datos[1].trim());
				torneoTenista = datos[2] + "\t" + datos[0];

				//pregunto si la key no esta
				if(!premiados.containsKey(anio)) {
					l = new ArrayList<String>();
				}else {
					l = premiados.get(anio);
				}
				
				l.add(torneoTenista);
				this.premiados.put(anio, l);
				
				linea = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

	protected TreeMap<Integer, ArrayList<String>> getPremiados() {
		return premiados;
	}


	public static void main(String[] args) {
		DeportistasPremiados dp = new DeportistasPremiados();
		dp.leerDerportistas("premiados.in");
		System.out.println(dp.getPremiados());
	}

	
}
