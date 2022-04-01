import { Component, OnInit } from '@angular/core';
import { faFacebook,faGoogle,faGithub,faInstagram  } from '@fortawesome/free-brands-svg-icons';
import { Router }  from "@angular/router";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  faFacebookF=faFacebook;
  faGoogle=faGoogle;
  faGithub=faGithub;
  faInstagram=faInstagram;
  constructor(public router: Router) { }

  ngOnInit(): void {
  }

}
