import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the BoughtPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

 import { HomePage } from '../home/home';

@IonicPage()
@Component({
  selector: 'page-bought',
  templateUrl: 'bought.html',
})
export class BoughtPage {

  public referenceNumber: any;
  constructor(public navCtrl: NavController, public navParams: NavParams){
    this.referenceNumber = Math.floor(Math.random() * Math.floor(100000));
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad BoughtPage');
  }

  ionViewWillLeave(){
    //console.log("LEaving Bye Bye");
    this.navCtrl.push(HomePage, {});
  }

}
