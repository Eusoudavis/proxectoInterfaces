package modelo.Loxica;

import modelo.dao.implementacion.cartaDAO.CartaDAO;
import modelo.vo.Carta.Carta;
import modelo.vo.Local.Local;

import java.util.List;

/**
 * Clase que representa a LoxicaCarta na aplicación
 */
public class LoxicaCarta {

    public List<Carta> validarFindByIdLocal(Local local) {
        CartaDAO cartaDAO = new CartaDAO();
        return cartaDAO.findByIdLocal(local);
    }

    public Carta validarBuscarPorNome(Carta carta) {
        CartaDAO cartaDAO = new CartaDAO();
        return cartaDAO.findByNomeCarta(carta);
    }

    public void validarCreate(Carta carta) {
        CartaDAO cartaDAO = new CartaDAO();
        cartaDAO.create(carta);
    }

    public Carta validarFindIdMax(Carta carta) {
        CartaDAO cartaDAO = new CartaDAO();
        return cartaDAO.findByIdMax(carta);
    }
}
