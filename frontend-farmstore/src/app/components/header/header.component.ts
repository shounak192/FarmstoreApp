import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { CartService } from 'app/services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthService,
    private router: Router, private cartService: CartService) { /* this.user = this.getRole();  */ }

  public totalItem: number = 0;
  public searchTerm: string = '';
  public itemCategory:string='';

  ngOnInit(): void {
    this.totalItem= this.cartService.getItems().length;
  }
  getRole() {
    return this.authService.getRole();
  }

  getUserType() {
    return this.authService.getUsertype();
  }

  getUser() {
    return this.authService.retrieveUserDetails();
  }

  search(event:any){
    // this.searchTerm = (event.target as HTMLInputElement).value;
    console.log(this.searchTerm);
    this.cartService.search.next(this.searchTerm);
  }

  category(itemCategory:string){
    console.log(itemCategory);
    this.cartService.category.next(itemCategory);
  }
}
