import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

import {Validators, FormBuilder, FormGroup } from '@angular/forms';

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
   private userInfo : FormGroup;
   public validation_messages:any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http, private formBuilder: FormBuilder) {
    this.validation_messages = {
    'email': [
    		{ type: 'required', message: 'Email is required.' },
    		{ type: 'pattern', message: 'Your must enter a valid email address' }
    	],
      'password': [
      		{ type: 'required', message: 'Password is required' },
      		{ type: 'minlength', message: 'Your password with at least 5 characters' },
      		{ type: 'pattern', message: 'Your password must have at least one lower case character, one capital character and one number' }
      	],
        'name': [
            { type: 'required', message: 'Name is required' }
          ],
        'surname': [
            { type: 'required', message: 'Surname is required' }
          ],
        'address': [
        		{ type: 'required', message: 'Address is required' }
          ]


      };
//https://ionicthemes.com/tutorials/about/ionic2-form-handling-and-validation
    this.userInfo = this.formBuilder.group({
      email: ['', Validators.compose([
			 Validators.required,
			 Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
		 ])],
      password: ['', Validators.compose([
		 	Validators.minLength(5),
		 	Validators.required,
		 	Validators.pattern('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$')
		])],
      name: ['', Validators.required],
      surname: ['', Validators.required],
      address: ['', Validators.required],
    });


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

  logForm(){
  console.log(this.userInfo.value)
}

}
