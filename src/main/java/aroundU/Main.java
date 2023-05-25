package aroundU;

import java.io.FileWriter;
import java.io.IOException;

import interfaces.Ventana;

public class Main {

	public static void main(String[] args) {
		Ventana v=new Ventana();
	
		try {
			FileWriter escritor=new FileWriter("./bdconfig.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
