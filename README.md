# Project-KoAnalyzer
Korean NLP framework with Java

> KoAnalyzer는 twitter-korean-text(https://github.com/twitter/twitter-korean-text)를 기반으로 하여 한국어 자연어 처리 기능을 제공합니다.

> **핵심 한국어 자연어 처리 기능은 twitter-korean-text(https://github.com/twitter/twitter-korean-text)에서 개발되었습니다.**

> KoAnalyzer는 서버형태로 작동되어 API 서버 형태로 사용할 수 있습니다. 

####한국어 정규화 Normalization
> URL : /normalization/{text} GET

####한국어 토큰화 Tokenization
> URL : /tokenization/{text} GET

####한국어 어근화 Stemming
> URL : /stemming/{text} GET

####어구 추출 Phrase Extraction
> URL : /extraction/{text} GET

추가할 지원 기능
> 자연어 처리 결과를 ORM을 통해 DB에 저장

> 정규화 / 어근화 / 토큰화 / 추출 결과에 대한 빈도수 통계 기능 제공

사용된 기술
> Scala

> Spring-Boot

> Hibernate 

빌드
> KoAnalyzer는 Gradle를 사용하고 있습니다.

