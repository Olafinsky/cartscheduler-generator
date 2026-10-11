# Generator

## Użycie z CartScheduler Backend

Biblioteka jest publikowana jako pakiet Maven do GitHub Packages, dlatego backend
nie potrzebuje lokalnej ścieżki do tego repozytorium. Wersja `1.0.0` jest
publikowana automatycznie po wypchnięciu tagu `v1.0.0`:

```shell
git tag v1.0.0
git push origin v1.0.0
```

Wykonuje to workflow `.github/workflows/publish-package.yml`. Numer wersji
artefaktu pochodzi z tagu bez prefiksu `v`; każdą kolejną publikację wykonuj z
nowym tagiem, np. `v1.0.1`.

Na komputerze, na którym backend pobiera bibliotekę, utwórz plik
`~/.gradle/gradle.properties` (nigdy nie dodawaj go do repozytorium):

```properties
gpr.user=Olafinsky
gpr.key=TOKEN_GITHUB
```

Token klasyczny GitHub wymaga zakresu `read:packages` do pobierania pakietu;
do ręcznego publikowania potrzebny jest również `write:packages`.

Instrukcja z `mavenLocal()` poniżej pozostaje wyłącznie opcjonalnym sposobem
testowania biblioteki lokalnie — nie jest potrzebna do pracy backendu.

Biblioteka Java do generowania arkuszy z kandydatami. Wymaga Java 21 lub nowszej.

## Budowanie

```shell
./gradlew build
```

Na Windowsie użyj `gradlew.bat build`. Gotowy plik JAR znajduje się w `build/libs`.

## Użycie w innym projekcie Gradle

Najpierw opublikuj bibliotekę w lokalnym repozytorium Maven:

```shell
./gradlew publishToMavenLocal '-PreleaseVersion=1.0.0'
```

Dodaj `mavenLocal()` oraz zależność do `build.gradle` projektu-klienta:

```groovy
repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation 'org.cartscheduler:cartscheduler-generator:1.0.0'
}
```

Główne API znajduje się w pakiecie `org.generator`. Gotowe filtry są w pakietach
`org.generator.acceptancefilter`, `org.generator.scorefilter` i
`org.generator.postgenerationfilter`.
