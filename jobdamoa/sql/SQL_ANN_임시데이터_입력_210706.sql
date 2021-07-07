SELECT * FROM ANNOUNCEMENT;
COMMIT;
-- 임시데이터 1
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(1, 1, '백엔드', 'regular', 'new', '수시채용', '서울 강남구', '서버 개발자 모집', 20, 3000, 3500, '업무가 쉬워요', '서버를 잘 아는 사람만 지원하세요.', '정보처리기사 자격증 보유');
-- 임시데이터 2
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(2, 2, '프런트엔드', 'contract', 'old', '수시채용', '서울 노원구', '웹 개발자 모집', 21, 4000, 4800, '경력 있는 사람만 오세요', '프런트 잘 하는 사람만.', '없음');
-- 임시데이터 3
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(3, 3, '백엔드', 'regular', 'new', '정기채용', '서울 중구', '서버 개발자 모집', 20, 2800, 3000, '업무가 어려워요', '서버를 잘 아는 사람만 지원하세요.', '아무나');
-- 임시데이터 4
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(4, 4, 'DBA', 'rest', 'okay', '수시채용', '판교', 'DBA 모집', 20, 3000, 3500, '실력 있는 DBA만', 'MariaDB를 잘 다루는 사람만', 'OCJP 자격증 또는 그에 준하는 능력 보유자');
-- 임시데이터 5
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(5, 5, '백엔드', 'regular', 'new', '상시채용', '서울 강서구', '서버 개발자 모집', 20, 3000, 4000, '좋좋소 아님', '일 잘하는 신입만', '정보처리기사 자격증 보유');
-- 임시데이터 6
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(6, 6, '디자이너', 'regular', 'old', '공개채용', '서울 강북구', '디자이너 모집', 24, 5000, 5500, 'CSS와 여러가지 프런트단까지 할 줄 알아야 함', '기술이 좋은 사람 우대', '포토샵, CSS, 일러스트 기본');
-- 임시데이터 7
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(7, 7, '기술영업', 'contract', 'old', '수시채용', '서울 강남구', 'IT영업인 모집', 40, 5000, 6000, '말을 잘 하는 사람만', '기술 스펙 필요 없음', '없음');
-- 임시데이터 8
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(8, 8, '서버 운영', 'intern', 'old', '~ 12-31', '서울 강남구', '리눅스/유닉스 운영 대기조 모집', 20, 4000, 4200, '업무가 쉬워요', '밤 잘 새고, 문제 발생 시 대응 잘 하는 사람 우대', '리눅스마스터 자격증 보유');
-- 임시데이터 9
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(9, 9, 'CTO', 'contract', 'old', '공개채용', '서울 성동구', '기술고문 모집', 100, 10000, 12000, '다양한 기술 보유한 CTO', '기술적으로 업무 이해도가 있어야 함', '대기업 임원 출신 우대');
-- 임시데이터 10
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(10, 10, '서버관리', 'regular', 'new', '상시채용', '경기 평택시', '삼성전자 반도체 서버 운영자 모집', 30, 3200, 3500, '업무가 쉬워요', '서버를 잘 아는 사람만 지원하세요.', '정보처리기사 자격증 보유');
-- 임시데이터 11
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(11, 11, '인공지능 개발', 'regular', 'new', '수시채용', '경기 김포시', '인공지능 AI 개발자 모집', 44, 4400, 4900, '고난이도 업무입니다.', '인공지능 업무 경험이 있으면 좋아요.', '석/박사 학위 우대');
-- 임시데이터 12
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(12, 12, '프런트엔드', 'intern', 'new', '정기채용', '서울 도봉구', '웹 개발자 모집', 20, 3000, 3500, '업무가 쉬워요', '웹, 자바스크립트, jquery 등 다룰 줄 알아야 함', '정보처리기사 자격증 보유');
-- 임시데이터 13
INSERT INTO ANNOUNCEMENT(ANN_NUM, COM_NUM, ANN_JOB, ANN_TYPE, ANN_CAREER, ANN_RECRUIT_PERIOD, ANN_LOCATION, ANN_TITLE, ANN_VIEW, ANN_MIN, ANN_MAX, ANN_CONTENTS, ANN_QUALIFICATION, ANN_PRIME)
VALUES(13, 13, '백엔드', 'intern', 'new', '정기채용', '서울 도봉구', '응용프로그램 개발자 모집', 20, 3000, 3500, '업무가 쉬워요', 'awt, javafx 등 자바기반 응용프로그램 개발', '정보처리기사 자격증 보유');