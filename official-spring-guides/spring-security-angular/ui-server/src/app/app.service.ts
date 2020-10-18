import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private  http: HttpClient) {
  }

  authenticated: boolean = false;

  authenticate(credentials: { username: String, password: String }, callback: Function) {
    let headers = new HttpHeaders(
      credentials ? {
        authorization: 'Basic ' + btoa(`${credentials.username}:${credentials.password}`)
      } : {}
    );
    headers = headers.append("X-Requested-With", "XMLHttpRequest");
    this.http.get('user', {headers: headers}).subscribe(
      response => {
        this.authenticated = response.hasOwnProperty('name');
        return callback && callback();
      }
    )
  }
}
