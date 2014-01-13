#JEE Czytelnia (JDK 1.7)

**Autor:** Maciej Kołek / kontakt@ferus.info

Aplikacja korzysta z następujących technologii, frameworków:

* JSF
* EJB 3.1
* JPA
* Hibernate
* OmniFaces `dla wstrzykiwania EJB do FacesConverter`
* mySQL za pomocą jdbc
* CDI, BeanValidations
* [PureCSS.io](http://purecss.io) `do stylowania tabel`

Aplikacja posiada:

* Konwertery `@FacesConverter`
* Validatory `@FacesValidator - pesel`
* AJAX `konwersja pola tekstowego z pierwszej malej litery na duza`

Na aplikacje składają się:

* 4 klasy entity
* 4 klasy EJB
* 4 klasy kontrolerów
* 3 Konwertery
* 1 Validator
* 1 plik `.sql` z definicją bazy danych
* ... dużo plików `*.xhtml`
