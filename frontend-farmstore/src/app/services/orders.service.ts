import { HttpClient, HttpHeaders } from '@angular/common/http';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Orders } from '../models/orders';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  constructor(private authService : AuthService,
    private http :HttpClient) { }

// getHttpOptions(){
// let httpOptions = {};
// let userData: any = '';
// userData = this.authService.retrieveUserDetails();
// if(userData!=null){
// let token = JSON.parse(userData).token;
// console.log("token:" + token);
// httpOptions =  {
// headers: new HttpHeaders({
// 'content-type': 'application/json',
// 'Authorization': 'Bearer ' + token
// })
// }
// }
// return httpOptions;
// }
  addOrder(order:Orders):Observable<Orders>{
    console.log('in service');
    console.log(order);
    return this.http.post<Orders>('http://localhost:8083/order/add',order);
  }
  viewOrder(ItemId :number): Observable<Orders[]>{
    return this.http.get<Orders[]>('http://localhost:8083/order/ItemId/'+ItemId);
  }
  deleteOrder(order:Orders): Observable<Orders[]>{
    return this.http.put<Orders[]>('http://localhost:8083/order/deleteorder',order);
  }
  viewAllOrders():Observable<Orders[]>{
    return this.http.get<Orders[]>('http://localhost:8083/order/get');
  }
  viewOrderByOrderId(orderId:number):Observable<Orders>{
    console.log(orderId);
    return this.http.get<Orders>('http://localhost:8083/order/orderId/'+orderId);
  }
}
