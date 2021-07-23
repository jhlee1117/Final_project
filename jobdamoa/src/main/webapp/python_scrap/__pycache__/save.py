import json

SAVE_DIRECTORY = 'C:/WorkPlace/Spring/SpringSrc/final_project/jobdamoa/src/main/webapp/'

def save_to_file(jobs, name):
    #jobs_json = json.dumps(jobs, ensure_ascii=False)
    #js_form_json = "data='" + str(jobs_json) + "'"
    with open(SAVE_DIRECTORY + name + ".json", "w", encoding="utf-8") as f:
        #f.write(js_form_json)
        json.dump(jobs, f, ensure_ascii=False)

    # file = open("jobs.csv", mode="w", newline='')
    # writer = csv.writer(file)
    # writer.writerow([v "title", "company", "location", "experience", "position", "link"])
    # for job in jobs:
    #     writer.writerow(list(job.values()))
    return