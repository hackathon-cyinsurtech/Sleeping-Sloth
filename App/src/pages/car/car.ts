import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

/**
 * Generated class for the CarPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-car',
  templateUrl: 'car.html',
})
export class CarPage {

  public userName: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http) {
    let headers = new Headers ();
  headers.append('Content-Type', 'application/json');

  /*this.http.get('http://10.11.74.3:8090/', JSON.stringify(body), {headers: headers})
      //.map(res => res.json())
      .subscribe(data => {
          console.log(data);
      });
      */

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CarPage');
  }

}
