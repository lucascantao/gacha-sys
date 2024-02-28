import { inject } from "@angular/core"
import { Router } from "@angular/router"
import { AutenticacaoService } from "../service/autenticacao.service";

export const authGuard = () => {
    const router = inject(Router);
    const autenticacaoService = inject(AutenticacaoService);

    console.log(autenticacaoService.isAuthenticated())

    if (autenticacaoService.isAuthenticated()){
        return true;
    } else {
        router.navigateByUrl('/login')
        return false;
    }
    
}