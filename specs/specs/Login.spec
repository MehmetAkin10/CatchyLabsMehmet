CatchyLabs Gauge Selenium
=====================
Created by mehmetakin



1.Akin Kullanici Adi ile Login
-------------------------------
tags:@1akinKullaniciAdiileLogin
* "https://catchylabs-webclient.testinium.com/signIn" adresine git
* "Username" Elementine tıkla
* "Username" elementine "Akin" textini yaz
* "Password" Elementine tıkla
* "Password" elementine "Mehmet.1998" textini yaz
* "LoginButon" Elementine tıkla
* Element var mı kontrol et "OpenMoneyTransferButton"
* "2" saniye bekle




2.Gecerli Kullanici Adi Gecersiz Sifre Kontrol
----------------------------------------------
tags:@2gecerliKullaniciAdiGecersizSifreKontrol
* "https://catchylabs-webclient.testinium.com/signIn" adresine git
* "Username" Elementine tıkla

* "Username" elementine "Akin" textini yaz
* "Password" Elementine tıkla
* "Password" elementine "mehmet.1998" textini yaz
* "LoginButon" Elementine tıkla
//* "HataliLoginUyari" elementini kontrol et


3.Gecersiz Kullanici Adi Gecerli Sifre Kontrol
----------------------------------------------
tags:@3gecersizKullaniciAdiGecerliSifreKontrol
* "https://catchylabs-webclient.testinium.com/signIn" adresine git
* "Username" Elementine tıkla
* "Username" elementine "akin" textini yaz
* "Password" Elementine tıkla
* "Password" elementine "Mehmet.1998" textini yaz
* "LoginButon" Elementine tıkla
//* "HataliLoginUyari" elementini kontrol et


4.Sifre Olmadan Login
---------------------
tags:@4sifreOlmadanLogin
* "https://catchylabs-webclient.testinium.com/signIn" adresine git
* "Username" Elementine tıkla
* "Username" elementine "akin" textini yaz
* "LoginButon" Elementine tıkla
//* "HataliLoginUyari" elementini kontrol et


5.Kullanici Adi Olmadan Login
---------------------
tags:@5kullaniciAdiOlmadanLogin
* "https://catchylabs-webclient.testinium.com/signIn" adresine git
* "Password" Elementine tıkla
* "Password" elementine "Mehmet.1998" textini yaz
* "LoginButon" Elementine tıkla
//* "HataliLoginUyari" elementini kontrol et






