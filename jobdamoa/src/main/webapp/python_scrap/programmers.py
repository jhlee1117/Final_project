import requests
from bs4 import BeautifulSoup
import json

START = 1
URL = f"https://programmers.co.kr/job?_=1624927323767&job_position%5Bdummy%5D=0&job_position%5Bmin_career%5D=0&order=recent"

def extract_programmers_page():
    result = requests.get(URL)
    soup = BeautifulSoup(result.text, "html.parser")
    pagination = soup.find("ul", {"class":"pagination"})
    lists = pagination.find_all('a')

    pages = []
    for list in lists:
        if list.string.isdigit():
            pages.append(int(list.string))

    last_page = pages[-1]

    return last_page


def extract_job_info(html):
    title = html.find("h5", {"class":"position-title"}).find("a").string
    company = html.find("h6", {"class":"company-name"})
    job_id = html.find("h5", {"class":"position-title"}).find("a")["href"]

    if company.find("span") is not None:
        company.span.decompose()
        company = company.get_text().strip()
    else:
        company = company.get_text().strip()

    company_info = html.find("ul", {"class":"company-info"})
    location = company_info.find("li", {"class":"location"})
    location.svg.decompose()
    location = location.get_text().strip()
    experience = company_info.find("li",{"class":"experience"})
    experience.svg.decompose()
    experience = experience.get_text().strip()
    
    positions = html.find("ul", {"class":"list-position-tags"}).find_all("li", {"class":"stack-item"})
    p = []

    for i in positions:
        p.append(i.get_text().strip())
        print(i.get_text().strip())
    positions = ",".join(p)

    result = {'title':title, 'company':company, 'location':location, 'experience':experience, 'positions':positions, 'link':f"https://programmers.co.kr{job_id}"}
    return result

def extract_programmers_jobs(last_page):
    jobs = []

    for page in range(START, last_page+1):
        print(str(page) + "페이지 스크래핑중(프로그래머스)")
        result = requests.get(f"{URL}&page={page}")
        soup = BeautifulSoup(result.text, "html.parser")

        results = soup.find_all("li", {"class":"list-position-item"})

        for i in results:
            job_info = extract_job_info(i)
            jobs.append(job_info)
    
    return jobs

def get_jobs():
    last_page = extract_programmers_page()
    jobs_list = extract_programmers_jobs(last_page)

    return jobs_list