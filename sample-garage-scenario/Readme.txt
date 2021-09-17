JAVA VERSİON : 11

POSTMAN CONTROLS
****************
To see the garage contents(Garaj içeriğini görmek için)
	{GET METHOD} endpoint -> localhost:8082/api/garage/status 
******************************************************************************************************
To see issued tickets(Kesilen biletleri görmek için)
	{GET METHOD} endpoint -> localhost:8082/api/tickets/status 
******************************************************************************************************
To add a vehicle to the parking lot(Garaja araç eklemek için)
	{POST METHOD} endpoint -> localhost:8082/api/tickets/create 

		Submitted data must be in this format(Gönderilen JSON bu formatta olmalıdır)
		                                                               -> {
                                                           			 "reasonForApplication" : "park",
   						   "carPlaque" : "34-LO-2000",
   						   "carColor" : "White",
    						   "carType" : "Car"
						 }
******************************************************************************************************	
To exit from the parking lot, i.e. cancel the issued ticket(Garajdan araba çıkarmak için diyer bir deyim ile bilet iptali için)
	{POST METHOD} endpoint -> localhost:8082/api/tickets/delete

		!Enter parameters with postman key and value(Parametre olarak girilecek araç plakası POSTMAN key, value kısmından girilmelidir.)
		!Endpoint should be like this (localhost:8082/api/tickets/delete?carPlaque=34-LO-2000) (Örnek endpoint)
******************************************************************************************************
NOTES

#Since a database was not desired, I used a hashMap<Integer, Vehicle> for the garage on inMemory and a List<Ticket> on inMemory to see the tickets that were cut.

#Why don't service classes have an abstract layer?
-The @Autowired annotation is no longer used in current spring boot projects. The reason is that when starting your Spring boot project, Singleton creates an instance for each structure, and for this reason, calls are processed directly over that singleton structure. Therefore, since each structure has a singleton instance at the back, the project can work as before with private final access specifiers.

#In order not to suffer from future objectivity weakness, I wrapped each of my concrete classes with the Entity interface that I created as abstract.

#I have overridden the equals, hashCode methods in all my concrete models so that the reference equality checks I have used will give a correct result.

#I used the dtos I had created in order not to open an entity directly to the outside. I did not create a dto with the contents of the garage just to show the tickets and garage status in inMemory, because it is requested in this way as per the scenario.

#Since there is no DAO layer in the scenario, I created and used the List<Ticket> and HashMap<Integer, Vehicle> data structures in inMemory within their own services.

#I used my DtoConverters over a single dto. The reason for this is that the incoming ticket information contains both Vehicle and Ticket information. That is, to be processed through a single input.

#I wrote all the logic of adding cars on GarageService. I did not add a comment line between them, but I specified the method names in a descriptive way.

******************************************************************************************************
NOTLAR

#Bir veri tabanı istenmediği için inMemory üzerinde garaj için bir hashMap<Integer, Vehicle> ve kesilen biletleri görmek için ise yine inMemory üzerinde bir List<Ticket> kullandım.

#Servis class larının neden soyut bir katmanı yok?
-Güncel spring boot projelerinde artık @Autowired anotasyonu kullanılmıyor. Sebebi ise Spring boot projenizi başlatırken her bir yapı için Singleton bir örnek oluşturuyor ve bu sebeple call işlemlerinde direk o singleton yapı üzerinden işlem görüyor. Bu yüzden her yapının arka tarafta bir singleton örneği oluştuğu için private final erişim belirleyicileri ile yazılan projeler eskisi gibi çalışabiliyor.

#İleriye yönelik nesnellik zaafiyeti çekmemek adına her bir concrete yani somut class'ımı, abstract yani soyut olarak yaratmış olduğum Entity interface'i ile sardım.

#Kullanmış olduğum referans eşitliği kontrollerinin doğru bir sonuç vermesi adına tüm somut modellerimde equals, hashCode metodlarını override ettim.

#Dışarıya direk entity açmamak adına oluşturmuş olduğum dtoları kullandım. Sadece inMemory de ki biletleri ve garaj durumunu göstermek için garajın içeriğine sahip bir dto oluşturmadım onun sebebi ise senaryo gereği bu şekilde istendiği için.

#inMemory deki List<Ticket> ve HashMap<Integer, Vehicle> veri yapılarımı senaryo da DAO katmanı olmadığı için kendi servislerinin içerisinde oluşturup kullandım.

#DtoConverterlarımı tek bir dto üzerinden kullandım. Bunun sebebi ise gelen bilet bilgilerinin içerisinde hem Vehicle hem de Ticket bilgilerinin bulunması. Yani tek bir input üzerinden işlem görmesi için.

#Araba ekleme işleminin tüm logic kısmını GarageService üzerine yazdım. Aralarına yorum satırı eklemedim fakat metod isimlerini açıklayıcı bir şekilde belirttim.
