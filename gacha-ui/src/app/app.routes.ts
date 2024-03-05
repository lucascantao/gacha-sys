import { Routes } from '@angular/router';
import { BannerComponent } from './pages/banner/banner.component';
import { LoginComponent } from './pages/login/login.component';
import { authGuard } from './utils/auth.guard';
import { UserDetailsComponent } from './pages/user-details/user-details.component';
import { CreateBannerComponent } from './pages/create-banner/create-banner.component';

export const routes: Routes = [
    {path: '', redirectTo: '/login', pathMatch: 'full'},
    {path: 'user-details', component: UserDetailsComponent, canActivate: [authGuard]},
    {path: 'banner', component: BannerComponent, canActivate: [authGuard]},
    {path: 'create-banner', component: CreateBannerComponent, canActivate: [authGuard]},
    {path: 'login', component: LoginComponent},
];
