package modelo.vo.Local;

import modelo.vo.Carta.Carta;
import modelo.vo.Concello.Concello;
import modelo.vo.Estado;
import lombok.Data;
import modelo.vo.Produto.ProdutoCarta;

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
	private String especialidade;
	private Concello concello;
	private Estado estado;
	/**
	 * Array de
	 */
	List<Carta> cartas;
	private int idLocal;
	private String rua;
	private int numero;
	private String telefono;
	private String email;

}