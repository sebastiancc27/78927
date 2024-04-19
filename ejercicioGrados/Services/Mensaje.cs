using System;
using System.ServiceModel;

namespace WSDL.mensajes{
    [ServiceContract]
    public interface Mensajes{
    [OperationContract]
        double caf(double s);

    [OperationContract]
        double fac(double s);
    }

}