import { Component, OnInit } from '@angular/core';
import { AdminService } from 'app/services/admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private adminService:AdminService) { }
 
  ngOnInit(): void {
}

}
