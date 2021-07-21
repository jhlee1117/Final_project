from saramin import get_jobs as get_saramin_jobs
from programmers import get_jobs as get_programmers_jobs
from save import save_to_file



programmers_jobs = get_programmers_jobs()
#saramin_jobs = get_saramin_jobs()

jobs  = programmers_jobs
save_to_file(jobs)