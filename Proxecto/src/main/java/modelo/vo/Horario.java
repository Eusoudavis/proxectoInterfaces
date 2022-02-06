package  modelo.vo;

import lombok.Data;

/**
 * Clase que representa o noso Horario na aplicación
 */
@Data
public class Horario {

	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idHorario;
	private int horaApertura;
	private int horaPeche;
	private String diaPeche;



}