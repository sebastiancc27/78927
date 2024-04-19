using System;
using WSDL.mensajes;

namespace WSDL.operaciones{//!EK NAMESPACE PERMITE QUE LA CLASE ESTE DEFINIDO EN UN CONTEXTO
//* PUEDE QUE EL NACEMSPACE NO TENGA NINGUNA RELACIÓN CON EL NOMBRE DEL ARCHIVO
    public class Operaciones : Mensajes{
     public double caf(double gradosC)
        {
           // Console.WriteLine("Input data. IntProperty: {0}, StringProperty: {1}", inputModel.IntProperty, inputModel.StringProperty);
            return  (gradosC*1.8)+32;
        }

        public double fac(double gradosF)
        {
           // Console.WriteLine("Input data. IntProperty: {0}, StringProperty: {1}", inputModel.IntProperty, inputModel.StringProperty);
            return  (gradosF-32)*0.5556;
        }

    }
}