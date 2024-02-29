import { Routes } from '@angular/router';
import { BannerComponent } from './pages/banner/banner.component';
import { LoginComponent } from './pages/login/login.component';
import { authGuard } from './utils/auth.guard';
import { UserDetailsComponent } from './pages/user-details/user-details.component';

export const routes: Routes = [
    // {path: '', redirectTo: 'banner', pathMatch: 'full'},
    {path: 'user-details', component: UserDetailsComponent, canActivate: [authGuard]},
    {path: 'banner', component: BannerComponent, canActivate: [authGuard]},
    {path: 'login', component: LoginComponent},
];
