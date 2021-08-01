from bs4 import BeautifulSoup
import time
from selenium import webdriver as wd

START = 1
URL = f"https://programmers.co.kr/job?min_salary=&min_career=0&min_employees=&order=recent&page=1"
driver = wd.Chrome(executable_path = 'C:/my_project/spring/final_project/jobdamoa/src/main/webapp/python_scrap/chromedriver')
driver.implicitly_wait(3)

def extract_programmers_page():
    driver.get(URL)
    result = driver.page_source
    time.sleep(1)
    soup = BeautifulSoup(result, "html.parser")
    pagination = soup.find("ul", {"class":"pagination"})

    lists = pagination.find_all('span')

    pages = []
    for list in lists:
        pages.append(list.string)

    last_page = int(pages[-2])
    print(last_page)
    
    return last_page


def extract_job_info(html):
    title = html.find("h5", {"class":"position-title"}).find("a").get_text().strip()
    company = html.find("h6", {"class":"company-name"})
    job_id = html.find("h5", {"class":"position-title"}).find("a")["href"]

    if company.find("span") is not None:
        company.span.decompose()
        company = company.get_text().strip()
    else:
        company = company.get_text().strip()

    company_info = html.find("ul", {"class":"company-info"})
    experience = company_info.find("li",{"class":"experience"})
    experience.svg.decompose()
    experience = experience.get_text().strip()
    location = company_info.find("li", {"class":"location"})
    location.svg.decompose()
    location = location.get_text().strip()
    
    positions = html.find("ul", {"class":"list-position-tags"}).find_all("li", {"class":"stack-item"})
    p = []

    for i in positions:
        p.append(i.get_text().strip())
    positions = ",".join(p)

    result = {'title':title, 'company':company, 'location':location, 'experience':experience, 'positions':positions, 'link':f"https://programmers.co.kr{job_id}"}
    return result


def extract_programmers_jobs(last_page):
    jobs = []

    for page in range(START, last_page+1):
        print(str(page) + "페이지 스크래핑중(프로그래머스)")
        driver.get(URL.replace("page=1", f"page={page}"))
        time.sleep(1.5)
        result = driver.page_source
        soup = BeautifulSoup(result, "html.parser")

        results = soup.find_all("li", {"class":"list-position-item"})

        for i in results:
            job_info = extract_job_info(i)
            jobs.append(job_info)
    
    return jobs

def get_jobs():
    last_page = extract_programmers_page()
    jobs_list = extract_programmers_jobs(last_page)
    driver.quit()

    return jobs_list