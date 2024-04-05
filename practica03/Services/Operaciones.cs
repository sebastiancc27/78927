using System;
using WSDL.mensajes;

namespace WSDL.operaciones{//!EK NAMESPACE PERMITE QUE LA CLASE ESTE DEFINIDO EN UN CONTEXTO
//* PUEDE QUE EL NACEMSPACE NO TENGA NINGUNA RELACIÓN CON EL NOMBRE DEL ARCHIVO
    public class Operaciones : Mensajes{
    public int sumar(int num1, int num2){
        return num1+num2;
    }

    public    int restar(int num1, int num2){
        return num1-num2;
    }
        public int multiplicar(int num1, int num2){
                return num1*num2;
        }
        public int dividir(int num1, int num2){
                return num1/num2;
        }
        public int cuadradoNumero(int num){
            return num*num;
        }
        public double potenciaNumero(int num1, int potencia){
                double res = Math.Pow(num1,potencia);
                return res;
        }

    }
}