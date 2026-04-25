public class Jugueteria {

	public static void main(String[] args) {
		
		Encimera encimera = new Encimera();
		
		for(int i = 1; i < 4;i++ ){
			Elfo elfo = new Elfo(i,encimera);
			Thread hilo = new Thread(elfo);
			hilo.start();
		}
		
		for(int i = 1; i < 21;i++ ){
			Nino_Malo niño = new Nino_Malo(i,encimera);
			Thread hilo = new Thread(niño);
			hilo.start();
		}
		
		for(int i = 1; i < 6;i++ ){
			Nino_Bueno niño = new Nino_Bueno(i,encimera);
			Thread hilo = new Thread(niño);
			hilo.start();
		}

	}

}
