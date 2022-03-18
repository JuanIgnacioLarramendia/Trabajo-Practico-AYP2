package prueba.razas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import armas.Arma;
import unidades.Reralope;

public class PruebaReralopes {

	private Reralope aliado;
	private Reralope enemigo;

	/**
	 * Inicializar un aliado y un enemigo Reralopes para que peleen entre si
	 */
	@Before
	public void initialize() {
		aliado = new Reralope();
		enemigo = new Reralope();
	}

	/**
	 * Crea un Reralopes
	 */
	@Test
	public void prueba001() {
		Assert.assertNotNull(aliado);
	}

	/**
	 * Verificar la salud inicial
	 */
	@Test
	public void prueba002() {
		Assert.assertEquals(53, aliado.obtenerSalud());
	}

	/**
	 * Verificar el danio de base
	 */
	@Test
	public void prueba003() {
		Assert.assertEquals(27, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar el rango minimo
	 */
	@Test
	public void prueba004() {
		Assert.assertEquals(5, aliado.obtenerRangoMin());
	}

	/**
	 * Verificar el rango maximo
	 */
	@Test
	public void prueba005() {
		Assert.assertEquals(46, aliado.obtenerRangoMax());
	}

	/**
	 * Verificar el arma equipada
	 */
	@Test
	public void prueba006() {
		Assert.assertEquals(Arma.CATAPULTA, aliado.obtenerArma());
	}

	/**
	 * Verificar que no este desmayado mientras su vida sea mayor que cero
	 */
	@Test
	public void prueba007() {
		Assert.assertFalse(aliado.estaDesmayado());
	}

	/**
	 * Verificar que se desmaye si recibe un golpe que lo deje debajo de la vida
	 */
	@Test
	public void prueba008() {
		aliado.establecerSalud(1);
		enemigo.atacar(aliado);

		Assert.assertTrue(aliado.estaDesmayado());
	}

	/**
	 * Poner a un Reralopes en modo de descanso
	 */
	@Test
	public void prueba009() {
		aliado.descansar();
		Assert.assertTrue(aliado.estaDescansando());
	}

	/**
	 * Verificar si un Reralopes esta desconcentrado
	 */
	@Test
	public void prueba010() {
		Assert.assertFalse(aliado.estaConcentrado());
	}

	/**
	 * Verificar que el turno propio inicial es cero
	 */
	@Test
	public void prueba011() {
		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Avanzar el turno propio
	 */
	@Test
	public void prueba012() {
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(1, aliado.obtenerTurnoPropio());
	}

	/**
	 * Resetear el turno propio
	 */
	@Test
	public void prueba013() {
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();
		aliado.resetearTurnoPropio();

		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Verificar si un Reralopes se desconcentra al recibir danio
	 */
	@Test
	public void prueba014() {
		aliado.descansar();
		enemigo.atacar(aliado);

		Assert.assertFalse(aliado.estaConcentrado());
	}

	/**
	 * Verificar que acierte su primer golpe
	 */
	@Test
	public void prueba015() {
		aliado.atacar(enemigo);

		Assert.assertEquals(26, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que falle su segundo golpe
	 */
	@Test
	public void prueba016() {
		for (int i = 0; i < 2; i++) {
			aliado.atacar(enemigo);
		}

		Assert.assertEquals(26, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que acierte su tercer golpe
	 */
	@Test
	public void prueba017() {
		for (int i = 0; i < 3; i++) {
			aliado.atacar(enemigo);
		}

		Assert.assertEquals(-1, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que falle su cuarto golpe
	 */
	@Test
	public void prueba018() {
		for (int i = 0; i < 4; i++) {
			aliado.atacar(enemigo);
		}

		Assert.assertEquals(-1, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que estando descansado, su danio base sea el doble
	 */
	@Test
	public void prueba019() {
		aliado.descansar();

		Assert.assertEquals(54, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar que estando descansado, luego de un turno propios el danio base
	 * siga duplicado
	 */
	@Test
	public void prueba020() {
		aliado.descansar();
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(54, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar que estando descansado, luego de dos turnos propios el danio base
	 * siga duplicado
	 */
	@Test
	public void prueba021() {
		aliado.descansar();
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(54, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar que estando descansado, luego de tres turnos propios el danio base
	 * vuelva a su valor original
	 */
	@Test
	public void prueba022() {
		aliado.descansar();
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(27, aliado.obtenerDanioBase());
	}

}
