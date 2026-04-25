import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Encimera {

	private ArrayList<Juguete> contenedor;
	private final int CANTIDAD_MAXIMA = 7;
	private int cantidadTotalDeJuguetesPorFabricar;
	private int juguetesFabricados;
	private Semaphore accesoJuguetes;
	private Semaphore accesoDeclararJuguetes;
	
	public Encimera () {
		accesoDeclararJuguetes = new Semaphore(1);
		accesoJuguetes = new Semaphore(1); // total pjs juguetería, definido por enunciado.
		contenedor = new ArrayList<>();
		cantidadTotalDeJuguetesPorFabricar = 0;
		juguetesFabricados = 0;
	}

	public void ponerJugueteEnLaEncimera(Juguete juguete) {
		try {
			accesoJuguetes.acquire();
			while (contenedor.size() >= CANTIDAD_MAXIMA) {
				System.out.println("Encimera llena. Elfo esperando...");
				accesoJuguetes.release();
				Thread.sleep(1000);
				accesoJuguetes.acquire();
			}
			contenedor.add(juguete);
			System.out.println("SE HA AÑADIDO A LA ENCIMERA: " + juguete);
			accesoJuguetes.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public Juguete sacarJugueteEnLaEncimera() {
		try {
			accesoJuguetes.acquire();
			while (contenedor.isEmpty()) {
				System.out.println("Encimera vacia. Niño esperando...");
				accesoJuguetes.release();
				Thread.sleep(1000);
				accesoJuguetes.acquire();
			}
			Juguete jugueteSacado = contenedor.removeFirst();
			accesoJuguetes.release();
			return jugueteSacado;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Juguete> getContenedor() {
		return contenedor;
	}

	public int getCantidadTotalDeJuguetesPorFabricar() {
		return cantidadTotalDeJuguetesPorFabricar;
	}

	public void setCantidadTotalDeJuguetesPorFabricar(int cantidadTotalDeJuguetesPorFabricar) {
		try {
			accesoDeclararJuguetes.acquire(1);
			this.cantidadTotalDeJuguetesPorFabricar += cantidadTotalDeJuguetesPorFabricar;
			accesoDeclararJuguetes.release(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// debug
		//System.out.println("CANTIDAD TOTAL ACTUALIZADA: " + this.cantidadTotalDeJuguetesPorFabricar);
	}
	
	public void aumentarCantidadJuguetesFabricados() {
		try {
			accesoDeclararJuguetes.acquire(1);
			juguetesFabricados++;
			accesoDeclararJuguetes.release(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getJuguetesFabricados() {
		return juguetesFabricados;
	}
	

	
	
}
