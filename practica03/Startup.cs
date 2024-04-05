using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.DependencyInjection;

using WSDL.operaciones;
using WSDL.mensajes;
using SoapCore;
using Microsoft.Extensions.DependencyInjection.Extensions;

namespace soap_test
{
    public class Startup
    {
        // This method gets called by the runtime. Use this method to add services to the container.
        // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        public void ConfigureServices(IServiceCollection services)
        {
            services.TryAddSingleton<Mensajes, Operaciones>();//RELACIONA MENSAJES CON OPERACIONES
            //services.TryAddSingleton<Mensajes, Operaciones>(); SE PUEDEN AÑADIR MÁS WEB SERVICES 
            //AÑADIENDO MÁS ENLACES ENTRE CLASES 

            services.AddMvc();
        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, Microsoft.Extensions.Hosting.IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
                app.UseSoapEndpoint<Mensajes>("/soap.asmx", new SoapEncoderOptions(),SoapSerializer.XmlSerializer);
/*                app.UseSoapEndpoint<Mensajes>("/soap.asmx", new SoapEncoderOptions(),SoapSerializer.XmlSerializer);
SE PUEDEN AÑADIR MÁS RUTAS AÑADIENDO MÁS ENLACES
*/

            }

            app.Run(async (context) =>
            {
                await context.Response.WriteAsync("<a href='/soap.asmx'>Para consumir WSDL</a>");
            });
        }
    }
}