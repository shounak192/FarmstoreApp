import { Component, OnInit } from '@angular/core';
import {NgForm, FormControl, FormGroup, Validators  } from '@angular/forms';
import { Router } from "@angular/router";
import { Credentials } from 'app/models/credential';
import { Farmer } from 'app/models/farmer';
import { Supplier } from 'app/models/supplier';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { LoginService } from 'app/services/login.service';
import { SupplierService } from 'app/services/supplier.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credential:Credentials= new Credentials();
  errorResponse: string='';
  user:string='';
  token:string='';
  farmer: Farmer = new Farmer();
  supplier: Supplier = new Supplier();

  constructor(private router: Router, private authService: AuthService, private supplierService: SupplierService) { }

  ngOnInit(): void {
    sessionStorage.clear();
  }

  login(){
    console.log(this.credential);
      this.authService.authenticate(this.credential).subscribe((response) => {
        console.log(response);
        this.user= response.response.msg;
        this.token = response.jwttoken;
        this.credential = response.credential;

        this.authService.storeCredentialsDetails(JSON.stringify(this.credential));
          this.authService.setUserName(this.credential.userName);
          this.authService.setRole(JSON.stringify(this.credential.userType));
        
        if(this.user==='Farmer'){
          this.authService.setUsertype('1');
          this.router.navigate(['farmer']);
        }
       else if(this.user==='Supplier'){
        this.authService.setUsertype('2');
          this.router.navigate(['supplier']);
        }
        else if(this.user==='Admin'){
          console.log("...");
          this.authService.setUsertype('0');
          this.router.navigate(['admin']);
        }
        // this.authService.storeCredentialsDetails(JSON.stringify(response));
        
      },
      (err) => {
        this.errorResponse = err.error.message;
        console.log(err);
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: this.errorResponse
        })
        console.log(this.errorResponse);
      })
    }


    navigateToRegister() {
      this.router.navigate(['registration-component'])
    }
}


