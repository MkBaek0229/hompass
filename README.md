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
- [] 사용자는 자신의 연령대에 맞는 질문 문항을 제공받기위해 자신의 연령대를 체크하고 시작하기 버튼을 누를수 있어야한다.
- [] 테스트

# 문제 해결 사항
1. Tailwind css 라이브러리 설치시 과거의 포스팅글 (2023)년 기준
- npm install -D tailwindcss postcss autoprefixer

문제점 : 현재 이렇게 명령어를 작성해서 관련 라이브러리 설치 할경우 최신기준 ver4가 설치되어서
블로그포스팅 안내글에 따른 tailwindcss 라이브러리 설정을 할 수 가 없었다.

해결방법 : - https://kamsi76.tistory.com/entry/tailwindcss-Spring-Boot-Thymeleaf-%EC%97%90-TailwindCSS-%EC%84%A4%EC%A0%95%EB%B0%A9%EB%B2%95

해당 블로그의 글을 참조해서.
명시적으로 ver3의 tailwindcss 라이브러리를 설치 할 수 있도록 해주었다.

- npm install --save-dev tailwindcss@3 postcss autoprefixer
