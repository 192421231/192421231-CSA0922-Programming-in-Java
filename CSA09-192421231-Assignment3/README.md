# Programming in Java – Assignment 3 (CO3)

**Student Name:** Yuvasri B  
**Register Number:** 192421231  
**Repository Folder:** `CSA09-192421231-Assignment3`  
**Java Environment:** Visual Studio Code with Java Platform Extension (Oracle Corporation)  
**GitHub Repository:** 

## Table of Contents

- **Q1:** ATM Application – Exception Handling, Custom Exception Hierarchy, Multi-Catch and Finally Block
- **Q2:** Custom Checked Exceptions – Exception Propagation and Chained Exceptions
- **Q3:** File Management – Manual Resource Closing and Try-with-Resources
- **Q4:** Java Multithreading – Thread Class, Runnable Interface and Thread Lifecycle
- **Q5:** Cinema Ticket Reservation – Race Conditions and Synchronization
- **Q6:** Wallet Transactions – Deadlock Prevention and Producer-Consumer Model
- **Q7:** Answer-Script Processing – Executor Service, Parallel Stream and Independent Threads

Every question folder includes the Java source file (`Main.java`), program output (`OUTPUT.txt`) and a separate `Screenshots` folder containing execution evidence.

## Compilation and Execution

The following commands can be used to compile and execute each Java program from its respective question folder:

```bash
javac Main.java
java Main
```

## Steps to Run Programs in Visual Studio Code

1. Launch Visual Studio Code.
2. Choose **File → Open Folder** and select the assignment directory.
3. Open the required question folder, such as Q1, Q2 or Q3.
4. Open the `Main.java` source file.
5. Verify that the Java Extension Pack is installed and a JDK is configured.
6. Open the integrated terminal using **Terminal → New Terminal**.
7. Move to the required question directory:

```bash
cd Q1
```

8. Compile the source file:

```bash
javac Main.java
```

9. Execute the program:

```bash
java Main
```

For Q1, provide the required test inputs when the program requests them. Check the displayed result and capture a screenshot showing both the source code and execution output.

Repeat the same procedure for all seven questions. Store each screenshot in the corresponding question's `Screenshots` folder.

**Note:** Screenshots submitted as execution evidence should be captured directly from your own program execution. Do not create or modify screenshots to represent results that were not actually produced.

## Task Completion and Verification

| Task | Implementation and verification |
|---|---|
| Q1 | Tested successful withdrawal and four exception scenarios. Verified that the finally block executes in all five test cases. |
| Q2 | Checked exam closure, student registration, file-size validation and storage-related exceptions. Verified exception chaining for the storage failure. |
| Q3 | Compared manual resource closing with try-with-resources. Checked report consistency and resource closure for valid and corrupted input files. |
| Q4 | Executed multiple trials using Thread and Runnable. Also examined thread priority and daemon-thread behaviour. |
| Q5 | Compared unsynchronized and synchronized booking operations. Checked how synchronization prevents duplicate seat allocation. |
| Q6 | Implemented wallet transfers with consistent lock ordering and producer-consumer communication. Verified the expected total and bounded-queue behaviour. |
| Q7 | Tested answer-script processing using 10,000 generated cases and compared the executor, parallel-stream and individual-thread approaches. |

## Q1 – Test Case Details

The ATM program is tested using the following inputs:

| Test Scenario | Account Number | Withdrawal Amount | Card Reader File |
|---|---:|---:|---|
| Successful transaction | `192421231` | `500` | Available |
| Invalid account input | `abc` | Not applicable | Not applicable |
| Negative withdrawal | `192421231` | `-10` | Available |
| Insufficient account balance | `192421231` | `6000` | Available |
| Card-reader file unavailable | `192421231` | `100` | Missing |

These test cases help verify successful transactions, input validation, exception handling and execution of the finally block.

## Screenshot Documentation

Each question contains screenshots captured during local program execution in Visual Studio Code. The screenshots are intended to show the source code and corresponding terminal output.

Q1 contains separate screenshots for its five test scenarios. The remaining questions include their respective program execution evidence.

## Submission Checklist

- [ ] Update the assignment cover page with the correct student name and register number.
- [ ] Verify that the GitHub repository contains all seven question folders.
- [ ] Upload genuine program execution screenshots.
- [ ] Add Programiz screenshots if specifically requested by the faculty.
- [ ] Complete the Student A and Student B responsibility section with the actual partner details.
- [ ] Include the pair-work contribution record.
- [ ] Push the source code, output files and screenshots to GitHub.
- [ ] Maintain separate commits for the individual question implementations.

## Final Note

Program outputs and execution timings may differ depending on the computer configuration, Java version and system workload. Therefore, all programs should be executed again in the local environment before final submission. The final report should contain the actual output screenshots and measured results obtained during verification.