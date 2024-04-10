# instalar el framework .net versión 5
from mcr.microsoft.com/dotnet/sdk
# clonar el repositorio del servicio
run git clone https://github.com/sebastiancc27/78927
# independizarlo para simplificar rutas
run mv /78927/practica03 /app
workdir /app
expose 5000
# defino el entry point
cmd ["dotnet", "run"]
# instalar el paquete SoapCore
run dotnet add package SoapCore
run dotnet dev-certs https --clean
run dotnet dev-certs https -t