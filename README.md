# Project-KoAnalyzer
Korean NLP framework with Java

**Alive Module : KoAnalyzer-APIServer**

**Other modules will be deleted**

* KoAnalyzer는 twitter-korean-text(https://github.com/twitter/twitter-korean-text)를 기반으로 하여 한국어 자연어 처리 기능을 제공합니다.

* **핵심 한국어 자연어 처리 기능은 twitter-korean-text(https://github.com/twitter/twitter-korean-text)에서 개발되었습니다.**

* KoAnalyzer는 서버형태로 작동되어 API 서버 형태로 사용할 수 있습니다. 

###한국어 자연어 처리 기능###
* KoAnalyzer는 Spring-Data JPA를 통해 자연어 처리 결과를 자동으로 DB에 저장합니다. POST 메서드로 URL을 요청하면 GET 방식과 동일한 기능을 수행하되, DB에 Phrase 결과를 저장합니다. 

* /resources/config.properties를 통해 DB연결을 설정할 수 있습니다.

~~~
//Default configuration for H2 in-memory database
DriverClass=org.h2.Driver
DBurl=jdbc:h2:mem:testdb
DBuser=sa
DBpassword=
RepoPackage=com.KoAnalyzer.APIServer
~~~

* MySQL 설정 에제

**한글 DB 저장을 위해 useUnicode=true&characterEncoding=utf8 반드시 포함**

~~~
DriverClass=com.mysql.jdbc.Driver
DBurl=jdbc:mysql://localhost:8080/test?useUnicode=true&characterEncoding=utf8
DBuser=test
DBpassword=
RepoPackage=com.KoAnalyzer.APIServer
~~~

####한국어 정규화 Normalization
* URL : /normalization/{text} GET

####한국어 토큰화 Tokenization
* URL : /tokenization/{text} GET

####한국어 어근화 Stemming
* URL : /stemming/{text} GET

####어구 추출 Phrase Extraction
* URL : /extraction/{text} GET

추가할 지원 기능
* 자연어 처리 결과를 ORM을 통해 DB에 저장

* 정규화 / 어근화 / 토큰화 / 추출 결과에 대한 빈도수 통계 기능 제공

###사용된 기술
* Scala

* Spring-Boot

* Hibernate 

###빌드
* KoAnalyzer는 Gradle를 사용하고 있습니다.

