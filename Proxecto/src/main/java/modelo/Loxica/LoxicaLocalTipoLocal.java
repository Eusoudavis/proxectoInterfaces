package modelo.Loxica;

import modelo.dao.implementacion.localDAO.LocalTipoLocalDAO;
import modelo.vo.Local.LocalTipoLocal;

public class LoxicaLocalTipoLocal {

    public void validarCreate (LocalTipoLocal localTipoLocal){
        LocalTipoLocalDAO localTipoLocalDAO = new LocalTipoLocalDAO();
        localTipoLocalDAO.create(localTipoLocal);
    }
}
