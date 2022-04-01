import { Injectable } from '@angular/core';
import { UserType } from '../models/userType';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Credentials } from 'app/models/credential';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  role :string ='';
  constructor(private httpClient: HttpClient) { }
  Usertype : UserType= UserType.SUPPLIER;

  authenticate(credential: Credentials): Observable<any>{
    return this.httpClient.post<any>('http://localhost:8083/login',credential).pipe(
     map(
       userData => {
        sessionStorage.setItem('username', credential.userName);
        let tokenStr= 'Bearer '+userData.token;
        sessionStorage.setItem('token', tokenStr);
        return userData;
       }
     )

    );
  }

  storeCredentialsDetails(credentialData: string){
    sessionStorage.setItem('credentialData', credentialData);
  }

  retrieveCredentialDetails(){
    return sessionStorage.getItem('credentialData');
  }

  getToken(){ 
    return sessionStorage.getItem('token');
  }

  removeUserDetails(){
    sessionStorage.removeItem('userData');
  }
  
  setUsertype(usertype :string){
    sessionStorage.setItem('Usertype',usertype);
  }

  setUserName(username: string){
    sessionStorage.setItem('username',username);
  }

  getUserName(){
    return sessionStorage.getItem('username');
  }
  
  getUsertype (){
    return sessionStorage.getItem('Usertype');
  }
  
  removeUsertype(){
    sessionStorage.removeItem('Usertype');
  }
  storeUserDetails(userData: string){
    sessionStorage.setItem('userData', userData);
  }

  retrieveUserDetails(){
    return sessionStorage.getItem('credentialData');
  }
  setRole(role:string){
    sessionStorage.setItem('role', role);
  }
  getRole (){
    return sessionStorage.getItem('role');
  }
  removeRole(){
    sessionStorage.removeItem('role');
  }
}

export class User{
  constructor(
    public status:string,
     ) {}
  
}

export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
  
}
