import json
import csv

SAVE_DIRECTORY = 'C:/my_project/spring/final_project/jobdamoa/src/main/webapp/python_scrap/'

def save_to_file(jobs, name):
    with open(SAVE_DIRECTORY + name + ".json", "w", encoding="utf-8") as f:
        json.dump(jobs, f, ensure_ascii=False)
    return

def save_to_file_js_form(jobs, name):
    jobs_json = json.dumps(jobs, ensure_ascii=False)
    js_form_json = "data='" + str(jobs_json) + "'"

    with open(SAVE_DIRECTORY + name + ".json", "w", encoding="utf-8") as f:
        f.write(js_form_json)
    return

def save_to_file_csv(jobs, name):
    file = open(SAVE_DIRECTORY + name + ".csv", mode="w", newline='')
    writer = csv.writer(file)
    writer.writerow(["title", "company", "location", "experience", "position", "link"])
    for job in jobs:
        writer.writerow(list(job.values()))
    return
