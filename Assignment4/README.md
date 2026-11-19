# CSA09 – Programming in Java – Assignment 4

**Student Name:** Yuvasri B  
**Register Number:** 192421231  
**Course:** CSA09 – Programming in Java  
**Java Validation Environment:** OpenJDK 21.0.12  
**GitHub Repository:** 

## 1. Project Structure

```text
CSA09-192421231-Assignment4/
├── Task1/                         # Fee payment window, service, repository and tests
│   └── Screenshots/
├── Task2/                         # Outpatient appointment management
│   └── Screenshots/
├── Task3/                         # Library search and window layout
│   └── Screenshots/
├── Task4/                         # Drawing pad: broken, fixed and buffered versions
│   ├── CompilerErrorDemo/
│   └── Screenshots/
├── Task5/                         # Converter implementations A–D and A2–D2
│   └── Screenshots/
├── Task6/                         # Swing and JDBC event registration system
│   ├── sql/                       # MySQL schema and optional test data
│   ├── src/events/                # Application, model, service, DAO and UI
│   ├── output/                    # Sample CSV export
│   └── Screenshots/
├── REPORT.md                      # Assignment report
├── docs/
│   └── ASSIGNMENT4.pdf            # Original assignment question paper
├── verify.sh                      # Linux/macOS verification script
├── verify.ps1                     # Windows PowerShell verification script
├── verification-results.txt       # Compilation, test and benchmark results
└── README.md
```

Compiled `.class` files and the local `out/` folder are excluded through `.gitignore`.

## 2. Compilation and Verification

**Requirement:** JDK 21 or a compatible newer version.

Run the appropriate verification script from the main project folder.

**Windows PowerShell**

```powershell
.\verify.ps1
```

**Linux / macOS**

```bash
chmod +x verify.sh
./verify.sh
```

The scripts compile the six task programs, execute the fee service and event service tests, run the Task 1 dispatch benchmark, and check whether the intentionally incorrect Task 4 example produces the expected `@Override` compiler error.

## 3. Running the Programs

After compilation, execute the following commands from the repository's main folder.

| Task | Program | Run command |
|---|---|---|
| 1 | Fee payment | `java -cp out FeeWindow` |
| 1 | Dispatch benchmark | `java -cp out DispatchBench` |
| 2 | Appointment desk | `java -cp out AppointmentDesk` |
| 3 | Library search | `java -cp out LibrarySearch` |
| 4 | Broken drawing pad | `java -cp out DrawPadBroken` |
| 4 | Repaired drawing pad | `java -cp out DrawPad` |
| 4 | Buffered drawing pad | `java -cp out DrawPadBuffered` |
| 5 | Completed lambda converter | `java -cp out Converter` |
| 5 | Alternative requirement example | `java -cp out ConverterA2` |
| 6 | Event registration | `java -cp out events.App` |
| 6 | Service testing | `java -cp out events.ServiceTest` |

The remaining Task 5 implementations can be executed using `ConverterA`, `ConverterB`, `ConverterC`, `ConverterD` and the corresponding updated versions `ConverterA2` through `ConverterD2`.

## 4. Task 6 – MySQL Configuration

The application can run in demo mode without a live database. To connect it to MySQL:

1. Install MySQL 8 and MySQL Connector/J.
2. Execute `Task6/sql/schema.sql` on the MySQL server.
3. Copy `Task6/db.properties.example` into the repository's main folder as `db.properties`.
4. Enter the database URL, username and password in the properties file.
5. Add the Connector/J JAR to the Java classpath and launch `events.App`.

If `db.properties` is unavailable, the application automatically uses its in-memory demo DAO. The optional `Task6/sql/seed_100k.sql` file can be used for large-scale data and paging tests after creating the database.

**Important:** Do not upload actual database passwords or other private credentials to GitHub.

## 5. Screenshots and Verification Evidence

The project contains screenshots and test evidence for the six tasks. Some checks involving a live database or computer-specific window behaviour may need to be repeated on the submission computer.

| Task | Evidence included | Additional verification |
|---|---|---|
| 1 | Invalid amount, processing status, successful payment and receipt, service tests and benchmark | Capture fresh terminal evidence if required by the instructor |
| 2 | Department and doctor selection, successful booking, invalid booking, confirmation dialog and event trace | No additional check identified in the current checklist |
| 3 | Small, default and large window screenshots | Repeat window resizing checks on the submission computer if required |
| 4 | Broken click behaviour, repaired drawing, minimize/restore evidence and compiler error | Confirm native minimize/restore behaviour |
| 5 | Successful conversion, invalid amount, Enter-key result and comparison text | Demonstrate all four converter styles if required |
| 6 | Registration, invalid input, duplicate rejection, table paging, File menu, CSV export and service tests | Live MySQL unique-constraint evidence requires a MySQL setup |

The included screenshots demonstrate application execution. However, they do not establish that an external MySQL server was configured. The `REPORT.md` file provides further explanations of the design, testing, validation and remaining checks.

## 6. GitHub Submission Procedure

1. Create a public repository or a private repository accessible to the instructor.
2. Use the repository name `CSA09-192421231-Assignment4`.
3. Upload the complete project folder, including all six task folders and the report.
4. Commit the work progressively, with at least one meaningful commit for each task.
5. Update the GitHub URL in this README after creating your repository.
6. Add the same repository URL to the report cover page if required by the assignment instructions.

## 7. Conclusion

This assignment covers Java application development, GUI design, event handling, exception handling, lambda expressions, database connectivity and testing. The six tasks demonstrate the implementation and validation of different Java programming concepts through practical applications.