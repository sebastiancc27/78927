using System;
using System.ServiceModel;

namespace WSDL.mensajes{
    [ServiceContract]
    public interface Mensajes{
        [OperationContract]//OPERATION CONTRAR HACE REFERENCIA A LOS METODOS
        int sumar(int num1, int num2);
        [OperationContract]//OPERATION CONTRAR HACE REFERENCIA A LOS METODOS
        
        int restar(int num1, int num2);
        [OperationContract]//OPERATION CONTRAR HACE REFERENCIA A LOS METODOS

        int multiplicar(int num1, int num2);
        [OperationContract]//OPERATION CONTRAR HACE REFERENCIA A LOS METODOS

        int dividir(int num1, int num2);
        [OperationContract]//OPERATION CONTRAR HACE REFERENCIA A LOS METODOS

        int cuadradoNumero(int num);
        [OperationContract]//OPERATION CONTRAR HACE REFERENCIA A LOS METODOS

        double potenciaNumero(int num1, int potencia);
    }

}