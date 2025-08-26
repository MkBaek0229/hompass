# 건강관리 웹앱 - Hompass


# 환경 설정
1. Tailwind css 라이브러리
- 참조 문서 :
- https://gerrymandering.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%97%90%EC%84%9C-Tailwind-CSS-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
- https://kamsi76.tistory.com/entry/tailwindcss-Spring-Boot-Thymeleaf-%EC%97%90-TailwindCSS-%EC%84%A4%EC%A0%95%EB%B0%A9%EB%B2%95
# 요구사항 척도

- [o] 사용자는 hompass의 메인 화면을 확인 할 수 있다. (로고와 타이틀이 작성된 헤더)
- [o] 사용자는 hompass에 대한 간단한 설명 텍스트가 적혀있는 설명 섹션을 확인 할 수 있어야 한다.
- [o] 사용자는 hompass의 홈화면에서 시작하기 버튼을 눌러서. 자가진단 화면페이지로 넘어갈수 있어야 한다.
- [o] 사용자는 자신의 연령대에 맞는 질문 문항을 제공받기위해 자신의 연령대를 체크하고 시작하기 버튼을 누를수 있어야한다.
- [o] 사용자는 연령대를 체크하고 자가진단 페이지로 넘어가면서 랜덤한 닉네임,연령정보를 데이터베이스에 저장할수 있다.

# 문제 해결 사항
1. Tailwind css 라이브러리 설치시 과거의 포스팅글 (2023)년 기준
>npm install -D tailwindcss postcss autoprefixer

문제점 : 현재 이렇게 명령어를 작성해서 관련 라이브러리 설치 할경우 최신기준 ver4가 설치되어서
블로그포스팅 안내글에 따른 tailwindcss 라이브러리 설정을 할 수 가 없었다.

해결방법 : - https://kamsi76.tistory.com/entry/tailwindcss-Spring-Boot-Thymeleaf-%EC%97%90-TailwindCSS-%EC%84%A4%EC%A0%95%EB%B0%A9%EB%B2%95

해당 블로그의 글을 참조해서.
명시적으로 ver3의 tailwindcss 라이브러리를 설치 할 수 있도록 해주었다.

>npm install --save-dev tailwindcss@3 postcss autoprefixer

2. h2 데이터베이스 생성중 발생 에러

> Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement "drop table if exists [*]user cascade "; expected "identifier"; SQL statement:

문제점: User 엔터티 클래스를 작성후 실행하였더니 위의 에러가 발생하였다.

해결 방법 : - https://kchs94.tistory.com/220

유사한 문제에 대한 검색을 서칭하여 위의 블로그 글을 찾아냈고 해당 글을 참조하여
h2데이터베이스에서 User가 예약어이기때문에 테이블명으로 사용할수 없다는것을 알게되어
user뒤에 s를 붙여 users로 작성해주니 문제없이 작동되었다.

3. No default constructor for entity

문제점: 연령 선택 -> 자가진단 페이지에서 question 테이블에 임시로 넣어둔 데이터들을 모두 조회해와서.
해당 리스트들을 모델에 추가하여 동적렌더링을 시도하는 과정에서.
>ArrayList<Question> questionEntityList = questionRepository.findAll();

이부분에서 에러가 발생하고있었는데. No default constructor for entity에러가 발생하였음.

해결방법 : - https://velog.io/@jaeyumn/JPA-No-default-constructor-for-entity

Question Entity의 Lombok을 통해 @NoArgsConstructor 애터네이션을 작성해서 기본생성자를 만들어주었더니 해결되었다. 

