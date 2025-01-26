# CatchyLabsProject

 1.Proje Hakkında
 - Bu proje, web tabanlı bir bankacılık uygulamasının otomasyon test süreçlerini kapsamaktadır. Kullanıcıların sisteme giriş yapma, para transferi, kart aracılığıyla para yatırma ve hesap ayarlarını düzenleme gibi işlemleri sorunsuz şekilde gerçekleştirebilmesi için gerekli tüm özelliklerin test edilmesi amaçlanmıştır. Proje, kullanıcı deneyimini iyileştirmek ve güvenliği en üst seviyeye taşımak için detaylı bir test stratejisi sunmaktadır.

 2.Proje Özellikleri

    Fonksiyonlar
 - Kullanıcı Giriş İşlemleri
 - Hesaplar Arası Para Transfer İşlemleri
 - Kart ile Para Yükleme İşlemleri
 - Hesap Adı Güncelleme İşlemi
 - Farklı tarayıcı uyumluluk testleri (Chrome, Firefox, Edge).


    Teknolojiler
 - Java: Test otomasyonu kodlaması için.
 - Selenium WebDriver: Tarayıcı otomasyonu için.
 - Gauge: BDD formatında test yazımı ve raporlama için.
 - HTML-report : Test koşumlarını raporlama için.
 - Maven: Bağımlılık yönetimi ve test çalıştırma için.
 - Tasarım Deseni: Page Object Model (POM) kullanıldı.


  3.Kurulum Talimatları 

 - Projeyi çalıştırmak için aşağıdaki yazılımların bilgisayarınızda kurulu olduğundan emin olun:

 - Java JDK 11 veya üstü
 - Apache Maven 3.6 veya üstü
 - Git (opsiyonel): Kodları klonlamak için.
 - IDE (IntelliJ IDEA, Eclipse vb.): Projeyi düzenlemek ve çalıştırmak için.
 - Gauge 1.6.3 veya üstü


    Repository'i klonlamak için aşağıdakini bağlantıyı kullanabilirsiniz ;
    git clone https://github.com/MehmetAkin10/CatchyLabsMehmet.git


   4.Kullanım Yönergeleri

  Test Nasıl Yürütülür ?

    1. Proje dizisine gidiniz.
    2. Maven kullanarak testleri çalıştırın.

        mvn gauge:execute
   
  Tag Kullanarak Testleri Yürütme;
    
        mvn gauge:execute -DspecsDir=specs -Dtags:"tagName"
 - Eğer bir test @smoke etiketiyle işaretlendiyse ve komut -Dtags="smoke" şeklindeyse, yalnızca bu teste ait senaryolar çalıştırılır.

 Test Raporları
 - Test süreçlerinin sonuçlarını ve detaylarını içeren raporlar otomatik olarak oluşturulmaktadır. Gauge raporlama aracı ile görsel ve detaylı bir formatta test sonuçları sunulur.

Raporların Görüntülenmesi:

Test sonuçları reports/html-report/index.html dosyasına kaydedilir. Tarayıcıda bu dosyayı açarak başarı oranlarını ve hata detaylarını inceleyebilirsiniz.

Hata Logları:

Tüm test adımları ve hatalar logs/gauge.log dosyasında saklanır. Bu dosya, test sonuçlarının detaylı analizi için kullanılabilir.

Ekran Kayıtları:

Test sürerken çekilmiş Ekran Görüntüleri .gauge/screenshots dosyasında saklanmaktadır.


5. Sorun Giderme İpuçları
- Kurulum ile İlgili Sorunlar

 1.mvn komutu çalışmıyor:

Maven'in sistem PATH değişkenine eklendiğinden emin olun.
Yükleme talimatlarını buradan kontrol edin.

 2.java komutu bulunamadı:

Java'nın kurulu olduğundan ve PATH değişkenine eklendiğinden emin olun.
Java versiyonunuzu doğrulamak için:

        java -version

 3.Raporlama Sorunları:

 Raporlar eksikse veya hatalı oluşturulmuşsa, rapor klasörünü temizleyin ve testleri yeniden çalıştırın:

       mvn clean test

 4.Geliştirici Modunda Test Çalıştırma:

 Daha fazla detay görmek ve testlerin hata ayıklamasını yapmak için Maven debug modunu kullanabilirsiniz:

       mvn gauge:execute -X


 Not : Proje hakkında her hangi bir sorunuz olursa mail yoluyla iletişime geçebilirsiniz.
      
     E-mail : mehmetaknn@hotmail.com
