import {Routes} from '@angular/router';
import {LoginComponent} from './public/login/login.component';
import {RegisterComponent} from './public/register/register.component';
import {HomeComponent} from './auth/home/home.component';
import {NotFoundComponent} from './common/not-found/not-found.component';
import {MoviesComponent} from './public/movie/movies.component';
import {UserAccountComponent} from './auth/user-account/user-account.component';
import {BarComponent} from './public/bar/bar.component';
import {BillboardComponent} from './public/billboard/billboard.component';
import {MovieEditorComponent} from './public/movie-editor/movie-editor.component';
import {BillboardEditorComponent} from './public/billboard-editor/billboard-editor.component';
import {MovieCreatorComponent} from './public/movie-creator/movie-creator.component';
import {PublicGuard} from './common/guards/public.guard';
import {AuthGuard} from './common/guards/auth.guard';

// To route to the different client urls

export const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: '/login'
  },
  {
    path: 'login', component: LoginComponent, pathMatch: 'full', canActivate: [PublicGuard]
  },
  {
    path: 'register', component: RegisterComponent, canActivate: [PublicGuard]
  },
  {
    path: 'home', redirectTo: '/billboard', canActivate: [AuthGuard]
  },
  {
    path: 'billboard', component: BillboardComponent, canActivate: [AuthGuard]
  },
  {
    path: 'billboard/edit', component: BillboardEditorComponent, canActivate: [AuthGuard]
  },
  {
    path: 'movie/:id' , component: MoviesComponent, canActivate: [AuthGuard]
  },
  {
    path: 'billboard/new-movie' , component: MovieCreatorComponent, canActivate: [AuthGuard]
  },
  {
    path: 'movie/:id/edit' , component: MovieEditorComponent, canActivate: [AuthGuard]
  },
  {
    path: 'account', component: UserAccountComponent, canActivate: [AuthGuard]
  },
  {
    path: 'bar', component: BarComponent, canActivate: [AuthGuard]
  },
  {
    path: '*', component: NotFoundComponent, canActivate: [PublicGuard]
  }
];
