# spring-boot-base 

### 기본 프로젝트
Spring Boot 공부

### 주요 특징
- Spring Boot(2.1.0)
- MVC
- Security
- Freemarker
- Jpa (mysql)
- JUnit 5 and 4


### logging filter 
- ContentCachingRequestWrapper 적용 (InputStream을 여러번 읽기 위해서)

### NotProfile
- Conditional, Profile을 이용한 Custom Annotation 
- 해당 Profile을 제외하고 빈 등록

### Sleuth
- MSA와 같은 여러 서비스에 걸쳐 일어나는 트랜잭션에 대한 로그 트레이싱이다. 하나의 연관된 ID를 통해 로그마다 찍어준다.

Span ID - 작업의 기본 단위로, 각 서비스 호출시 마다 생성한다.

Trace ID- 최초 호출시 생성되는 ID로, 모든 서비스를 묶어준다. 



### SessionAttributes && ModelAttribute
- 어노테이션으로 모델 정보를 자동으로 세션에 넣어준다. ModelAttribute를 통해 세션 데이터를 바인딩할 수 있다. 

### InitBinder && Custom Validator
- 우아한 데이터 바인딩


