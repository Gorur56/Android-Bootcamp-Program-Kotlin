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
