
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Supplier } from 'app/models/supplier';
import { AdminService } from 'app/services/admin.service';

@Component({
  selector: 'app-viewsupplier',
  templateUrl: './viewsupplier.component.html',
  styleUrls: ['./viewsupplier.component.css']
})
export class ViewsupplierComponent implements OnInit {

  constructor(private adminService:AdminService,private router: Router) { 
  }

  allSuppliers:Supplier[]=[];
  suppliers :Supplier= new Supplier();

  ngOnInit(): void {

    this.adminService.getSupplierList().subscribe(data =>{
      console.log(data);
      this.allSuppliers = data;
    });
  }

  delete(supId:number)
  {
    this.adminService.removeSupplier(supId).subscribe(data=>{
     
      this.suppliers = data;
      alert("Supplier Deleted ")
      
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
