package prueba.razas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import armas.Arma;
import unidades.Radaiteran;

public class PruebaRadaiteran {

	private Radaiteran aliado;
	private Radaiteran enemigo;

	/**
	 * Inicializar un aliado y un enemigo Radaiteran para que peleen entre si
	 */
	@Before
	public void initialize() {
		aliado = new Radaiteran();
		enemigo = new Radaiteran();
	}

	/**
	 * Crea un Radaiteran
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
		Assert.assertEquals(36, aliado.obtenerSalud());
	}

	/**
	 * Verificar el danio de base
	 */
	@Test
	public void prueba003() {
		Assert.assertEquals(56, aliado.obtenerDanioBase());
	}

	/**
	 * Verificar el rango minimo
	 */
	@Test
	public void prueba004() {
		Assert.assertEquals(17, aliado.obtenerRangoMin());
	}

	/**
	 * Verificar el rango maximo
	 */
	@Test
	public void prueba005() {
		Assert.assertEquals(41, aliado.obtenerRangoMax());
	}

	/**
	 * Verificar el arma equipada
	 */
	@Test
	public void prueba006() {
		Assert.assertEquals(Arma.SHURIKEN, aliado.obtenerArma());
	}

	/**
	 * Verificar la cantidad de ataques iniciales
	 */
	@Test
	public void prueba007() {
		Assert.assertEquals(0, aliado.obtenerCantidadDeAtaques());
	}

	/**
	 * Verificar que no este desmayado mientras su vida sea mayor que cero
	 */
	@Test
	public void prueba008() {
		Assert.assertFalse(aliado.estaDesmayado());
	}

	/**
	 * Verificar que se desmaye si recibe un golpe que lo deje debajo de la vida
	 */
	@Test
	public void prueba009() {
		aliado.establecerSalud(1);
		enemigo.atacar(aliado);

		Assert.assertTrue(aliado.estaDesmayado());
	}

	/**
	 * Poner a un Radaiteran en modo de descanso
	 */
	@Test
	public void prueba010() {
		aliado.descansar();

		Assert.assertTrue(aliado.estaDescansando());
	}

	/**
	 * Verificar que la primera vez que ataca su danio es igual al danio base
	 */
	@Test
	public void prueba011() {
		aliado.atacar(enemigo);

		Assert.assertEquals(-20, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que la segunda vez que ataca su danio es igual al danio base mas
	 * tres
	 */
	@Test
	public void prueba012() {
		aliado.atacar(enemigo);
		aliado.atacar(enemigo);

		Assert.assertEquals(-79, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que la tercera vez que ataca su danio es igual al danio base mas
	 * dos veces tres
	 */
	@Test
	public void prueba013() {
		aliado.atacar(enemigo);
		aliado.atacar(enemigo);
		aliado.atacar(enemigo);

		Assert.assertEquals(-141, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que la cuarta vez que ataca su danio es igual al danio base mas
	 * tres veces tres
	 */
	@Test
	public void prueba014() {
		aliado.atacar(enemigo);
		aliado.atacar(enemigo);
		aliado.atacar(enemigo);
		aliado.atacar(enemigo);

		Assert.assertEquals(-206, enemigo.obtenerSalud());
	}

	/**
	 * Verificar que el Radaiteran reciba la totalidad de danio al ser atacado
	 */
	@Test
	public void prueba015() {
		enemigo.atacar(aliado);

		Assert.assertEquals(-20, aliado.obtenerSalud());
	}

	/**
	 * Verificar que el turno propio inicial es cero
	 */
	@Test
	public void prueba016() {
		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}

	/**
	 * Avanzar el turno propio
	 */
	@Test
	public void prueba017() {
		aliado.siguienteTurnoPropio();

		Assert.assertEquals(1, aliado.obtenerTurnoPropio());
	}

	/**
	 * Resetear el turno propio
	 */
	@Test
	public void prueba018() {
		aliado.siguienteTurnoPropio();
		aliado.siguienteTurnoPropio();
		aliado.resetearTurnoPropio();

		Assert.assertEquals(0, aliado.obtenerTurnoPropio());
	}
}
