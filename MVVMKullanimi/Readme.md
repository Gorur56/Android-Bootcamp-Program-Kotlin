# MVVM MİMARİSİ
Çalışma yapısı aşağıdaki gibidir.
( DataBinding, Fragment (VİEW) <=> ViewModel (LiveData) ) UI Layer  <=====> ( Repository <=> Data Source ) Data Layer <=========> Model

#### UI LAYER
* View Binding: Layout üzerindeinde nesnelere erişim sağlar.
* View Data: ViewBinding gibi Activity ve layout dosyarı araasındaki iletişi sağlar. Ayrıca erişimi Avtivity veta Fragment sınıfında değil layout dosyalarındada sağlar.
             Layout dosyasında android kütüphaleri kullanarabiliriz. Koşullu iafeler oluşturabiliriz.
* LiveData: Kod tekrarı engelmmek için kullanılır. Observe Pattern ile çalışır. Observe ile değer değiştiğinde diğer yerleride bildirip değiştirir.

#### DATA LAYER
DataSource ve Repository, yazılım geliştirmede veriye erişim ve yönetim katmanlarını organize etmek için kullanılan tasarım desenleridir. 

* COROURTINE: Asenkron bir çalışma ile veri gönderir. Coroutineler, suspend anahtar kelimesi ile tanımlanır ve launch, async, await gibi yapı taşları ile kullanılır.
* REPOSTORY: Repository, veri erişim katmanını daha yüksek seviyede soyutlamak için kullanılan bir desendir. Repostory 'nin ilk görevi DataSource Erişmek ve yönetmektir.
* DATA SOURCES: DataSource, genellikle veri kaynağına doğrudan erişim sağlayan bir bileşendir.

  * Toplama Ve Çarpma işlemi yapan bir uygulamadır.
  * Layout dosyasında yapılan işlemler;
      1. 0 olduğunda sonucText göstermez.
      2. Uzunluk 1 ise textSize 50sp, 1 'den büyükse textSize 100sp olur.
      3. !0 2dan küçükse sonucText Mavi, büyükse kırmızı olur.
  * Activity dosyasında yapılan işlemler; DataBinding, ViewModel, LiveData, Repository, DataSource
    

  ![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/19013152-4b20-4af4-9e83-5367b0971722) ![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/f80f0afb-0643-4215-a024-935fb0829e25)



