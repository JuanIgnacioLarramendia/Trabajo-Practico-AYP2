package prueba.mapa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercito.Ejercito;
import mapa.*;
import unidades.*;

public class PruebaDistancia {

	private Distancia distanciaA;
	private Distancia distanciaB;

	private Poblado pobladoA;
	private Poblado pobladoB;

	@Before
	public void inicializar() {

		Ejercito ejercitoA = new Ejercito();
		Ejercito ejercitoB = new Ejercito();

		ejercitoA.agregarAlEjercito(new Wrive());
		ejercitoB.agregarAlEjercito(new Radaiteran());

		pobladoA = new Poblado("1", ejercitoA, Bando.ALIADO);
		pobladoB = new Poblado("2", ejercitoB, Bando.ENEMIGO);

		distanciaA = new Distancia(pobladoA.obtenerNombre(), 10);
		distanciaB = new Distancia(pobladoB.obtenerNombre(), 20);
	}

	/**
	 * Obtener la distancia al poblado
	 */
	@Test
	public void prueba001() {
		Assert.assertEquals(10, distanciaA.obtenerDistancia(), 0);
	}

	/**
	 * Obtener el nombre del Poblado (vertice)
	 */
	@Test
	public void prueba002() {
		Assert.assertEquals("1", distanciaA.obtenerNombrePoblado());
	}

	/**
	 * Verificar que la distancia al poblado 2 sea mayor al del poblado 1
	 */
	@Test
	public void prueba003() {
		Assert.assertEquals(1, distanciaB.compareTo(distanciaA));
	}

}
