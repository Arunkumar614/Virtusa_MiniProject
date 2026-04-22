**Python - OpsBot Log Automator**

**Description:**
This project automates the analysis of server log files by filtering important security-related events such as ERROR, CRITICAL, and FAILED LOGIN attempts.

**Features:**
- Reads log file line by line
- Filters important logs and removes noise (INFO)
- Counts frequency of each issue type
- Generates a security alert file with date
- Displays file size using os module

**Files:**
- opsbot.py → main script
- server.log → input file
- security_alert_[date].txt → output file

**Input file:**
<img width="1456" height="373" alt="image" src="https://github.com/user-attachments/assets/c6b64b6a-3320-40d1-899e-4f96f17b5387" />

**Before file (server.log) contains all logs including INFO.**
**After file (security_alert) contains only filtered security-related logs.**
<img width="1916" height="1020" alt="image" src="https://github.com/user-attachments/assets/a4cf2472-cb7f-42d9-802c-77302a3443cb" />

