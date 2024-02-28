import { HttpInterceptorFn } from "@angular/common/http";

export const interceptor: HttpInterceptorFn = (request, next) => {
    
    const token = localStorage.getItem("token") ?? '';
    request = request.clone({
        setHeaders: {
            Authorization: token ? `Bearer ${token}` : '',
        }
    })

    return next(request);
}