INSERT INTO books (title, author, publisher, published_date, isbn, description, deleted_yn)
VALUES ('Clean Code 클린 코드', '로버트 C. 마틴', '인사이트(insight)', '2013-12-24', '9788966260959', '애자일 소프트웨어 장인 정신', 'N'),
       ('스프링 부트 3 백엔드 개발자 되기 : 자바 편 (2판)', '신선영', '골든래빗', '2024-04-05', '9791191905717',
        'JPA+OAuth2+JWT+AWS와 배우는 스프링 부트 3 Java 백엔드 입문자를 위한 풀 패키지', 'N'),
       ('GitOps Cookbook', '나탈리 빈토, 알렉스 소토 부에노', '인사이트(insight)', '2024-11-26', '9788966264537',
        '커스터마이즈, 헬름, 텍톤, Argo CD를 활용한 쿠버네티스 CI/CD 구축하기', 'N');

INSERT INTO bookimages (book_id, image_url)
VALUES (1, 'https://image.yes24.com/goods/11681152/XL'),
       (2, 'https://image.yes24.com/goods/125668284/XL'),
       (3, 'https://image.yes24.com/goods/138929285/XL');

INSERT INTO jpa_books (title, author, publisher, published_date, isbn, description)
VALUES ('Clean Code 클린 코드', '로버트 C. 마틴', '인사이트(insight)', '2013-12-24', '9788966260959', '애자일 소프트웨어 장인 정신'),
       ('스프링 부트 3 백엔드 개발자 되기 : 자바 편 (2판)', '신선영', '골든래빗', '2024-04-05', '9791191905717',
        'JPA+OAuth2+JWT+AWS와 배우는 스프링 부트 3 Java 백엔드 입문자를 위한 풀 패키지'),
       ('GitOps Cookbook', '나탈리 빈토, 알렉스 소토 부에노', '인사이트(insight)', '2024-11-26', '9788966264537',
        '커스터마이즈, 헬름, 텍톤, Argo CD를 활용한 쿠버네티스 CI/CD 구축하기');

INSERT INTO jpa_bookimages (book_id, image_url)
VALUES (1, 'https://image.yes24.com/goods/11681152/XL'),
       (2, 'https://image.yes24.com/goods/125668284/XL'),
       (3, 'https://image.yes24.com/goods/138929285/XL');