
package ejercito;

import java.util.ArrayList;
import java.util.Iterator;

import unidades.Unidad;

public class Ejercito implements Tropa {

	private ArrayList<Tropa> tropas;

	public Ejercito() {

		tropas = new ArrayList<Tropa>();

	}

	public void agregarAlEjercito(Tropa tropa) {

		tropas.add(tropa);

	}

	public void agregarAliadosAlEjercito(Tropa tropa) {

		tropas.add(0, tropa);

	}

	@Override
	public void atacar(Tropa objetivo) {

		tropas.get(0).atacar(objetivo);

	}

	@Override
	public void descansar() {

		Iterator<Tropa> i = tropas.iterator();

		while (i.hasNext())
			i.next().descansar();

	}

	@Override
	public void recibirAtaque(int ataque) {

		tropas.get(0).recibirAtaque(ataque);

		if (obtenerPrimeraUnidad().estaDesmayado()) {
			tropas.remove(0);
		}

	}

	@Override
	public boolean estaDesmayado() {

		return tropas.isEmpty();

	}

	@Override
	public void siguienteTurnoContiguo() {

		Iterator<Tropa> i = tropas.iterator();

		while (i.hasNext())
			i.next().siguienteTurnoContiguo();
	}

	@Override
	public void resetearTurnoContiguo() {
		Iterator<Tropa> i = tropas.iterator();

		while (i.hasNext())
			i.next().resetearTurnoContiguo();
	}

	public void reagruparse() {

		tropas.add(extraerPrimeraUnidad());

	}

	public ArrayList<Tropa> obtenerTropas() {
		return tropas;
	}

	public Unidad extraerPrimeraUnidad() {

		Unidad primeraUnidad = null;

		if (tropas.get(0) instanceof Ejercito) {
			primeraUnidad = ((Ejercito) (tropas.get(0))).extraerPrimeraUnidad();
		} else {
			primeraUnidad = (Unidad) tropas.get(0);

			tropas.remove(0);
		}

		return primeraUnidad;
	}

	public Unidad obtenerPrimeraUnidad() {

		Unidad primeraUnidad = null;

		if (tropas.get(0) instanceof Ejercito) {
			primeraUnidad = ((Ejercito) (tropas.get(0))).extraerPrimeraUnidad();
		} else {
			primeraUnidad = (Unidad) tropas.get(0);
		}

		return primeraUnidad;
	}

	public int cantidadUnidades() {
		return tropas.size();
	}

}
