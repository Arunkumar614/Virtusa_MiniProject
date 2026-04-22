Python - OpsBot Log Automator

**Description**: 
This project automates the analysis of server log files by filtering important security-related events such as ERROR, CRITICAL, and FAILED LOGIN attempts.

**Features**:
- Reads log file line by line
- Filters important logs and removes noise (INFO)
- Counts frequency of each issue type
- Generates a security alert file with date
- Displays file size using os module

**Files**:
- opsbot.py → main script
- server.log → input file
- security_alert_[date].txt → output file

**Output**:
Displays summary of detected issues and creates an alert file.

**Input File Logs:**
<img width="1461" height="385" alt="image" src="https://github.com/user-attachments/assets/3bc754d3-9e94-4228-b360-f9d5d20f56cf" />

Before file (server.log) contains all logs including INFO.
**After file (security_alert) contains only filtered security-related logs:**

<img width="1918" height="1019" alt="image" src="https://github.com/user-attachments/assets/9f3d17d1-57d3-42b9-bf20-c40a2775ec48" />

