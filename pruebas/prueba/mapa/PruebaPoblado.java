package prueba.mapa;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejercito.Ejercito;
import mapa.*;
import unidades.*;

public class PruebaPoblado {

	private Poblado pobladoA;
	private Poblado pobladoB;
	private Camino caminoAB;

	@Before
	public void inicializar() {
		Ejercito ejercitoA = new Ejercito();
		Ejercito ejercitoB = new Ejercito();

		ejercitoA.agregarAlEjercito(new Wrive());
		ejercitoB.agregarAlEjercito(new Radaiteran());

		pobladoA = new Poblado("1", ejercitoA, Bando.PROPIO);
		pobladoB = new Poblado("2", ejercitoB, Bando.ENEMIGO);
		caminoAB = new Camino(pobladoB, 10);
	}

	/**
	 * Verificar que el poblado A no sea nulo
	 */
	@Test
	public void prueba001() {
		Assert.assertNotNull(pobladoA);
	}

	/**
	 * Verificar que el poblado B no sea nulo
	 */
	@Test
	public void prueba002() {
		Assert.assertNotNull(pobladoB);
	}

	/**
	 * Verificar que el camino que une A y B no sea nulo
	 */
	@Test
	public void prueba003() {
		Assert.assertNotNull(caminoAB);
	}

	/**
	 * Agregar el camino que una A con B
	 */
	@Test
	public void prueba004() {
		pobladoA.agregarCamino(caminoAB);

		Assert.assertEquals("[2, 10] ", pobladoA.toString());
	}

	/**
	 * Agregar camino que una A con B B <- A;
	 */
	@Test
	public void prueba005() {
		HashMap<String, Camino> m = new HashMap<String, Camino>();
		m.put(pobladoB.obtenerNombre(), caminoAB);
		pobladoA.agregarCamino(caminoAB);

		Assert.assertEquals(m, pobladoA.obtenerListaDeCaminos());
	}

	/**
	 * Obtener un ejercito a partir del poblado A y comprobar la cantidad de
	 * unidades
	 */
	@Test
	public void prueba006() {
		Ejercito ejercito = pobladoA.obtenerEjercito();

		Assert.assertEquals(1, ejercito.cantidadUnidades());
	}
}
