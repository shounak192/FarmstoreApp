import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(private httpClient: HttpClient) { }

  public addItem(item:Item):Observable<any> {
    console.log("In service: ");
    console.log(item);
    return this.httpClient.post("http://localhost:8083/item/add/",item);
  }

  public updateItem(item:Item):Observable<any> {
    console.log("In service: ");
    console.log(item);
    return this.httpClient.put("http://localhost:8083/item/update/",item);
  }

  public removeItem(itemId:number):Observable<Item[]> {
    console.log("In service: ");
    return this.httpClient.get<Item[]>("http://localhost:8083/item/delete/"+itemId);
  }

  public verfiyItem(itemId:number):Observable<any> {
    console.log("In service: ");
    return this.httpClient.put("http://localhost:8083/item/verify",{},{params: {itemId: itemId}});
  }

  public browseItems():Observable<any> {
    console.log("In service: ");
    return this.httpClient.get("http://localhost:8083/item/view/all");
  }

  public viewItems(id:number):Observable<Item[]> {
    console.log("Reached service: ");
    return this.httpClient.get<Item[]>("http://localhost:8083/farmer/viewitemsbyfarmerid/"+id);
  }

  public viewAllItems():Observable<any> {
    console.log("Reached service: ");
    return this.httpClient.get("http://localhost:8083/admin/item/list");
  }
}
