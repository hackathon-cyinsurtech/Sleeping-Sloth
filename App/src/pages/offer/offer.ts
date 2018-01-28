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
  public insuranceCompany: any;



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

                   this.coverType = this.details.offer.coverType;
                   this.driverCover = this.details.offer.driverCover;
                   this.excess = this.details.offer.excess;
                   this.id = this.details.offer.id;
                   this.legalAssistance = this.details.offer.legalAssistance;
                   this.passengersCover = this.details.offer.passengersCover;
                   this.personalAccident = this.details.offer.personalAccident;
                   this.price = this.details.offer.price;
                   this.quoteRequestId = this.details.offer.quoteRequestId;
                   this.roadHelp = this.details.offer.roadHelp;
                   this.thirdParty = this.details.offer.thirdParty;
                   this.userId = this.details.offer.userId;
				   this.insuranceCompany  = this.details.user.name + " " + this.details.user.surname

               });

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad OfferPage');
  }

  buy(){
    console.log("BUY");
  }

}
