import { Credentials } from '../models/credential';
import { Supplier } from '../models/supplier';
import { UserType } from '../models/userType';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Farmer } from 'app/models/farmer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = 'http://localhost:8083';
  constructor(private http: HttpClient) { }

  login(credential: Credentials): Observable<any> {
    return this.http.post(this.baseUrl + '/login', credential);
  }



}
