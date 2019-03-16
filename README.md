# spring-boot-base 

### 기본 프로젝트
보다 빠르고 편리하게 개발하기 위한 기본 코드 + 공부

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


### SessionAttributes && ModelAttribute
- 어노테이션으로 모델 정보를 자동으로 세션에 넣어준다. ModelAttribute를 통해 세션 데이터를 바인딩할 수 있다. 

### InitBinder && Custom Validator
- 우아한 데이터 바인딩


