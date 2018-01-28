import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { Http, Headers } from '@angular/http';
import 'rxjs/add/operator/map';

import {Validators, FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms"

import { Camera, CameraOptions } from '@ionic-native/camera';
import { Platform } from 'ionic-angular';

import { Storage } from '@ionic/storage';

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
   public apiURL: any;

   public photo:any;
   public questions:any;
   public choices:any;
   public detailsSaved:boolean =false;
   public isLoggedIn:boolean = false;
   public userId:any = "";
   public idToUploadPhoto:any;
   public pageVisitType:any;
   public onePhotoSaved:boolean=false;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: Http, private formBuilder: FormBuilder, private camera: Camera, public platform: Platform, private storage: Storage) {

    this.idToUploadPhoto = navParams.get("id");
    this.pageVisitType = navParams.get("takePhoto");

    if(this.pageVisitType){
      this.detailsSaved = true;
    }

//
    if (this.platform.is('ios') || this.platform.is('android') ) {
         // This will only print when on iOS
         this.apiURL = "http://default-environment.nmisbuxyma.us-east-2.elasticbeanstalk.com";
       }else{
         this.apiURL = "/api";
       }


   this.http.get(this.apiURL+'/question/find?insuranceTypeCode=CAR', {})
           //.map(res => res.json())

           .subscribe(data => {
               console.log(JSON.parse(data['_body']));
               this.questions = JSON.parse(data['_body']);




           });

   this.http.get(this.apiURL+'/question/allchoices', {})
           //.map(res => res.json())

           .subscribe(data => {
               console.log(JSON.parse(data['_body']));
               this.choices = JSON.parse(data['_body']);
           });


           //https://ionicthemes.com/tutorials/about/ionic2-form-handling-and-validation
           if(this.isLoggedIn){
           this.userInfo = this.formBuilder.group({
             name: ['', Validators.required],
             surname: ['', Validators.required],
             address: ['', Validators.required],
             1: [''],
             2: [''],
             3: [''],
             4: [''],
             5: [''],
             6: [''],
             7: [''],
             8: [''],
             9: [''],
             10: [''],
             11: [''],
             12: [''],
             13: [''],
             14: [''],
             15: [''],
             16: [''],
             17: [''],
             18: [''],
             19: [''],
             20: [''],
             21: [''],
             22: [''],
             23: [''],
             24: [''],
             25: [''],
             26: [''],
             27: [''],
             28: [''],
           });
          }else{
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
              1: [''],
              2: [''],
              3: [''],
              4: [''],
              5: [''],
              6: [''],
              7: [''],
              8: [''],
              9: [''],
              10: [''],
              11: [''],
              12: [''],
              13: [''],
              14: [''],
              15: [''],
              16: [''],
              17: [''],
              18: [''],
              19: [''],
              20: [''],
              21: [''],
              22: [''],
              23: [''],
              24: [''],
              25: [''],
              26: [''],
              27: [''],
              28: [''],
            });
          }






/*
//load photos
this.http.get(this.apiURL+'/photo/find?quoteRequestId=1', {})
    //.map(res => res.json())

    .subscribe(data => {
        console.log(data);
        var temp = JSON.parse(data['_body']);
        console.log(temp[0]);
        this.photo = temp[0]['data'];
    });
*/

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





  }

  createFormRestrictions(){









  }

  ionViewWillEnter() {
    console.log('ionViewDidLoad CarPage');
    this.storage.get('userId').then((val) => {
        if(val == "" || val == null){
           this.isLoggedIn=false;
        }else{

             this.userId = val;
          this.isLoggedIn=true;
        }
        console.log("is null? "+val + this.isLoggedIn);
      });
  }

  logForm(){
    if(this.userInfo.valid || this.isLoggedIn ){

        let headers = new Headers ();
        headers.append('Content-Type', 'application/json');
        headers.append('Authorization', 'Bearer ');

       // console.log(base64Image);
       var body: any ;
        if(this.isLoggedIn){
          body='{"userId":"'+this.userId+'" ,"insuranceTypeCode": "CAR" ,';
        }else{
          body ='{"insuranceTypeCode": "CAR" ,';
        }



          Object.keys(this.userInfo.controls).forEach(key => {


            if(this.userInfo.get(key).value != ""){
              console.log(key);
                          console.log( this.userInfo.get(key).value);
                body += '"'+key+'": "'+this.userInfo.get(key).value+'" ,';
            }

          });

          body = body.slice(0, -1);
          body += "}";
          console.log(body);

      /*for(let temp of this.userInfo){
        if(temp[1]!=""){
          console.log(temp[0]+" "+temp[1]);
        }
      }*/
      this.detailsSaved=true;
      this.http.post(this.apiURL+'/quote/add', body , {headers: headers})
      //.map(res => res.json())
      .subscribe(data => {
          console.log("Insurance data sent");
          console.log(data);
          this.idToUploadPhoto = data['_body'];
          this.storage.set('userId', data['_body']);
      });


    }else{
      console.log("fucking else");

    }
  //console.log(this.userInfo.value)
}

startPhotoProcess(){
  const options: CameraOptions = {
    quality: 20,
    destinationType: this.camera.DestinationType.DATA_URL,
    encodingType: this.camera.EncodingType.JPEG,
    mediaType: this.camera.MediaType.PICTURE
  }

  console.log("pinky and the brain");
  this.camera.getPicture(options).then((imageData) => {
 // imageData is either a base64 encoded string or a file URI
   // If it's base64:
   let headers = new Headers ();
   headers.append('Content-Type', 'application/json');
   headers.append('Authorization', 'Bearer ');

   let base64Image = 'data:image/jpeg;base64,' + imageData;
  // console.log(base64Image);


   var body: any ="";

   body = '{"quoteRequestId": "'+this.idToUploadPhoto+'", "data" : "'+base64Image+'"}';
 console.log(body);

 this.http.post(this.apiURL+'/photo/add', body, {headers: headers})
 //.map(res => res.json())
 .subscribe(data => {
    console.log("Photo Uploaded");
    this.startPhotoProcess();
    this.onePhotoSaved = true;
 });



  }, (err) => {
   // Handle error
  });
}

finishedPhotoProcess(){
  this.navCtrl.pop();
}

}
