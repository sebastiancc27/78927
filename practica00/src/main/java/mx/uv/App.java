package mx.uv;
import static spark.Spark.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        get("/", (request,response)->{
            String respuesta="<note>\r\n" + //
                                "  <to>Tove</to>\r\n" + //
                                "  <from>Jani</from>\r\n" + //
                                "  <heading>Reminder</heading>\r\n" + //
                                "  <body>Don't forget me this weekend!</body>\r\n" + //
                                "</note>";
            response.type("application/xml");
            return respuesta;
        });

        get("/xml", (request, response)->{
            Alumno alumno=new Alumno();
            alumno.setNombre("Sebastian");
            alumno.setId("7");
            XmlMapper xml = new XmlMapper();
            String  respuesta=xml.writeValueAsString(alumno);

            response.type("application/xml");

            return respuesta;
            //return "<nombre>"+respuesta.getNombre()+"</nombre>";
        });
    }
}

class Alumno{
    String nombre;
    String apellido;
    String id;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
}
