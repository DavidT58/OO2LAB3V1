## ЕЛЕКТРОТЕХНИЧКИ ФАКУЛТЕТ

```
Одсеци за СИ, ИР, ОС и ОФ Београд 17. 05. 2020.
```
```
```
# Трећи домаћи задатак из Објектно оријентисаног програмирања 2

```
1 ) Саставити на језику Java следећи пакет класа:
```
- Активна **_рупа_** је платно (Canvas) браон боје која се ствара са задатом баштом у којој се
    налази и садржи животињу која може да се постави и дохвати. Могуће је згазити рупу и тада
    се испољава ефекат ударене животиње у рупи. Операција је без ефекта уколико животиња
    није постављена. При исцртавању рупе исцртава се животиња, уколико је постављена. Нит
    рупе је могуће створити, покренути и трајно зауставити. Могуће је испитати да ли је нит
    рупе покренута. Радња рупе се састоји из исцртавања у постављеном броју корака са
    размацима од 100 милисекунди. Број корака може да се постави и дохвати. Након последњег
    корака рупа чека 2 секунде а потом се нит рупе трајно зауставља. Трајним заустављањем
    нити рупе уклања се животиња и обавештава башта да је рупа слободна. Додатно, пре
    уклањања животиње, уколико она није до тада била ударена (у току трајања исцртавања
    закључно са чекањем), испољава се ефекат побегле животиње.
- **_Животиња_** се ствара са задатом рупом из које излази. Могуће је исцртати животињу на
    њеној рупи. Животиња се исцртава у одређеном облику одговарајућих димензија. Димензије
    се рачунају као проценат од димензија рупе (платна) који је једнак проценту тренутног
    корака исцртавања рупе у односу на укупан број корака. Могуће је испољити ефекат ударене
    животиње и ефекат побегле животиње.
- **_Кртица_** је животиња која се исцртава тамно сивом бојом у облику елипсе. Испољавањем
    ефекта ударене кртице рупа из које кртица излази се трајно зауставља. Испољавањем ефекта
    побегле кртице се краде јединична количина поврћа из баште.
- Активна **_башта_** је панел са зеленом позадином који садржи матрицу рупа, одређену
    количину поврћа (при стварању 100), интервал чекања и број корака за исцртавање рупа.
    Ствара се са задатим бројем врста и колона. Могуће је поставити и дохватити број корака
    исцртавања рупа. Постављањем броја корака он се примењује на све рупе у башти. Могуће је
    смањити количину поврћа за један. Одређену рупу у башти је могуће згазити притиском
    миша над њом. Башту је могуће покренути и трајно зауставити. Радња баште се састоји из
    постављања кртице у насумично одабраној слободној рупи на постављени интервал чекања
    након чега се нит рупе ствара и покреће. Интервал чекања је могуће поставити. Након
    стварања и покретања нити нове рупе, интервал чекања се смањује за 1 проценат. Могуће је
    обавестити башту да је рупа слободна. При покретању су све рупе подразумевано слободне.
- **_Игра_** је главни прозор апликације (са слике) који садржи једну башту величине 4 x 4. Сме
    постојати само један примерак игре који је могуће дохватити. Могуће је покренути игру са
    одабраном тежином притиском на дугме Kreni и тада се покреће башта, а дугме мења
    натпис у Stani. Текућу игру је могуће трајно зауставити
    притиском на дугме Stani, када се мења натпис дугмета у
    Kreni. Одабрана тежина поставља интервал чекања у башти
    и број корака исцртавања рупе на 1000 ms и 10 (лако),
    односно 750ms и 8 (средње), односно 500ms и 6 (тешко),
    респективно. Након покретања игре, тежину није могуће
    променити. Игра приказује број преостале количине поврћа у
    башти. Игра се аутоматски зауставља када количина поврћа у
    башти падне на 0.

**НАПОМЕНЕ:
а)** Трећи домаћи задатак је основа за израду треће лабораторијске вежбе.
**б)** Студент треба да преда своја решења, сходно упутствима које добије преко мејлинг листе предмета. Предата решења
биће доступна студенту и користиће их као полазну тачку за израду лабораторијске вежбе.
**в)** Решење домаћег задатка се не оцењује, али улази у састав решења лабораторијске вежбе које се оцењује


