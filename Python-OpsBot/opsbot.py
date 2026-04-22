import os
from datetime import datetime

with open("server.log", "r") as file:
    lines = file.readlines()

keywords = ["ERROR", "CRITICAL", "FAILED LOGIN"]

error_count = {
    "ERROR": 0,
    "CRITICAL": 0,
    "FAILED LOGIN": 0
}

filtered_lines = []

for line in lines:
    for key in keywords:
        if key in line:
            filtered_lines.append(line.strip())
            error_count[key] += 1


current_date = datetime.now().strftime("%Y-%m-%d")
filename = f"security_alert_{current_date}.txt"

with open(filename, "w") as file:
    for log in filtered_lines:
        file.write(log + "\n")


print("=== Security Alert Summary ===")
for key, value in error_count.items():
    print(f"{key}: {value}")

file_size = os.path.getsize(filename)
print("\nAlert file created:", filename)
print("File size:", file_size, "bytes")
