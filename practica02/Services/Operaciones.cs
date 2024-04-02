using System;
using System.Collections;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes
    {   
        ArrayList nombres = new ArrayList();

        public string Mostrar(int id)
        {
            string[] arrayNumeros = (string[])nombres.ToArray(typeof(string));
            string nombre = arrayNumeros[id];
            return nombre;
        }

        public string Saludar(string nombre)
        {
            string msj = "Hola " + nombre;
            nombres.Add(nombre);
            return msj;
        }
    }
}