#Наръчник за правене на Unit тестове.

# Unit тестове #

Add your content here.


# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages

- За да направите Unit тестове на java клас първо трябва да кликнете с десен бутон върху класа на които искате да направите Unit тестове след което да изберете New → JUnit Test Case.
![https://lh6.googleusercontent.com/-_KvsgAlMIp0/TwmC7_3dkfI/AAAAAAAAADI/BjI2_AwANS0/s800/unit.test1.jpg](https://lh6.googleusercontent.com/-_KvsgAlMIp0/TwmC7_3dkfI/AAAAAAAAADI/BjI2_AwANS0/s800/unit.test1.jpg)

- От показалият се прозорец избирате:
  * New JUnit 4 test
  * Пакета в който да се намира теста трябва да завършва на **.test** за да се знае че в този пакет се намират тестове.
  * Следните методи може да ги генерирате при необходимост:
    1. setUpBeforeClas()
    1. tearDownAfterClas()
    1. setUp()
    1. tearDown()

![https://lh4.googleusercontent.com/-bC6GxWoWBHE/TwmGsdfNdlI/AAAAAAAAADc/2ugPIHdpeZs/s800/unit.test2.jpg](https://lh4.googleusercontent.com/-bC6GxWoWBHE/TwmGsdfNdlI/AAAAAAAAADc/2ugPIHdpeZs/s800/unit.test2.jpg)

- Натискате бутона **Next >** и избирате за кои методи от вашият клас да генерира кух код който по късно да редактирате:
![https://lh4.googleusercontent.com/-3ktch-Eetxg/TwmJLkKM7II/AAAAAAAAADk/2jVzC3h2UjM/s800/unit.test3.jpg](https://lh4.googleusercontent.com/-3ktch-Eetxg/TwmJLkKM7II/AAAAAAAAADk/2jVzC3h2UjM/s800/unit.test3.jpg)

- Тестовия клас се генерира автоматично и вече можете да добавяте нови тестове към него (важно когато създавате теств клас е името му да завършва на **Test** за да се разбира че класът е тестов).
- За да стартирате тестовете е нужно да изберете тестовия клас и да изберете от менюто Run -> Run-As -> JUnit Test.
![https://lh3.googleusercontent.com/-8xRnPwro2yg/TwmV78mSKhI/AAAAAAAAADs/i6m7mqG3q_E/s800/unit.test4.jpg](https://lh3.googleusercontent.com/-8xRnPwro2yg/TwmV78mSKhI/AAAAAAAAADs/i6m7mqG3q_E/s800/unit.test4.jpg)

- За да стартирате Unit тестове от няколко класа е необходимо да направите Test Suite:
  * Маркирате всички тестови класове съдържащи се в пакета с тестове и кликате с десен бутон на мишката върху някои от тях.
  * Избирате New->Other->JUnit Test Suite
![https://lh3.googleusercontent.com/-LFZsdYM2oiU/TwmX9dUkDcI/AAAAAAAAAD0/N7C2-wHh6Wo/s800/unit.test5.jpg](https://lh3.googleusercontent.com/-LFZsdYM2oiU/TwmX9dUkDcI/AAAAAAAAAD0/N7C2-wHh6Wo/s800/unit.test5.jpg)

  * След което натискате бутона **Next >** и избирате кои тестови класове да бъдат вкарани във Test Suite.
![https://lh6.googleusercontent.com/-xJwPex4_zcc/TwmX9jKOAII/AAAAAAAAAD4/JTOoYCswyd8/s800/unit.test6.jpg](https://lh6.googleusercontent.com/-xJwPex4_zcc/TwmX9jKOAII/AAAAAAAAAD4/JTOoYCswyd8/s800/unit.test6.jpg)
  * Създава се нов клас който може да стартирате от менюто Run -> Run-As -> JUnit Test и тои ще изпълни всички тестове от тестовите класове прикачени към него.

- За повече информация вижте следните линкове:
  * http://junit.sourceforge.net/doc/faq/faq.htm
  * http://www.junit.org/apidocs/org/junit/Assert.html
  * http://kentbeck.github.com/junit/javadoc/latest/