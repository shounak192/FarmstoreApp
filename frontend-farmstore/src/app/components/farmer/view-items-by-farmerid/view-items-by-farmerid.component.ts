import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { AuthService } from 'app/services/auth.service';
import { FarmerService } from 'app/services/farmer.service';


@Component({
  selector: 'app-view-items-by-farmerid',
  templateUrl: './view-items-by-farmerid.component.html',
  styleUrls: ['./view-items-by-farmerid.component.css']
})
export class ViewItemsByFarmeridComponent implements OnInit {

  itemList: Item[] = [];
  farmer: Farmer = new Farmer();
  userName: string ='';
  
  constructor(
    private farmerService: FarmerService, 
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthService
    
  ) {}

  ngOnInit() {
    this.userName = this.authService.getUserName() as string;
    console.log(this.userName);
    this.farmerService.getFarmerByUserName(this.userName).subscribe((response) => {
      console.log('response' + response)
      this.farmer = response;
      this.farmerService.viewItemsByFarmerId(this.farmer.farmerId).subscribe((response) => {
      console.log('response' + response);
      this.itemList = response;
      console.log(this.itemList);
    },
    (err)=>{alert(err.error.msg)});
  })
}

  navigateToFarmerHome() {
    this.router.navigate(['']);
  }

  navigateToUpdateItem() {
    this.router.navigate(['']);
  }

  deleteItem() {

  }

}
