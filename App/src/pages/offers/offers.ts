import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Platform } from 'ionic-angular';


import { OfferPage } from '../offer/offer';
/**
 * Generated class for the OffersPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-offers',
  templateUrl: 'offers.html',
})
export class OffersPage {

  public offers: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http,  public platform: Platform) {
    if (this.platform.is('ios') || this.platform.is('android') ) {
         // This will only print when on iOS
         this.apiURL = "http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com";
       }else{
         this.apiURL = "/api";
       }


        var quoteID = navParams.get("id");
       this.http.get(this.apiURL+'/offer/findForQuote?quoteRequestId='+quoteID, {})
               //.map(res => res.json())

               .subscribe(data => {
                   console.log(JSON.parse(data['_body']));
                   this.offers = JSON.parse(data['_body']);
                   if(this.offers.length == 0){
                     console.log("zero");
                     this.offers = undefined;
                   }


               });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad OffersPage');
  }

  loadOfferDetails(id:any){
    this.navCtrl.push(OfferPage, {
      id: id
    });
  }

}
