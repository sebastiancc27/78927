package mx.uv.demo;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.BuscarSaludosResponse;
import mx.uv.t4is.saludos.SaludarRequest;
import mx.uv.t4is.saludos.SaludarResponse;
import mx.uv.t4is.saludos.BuscarSaludosResponse.Saludos;

import java.util.ArrayList;
import java.util.List;
import java.util.List.*;

import javax.swing.text.html.parser.Element;
//CADA VEZ QUE LLEGUE UN SALUDO SE GUARDA EN UN ESTRUCTURA
@Endpoint
public class SaludosEndPoint {

    //ArrayList<String> saludos=new ArrayList<String>();
    //List<BuscarSaludosResponse.Saludos> saludos = new ArrayList<>();
    ArrayList<BuscarSaludosResponse.Saludos> saludosResponseList = new ArrayList<>();

    int i=0;
    //!SALUDAR REQUEST HACE ALUCIÓN A LA CLASE PARA LLAMAR AL METODO
    @PayloadRoot(localPart = "SaludarRequest",namespace = "t4is.uv.mx/saludos")
    @ResponsePayload 
    public SaludarResponse saludar(@RequestPayload SaludarRequest peticion) {
        SaludarResponse respuesta = new SaludarResponse();           
        respuesta.setRespuesta("Hola " + peticion.getNombre());//GUARDAR EL VALOR DE PETICION.GETNOMBRE        
        Saludos saludo = new Saludos();
        saludo.setId(i);
        saludo.setNombre(peticion.getNombre());       

        saludosResponseList.add(saludo);
        System.out.println("SALUDO AGREGADO CORRECTAMENTE");
        i++;
        return respuesta;
    }
        
    //?localpart = defiinir el nombre del msj que dispara la invocación
        @PayloadRoot(localPart = "BuscarSaludosRequest",namespace = "t4is.uv.mx/saludos")
     // LA RESPUESTA NOS LA VA A CONVERTIR EN EL FORMATO QUE CORRESPONDA
         @ResponsePayload // LA FUNCIÓN SE COVIERTE EN UN XML O SERIALIZARLA         
         public BuscarSaludosResponse buscarSaludos() {
            BuscarSaludosResponse respuesta= new BuscarSaludosResponse();  
            for(int i=0;i < saludosResponseList.size();i++) {
                    //System.out.println(saludosResponseList.get(i).getNombre());
                    respuesta.getSaludos().add(saludosResponseList.get(i));
            }
            return respuesta;
        }
}
