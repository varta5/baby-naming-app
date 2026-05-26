import sys
import json

import requests

ENDPOINT = "/api/v1/names"

if __name__ == "__main__":

    if len(sys.argv) < 3:
        raise Exception("Missing argument! First argument should be path and name of file containing names to upload, second argument should be the URL of the backend service")
    filepath = sys.argv[1]
    url = sys.argv[2]
    with open(filepath, "r", encoding="utf-8") as file:
        file_contents = file.readlines()

    counter = 0
    headers = {
        "Content-Type": "application/json"
    }
    for line in file_contents:
        if len(line.strip().split(" ")) != 1:
            continue
        counter += 1
        baby_name = line.strip()
        print(f'{counter} / {len(file_contents)} - Uploading baby name "{baby_name}"')
        body = {
            "name": baby_name
        }
        requests.post(f"{url}{ENDPOINT}", headers=headers, data=json.dumps(body))
    print(f"Uploaded {counter} baby names")

    baby_names = requests.get(f"{url}{ENDPOINT}").json()
    print(f"There are {len(baby_names)} baby names stored in the application")
