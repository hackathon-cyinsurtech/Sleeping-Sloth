import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { BoughtPage } from './bought';

@NgModule({
  declarations: [
    BoughtPage,
  ],
  imports: [
    IonicPageModule.forChild(BoughtPage),
  ],
})
export class BoughtPageModule {}
