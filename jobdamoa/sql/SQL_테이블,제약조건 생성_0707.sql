-- 기업공고 테이블 생성
CREATE TABLE announcement
(
    ann_num    NUMBER NOT NULL,
    com_num    NUMBER NOT NULL,
    ann_job    VARCHAR2(20) NOT NULL,
    ann_type    VARCHAR2(20) NOT NULL,
    ann_career    VARCHAR2(20) NOT NULL,
    ann_recruit_period    VARCHAR2(50) NOT NULL,
    ann_location    VARCHAR2(20) NOT NULL,
    ann_title    VARCHAR2(100) NOT NULL,
    ann_view    NUMBER NOT NULL,
    ann_del    CHAR(1) DEFAULT 'n' NOT NULL,
    ann_min    NUMBER NOT NULL,
    ann_max    NUMBER NOT NULL,
    ann_contents    VARCHAR2(1000) NOT NULL,
    ann_qualification    VARCHAR2(1000) NOT NULL,
    ann_prime    VARCHAR2(1000) NOT NULL,
    ann_regdate    DATE DEFAULT sysdate NOT NULL
);
-- 기업공고 PK 인덱스 생성
CREATE UNIQUE INDEX idx_ann_pk ON announcement
( ann_num );
-- 기업공고 PK 지정
ALTER TABLE announcement
 ADD CONSTRAINT ann_pk PRIMARY KEY ( ann_num )
 USING INDEX idx_ann_pk;
-- 기업공고 고용형태 제약조건 지정
ALTER TABLE announcement
 ADD CONSTRAINT ann_type_ck CHECK ( ann_type IN ('regular','contract','intern','rest') );
-- 기업공고 경력 제약조건 지정
ALTER TABLE announcement
 ADD CONSTRAINT ann_career_ck CHECK ( ann_career IN ('new','old','okay') );
-- 기업공고 게시물 삭제여부 제약조건 지정(초기값 n)
ALTER TABLE announcement
 ADD CONSTRAINT ann_del_ck CHECK ( ann_del IN ('y','n') );

-- 기업회원 테이블 생성
CREATE TABLE company
(
    com_num    NUMBER NOT NULL,
    com_id    VARCHAR2(20) NOT NULL,
    com_password    VARCHAR2(20) NOT NULL,
    com_join_date    DATE DEFAULT sysdate NOT NULL,
    com_email    VARCHAR2(30) NOT NULL,
    com_business_num    VARCHAR2(30) NOT NULL,
    com_name    VARCHAR2(20) NOT NULL,
    com_homepage    VARCHAR2(50),
    com_emp_num    NUMBER NOT NULL,
    com_sales    NUMBER NOT NULL,
    com_invalid    CHAR(1) DEFAULT 'n' NOT NULL,
    com_address    VARCHAR2(50) NOT NULL,
    com_pno    VARCHAR2(20) NOT NULL,
    user_dist    CHAR(1) DEFAULT '1' NOT NULL
);
-- 기업회원 PK 인덱스 생성
CREATE UNIQUE INDEX idx_company_pk ON company
( com_num );
-- 기업회원 PK 지정
ALTER TABLE company
 ADD CONSTRAINT com_pk PRIMARY KEY ( com_num )
 USING INDEX idx_company_pk;
-- 기업회원 UK 인덱스 생성
CREATE UNIQUE INDEX idx_company_uk ON company
( com_id ); 
-- 기업회원 UK 지정 (ID)
ALTER TABLE company
 ADD CONSTRAINT company_uk UNIQUE ( com_id )
 USING INDEX idx_company_uk;
-- 기업회원 탈퇴여부 제약조건 지정(초기값 n)
ALTER TABLE company
 ADD CONSTRAINT com_invalid_ck CHECK ( com_invalid IN ('y','n') );

-- 즐겨찾기 테이블 생성
CREATE TABLE favorites
(
    fav_num    NUMBER NOT NULL,
    mem_num    NUMBER NOT NULL,
    ann_num    NUMBER NOT NULL
);
-- 즐겨찾기 pk 인덱스 생성
CREATE UNIQUE INDEX idx_fav_pk ON favorites
( fav_num );
-- 즐겨찾기 pk 지정
ALTER TABLE favorites
 ADD CONSTRAINT fav_pk PRIMARY KEY ( fav_num )
 USING INDEX idx_fav_pk;

-- 관리자 테이블 생성
CREATE TABLE manager
(
    manager_id    VARCHAR2(20) NOT NULL,
    manager_password    VARCHAR2(20) NOT NULL,
    user_dist    CHAR(1) DEFAULT '2' NOT NULL,
    manager_num    NUMBER NOT NULL
);
-- 관리자 pk 인덱스 생성
CREATE UNIQUE INDEX idx_manager_pk ON manager
( manager_num );
-- 관리자 pk 지정
ALTER TABLE manager
 ADD CONSTRAINT manager_pk PRIMARY KEY ( manager_num )
 USING INDEX idx_manager_pk;
-- 관리자 uk 인덱스 생성
CREATE UNIQUE INDEX idx_manager_uk ON manager
( manager_id );
-- 관리자 uk 지정
ALTER TABLE manager
 ADD CONSTRAINT manager_UK UNIQUE ( manager_id )
 USING INDEX idx_manager_uk;

-- 회원 테이블 생성
CREATE TABLE member
(
    mem_num    NUMBER NOT NULL,
    mem_id    VARCHAR2(20) NOT NULL,
    mem_password    VARCHAR2(20) NOT NULL,
    mem_nickname    VARCHAR2(20) NOT NULL,
    mem_join_date    DATE DEFAULT sysdate NOT NULL,
    mem_email    VARCHAR2(30) NOT NULL,
    mem_invalid    CHAR(1) DEFAULT 'n' NOT NULL,
    user_dist    CHAR(1) DEFAULT '0' NOT NULL
);
-- 회원 pk 인덱스 생성
CREATE UNIQUE INDEX idx_mem_pk ON member
( mem_num );
-- 회원 pk 지정
ALTER TABLE member
 ADD CONSTRAINT mem_pk PRIMARY KEY ( mem_num )
 USING INDEX idx_mem_pk;
-- 회원 uk 인덱스 생성
CREATE UNIQUE INDEX idx_mem_uk ON member
( mem_id );
-- 회원 uk 지정
ALTER TABLE member
 ADD CONSTRAINT mem_uk UNIQUE ( mem_id )
 USING INDEX idx_mem_uk;
-- 회원 탈퇴여부?제약조건 지정(초기값 n)
ALTER TABLE member
 ADD CONSTRAINT mem_invalid_ck CHECK ( mem_invalid IN ('y','n') );

-- 즐겨찾기_스크랩 테이블 생성
CREATE TABLE scrap
(
    scrap_num    NUMBER NOT NULL,
    mem_num    NUMBER NOT NULL,
    scrap_title    VARCHAR2(100) NOT NULL,
    scrap_company    VARCHAR2(20) NOT NULL,
    scrap_location    VARCHAR2(20) NOT NULL,
    scrap_career    VARCHAR2(20) NOT NULL,
    scrap_link    VARCHAR2(100) NOT NULL
);
-- 즐겨찾기_스크랩 pk 인덱스 생성
CREATE UNIQUE INDEX idx_scrap_pk ON scrap
( scrap_num );
-- 즐겨찾기_스크랩 pk 지정
ALTER TABLE scrap
 ADD CONSTRAINT scrap_pk PRIMARY KEY ( scrap_num )
 USING INDEX idx_scrap_pk;