//Este archivo define la configuración principal de una aplicación Angular
// utilizando la API de standalone introducida en Angular 14 (y versiones posteriores).
// En lugar de usar módulos (NgModule), se define un objeto ApplicationConfig
// que contiene varios providers fundamentales para la aplicación.
// Este objeto luego puede ser pasado a la función bootstrapApplication() (normalmente en el main.ts)
// para iniciar la aplicación.

import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
//ApplicationConfig: Tipo de dato que describe la configuración de la aplicación.
//provideZoneChangeDetection: Proveedor que configura el comportamiento de la detección de cambios usando Zones.

import { provideRouter } from '@angular/router';
//provideRouter: Proveedor que configura el enrutamiento (routing) con un conjunto de rutas dado.

import { routes } from './app.routes';
//routes: El arreglo de rutas definidas en el archivo app.routes.ts.

import { provideHttpClient } from '@angular/common/http';
// provideHttpClient: Proveedor que habilita el uso de HttpClient para peticiones HTTP en la aplicación.

export const appConfig: ApplicationConfig = {
  //appConfig: Se exporta un objeto que cumple con la interfaz ApplicationConfig.
  providers: [
    //providers: Arreglo de servicios y configuraciones que se agregan al injector principal de la aplicación.

    provideZoneChangeDetection({ eventCoalescing: true }),
    //provideZoneChangeDetection({ eventCoalescing: true }): Activa la detección de cambios (change detection) basada en Zonas (Zones) en Angular.
    //La opción eventCoalescing: true optimiza la detección de cambios agrupando (o "coalesciendo")
    // varios eventos cercanos en el tiempo en una sola verificación de detección de cambios.
    // Esto puede mejorar el rendimiento en escenarios con muchos eventos.

    provideRouter(routes),
    //provideRouter(routes): Registra el servicio de enrutador principal de Angular.
    // Usa el arreglo de rutas importado de ./app.routes para definir cómo se navega dentro de la aplicación.

    provideHttpClient(),
    // provideHttpClient(): Habilita el servicio HttpClient, que se utiliza
    // para hacer solicitudes HTTP (GET, POST, etc.) hacia APIs o servicios externos desde Angular.
  ],
};
