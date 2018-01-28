import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';

import { CarPage } from '../pages/car/car';
import { OffersPage } from '../pages/offers/offers';
import { OfferPage } from '../pages/offer/offer';
import { BoughtPage } from '../pages/bought/bought';

import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import { Camera, CameraOptions } from '@ionic-native/camera';
import { IonicStorageModule } from '@ionic/storage';


@NgModule({
  declarations: [
    MyApp,
    HomePage,
    CarPage,
    OffersPage,
    OfferPage,
    BoughtPage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    IonicStorageModule.forRoot(),
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    CarPage,
    OffersPage,
    OfferPage,
    BoughtPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    Camera,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
