import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Farmer } from '../models/farmer';
import { Observable } from 'rxjs';
import { Item } from '../models/item';


@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  baseUrl = "http://localhost:8083";

  constructor(private http :HttpClient) { }

  getFarmerByUserName(userName: any):Observable<Farmer>{
    return this.http.get<Farmer>(this.baseUrl+'/farmer/viewfarmerbyusername/'+userName);
  }

  updateFarmer(farmer:Farmer):Observable<Farmer>{
    return this.http.put<Farmer>(this.baseUrl+'/farmer/updatefarmer',farmer);
  }

  viewItemsByFarmerId(farmerid:number): Observable<Item[]>{
    return this.http.get<Item[]>(this.baseUrl+'/farmer/viewitemsbyfarmerid/'+farmerid);
  }

  addItem(item:Item):Observable<Item> {
    return this.http.post<Item>(this.baseUrl+'/item/add',item);
  }

}
