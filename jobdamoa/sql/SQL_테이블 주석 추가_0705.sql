
COMMENT ON COLUMN announcement.ann_num IS '기업공고번호';

COMMENT ON COLUMN announcement.com_num IS '기업회원번호';

COMMENT ON COLUMN announcement.ann_job IS '직무';

COMMENT ON COLUMN announcement.ann_type IS '고용형태';

COMMENT ON COLUMN announcement.ann_career IS '경력';

COMMENT ON COLUMN announcement.ann_recruit_period IS '기간';

COMMENT ON COLUMN announcement.ann_location IS '근무위치';

COMMENT ON COLUMN announcement.ann_title IS '타이틀';

COMMENT ON COLUMN announcement.ann_view IS '조회수';

COMMENT ON COLUMN announcement.ann_del IS '공고삭제여부';

COMMENT ON COLUMN announcement.ann_min IS '최소급여';

COMMENT ON COLUMN announcement.ann_max IS '최대급여';

COMMENT ON COLUMN announcement.ann_contents IS '업무소개';

COMMENT ON COLUMN announcement.ann_qualification IS '자격요건';

COMMENT ON COLUMN announcement.ann_prime IS '우대사항';

COMMENT ON COLUMN announcement.ann_regdate IS '공고작성일';

COMMENT ON TABLE announcement IS '기업공고';



COMMENT ON COLUMN company.com_num IS '기업회원번호';

COMMENT ON COLUMN company.com_id IS '아이디';

COMMENT ON COLUMN company.com_password IS '비밀번호';

COMMENT ON COLUMN company.com_join_date IS '가입일';

COMMENT ON COLUMN company.com_email IS '대표이메일';

COMMENT ON COLUMN company.com_business_num IS '사업자등록번호';

COMMENT ON COLUMN company.com_name IS '회사명';

COMMENT ON COLUMN company.com_homepage IS '회사홈페이지';

COMMENT ON COLUMN company.com_emp_num IS '사원수';

COMMENT ON COLUMN company.com_sales IS '매출';

COMMENT ON COLUMN company.com_invalid IS '탈퇴여부';

COMMENT ON COLUMN company.com_address IS '회사주소';

COMMENT ON COLUMN company.com_pno IS '회사전화번호';

COMMENT ON COLUMN company.user_dist IS '회원구분';

COMMENT ON TABLE company IS '기업회원';



COMMENT ON COLUMN favorites.fav_num IS '즐겨찾기번호';

COMMENT ON COLUMN favorites.mem_num IS '회원번호';

COMMENT ON COLUMN favorites.ann_num IS '기업공고번호';

COMMENT ON TABLE favorites IS '즐겨찾기_기업공고';



COMMENT ON COLUMN manager.manager_id IS '관리자ID';

COMMENT ON COLUMN manager.manager_password IS '비밀번호';

COMMENT ON COLUMN manager.user_dist IS '회원구분';

COMMENT ON COLUMN manager.manager_num IS '관리자번호';

COMMENT ON TABLE manager IS '관리자';



COMMENT ON COLUMN member.mem_num IS '회원번호';

COMMENT ON COLUMN member.mem_id IS '아이디';

COMMENT ON COLUMN member.mem_password IS '비밀번호';

COMMENT ON COLUMN member.mem_nickname IS '닉네임';

COMMENT ON COLUMN member.mem_join_date IS '가입일';

COMMENT ON COLUMN member.mem_email IS '이메일';

COMMENT ON COLUMN member.mem_invalid IS '탈퇴여부';

COMMENT ON COLUMN member.user_dist IS '회원구분';

COMMENT ON TABLE member IS '개인회원';



COMMENT ON COLUMN scrap.scrap_num IS '즐겨찾기번호';

COMMENT ON COLUMN scrap.mem_num IS '회원번호';

COMMENT ON COLUMN scrap.scrap_title IS '타이틀';

COMMENT ON COLUMN scrap.scrap_company IS '회사';

COMMENT ON COLUMN scrap.scrap_location IS '위치';

COMMENT ON COLUMN scrap.scrap_career IS '경험';

COMMENT ON COLUMN scrap.scrap_link IS '링크';

COMMENT ON TABLE scrap IS '즐겨찾기_스크랩';

