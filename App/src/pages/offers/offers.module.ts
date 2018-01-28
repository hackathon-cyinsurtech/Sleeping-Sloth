import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { OffersPage } from './offers';


import { OfferPage } from '../offer/offer';

@NgModule({
  declarations: [
    OffersPage,
  ],
  imports: [
    IonicPageModule.forChild(OffersPage),
  ],
})
export class OffersPageModule {}
