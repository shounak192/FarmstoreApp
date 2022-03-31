import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { UserType } from '../models/userType';
import { Farmer } from '../models/farmer';
import { Supplier } from '../models/supplier';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http : HttpClient ) { }

  public registerFarmer(farmer : Farmer):Observable<any>{
    return this._http.post("http://localhost:8083/register/farmer",farmer);
  }

  public registerSupplier(supplier : Supplier):Observable<any>{
    return this._http.post("http://localhost:8083/register/supplier",supplier);
  }

}
