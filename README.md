# DevBooks
개인 프로젝트 - 도서 판매 관리 시스템

### For Mac M1 ~

docker desktop을 실행하고 docker 폴더 내에서 터미널로 명령어 `docker-compose up`를 통해서 애플리케이션에 필요한 MySql 서버와
데이터베이스를 실행할 수 있습니다.

### For Windows

`docker-compose up` 명령어 실행 전 docker-compose.yml을 편집합니다. 

기존 `platform: linux/arm64/v8`에서 `platform: linux/x86_64`로 바꾼 후 `docker-compose up`를 실행합니다. 