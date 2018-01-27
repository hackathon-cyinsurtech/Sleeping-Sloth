import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

import {Validators, FormBuilder, FormGroup } from '@angular/forms';

import { Camera, CameraOptions } from '@ionic-native/camera';

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

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http, private formBuilder: FormBuilder, private camera: Camera) {

    let headers = new Headers ();
    headers.append('Content-Type', 'application/json');
    headers.append('Authorization', 'Bearer ');

    var body ='{"code": "HOUSESloth", "description":"HouseSlloth"}';
console.log(body);
console.log(JSON.stringify(body));
this.http.post('/api', body, {headers: headers})
//.map(res => res.json())
.subscribe(data => {

});

this.http.get('http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com/user/all', {})
    //.map(res => res.json())
    .subscribe(data => {
        console.log(data);
    });

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





  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CarPage');
  }

  logForm(){
    if(this.userInfo.valid){



    }else{


    }
  console.log(this.userInfo.value)
}

startPhotoProcess(){
  const options: CameraOptions = {
    quality: 100,
    destinationType: this.camera.DestinationType.DATA_URL,
    encodingType: this.camera.EncodingType.JPEG,
    mediaType: this.camera.MediaType.PICTURE
  }

  console.log("pinky and the brain");
  this.camera.getPicture(options).then((imageData) => {
   // imageData is either a base64 encoded string or a file URI
   // If it's base64:
   let base64Image = 'data:image/jpeg;base64,' + imageData;
   console.log(base64Image);
  }, (err) => {
   // Handle error
  });
}

}
