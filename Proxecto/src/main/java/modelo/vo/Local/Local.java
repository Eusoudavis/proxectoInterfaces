package modelo.vo.Local;

import modelo.vo.Carta.Carta;
import modelo.vo.Concello.Concello;
import modelo.vo.Estado;
import modelo.vo.Horario;
import modelo.vo.Produto.Produto;
import lombok.Data;

import java.util.List;

@Data
public class Local {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private String nomeLocal;
	/**
	 * ArrayList<TipoLocal>
	 */
	List<TipoLocal> tipoLocalList;
	//private TipoLocal tipo;
	private Produto especialidade;
	private Concello concello;
	private double rangoPrezos;
	private Horario idHorario;
	private Estado estado;
	/**
	 * Array de
	 */
	List<Carta> cartas;
	//private Carta carta;
	private int idLocal;
	private String rua;
	private int numero;
	private String telefono;
	private String email;
}