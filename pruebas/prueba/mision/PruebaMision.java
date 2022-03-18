package prueba.mision;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mision.FormatException;
import mision.Mision;
import unidades.*;
import mapa.*;

public class PruebaMision {

	private Mision mision;

	@Before
	public void inicializar() {
		try {
			mision = new Mision("misiones/misionOriginal.txt");
		} catch (IOException | FormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Verificar que el archivo misionOriginal.txt cargue correctamente
	 */
	@Test
	public void prueba001() {
		Assert.assertNotNull(mision);
	}

	/**
	 * Verificar el nombre del poblado propio del archivo misionOriginal.txt
	 */
	@Test
	public void prueba002() {
		Assert.assertEquals("1", Mapa.obtenerMapa().obtenerPoblados().get("1").obtenerNombre());
	}

	/**
	 * Verificar la cantidad de habitantes del poblado propio del archivo
	 * misionOriginal.txt
	 */
	@Test
	public void prueba003() {
		Assert.assertEquals(100, Mapa.obtenerMapa().obtenerPoblados().get("1").obtenerCantidadHabitantes());
	}

	/**
	 * Verificar la raza del poblado propio del archivo misionOriginal.txt
	 */
	@Test
	public void prueba004() {
		Assert.assertTrue(Mapa.obtenerMapa().obtenerPoblados().get("1").obtenerEjercito()
				.obtenerPrimeraUnidad() instanceof Wrive);
	}

	/**
	 * Verificar el bando del poblado propio del archivo misionOriginal.txt
	 */
	@Test
	public void prueba005() {
		Assert.assertEquals(Bando.PROPIO, Mapa.obtenerMapa().obtenerPoblados().get("1").obtenerBando());
	}

	/**
	 * Verificar el nombre del poblado 2 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba006() {
		Assert.assertEquals("2", Mapa.obtenerMapa().obtenerPoblados().get("2").obtenerNombre());
	}

	/**
	 * Verificar la cantidad de habitantes del poblado 2 del archivo
	 * misionOriginal.txt
	 */
	@Test
	public void prueba007() {
		Assert.assertEquals(30, Mapa.obtenerMapa().obtenerPoblados().get("2").obtenerCantidadHabitantes());
	}

	/**
	 * Verificar la raza del poblado 2 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba008() {
		Assert.assertTrue(Mapa.obtenerMapa().obtenerPoblados().get("2").obtenerEjercito()
				.obtenerPrimeraUnidad() instanceof Reralope);
	}

	/**
	 * Verificar el bando del poblado 2 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba009() {
		Assert.assertEquals(Bando.ALIADO, Mapa.obtenerMapa().obtenerPoblados().get("2").obtenerBando());
	}

	/**
	 * Verificar el nombre del poblado 3 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba010() {
		Assert.assertEquals("3", Mapa.obtenerMapa().obtenerPoblados().get("3").obtenerNombre());
	}

	/**
	 * Verificar la cantidad de habitantes del poblado 3 del archivo
	 * misionOriginal.txt
	 */
	@Test
	public void prueba011() {
		Assert.assertEquals(40, Mapa.obtenerMapa().obtenerPoblados().get("3").obtenerCantidadHabitantes());
	}

	/**
	 * Verificar la raza del poblado 3 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba012() {
		Assert.assertTrue(Mapa.obtenerMapa().obtenerPoblados().get("3").obtenerEjercito()
				.obtenerPrimeraUnidad() instanceof Nortaichian);
	}

	/**
	 * Verificar el bando del poblado 3 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba013() {
		Assert.assertEquals(Bando.ENEMIGO, Mapa.obtenerMapa().obtenerPoblados().get("3").obtenerBando());
	}

	/**
	 * Verificar el nombre del poblado 4 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba014() {
		Assert.assertEquals("4", Mapa.obtenerMapa().obtenerPoblados().get("4").obtenerNombre());
	}

	/**
	 * Verificar la cantidad de habitantes del poblado 4 del archivo
	 * misionOriginal.txt
	 */
	@Test
	public void prueba015() {
		Assert.assertEquals(60, Mapa.obtenerMapa().obtenerPoblados().get("4").obtenerCantidadHabitantes());
	}

	/**
	 * Verificar la raza del poblado 4 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba016() {
		Assert.assertTrue(Mapa.obtenerMapa().obtenerPoblados().get("4").obtenerEjercito()
				.obtenerPrimeraUnidad() instanceof Nortaichian);
	}

	/**
	 * Verificar el bando del poblado 4 del archivo misionOriginal.txt
	 */
	@Test
	public void prueba017() {
		Assert.assertEquals(Bando.ENEMIGO, Mapa.obtenerMapa().obtenerPoblados().get("4").obtenerBando());
	}

	/**
	 * Verificar el nombre del poblado inicial del archivo misionOriginal.txt
	 */
	@Test
	public void prueba018() {
		Assert.assertEquals("1", Mapa.obtenerMapa().obtenerNombrePobladoInicial());
	}

	/**
	 * Verificar el nombre del poblado final del archivo misionOriginal.txt
	 */
	@Test
	public void prueba019() {
		Assert.assertEquals("4", Mapa.obtenerMapa().obtenerNombrePobladoFinal());
	}

	/**
	 * Verificar que el nombre del poblado inicial del archivo misionOriginal.txt
	 * sea correcto
	 */
	@Test
	public void prueba020() {
		Assert.assertEquals("1", Mapa.obtenerMapa().obtenerPobladoInicial().obtenerNombre());
	}

	/**
	 * Verificar que la cantidad de habitantes del poblado inicial del archivo
	 * misionOriginal.txt sea correcto
	 */
	@Test
	public void prueba021() {
		Assert.assertEquals(100, Mapa.obtenerMapa().obtenerPobladoInicial().obtenerCantidadHabitantes());
	}

	/**
	 * Verificar que el bando del poblado inicial del archivo misionOriginal.txt sea
	 * correcto
	 */
	@Test
	public void prueba022() {
		Assert.assertTrue(
				Mapa.obtenerMapa().obtenerPobladoInicial().obtenerEjercito().obtenerPrimeraUnidad() instanceof Wrive);
	}

	/**
	 * Verificar que el bando del poblado inicial del archivo misionOriginal.txt sea
	 * correcto
	 */
	@Test
	public void prueba023() {
		Assert.assertEquals(Bando.PROPIO, Mapa.obtenerMapa().obtenerPobladoInicial().obtenerBando());
	}

	/**
	 * Intentar leer una mision sin poblados
	 */

}
