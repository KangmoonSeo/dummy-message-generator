# dummy-message-generator
simple message generator for LLM Project

## quick start
1. install jdk-11 or jdk-17
    ```bash
    # jdk-11
    sudo apt-get install openjdk-11-jdk 
    ```
2. run start.sh
	```bash
	sh start.sh
	```

## API docs
- Request
    - Request Syntax
        | 메서드 | 요청 URL |
        | --- | --- |
        | GET | /api/* |
    - Request Elements
        | 파라미터 | 타입 | 필수 | 설명 |
        | --- | --- | --- | --- |
        | query | String |  | 사용자가 서버에 보낼 쿼리 |
- Response
    - Response Elements
        | 필드 | 타입 | 필수 | 설명 |
        | --- | --- | --- | --- |
        | isFinished | Boolean | Y | 메시지 응답 제공이 끝났는지 여부<br/>false면 이어서 응답을 제공하고,<br/>true면 서버가 모든 응답을 제공한 상태<br/>더미에서는 20%→true, 80%→false 반환  |
        | contentType | String | Y | content type<br/>text 또는 image |
        | content | String |  | content<br/>text: response string<br/>image:  |
        | createdDate | DateTime | Y | 응답이 생성된 DateTime |
