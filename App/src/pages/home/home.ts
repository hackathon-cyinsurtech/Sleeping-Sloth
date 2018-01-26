import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';


import { CarPage } from '../car/car';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  constructor(public navCtrl: NavController) {

  }

  insureMyCar(){
    this.navCtrl.push( CarPage );
  }

}
