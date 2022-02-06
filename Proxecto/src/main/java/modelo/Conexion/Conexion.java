package modelo.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase na que se define a conexión a bbdd da nosa aplicación
 */
public class Conexion {
    /**
     * Atributos de clase
     */
    static String bd = "proxectofinal";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;

    Connection conn = null;

    /** Constructor de DbConnection */
    public Conexion() {
        try{
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexi�n
            conn = DriverManager.getConnection(url,login,password);

            if (conn!=null){
                System.out.println("Conexion a base de datos "+bd+" OK");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    /**Permite retornar a conexi�n*/
    public Connection getConnection(){
        return conn;
    }

    /**
     * Permite desconectarse da bbdd
     */
    public void desconectar(){
        conn = null;
    }
}
