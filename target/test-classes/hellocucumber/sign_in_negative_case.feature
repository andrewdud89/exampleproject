@NegativeTest
Feature: Sign in negative case
  Sign in to gmail negative case

  Background:
    Given Open gmail url
    Given Sign in


  Scenario: Sign in to gmail with incorrect password case 1
    When Fill email "andrewdud89@gmail.com"
    When Fill password "12345"
    When the result should be Неверный пароль. Повторите попытку или нажмите на ссылку "Забыли пароль?", чтобы сбросить его.
    When Close Brouser

  Scenario: Sign in to gmail with incorrect password case 2
    When Fill email "andrewdud89@gmail.com"
    When Fill password "!@#$%$"
    When the result should be Неверный пароль. Повторите попытку или нажмите на ссылку "Забыли пароль?", чтобы сбросить его.
    When Close Brouser


  Scenario: Sign in to gmail with incorrect password case 3
    When Fill email "andrewdud89@gmail.com"
    When Fill password ""
    When the result should be Неверный пароль. Повторите попытку или нажмите на ссылку "Забыли пароль?", чтобы сбросить его.
    When Close Brouser
