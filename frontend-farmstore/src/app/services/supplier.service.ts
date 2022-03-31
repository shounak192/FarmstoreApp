import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { Supplier } from '../models/supplier';
import { Orders } from 'app/models/orders';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  constructor(private http: HttpClient,private authService: AuthService) { }
  supplier:Supplier=new Supplier();
  supplierName:string ='';
  userName:string='';

  viewDetails(userName:string):Observable<any>{
    let url = "http://localhost:8083/supplier/viewDetails";
     return this.http.get(url+"/"+userName);
  }

  updateDetails(supplier:Supplier):Observable<Supplier>{
    let url = "http://localhost:8083/supplier/updateDetails/";
    return this.http.put<Supplier>(url,supplier);
  }

  viewOrders(supplierId:number):Observable<Orders[]>{
    let url = "http://localhost:8083/supplier/viewOrders";
    return this.http.get<Orders[]>(url+"/"+supplierId);
  }

  
  
  
}
