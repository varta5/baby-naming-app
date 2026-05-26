# baby-naming-app

A web application to help choose the name for your child to be born

Backend is a Java Spring Boot application.

To run the backend, invoke below command:

```sh
./gradlew bootRun
```

The database consists of one table: "names" containing possible names

## Mass uploading baby names

With the upload_baby_names.py Python script, baby names can be mass uploaded using the respective endpoint of the backend service. The list of names should be provided as an input file - preferably a single text file in which one line contains one name. Only lines containing one word will be uploaded. Avoid providing input file with one-word header row.

The script expects two arguments:

- first is the path and name of the input file
- second is the backend service's base URL

```sh
python upload_baby_names.py example_baby_names.txt http://localhost:8080
```
