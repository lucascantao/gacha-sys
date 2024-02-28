import { Routes } from '@angular/router';
import { BannerComponent } from './banner/banner.component';
import { LoginComponent } from './login/login.component';
import { authGuard } from './utils/auth.guard';

export const routes: Routes = [
    {path: '', redirectTo: '/banner', pathMatch: 'full'},
    {path: 'banner', component: BannerComponent, canActivate: [authGuard]},
    {path: 'login', component: LoginComponent},
];
