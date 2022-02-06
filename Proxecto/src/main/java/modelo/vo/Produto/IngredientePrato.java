package modelo.vo.Produto;

import lombok.Data;

@Data
public class IngredientePrato {
    protected  Prato prato;
    protected  Ingrediente ingrediente;
}
