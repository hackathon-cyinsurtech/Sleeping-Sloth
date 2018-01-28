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

  public offerDetails: any;
  public quoteID: any;
  public apiURL: any;

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
                  // console.log(JSON.parse(data['_body']));
                   this.offerDetails = JSON.parse(data['_body']);

               });

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad OfferPage');
  }

}
