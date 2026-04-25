import java.util.concurrent.Semaphore;

public class Elfo implements Runnable{
	private int cantidadPorFabricar;
	private final int id;
	private Encimera encimera;
	private int idInicialParaJuguete = 0;
	private String[] tipos = {"Muñeca", "Vehículo", "Arma", "Pelota"};
	
	public Elfo(int id, Encimera encimera) {
		this.encimera = encimera;
		this.id = id;
		cantidadPorFabricar = asignarCantidad();
	}

	@Override
	public void run() {
		// debug
		System.out.println("ELFO " + id + " FABRICARA " + cantidadPorFabricar);
		encimera.setCantidadTotalDeJuguetesPorFabricar(cantidadPorFabricar);
		// debug
		System.out.println("ELFO " + id + " HA ACTUALIZADO EL TOTAL AHORA ES" + encimera.getCantidadTotalDeJuguetesPorFabricar());
		int cantidadFabricada = 0;
		Juguete juguete = crearJuguete();
		// debug
		System.out.println("JUGUETE CREADO: " + juguete);
		while(cantidadFabricada < cantidadPorFabricar) {
			encimera.ponerJugueteEnLaEncimera(juguete);
			System.out.println( "Soy el Elfo " + id + ", he colocado el juguete " + juguete.getId() + " tipo " + juguete.getTipo());
			juguete = crearJuguete();
			cantidadFabricada++;
			encimera.aumentarCantidadJuguetesFabricados();
		}
		//debug
		System.out.println("Soy el elfo " + id + ", termine mi trabajo.");
	}
	
	private Juguete crearJuguete(){
		// tiempo de espera para simular la creación del juguete.
		int tiempo = (int)(Math.random() * 3 + 1);
		try {
			Thread.sleep((long)1000 * tiempo);
			return new Juguete(++idInicialParaJuguete, tipos[(int)(Math.random() * 3 + 1)]);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private int asignarCantidad() {
		return (int)(Math.random() * 10 + 10);
	}

}




