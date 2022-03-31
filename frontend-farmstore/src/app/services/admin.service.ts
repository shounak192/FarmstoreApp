import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient,private authService: AuthService) { }

  getHttpOptions(){
    let httpOptions = {};
    let userData: any = '';
    userData = this.authService.retrieveUserDetails();
    if(userData!=null){
      let userName = JSON.parse(userData).credential.userName;
      console.log(userData);
      console.log("token:" + userName);
      httpOptions =  {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': 'Bearer ' + userName
      })
    }
  }
}

private baseUrl = 'http://localhost:8083/admin';
private viewAllOrders_endpoint = this.baseUrl+'/order/list';
private viewAllFarmers_endpoint = this.baseUrl+'/farmer/list';
private viewAllSuppliers_endpoint = this.baseUrl+'/supplier/list';
private viewAllItems_endpoint = this.baseUrl+'/item/list';
private removeFarmer_endpoint = this.baseUrl+'/farmer/remove';
private removeSupplier_endpoint = this.baseUrl+'/supplier/remove';
private viewSupplierById_endpoint = this.baseUrl+'/supplier/view';
private viewFarmerById_endpoint = this.baseUrl+'/farmer/view';

getOrderList(): Observable<any>
{
  return this.http.get(`${this.viewAllOrders_endpoint}`);
}

getFarmerList(): Observable<any>
{
  return this.http.get(`${this.viewAllFarmers_endpoint}`);
}

viewFarmer(id:number):Observable<any>{
  return this.http.get(`${this.viewFarmerById_endpoint}/${id}`);
}

getSupplierList(): Observable<any>
{
  return this.http.get(`${this.viewAllSuppliers_endpoint}`);
}

viewSupplier(id:number):Observable<any>{
  return this.http.get(`${this.viewSupplierById_endpoint}/${id}`);
}

getItemList(): Observable<any>
{
  return this.http.get(`${this.viewAllItems_endpoint}`);
}

removeFarmer(id:number):Observable<any>
{
  return this.http.delete(`${this.removeFarmer_endpoint}/${id}`, { responseType: 'text' });
}

removeSupplier(id:number):Observable<any>
{
  return this.http.delete(`${this.removeSupplier_endpoint}/${id}`, { responseType: 'text' });
}

}
