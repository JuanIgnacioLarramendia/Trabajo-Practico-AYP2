package ejercito;

public interface Tropa {

	public abstract void atacar(Tropa objetivo);

	public abstract void descansar();

	public abstract void recibirAtaque(int ataque);

	public abstract boolean estaDesmayado();

	public abstract void siguienteTurnoContiguo();

	public abstract void resetearTurnoContiguo();
}
