import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Http, Response, Headers, URLSearchParams, RequestOptions } from '@angular/http';
import { map, filter, scan } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  private baseURL: string = "http://localhost:8080/app/vehicles/";

  constructor(private _http: Http) { }

  getVehicleReport(file: File): Observable<any> {
    let formData:FormData = new FormData();
      formData.append('file', file);
      let headers = new Headers();
      headers.append('Accept', 'application/json');
      let options = new RequestOptions({ headers: headers });
      var httpUrl = this.baseURL + "report";
      return this._http.post(httpUrl, formData, options)
          .pipe(map((response: Response) => <any>response.json()))
  }

}
