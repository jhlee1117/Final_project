from saramin import get_jobs as get_saramin_jobs
from programmers import get_jobs as get_programmers_jobs
from save import save_to_file

programmers = get_programmers_jobs()
saramin = get_saramin_jobs()

save_to_file(programmers, "scrap_result_programmers")
save_to_file(saramin, "scrap_result_saramin")
