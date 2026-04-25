public class Nino_Bueno implements Runnable{
	private int id;
	private Encimera encimera;
	
	public Nino_Bueno(int id, Encimera encimera) {
		this.encimera = encimera;
		this.id = id;
	}

	@Override
	public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(encimera.getCantidadTotalDeJuguetesPorFabricar() != encimera.getJuguetesFabricados()) {
			Juguete juguete = encimera.sacarJugueteEnLaEncimera();
			jugar();
			System.out.println("Niño Bueno: " + id + " ha terminado de jugar.");
			encimera.ponerJugueteEnLaEncimera(juguete);
		}
		System.out.println("Niño Bueno: " + id + " se fue.");
		
	}
	
	private void jugar() {
		int tiempoDeJuego = (int)(Math.random() * 3 + 2);
		try {
			Thread.sleep(1000 * tiempoDeJuego);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
