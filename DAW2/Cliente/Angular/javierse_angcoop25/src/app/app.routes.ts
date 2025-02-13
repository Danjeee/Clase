// Importa la interfaz Routes desde '@angular/router'.
// Esto se utiliza para definir las rutas de la aplicación.
import { Routes } from '@angular/router';

// Importa los componentes a los que se navegará según las rutas.
import { LoginComponent } from './components/login/login.component';
import { RegistroSocioComponent } from './components/registro-socio/registro-socio.component';
import { GaleriaArticulosComponent } from './components/galeria-articulos/galeria-articulos.component';
import { VenderComponent } from './components/vender/vender.component';

// Define un array de objetos con la forma { path: string, component: any },
// que representan la configuración de rutas de la aplicación.
export const routes: Routes = [
  // Redirecciona la ruta raíz ('') a '/login'.
  // El pathMatch: 'full' indica que debe coincidir exactamente con ''.
  { path: '', redirectTo: '/login', pathMatch: 'full' },

  // Ruta para la página de login. Al navegar a '/login' se carga LoginComponent.
  { path: 'login', component: LoginComponent },

  // Ruta para el registro de socio. Al navegar a '/registrosocio' se carga RegistroSocioComponent.
  { path: 'registrosocio', component: RegistroSocioComponent },

  // Ruta para la galería de artículos. Al navegar a '/galeria' se carga GaleriaArticulosComponent.
  { path: 'galeria', component: GaleriaArticulosComponent },

  { path: 'vender', component: VenderComponent },

  // Ruta comodín. Si el usuario intenta acceder a una ruta que no existe,
  // se redirecciona automáticamente a '/login'.
  { path: '**', redirectTo: '/login' },
];
