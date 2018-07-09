import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse, HttpEventType } from '@angular/common/http';
import { AppService } from 'src/app/app.service';

@Component({
  selector: 'app-report',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {

  reportResponse: any;
  reports:any[];

  bigWheelCount:number;
  bicycleCount:number;
  carCount:number
  motorcycleCount:number;
  hangGliderCount:number;

  selectedFiles: FileList
  currentFileUpload: File

  constructor(private service: AppService) { }

  ngOnInit() {
  }

  selectFile(event) {
    this.selectedFiles = event.target.files;
  }

  upload() {
    if (this.selectedFiles.length > 0) {
      let file: File = this.selectedFiles[0];

      this.service.getVehicleReport(file).subscribe(response => {
        this.reportResponse = response;
        this.reports = response['vehicleReport'];
        this.bicycleCount=response['bicycleCount'];
        this.bigWheelCount=response['bigWheelCount'];
        this.carCount=response['carCount'];
        this.motorcycleCount=response['motorcycleCount'];
        this.hangGliderCount=response['hangGliderCount'];
      })
    }
  }

}
