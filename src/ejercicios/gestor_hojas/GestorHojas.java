package ejercicios.gestor_hojas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorHojas extends Thread {

	private static List<String> lista = new ArrayList<>();
	private static List<String> LS = Collections.synchronizedList(lista);
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			LS.add(new String("Texto" + i));
		}
		synchronized (LS) {
			for (String string : LS) {
				System.out.println(string);
			}
		}
	}
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new GestorHojas().start();
		}

	}

}
