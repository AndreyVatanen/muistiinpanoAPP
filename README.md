Muistio on yksinkertainen mutta toimiva muistiinpanosovellus, jossa yhdistyvät
Spring Boot REST API, Vaadin 24 -käyttöliittymä sekä kevyt HashMap-pohjainen "mock-tietokanta".
Sovelluksella voi luoda muistiinpanoja, tarkastella niitä ja merkitä ne tehdyiksi.


Backend
- Spring Boot
- Spring Web (REST API)

Frontend
- Vaadin 24 (Java UI Framework)

Data
- HashMap mock-tietokanta (ei oikeaa tietokantaa)

Muut
- Maven
- Java 21



Backend (REST API)

Sovelluksessa on yksinkertainen REST-rajapinta, jolla voi tehdä CRUD-operaatioita:

Metodi	Polku	Kuvaus
GET	/api/nayta	Hakee kaikki muistiinpanot
GET	/api/nayta/{id}	Hakee yhden muistiinpanon
POST	/api/luo/{id}	Luo uuden muistiinpanon
PUT	/api/muokkaa	Muokkaa olemassa olevaa
DELETE	/api/poista/{id}	Poistaa muistiinpanon


Esimerkkipyyntö:

POST /api/luo/1
{
  "id": 1,
  "tehtava": "Muista sali klo 15:00",
  "tehty": false
}


Käynnistys: 
git clone https://github.com/USERNAME/muistiinpanoAPP.git
cd muistiinpanoAPP
mvn spring-boot:run
http://localhost:8080/main
