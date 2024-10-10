# ProvaBackendHackatoSaloOcupacio
Prova tecnica

Descripció

Aquest projecte és una API desenvolupada amb Spring Boot en Java. Permet exportar e importar dades en format JSON a través d'operacions HTTP. A més, es compleixen tots els requisits especificats en la prova tècnica.

Requisits previs

Abans d'executar el projecte localment, assegura't de tenir instal·lats els següents components:

Java 11 o superior

Maven 3.6+

Un IDE compatible amb projectes Spring Boot (com IntelliJ IDEA o Eclipse)

Una base de dades MySQL amb el nom que posa a l'application.properties, en aquest cas, hackato. Es pot utilitzar un altra base de dades, però s'hauria d'especificar a l'application.properties.

A més a més, l'usuario root haurà de tindre la contrasenya super3, o, en cas de no voler cambiarla també s'hauria d'especificar a l'application.properties.

Requisits opcionals

Recomano fer servir Insomnia o Postman per fer les peticions de tipus POST, PUT o DELETE.

Configuració del projecte

Clona el repositori al teu ordinador:

git clone https://github.com/AriRuizMartinez/ProvaBackendHackatoSaloOcupacio.git

Despres obre el teu IDE:

Importa el projecte com a projecte Maven.

Executa la classe principal del projecte, que és DemoApplication.java.

L'aplicació s'executarà en http://localhost:9000. (El port també es pot cambiar a l'application.properties en cas de que el 9000 estigues ocupat)


Endpoints:

Usuaris:

    GET-http://localhost:9000/appActivitats/users

        Per mitja de d'una petició GET retorna l'informació de tots els usuaris.

    POST-http://localhost:9000/appActivitats/user

        Per mitja de d'una petició POST afegeix un nou usuari. Aquest s'ha de passar per mitjà del body en format JSON.

    GET-http://localhost:9000/appActivitats/users/{id}

        Per mitja de d'una petició GET retorna l'informació d'un usuari, el de l'id especificada. Per fer aquesta peticio ha de ser un id valid i sense {}. Ex: http://localhost:9000/appActivitats/users/1

    PUT-http://localhost:9000/appActivitats/users/{id}

        Per mitja de d'una petició PUT actualitza l'informació d'un usuari, el de l'id especificada. L'informació actualitzada s'ha de passar per mitjà del body en format JSON. 
        Per fer aquesta peticio ha de ser un id valid i sense {}. Ex: http://localhost:9000/appActivitats/users/1

    DELETE-http://localhost:9000/appActivitats/users/{id}

        Per mitja de d'una petició DELETE elimina un usuari, el de l'id especificada. Per fer aquesta peticio ha de ser un id valid i sense {}. Ex: http://localhost:9000/appActivitats/users/1

Activitat:

    POST-http://localhost:9000/appActivitats/actividad

        Per mitja de d'una petició POST afegeix una nova activitat. Aquesta s'ha de passar per mitjà del body en format JSON

    GET-http://localhost:9000/appActivitats/actividades

        Per mitja de d'una petició GET retorna l'informació de totes les activitats.

    GET-http://localhost:9000/appActivitats/actividades/{id}

        Per mitja de d'una petició GET retorna l'informació d'una activitat, la de l'id especificada. Per fer aquesta peticio ha de ser un id valid i sense {}. Ex: http://localhost:9000/appActivitats/actividades/1

    GET-http://localhost:9000/appActivitats/actividades/exportar

        Per mitja de d'una petició GET descarrega un fitxer JSON amb l'informació de totes les activitat.

    POST-http://localhost:9000/appActivitats/actividades/crear

        Per mitja de d'una petició POST afegeix noves activitats. Aquestes s'han de passar per mitjà del body en format JSON.

    POST-http://localhost:9000/appActivitats/actividades/importar

        Per mitja de d'una petició POST afegeix noves activitats. Aquestes s'han de passar per un fitxer del body en format JSON. Per fer-ho el nom del camp ha de ser "file" i adjuntar un arxiu .JSON amb les activitats.

    POST-http://localhost:9000/appActivitats/{usuarioId}/inscribir/{actividadId}

        Per mitja de d'una petició POST un usuari s'inscriu a una activitat, la de l'id especificada. Per fer aquesta peticio han de ser ids valids i sense {}. Ex: http://localhost:9000/appActivitats/1/inscribir/1

Amb els endpoints es compleixen els requisits tecnics i funcionals esmentats. La resta de requisits també es compleixen:

1. El projecte segueix un patró estructural

    El projecte està basat en l'arquitectura MVC (Model-View-Controller), que és un patró arquitectònic molt utilitzat en aplicacions Spring Boot. Aquesta estructura separa clarament les responsabilitats de cada component:

    Model: Representa les dades i les regles de negoci de l'aplicació. Les entitats com Actividad s'encarreguen d'emmagatzemar la informació.
    Controller: Gestiona les sol·licituds HTTP, connectant els models amb les vistes.
    View: Actualment el projecte no te vista, però aixi es veu més clar que estan separats tant el model, com la vista, com el controlador.

2. El codi és escalable i reutilitzable

    El codi està dissenyat per ser escalable gràcies a l'ús de Spring Boot, que permet modularitzar funcionalitats. El fet de tenir components desacoblats, com els controladors i els serveis, 
    facilita que es puguin afegir noves funcionalitats o escalar l'aplicació sense haver de modificar la major part del codi existent.

3. El codi està optimitzat i el seu rendiment és eficient

    L'aplicació està optimitzada per manejar arxius JSON grans i múltiples sol·licituds simultànies gràcies a les següents característiques:

    Spring Boot utilitza mecanismes interns de gestió de recursos, com la gestió de sessions i connexions a la base de dades, que milloren l'eficiència i el rendiment.
    L'ús d'ObjectMapper de Jackson per convertir dades JSON a objectes Java està optimitzat, ja que és una llibreria molt eficient en termes de deserialització.
    El disseny de l'API assegura que cada sol·licitud sigui manejada de manera independent, la qual cosa facilita la seva escalabilitat en entorns distribuïts.

4. El codi segueix bones pràctiques de programació

    El codi segueix bones pràctiques de programació:

    Neteja i llegibilitat: El codi està ben estructurat amb noms de mètodes i variables descriptius, cosa que facilita la seva comprensió per altres desenvolupadors.
    Gestió d'errors: L'aplicació gestiona correctament els errors, com quan es puja un arxiu buit o un arxiu amb format incorrecte. Això ajuda a evitar excepcions no controlades durant l'execució.
    Modularitat: Les diferents funcionalitats es divideixen en components separats (models, controladors, serveis), seguint el principi de separació de responsabilitats.

5. Les funcions tenen una única responsabilitat

    Cada funció dins del projecte segueix el principi de responsabilitat única (Single Responsibility Principle), que és un dels pilars dels principis SOLID:

    Els controladors tenen la responsabilitat de gestionar les sol·licituds HTTP.
    Les classes model, com Actividad, només tenen la responsabilitat de representar les dades i no contenen lògica de negoci.
    Aquest enfocament permet un codi més fàcil de mantenir i modificar, ja que cada funció o classe té una única responsabilitat clarament definida. Això també redueix el risc d'introduir errors quan s'afegeixen noves funcionalitats.

Autor
Ari Ruiz Martinez - ariruizmartinez@gmail.com


