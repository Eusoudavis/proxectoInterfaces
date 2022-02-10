package modelo.Loxica;

import Controlador.Coordinador;

import modelo.dao.implementacion.produtoDAO.ProdutoDAO;
import modelo.vo.Carta.Carta;
import modelo.vo.Produto.TipoBebida;
import modelo.vo.Produto.Produto;

import java.util.List;

public class LoxicaProducto {
    private Coordinador miCoordinador;
    public static boolean modifica = false;

     public List<Produto> validarFindIdTipoProdto(TipoBebida tipoBebida){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.findByIdTipoProduto(tipoBebida);
    }

    public List<Produto> validarReadProduto(Produto produto){
         ProdutoDAO produtoDAO = new ProdutoDAO();
         return produtoDAO.readProduto(produto);
    }


    public List<Produto> validarRead(){
         ProdutoDAO produtoDAO = new ProdutoDAO();
         return produtoDAO.read();
    }

    public void validaerCrearProdutoCarta(Produto produto, Carta carta){
         ProdutoDAO produtoDAO = new ProdutoDAO();
         produtoDAO.insertPordutoCarta(produto, carta);
    }

    public List<Produto> validarByName(Produto produto){
         ProdutoDAO produtoDAO = new ProdutoDAO();
         return produtoDAO.findByName(produto);
    }

    public List<Produto> validarByIdPrato(Produto produto){
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.findByIdPrato(produto);
    }
}
