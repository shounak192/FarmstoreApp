import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'app/models/category';
import { Credentials } from 'app/models/credential';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { ItemService } from 'app/services/item.service';
import { AuthService } from 'app/services/auth.service';
import { FarmerService } from 'app/services/farmer.service';
import Swal from 'sweetalert2';
import { UpdateFarmerComponent } from '../update-farmer/update-farmer.component';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css'],

})
export class AddItemComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private farmerService:FarmerService,
    private authService: AuthService,
    private itemService: ItemService
  ) { }

  item: Item= new Item();
  credential: Credentials = new Credentials() ;
  userName: string ='';
  farmer: Farmer = new Farmer();

  // item: Item = {
  //   itemId:  0,
  //   itemName: '',
  //   itemQuantity: 0,
  //   itemPrice: 0,
  //   itemCategory: Category.GRAINS,
  //   farmer: new Farmer(),
  //   //orders:Array<Orders> = [];
  //   verified: false
  // }

  ngOnInit(): void {

    // this.credential = this.authService.retrieveUserDetails();
    // console.log(this.credential.username);
    // this.farmerService.getFarmerByUserName(this.credential.username).subscribe((response) => {
    //   console.log('response' + response)
    //   this.item.farmer = response;
    //   console.log(response);
    // },
    // (err)=>{console.log(err.error.msg)});
    this.userName = this.authService.getUserName() as string;
    this.farmerService.getFarmerByUserName(this.userName).subscribe((response) => {
      console.log('response' + response)
      this.farmer = response;
  },
  (err)=>{console.log(err.error.msg)});
}

  addItem():void {
    let c= this.authService.retrieveCredentialDetails();
      this.farmer.credential = JSON.parse(c as string);
      console.log(this.farmer);
    this.item.farmer = this.farmer;
    console.log(this.item);
    this.itemService.addItem(this.item).subscribe((response) => {
      console.log(response);
      this.openSweetAlert();
    },
    (err)=>{console.log(err.error.msg)});
  }

  openSweetAlert() {
    Swal.fire('Item Added successfully and sent for verification','','success')
  }

  navigateToFarmerHome() {
    this.router.navigate(['']);
  }

}
