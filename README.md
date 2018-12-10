# LuNCh
LuNCh - backend for IoT lunsjregistrering

Trello: https://trello.com/b/bIGqICFQ/lunch

Herokuapp endepunkt for info om alle i NC: http://faghelg.herokuapp.com/persons 

Firebase: https://console.firebase.google.com/project/lunch-iot/database/lunch-iot/data 
Daniel Sandén (daniels) er "owner" og kan gi tilgang til friebasedatabasen.

Initielt oppsett er gjort, vi får kontakt med firebase, men det mangler skikkelig håndtering av events. Det er også godt mulig at nivået listener ligger på er feil, men den får i alle fall kontakt om ikke annet :P

##Fuksjonalitet

Tanken er at denne backenden skal ta imot events fra IoT-greiene, om RFID-brikke som er blitt lest eller lignende. Deretter skal serveren slå opp RFID ID i persons-tabellen for å sjekke om det finnes en bruker med den ID'en. Hvis ja trigger vi et event til appen som viser "registrert bilde" (det at man registreres til lunsj for dagen kan være event som trigger registrert bilde i appen).

Dersom RFID-ID er ukjent trigger vi et annet event i appen, nemlig registrer bruker bildet hvor bruker kan skrive inn navnet eller brukernavnet sitt for å koble RFID-ID mot nc-brukernavn (her kommer faghelg.herokuapp.com/persons inn). Det opprettes da en ny person i firebase persons tabellen og vi registrerer nytt innslag i "registrert til lunsj" tabellen som igjen trigger "du er registrert" bildet i appen.

Hvis noen lurer på noe så ta kontakt med kajas.