import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { Platform } from 'ionic-angular';
import { ToastController } from 'ionic-angular';

import { Storage } from '@ionic/storage';

import { CarPage } from '../car/car';
import { OffersPage } from '../offers/offers';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  public apiURL: any;
  public showLoginBtn: any=false;
  public userType: any;

  public pendingQuotes: any;
  public newQuoteRequests: any;

  constructor(public navCtrl: NavController, private alertCtrl: AlertController, public http: Http,  public platform: Platform, private toastCtrl: ToastController, private storage: Storage) {
    if (this.platform.is('ios') || this.platform.is('android') ) {
         // This will only print when on iOS
         this.apiURL = "http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com";
       }else{
         this.apiURL = "/api";
       }



  }

ionViewWillEnter() {
  this.storage.get('userId').then((val) => {
      if(val == "" || val == null){
         this.showLoginBtn=false;
		 console.log("User type " + this.userType);
      }else{
        this.showLoginBtn=true;
        console.log("val="+val);
        console.log("showLoginBtn="+this.showLoginBtn);

        this.platform.ready().then((readySource) => {
          this.http.get(this.apiURL+'/quote/find?userId='+val, {})
                  //.map(res => res.json())
             .subscribe(data => {
             console.log("pendingQUotes");
                  console.log(data);
                  this.pendingQuotes = JSON.parse(data['_body']);
                  console.log(this.pendingQuotes);
             });
        });




      }


      console.log("is nullHome? "+val+ this.showLoginBtn);
        console.log(this.pendingQuotes);
    });

      this.storage.get('userType').then((val) => {
        this.userType = val;
        if(this.userType != 'INSURANCE_COMPANY') {
                this.retreivePendingQuotes(temp.id);
        } else {
                this.retreiveNewQuoteRequests();
                console.log("This is an Insurance company");
        }
      });
}

  retreivePendingQuotes(val:any){
    this.http.get(this.apiURL+'/quote/find?userId='+val, {})
            //.map(res => res.json())
       .subscribe(data => {
       console.log("pendingQUotes");
            console.log(data);
            this.pendingQuotes = JSON.parse(data['_body']);
            console.log(this.pendingQuotes);
       });

       this.http.get(this.apiURL+'/quote/find?userId='+val, {})
               //.map(res => res.json())
          .subscribe(data => {
               console.log(data);
          });
  }


  retreiveNewQuoteRequests(){
     this.http.get(this.apiURL+'/quote/allOpen', {})
            //.map(res => res.json())
       .subscribe(data => {
       console.log("allOpenQuotes");
            console.log(data);
            this.newQuoteRequests = JSON.parse(data['_body']);
            console.log(this.newQuoteRequests);
       });
  }

  insureMyCar(){
    this.navCtrl.push( CarPage );
  }

  logout(){
     this.storage.set('userId', "");
     this.showLoginBtn=false;
	 this.userType = "";
   this.storage.set('userType', "");
	 console.log("User type " + this.userType);
     this.pendingQuotes = undefined;
     let toast = this.toastCtrl.create({
     message: 'Logout Succsessful!',
     duration: 4000,
     position: 'top'
    });

    toast.onDidDismiss(() => {
     console.log('Dismissed toast');
    });

    toast.present();

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
                         message: 'Error logging in. Please try again!',
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
					  this.userType = temp.userType;

            this.storage.set('userType', this.userType);
					  console.log("User type " + temp.userType);

					  if(this.userType != 'INSURANCE_COMPANY') {
						        this.retreivePendingQuotes(temp.id);
					  } else {
						        this.retreiveNewQuoteRequests();
						        console.log("This is an Insurance company");
					  }


					  toast.present();
                     }
                 });


           }
         }
       ]
     });
     alert.present();
  }

  loadPendingQuote(id:any){
    console.log(id);
    this.navCtrl.push(CarPage, {
      id: id,
      takePhoto: true
    });
  }

  loadWaitingOffer(id:any){
    console.log(id);
    this.navCtrl.push(OffersPage, {
      id: id
    });
  }

}
