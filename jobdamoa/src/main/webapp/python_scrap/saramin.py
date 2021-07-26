import requests
from bs4 import BeautifulSoup
import sys
import multiprocessing
import json

sys.setrecursionlimit(10**7)
START = 1
URL = f"https://www.saramin.co.kr/zf_user/jobs/list/job-category?page=1&cat_cd=404%2C407%2C416%2C417&exp_cd=1&loc_mcd=101000%2C102000&search_optional_item=y&search_done=y&panel_count=y&sort=RD&tab_type=all&cat_nm%5B404%5D=IT%C2%B7%EC%9D%B8%ED%84%B0%EB%84%B7+%3E+%EC%9B%B9%EA%B0%9C%EB%B0%9C&cat_nm%5B407%5D=IT%C2%B7%EC%9D%B8%ED%84%B0%EB%84%B7+%3E+%EC%9D%91%EC%9A%A9%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8%EA%B0%9C%EB%B0%9C&cat_nm%5B416%5D=IT%C2%B7%EC%9D%B8%ED%84%B0%EB%84%B7+%3E+%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4%C2%B7DBA&cat_nm%5B417%5D=IT%C2%B7%EC%9D%B8%ED%84%B0%EB%84%B7+%3E+%EC%9D%B8%EA%B3%B5%EC%A7%80%EB%8A%A5%28AI%29%C2%B7%EB%B9%85%EB%8D%B0%EC%9D%B4%ED%84%B0&loc_nm%5B101000%5D=%EC%84%9C%EC%9A%B8%EC%A0%84%EC%B2%B4&loc_nm%5B102000%5D=%EA%B2%BD%EA%B8%B0%EC%A0%84%EC%B2%B4&isSearchResultEmpty=1&isSectionHome=0&searchParamCount=3&recruit_kind=recruit&quick_apply=n&isAjaxRequest=1&page_count=50&type=job-category&is_param=1#searchTitle"
URL_LINK = f"https://www.saramin.co.kr"

def extract_saramin_page():
    result = requests.get(URL)
    soup = BeautifulSoup(result.text, "html.parser")

    job_number = soup.find("div", {"class":"recruit_list_renew"}).find("span",{"class":"total_count"}).find("em").string
    new_job_number = int(job_number.replace(",",""))
    last_page = new_job_number // 50 + 1

    return last_page


def extract_job_info(html):
    title = html.find("div", {"class":"notification_info"}).find("div", {"class":"job_tit"}).find("a", {"class":"str_tit"}).find("span").string
    company = html.find("div", {"class":"company_nm"}).find("a", {"class":"str_tit"}).find("span").string
    location = html.find("div", {"class":"company_info"}).find("p",{"class":"work_place"}).string
    experience = html.find("div", {"class":"recruit_condition"}).find("p",{"class":"career"}).string
    link = URL_LINK + html.find("div", {"class":"company_nm"}).find("a", {"class":"str_tit"})["href"]
    positions = html.find("div", {"class":"notification_info"}).find("div", {"class":"job_meta"}).find("span", {"class":"job_sector"}).find_all("span")

    p = []
    for i in positions:
        p.append(i.get_text().strip())
    positions = ",".join(p)

    result = {'title':title, 'company':company, 'location':location, 'experience':experience, 'positions':positions, 'link':link}
    
    return result

def extract_saramin_jobs(last_page):
    jobs = []
    for page in range(START, last_page+1):
        print(str(page) + "페이지 스크래핑중(사람인)")
        saramin_url = requests.get(URL.replace("page=1", f"page={page}"))
        soup = BeautifulSoup(saramin_url.text, "html.parser")

        results = soup.find_all("div", {"class":"list_item"})

        for i in results:
            job_info = extract_job_info(i)
            jobs.append(job_info)
    return jobs

def get_jobs():
    last_page = extract_saramin_page()
    jobs_list = extract_saramin_jobs(last_page)

    return jobs_list