# KİŞİLER UYGULAMASI

#### FAB BUTONU

* Kişiler uygulamamız Fab butonu ile kişi kaydeder. Basınca  Kişi Kayıt sayfasına geçiş yapar.
  
  ![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/21fb412b-ddc3-498a-ab09-04041b152d13) ![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/74bfde37-f2e8-4dbf-b192-f953c2ca8d15)

#### SEARCH KULLANIMI

* Search girilen her karakter ve enter butonuna basınca kelimeye göre arama yapar. Henüz listeye göre arama yapması için backend kısmını yazmadım.

![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/2064b825-2cde-4dd6-b209-d1f9419bdf67)![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/31547106-fc39-459a-a614-959959f69969)

#### CARD ÜZERİNE TIKLAMA

* Kişilere basınca detay sayfasına gider.

  ![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/bba348d1-c7d5-4d26-b12e-adedaed8bd00)


#### CARD ÜZERİNDEKİ CANCEL ICON TIKLAMA

* Cancel ikonunu basınca Snackbar çıkar ve silinsin mi diye sorar.

![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/d201504b-6eec-4efe-9e31-5205326f1fd8)

#### Kişiler Uygulaması MVVM

* MVVM ile kişiler uygulamamıza devam edip aşağıdaki modeli tasarlayacağız.

![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/f98fc7bf-a9ed-4805-bedf-a49d1663148c)

#### HILT Module Oluşturma

![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/aea78582-1bc3-47a3-8269-2769063c0176)

#### RETROFIT
![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/6a19225d-39bc-4143-b048-f66326de8444)

#### RESTFUL MİMARİSİ

![image](https://github.com/Gorur56/Android-Bootcamp-Program-Kotlin/assets/54911292/ae5f81a8-5cd2-4bbd-afc2-1d7853332bb3)


###### JSON
* Her {} olduğunda jsonda bir class oluşturacağı anlamına gelir. Yani her Süslü parantez aralığı için ayrı bir sınıf oluşturulur.
* CRUD işlemleri kullanırız.
* Class 'mız ile aşağıdaki linkte test etiğimiz bilgiler aynı olmalıdır.

 https://jsonformatter.curiousconcept.com/#
 veri girişi: {"success":0,"message":"Required field(s) is missing"}
 veri çıktısı:
 {
   "success":0,
   "message":"Required field(s) is missing"
}

###### İkinci JSON Formatı
* veri girişi:

{"kisiler":[{"kisi_id":"15674","kisi_ad":"Ahmet","kisi_tel":"3333"},
{"kisi_id":"16169","kisi_ad":"x","kisi_tel":"y"}],"success":1}

* Veri Çıktısı:

  {
    "kisiler":[
     {
          "kisi_id":"15674",
          "kisi_ad":"Ahmet",
          "kisi_tel":"3333"
      },
      {
         "kisi_id":"16169",
         "kisi_ad":"x",
         "kisi_tel":"y"
      }
   ],
   "success":1
  }

* Her süslü parantes arlığı için bir class olmalıdır. Aşağıdaki satır için Kisiler sınıfımız vardır. Ve her model her iki kayıt için kullanılabilir.

      "kisiler":[
     {
          "kisi_id":"15674",
          "kisi_ad":"Ahmet",
          "kisi_tel":"3333"
      },
      {
         "kisi_id":"16169",
         "kisi_ad":"x",
         "kisi_tel":"y"
      }

* Dış parantez içinde bir sınıf oluşturmamız gerekiyor
{
   "kisiler":[],
   "success":1
}







