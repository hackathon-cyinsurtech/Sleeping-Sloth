import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Platform } from 'ionic-angular';


import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

/**
 * Generated class for the RequestsPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-requests',
  templateUrl: 'requests.html',
})
export class RequestsPage {

  public questions: any;
  public quoteID: any;

  public apiURL: any;
    public address: any;
    public qAndA: any;
    public photos: any;


  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http, public platform: Platform) {
    this.quoteID = navParams.get("id");

    if (this.platform.is('ios') || this.platform.is('android') ) {
         // This will only print when on iOS
         this.apiURL = "http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com";
       }else{
         this.apiURL = "/api";
       }

    this.http.get(this.apiURL+'/quote/findQuote?quoteRequestId='+this.quoteID, {})
               //.map(res => res.json())
          .subscribe(data => {

        //  console.log(JSON.parse(data['_body']));
               var temp = JSON.parse(data['_body']);
              console.log("Temp");
              // console.log(temp);
               this.qAndA = temp;
              // console.log(this.qAndA.answers);
               //this.answers = temp.answers;
               this.address = temp.user.address;
               //console.log(answers);
          });


    this.http.get(this.apiURL+'/question/find?insuranceTypeCode=CAR', {})
            //.map(res => res.json())

            .subscribe(data => {
                console.log(JSON.parse(data['_body']));
                this.questions = JSON.parse(data['_body']);
            });


            this.http.get(this.apiURL+'/photo/find?quoteRequestId=34', {})
                    //.map(res => res.json())
                   .subscribe(data => {
                        console.log(data['_body']);
                        var te = JSON.parse(data['_body']);
                        this.photos = te[0].data;
                    });

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RequestsPage');
  }

}
