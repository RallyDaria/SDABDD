

Feature: Logowanie do aplikacji
  Jako użytkownik chę mieć możliwość logowania
  do aplikacji a móc korzystać z zaawansowanych funkcji

  Scenario: Poprawne logowanie do aplikacji
    Given Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny username
    And Uzytkownik wpisuje poprawne haslo
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany

  Scenario: Poprawne logowanie do aplikacji
    Given Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    When Uzytkownik wpisuje poprawny username
    And Uzytkownik wpisuje niepoprawne haslo
    And Uzytkownik klika przycisk Login
    Then Uzytkownik nie zostal poprawnie zalogowany

  Scenario: Poprawne logowanie do aplikacji (druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" w pole username
    And Uzytkownik wpisuje "SuperSecretPassword!" w pole pasword
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany



  Scenario: Niepoprawne logowanie do aplikacji(druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" w pole username
    And Uzytkownik wpisuje "blablabla" w pole pasword
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany

  Scenario: Niepoprawne logowanie do aplikacji(druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "  " w pole username
    And Uzytkownik wpisuje "  " w pole pasword
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany
@name
  Scenario: Niepoprawne logowanie do aplikacji(druga wersja)
    Given Uzytkownik wpisuje adres "https://the-internet.herokuapp.com/login"
    When Uzytkownik wpisuje "tomsmith" w pole username
    And Uzytkownik wpisuje "  " w pole pasword
    And Uzytkownik klika przycisk Login
    Then Uzytkownik zostal poprawnie zalogowany