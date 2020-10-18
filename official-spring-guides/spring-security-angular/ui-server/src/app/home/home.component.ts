import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  title = "Demo";
  greeting = {}

  constructor(private app: AppService, private http: HttpClient) {
    http.get("http://localhost:9000").subscribe(
      response => {
        this.greeting = response;
      }
    )
  }

  authenticated() {
    return this.app.authenticated;
  }
}
