import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Platform } from 'ionic-angular';
import { ToastController } from 'ionic-angular';

import { Storage } from '@ionic/storage';

import { CarPage } from '../car/car';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  public apiURL: any;
  public showLoginBtn: any=false;

  constructor(public navCtrl: NavController, private alertCtrl: AlertController, public http: Http,  public platform: Platform, private toastCtrl: ToastController, private storage: Storage) {
    if (this.platform.is('ios') || this.platform.is('android')) {
         // This will only print when on iOS
         this.apiURL = "http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com";
       }else{
         this.apiURL = "/api";
       }
  }

  insureMyCar(){
    this.navCtrl.push( CarPage );
  }

  login(){
    console.log("log me in");
    let alert = this.alertCtrl.create({
       title: 'Login',
       inputs: [
         {
           name: 'username',
           placeholder: 'Username'
         },
         {
           name: 'password',
           placeholder: 'Password',
           type: 'password'
         }
       ],
       buttons: [
         {
           text: 'Cancel',
           role: 'cancel',
           handler: data => {
             console.log('Cancel clicked');
           }
         },
         {
           text: 'Login',
           handler: data => {

             this.http.get(this.apiURL+'/user/load?email='+data.username+'&password='+data.password, {})
                     //.map(res => res.json())
                .subscribe(data => {

                     if(data['_body']==""){
                         let toast = this.toastCtrl.create({
                         message: 'Error loggin in. Please try again!',
                         duration: 4000,
                         position: 'top'
                        });

                        toast.onDidDismiss(() => {
                         console.log('Dismissed toast');
                        });

                        toast.present();
                       return false;
                     }else{
                       var temp = JSON.parse(data['_body']);
                       this.storage.set('userId', temp.id);
                       let toast = this.toastCtrl.create({
                       message: 'Welcome back '+temp.name+" "+temp.surname,
                       duration: 4000,
                       position: 'top'
                      });

                      toast.onDidDismiss(() => {
                       console.log('Dismissed toast');
                      });
                      this.showLoginBtn=true;

                      toast.present();
                     }
                 });


           }
         }
       ]
     });
     alert.present();
  }

}
