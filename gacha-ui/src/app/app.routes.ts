import { Routes } from '@angular/router';
import { BannerComponent } from './banner/banner.component';
import { LoginComponent } from './login/login.component';

export const routes: Routes = [
    {path: '', redirectTo: '/banner', pathMatch: 'full'},
    {path: 'banner', component: BannerComponent},
    {path: 'login', component: LoginComponent},
];
