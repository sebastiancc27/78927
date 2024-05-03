package com.example.practica06;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mx.uv.t4is.saludos.BusacrOperacionResponse;
import mx.uv.t4is.saludos.CelciusRequest;
import mx.uv.t4is.saludos.CelciusResponse;
import mx.uv.t4is.saludos.FahrenheitRequest;
import mx.uv.t4is.saludos.FahrenheitResponse;
import mx.uv.t4is.saludos.BusacrOperacionResponse.Operacion;

@Endpoint
public class ConvertidorEndPoint {
 
    ArrayList<BusacrOperacionResponse.Operacion > resultados = new ArrayList<>();
    int i=0;

    @PayloadRoot(localPart = "CelciusRequest",namespace = "t4is.uv.mx/saludos")
    @ResponsePayload 
    public CelciusResponse celciusFarenheit (@RequestPayload CelciusRequest grados){
        Operacion operacion = new Operacion();
        CelciusResponse respuesta= new CelciusResponse();
        double respuestaF= (grados.getGrados() * 1.8)+32;
        respuesta.setGrados(respuestaF);

        operacion.setId(String.valueOf(i));
        operacion.setOperacion("C-F");
        operacion.setRes(Double.toString(respuestaF));

        resultados.add(operacion);
        System.out.println("operacion agregada");

        return respuesta;
    } 

    @PayloadRoot(localPart = "FahrenheitRequest",namespace = "t4is.uv.mx/saludos")
    @ResponsePayload 
    public FahrenheitResponse celciusFarenheit (@RequestPayload FahrenheitRequest grados){
        FahrenheitResponse respuesta= new FahrenheitResponse();
        Operacion operacion=new Operacion();
        double respuestaF= (grados.getGrados() -32)/1.8;
        respuesta.setGrados(respuestaF);

        operacion.setId(String.valueOf(i));
        operacion.setOperacion("F-C");
        operacion.setRes(Double.toString(respuestaF));
        resultados.add(operacion);
    System.out.println("operacion agregada");
        return respuesta;
    } 

    @PayloadRoot(localPart = "BuscarOperacionRequest",namespace = "t4is.uv.mx/saludos")
    @ResponsePayload 
    public BusacrOperacionResponse mostrarHistorial (){
        BusacrOperacionResponse respuesta = new BusacrOperacionResponse();
        for(int i=0;i<resultados.size();i++){
            respuesta.getOperacion().add(resultados.get(i));
        }
        return respuesta;
    }
}
