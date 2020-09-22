import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule, MatNativeDateModule, MatSelectModule} from '@angular/material';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatDialogModule} from '@angular/material/dialog';
import {RouterModule} from '@angular/router';
import {MatStepperModule} from '@angular/material/stepper';
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './common/header/header.component';
import { LoginComponent } from './public/login/login.component';
import {LocationStrategy, PathLocationStrategy} from '@angular/common';
import { RegisterComponent } from './public/register/register.component';
import { HomeComponent } from './auth/home/home.component';
import { NotFoundComponent } from './common/not-found/not-found.component';
import {routes} from './routes';
import { MoviesComponent } from './public/movie/movies.component';
import { MovieEditorComponent } from './public/movie-editor/movie-editor.component';
import { UserAccountComponent } from './auth/user-account/user-account.component';
import { BarComponent } from './public/bar/bar.component';
import {SlickModule} from 'ngx-slick';
import {HttpService} from './common/services/http.service';
import {BarService} from './public/services/bar.service';
import {MoviesService} from './public/services/movies.service';
import { BillboardComponent } from './public/billboard/billboard.component';
import {AuthenticationService} from './common/services/authentication.service';

import {Ng2Webstorage} from 'ngx-webstorage';
import { LoaderComponent } from './common/loader/loader.component';
import { BillboardEditorComponent } from './public/billboard-editor/billboard-editor.component';
import { MovieCreatorComponent } from './public/movie-creator/movie-creator.component';
import {UserService} from './public/services/user.service';
import {AuthGuard} from './common/guards/auth.guard';
import {PublicGuard} from './common/guards/public.guard';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    NotFoundComponent,
    MoviesComponent,
    UserAccountComponent,
    BarComponent,
    BillboardComponent,
    LoaderComponent,
    MovieEditorComponent,
    BillboardEditorComponent,
    MovieCreatorComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    RouterModule.forRoot(routes),
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatStepperModule,
    SlickModule.forRoot(),
    HttpClientModule,
    Ng2Webstorage
  ],
  providers: [
    {provide: LocationStrategy, useClass: PathLocationStrategy},
    MatDatepickerModule,
    AppComponent,
    HttpService,
    BarService,
    MoviesService,
    UserService,
    AuthenticationService,
    AuthGuard,
    PublicGuard
  ],
    bootstrap: [AppComponent]
})
export class AppModule { }
