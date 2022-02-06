package modelo.vo.Usuario;

import modelo.vo.Concello.Concello;
import modelo.vo.Estado;
import lombok.Data;

/**
 * Clase que representa o usuario base na nosa aplicación
 */
@Data
public abstract class Usuario {
	/**
	 * Atributos de clase que representan os campos para a táboa na bbdd
	 */
	private int idUsuario;
	private String nome;
	private String apelido1;
	private String apelido2;
	private Concello concello;
	private String contrasinal;
	private Estado estado;
	private String rua;
	private int numero;
	private String telefono;
	private String email;
	private String rol;

}