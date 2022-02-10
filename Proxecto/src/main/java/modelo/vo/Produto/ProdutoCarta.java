package modelo.vo.Produto;

import modelo.vo.Carta.Carta;
import lombok.Data;

/**
 * Clase que representa a relación produto_carta na nosa aplicación.
 */
@Data
public class ProdutoCarta {
    /**
     * Atributos de clase que representan os campos para a táboa na bbdd
     */
    private Carta carta;
    private Produto produto;
    private double prezo;
	private boolean encargo;
	private boolean especialidade;
}
