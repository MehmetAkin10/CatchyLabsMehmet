CatchyLabs Gauge Selenium
=====================
Created by mehmetakin


     
1.Hesaba Para Yatirma İslemi
-----------------------------------------------
tags:@1hesabaParaYatirmaİslemi
* Akin Kullanici Adi ile Login
* "OpenMoneyTransferButton" Elementine tıkla
* "AddMoneyButton" Elementine tıkla
* "CardNumberTextbox" Elementine tıkla
* "CardNumberTextbox" elementine "1234123412341234" textini yaz
 "1234123412341234" textini "CardNumberTextbox" elemente tek tek yaz
* "CardHolderTextbox" Elementine tıkla
* "CardHolderTextbox" elementine "Testinium-1" textini yaz
* "ExpiryDateTextbox" Elementine tıkla
* "ExpiryDateTextbox" elementine "1026" textini yaz
* "CVVTextbox" Elementine tıkla
* "CVVTextbox" elementine "110" textini yaz
* "AddMoneyAmountTextbox" Elementine tıkla
* "AddMoneyAmountTextbox" elementine "100" textini yaz
* "2" saniye bekle
* "AddButton" Elementine tıkla
* Element var mı kontrol et "AddAmountKontrol"



2.Para Yatirma Veri Girmeden Add Kontrol
-----------------------------------------------
tags:@2paraYatirmaVeriGirmedenAddKontrol
* Akin Kullanici Adi ile Login
* "OpenMoneyTransferButton" Elementine tıkla
* "AddMoneyButton" Elementine tıkla
* "AddButton" Elementine tıkla
* Element var mı kontrol et "AddZorunluAlanKontrol"


3.Para Yatirma X İcon Kontrol
-----------------------------------------------
tags:@3paraYatirmaXİconKontrol
* Akin Kullanici Adi ile Login
* "OpenMoneyTransferButton" Elementine tıkla
* "AddMoneyButton" Elementine tıkla
* "AddXicon" Elementine tıkla
* Element var mı kontrol et "Checking"



4.Para Yatirma Card Number Too Short Kontrol
-----------------------------------------------
tags:@4paraYatirmaCardNumberTooShortKontrol
* Akin Kullanici Adi ile Login
* "OpenMoneyTransferButton" Elementine tıkla
* "AddMoneyButton" Elementine tıkla
* "1" saniye bekle
* "CardNumberTextbox" Elementine tıkla
* "CardNumberTextbox" elementine "123" textini yaz
* "CardHolderTextbox" Elementine tıkla
* "1" saniye bekle
* Element var mı kontrol et "AddMoneyCardNumberTooShortKontrol"



5.Para Yatirma Card Number Too Long Kontrol
-----------------------------------------------
tags:@5paraYatirmaCardNumberTooLongKontrol
* Akin Kullanici Adi ile Login
* "OpenMoneyTransferButton" Elementine tıkla
* "AddMoneyButton" Elementine tıkla
* "1" saniye bekle
* "CardNumberTextbox" Elementine tıkla
* "CardNumberTextbox" elementine "12341234123412341" textini yaz
* "CardHolderTextbox" Elementine tıkla
* "1" saniye bekle
* Element var mı kontrol et "AddMoneyCardNumberTooLongKontrol"


6.Para Yatirma Card Number Too Long Kontrol
-----------------------------------------------
tags:@6paraYatirmaCardNumberTooLongKontrol
* Akin Kullanici Adi ile Login
* "OpenMoneyTransferButton" Elementine tıkla
* "AddMoneyButton" Elementine tıkla
* "1" saniye bekle
* "ExpiryDateTextbox" Elementine tıkla
* "ExpiryDateTextbox" elementine "1" textini yaz
* "CardHolderTextbox" Elementine tıkla
* "1" saniye bekle
* Element var mı kontrol et "ExpiryDateHataKontrol"




