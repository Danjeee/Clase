import { bootstrapApplication } from '@angular/platform-browser';
// Importa la función bootstrapApplication desde @angular/platform-browser.
// Esta función permite iniciar la aplicación Angular en modo standalone,
// sin requerir la estructura tradicional de NgModules.

import { appConfig } from './app/app.config';
// Importa la configuración de la aplicación (ApplicationConfig) desde app.config.
// Esta configuración normalmente incluye proveedores de servicios como el router,
// HttpClient o configuraciones de Zone.

import { AppComponent } from './app/app.component';
// Importa el componente raíz de la aplicación.
// Este componente es el punto de entrada de la interfaz de usuario.

bootstrapApplication(AppComponent, appConfig).catch((err) =>
  console.error(err)
);
//Llama a bootstrapApplication, pasando el componente raíz (AppComponent) y la configuración
// de la aplicación (appConfig). Esto arranca la aplicación Angular, configurando el enrutador,
// HttpClient y cualquier otro servicio declarado en la configuración.
// Si ocurre algún error durante el arranque, se captura y se muestra en la consola.
