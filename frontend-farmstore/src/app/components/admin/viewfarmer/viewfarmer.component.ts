import { AdminComponent } from './../admin.component';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Farmer } from 'app/models/farmer';
import { AdminService } from 'app/services/admin.service';

@Component({
  selector: 'app-viewfarmer',
  templateUrl: './viewfarmer.component.html',
  styleUrls: ['./viewfarmer.component.css']
})
export class ViewfarmerComponent implements OnInit {

  allFarmers:Farmer[]=[];
  farmers :Farmer = new Farmer();

  registerForm !: FormGroup;

  farmerId !: FormControl;

  constructor(private adminService:AdminService,private router: Router) { 
  }

  ngOnInit(): void {
    this.farmerId = new FormControl('', [Validators.required]);
    this.registerForm = new FormGroup(
      {
        'farmerId': this.farmerId
        
      }
    );
    this.adminService.getFarmerList().subscribe(data =>{
      console.log(data);
      this.allFarmers = data;
    });
  }

  onSubmit(){
    this.adminService.viewFarmer(this.farmerId.value).subscribe(data =>{
      console.log(data);
      this.farmers = data;
      
    });
  }

  delete(farId:number)
  {
    this.adminService.removeFarmer(farId).subscribe(data=>{
     
      this.farmers = data;
      alert("Supplier Deleted")
      
  },
  err=>
  {
    alert(err.error.msg);
  }
  
  ); 
 
  }

  navigateToFarmerHome() {
    this.router.navigate(['']);
  }

}
