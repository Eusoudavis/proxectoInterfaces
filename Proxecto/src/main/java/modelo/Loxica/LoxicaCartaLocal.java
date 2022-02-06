package modelo.Loxica;

import modelo.dao.implementacion.cartaDAO.CartaLocalDAO;
import modelo.vo.Carta.CartaLocal;

public class LoxicaCartaLocal {

    public void validarCreate (CartaLocal cartaLocal){
        CartaLocalDAO cartaLocalDAO = new CartaLocalDAO();
        cartaLocalDAO.create(cartaLocal);
    }
}
