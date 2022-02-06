import modelo.vo.Produto.Bebida;
import modelo.vo.Produto.Produto;
import modelo.vo.Produto.TipoBebida;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Produto bebidas222 = new Bebida();

        int[] tipoBebidasArray = {
                6, 6,11,12,9,8,8,8,8,10,13,14,11,9};
        String[] fabricanteArray = {
                "Cabreiroa","Cabreiroa",
                "Hornimans","Lavazza",
                "Fanta","Mar de Frades",
                "Alma Atlantica", "Emina Rose",
                "Rectoral de Amandi", "Juver","Puleva",
                "TxinTxon","Hornimans","Schweppes"};
        int[] produtoArray = {
               19,20,21,22,23,24,25,26,27,28,29,30,31,32};

        List<TipoBebida> tipoBebidaList = new ArrayList<>();
        TipoBebida tipoBebida = new TipoBebida();
        List<Produto> produtosList = new ArrayList<Produto>();
        Produto bebida = new Bebida();


        for (int i = 0; i < produtoArray.length; i++) {
            for (int j = 0; j < tipoBebidasArray.length; j++) {
                for (int k=0; k< fabricanteArray.length; k++)
                if (i == j && j == k) {
                    bebida.setId(produtoArray[i]);
                    produtosList.add(bebida);

                    tipoBebida.setIdTipoBebida(tipoBebidasArray[j]);
                    tipoBebidaList.add(tipoBebida);

                    //String fabricante = fabricanteArray[k];
                    System.out.println("Insert into bebida values (" +  bebida.getId()  +", '"
                            + fabricanteArray[k] + "', " + tipoBebida.getIdTipoBebida() + ");");


                }
            }
        }




//        String[] productosBebidas = {"auga c/gas", "auga s/gas","camomila","cafe con leite","refresco laranxa",
//                "viño branco", "espumoso", "rosado",
//                "tinto", "zume laranxa", "batido chocolate", "margarita", "te vermello","tonica"};
//
//        File fileTipoBebida = new File("ProdutosBebidas.txt");
//
//        List<Produto> produtosList1 = new ArrayList<Produto>();
//
//        try {
//            FileWriter fwTipoBebida = new FileWriter(fileTipoBebida, true);
//            BufferedWriter bfTipoBebida = new BufferedWriter(fwTipoBebida);
//
//            for (String prod : productosBebidas
//            ) {
//                Produto produto = new Bebida();
//                bebida.setNome(prod);
//                produtosList.add(bebida);
//
//                bfTipoBebida.write("Insert into produto (nome_produto) values ('" + prod + "');");
//                System.out.println("Insert into produto (nome_produto) values ('" + prod + "');" );
//
//                bfTipoBebida.newLine();
//            }
//            bfTipoBebida.flush();
//            bfTipoBebida.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
    }
//        String arrayInsertBebida[][] = {
//                {
//                "auga", "auga c/gas"},
//                {"auga", "auga s/gas"},
//                {"infusion","camomila"},
//                {"cafe", "cafe con leite"},
//                {"refresco", "refresco laranxa"},
//                {"viño","vinho branco"},
//                {"viño", "espumoso"},
//                {"viño", "rosado"},
//                {"viño", "tinto"},
//                { "zume", "zume laranxa"},
//                {"batido","batido chocolate"},
//                {"cocktail", "margarita"},
//                {"infusion","te vermello"},
//                {"refresco","tonica"},
//        };
//
//        for (int i=0; i<arrayInsertBebida.length; i++){
//            for (int j = 0; j<arrayInsertBebida[0].length;j++){
//            System.out.println(arrayInsertBebida[i][j]);
//
//            }
//        }
//        for (int i=0; i<arrayInsertBebida[0].length; i++){
//            System.out.println(arrayInsertBebida[1][i]);
//        }

//        File fileTipoBebida = new File("TipoBebida.txt");
//
//        String[] tiposDeBebidas = {"cervexa", "auga", "Combinado", "viño", "refresco", "zume", "infusion", "cafe", "batido", "cocktail"};
//        List<TipoBebida> tipoBebidaList = new ArrayList<>();
//


//        try {
//            FileWriter fwTipoBebida = new FileWriter(fileTipoBebida, true);
//            BufferedWriter bfTipoBebida = new BufferedWriter(fwTipoBebida);
//
//        List<TipoBebida> tipoBebidaList = new ArrayList<>();

//            for (String nomeTipoBebida : tiposDeBebidas
//            ) {

//                TipoBebida tipoBebida = new TipoBebida();
//                tipoBebida.setNomeTipoBebida(nomeTipoBebida);
//                tipoBebidaList.add(tipoBebida);
//
//                bfTipoBebida.write("Insert into tipo_bebida (nome_tipo_bebida) values ('" + nomeTipoBebida + "');");
//                System.out.println("Insert into tipo_bebida (nome_tipo_bebida) values ('" + nomeTipoBebida + "');" );
//
//                bfTipoBebida.newLine();
//            }
//            bfTipoBebida.flush();
//            bfTipoBebida.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//