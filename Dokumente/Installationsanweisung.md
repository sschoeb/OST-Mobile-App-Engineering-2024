# Vorbereitung Workshop Mobile Engineering
Damit wir sofort mit den spannenden Themen rund um die Android App Entwicklung beginnen können muss jeder Teilnehmer vor dem Kurs die Entwicklungsumgebung aufgesetzt haben.
Diese Anleitung bezieht sich auf eine Windows-Installation. Grundsätzlich sollte das Vorgehen auf Linux resp. Mac OSX ähnlich sein.

## Einrichtung Repository
Sämtliche Übungen/Lösungen wie auch der Installations-Test werden über folgendes GitHub-Repository zur Verfügung gestellt:
https://github.com/sschoeb/OST-Mobile-App-Engineering-2024

Bitte klont das Repository. Beachtet dabei die folgenden Punkte:
• Der Ordner sollte nicht zu tief verschachtelt sein. Optimal etwas wie «C:/Projekte» verwenden.
• Der Pfad sollte keine Leerzeichen aufweisen
• Der Pfad sollte keine Sonderzeichen und keine Umlaute aufweisen

Solltet ihr euch nicht an diese Punkte halten, kann dies zu unspezifischen Build-Problemen führen!

## Download Android Studio 
https://developer.android.com/studio

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/2bdd159d-73d1-4c57-b6e6-6a76bc71f445)

Wir arbeiten mit der aktuellsten Version.

## Android Studio starten
Bestätigen Sie den Netzwerkzugriff. Ansonsten können keine weiteren Komponenten installiert werden.

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/8a2d6678-5c89-45eb-af18-4bf2bdb00014)

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/05c2e975-a55c-4aa7-b895-e12e71b4219c)

## Android Studio Welcome Screen
Wenn Sie hier angekommen sind haben Sie die erste Hürde geschafft. Nun müssen noch weitere Komponenten nachgeladen werden. Gehen sie dazu auf die drei Punkte und wähle dort “SDK Manager”

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/e6e19e79-03be-4dfa-946b-4e51de09377f)

Wähle dort im Tab “SDK Platforms” die folgenden Einträge aus:
- Android 12L
- Android 12.0
- 
Unter dem Tab SDK-Tools die folgenden Einträge:
- Android SDK Build-Tools 33
- Android Emulator
- Android SDK-Platform-Tools
- Android SDK Tools
- Google USB Driver (nur wenn ihr die App direkt auf eurem Android Smartphone laufen lassen wollt)
- Intel x86 Emulator Accelerator (HAXM Installer)
- 
Bestätigt dann mit “Apply” um die Installation zu starten.

## Installation überprüfen

1. Klicken Sie auf «Open» um ein bestehendes Projekt zu öffnen
![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/2b2e58f2-8f55-476c-a162-85c62e6a3b71)

2. Wählen Sie das Projekt «Installationstest» aus dem Git-Repository
![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/7b52f815-db02-474f-a15c-62e910a43bb8)

3. Das Projekt wird geöffnet
4. Öffnen Sie den “Device Manager” 

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/1229f55e-705b-4bc9-b431-590da0bfe9b3)

6. Klicken Sie auf «Create Virtual Device»

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/ad4171a4-4fed-40f1-a28f-f01e1109e672)


7. Wählen Sie ein Nexus 5X aus 

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/c83cf4d9-e619-4bb0-add3-64eb3d682513)


8. Wählen Sie das System Image “S” oder “Sv2” aus (muss gegebenenfalls noch über den Pfeil heruntergeladen werden) 

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/1255b817-9a9c-47a3-ac10-1d47b2b7de6c)


9. Konfiguration mit «Finish» bestätigen 

![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/59565a34-9928-4b67-acc5-b2bd64b5c85b)


10. Wähle den erstellten Emulator aus und starte die App über den “Play”-Button 
![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/e3ddc924-dab7-4ebd-81e7-dac8ba5dbdb9)

11. Der Emulator wird gestartet und folgende Ausgabe erscheint 
![image](https://github.com/sschoeb/OST-Mobile-App-Engineering-2024/assets/2493698/1ec567f0-cce3-46a1-9c51-89d201a4f125)

## Ready to go!
An diesem Punkt angekommen haben Sie die Installation soweit abgeschlossen und Sie sind bereits für den Mobile-Workshop. Keine Angst, sollte etwas nicht funktioniert haben, schauen wir das am ersten Abend gemeinsam an.
