import csv
import json

def save_to_file(jobs):
    jobs_json = json.dumps(jobs, ensure_ascii=False)
    js_form_json = str(jobs_json)
    with open("data.json", "w", encoding="utf-8") as f:
        f.write(js_form_json)
        #json.dump(jobs, f, ensure_ascii=False)

    # file = open("jobs.csv", mode="w", newline='')
    # writer = csv.writer(file)
    # writer.writerow(["title", "company", "location", "experience", "position", "link"])
    # for job in jobs:
    #     writer.writerow(list(job.values()))
    return
