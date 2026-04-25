public class Nino_Malo implements Runnable{
	private int id;
	private Encimera encimera;
	private int NUMERO_PARA_EXPULSION = 3;
	
	public Nino_Malo(int id, Encimera encimera) {
		this.encimera = encimera;
		this.id = id;
	}

	@Override
	public void run() {
		int juguetesRotos = 0;
		while(juguetesRotos < NUMERO_PARA_EXPULSION) {
			Juguete juguete = encimera.sacarJugueteEnLaEncimera();
			jugar();
			juguetesRotos++;
			System.out.println("Niño Malo: " + id + " ha roto " + juguete + " (" + juguetesRotos + "/" + NUMERO_PARA_EXPULSION + ")");
			// total > 0 evita que 0==0 sea true al inicio del programa
			if(encimera.getCantidadTotalDeJuguetesPorFabricar() > 0 &&
			   encimera.getCantidadTotalDeJuguetesPorFabricar() == encimera.getJuguetesFabricados()){
				break;
			}
		}
		System.out.println("Niño Malo: " + id + " expulsado");
	}

	private void jugar() {
		int tiempoDeJuego = (int)(Math.random() * 3 + 3);
		try {
			Thread.sleep(1000 * tiempoDeJuego);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
