import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Platform } from 'ionic-angular';

/**
 * Generated class for the OfferPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-offer',
  templateUrl: 'offer.html',
})
export class OfferPage {

  public details: any;
  public quoteID: any;
  public apiURL: any;



  public coverType: any;
  public driverCover: any;
  public excess: any;
  public id: any;
  public legalAssistance: any;
  public passengersCover: any;
  public personalAccident: any;
  public price: any;
  public quoteRequestId: any;
  public roadHelp: any;
  public thirdParty: any;
  public userId: any;



  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http,  public platform: Platform) {
    if (this.platform.is('ios') || this.platform.is('android') ) {
         // This will only print when on iOS
         this.apiURL = "http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com";
       }else{
         this.apiURL = "/api";
       }


        var quoteID = navParams.get("id");
       this.http.get(this.apiURL+'/offer/find?offerId='+quoteID, {})
               //.map(res => res.json())

               .subscribe(data => {
                 console.log("Hmmmmmmmm");
                 console.log(data);
                   console.log(JSON.parse(data['_body']));
                   this.details = JSON.parse(data['_body']);
                   console.log(this.details.id);

                   this.coverType = this.details.coverType;
                   this.driverCover = this.details.driverCover;
                   this.excess = this.details.excess;
                   this.id = this.details.id;
                   this.legalAssistance = this.details.legalAssistance;
                   this.passengersCover = this.details.passengersCover;
                   this.personalAccident = this.details.personalAccident;
                   this.price = this.details.price;
                   this.quoteRequestId = this.details.quoteRequestId;
                   this.roadHelp = this.details.roadHelp;
                   this.thirdParty = this.details.thirdParty;
                   this.userId = this.details.userId;

               });

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad OfferPage');
  }

}
