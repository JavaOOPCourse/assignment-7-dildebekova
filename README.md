[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/G0ut1bqt)


Graded Lab: File Processing System with
## Exception Handling

---

## Objective
Students will:
- Read and write files using Java File I/O
- Handle exceptions properly
- Use try-with-resources
- Validate input and handle errors gracefully

## Scenario
You are building a Student Record Processor.
The program reads student data from a file, processes it, and writes results to another file.

---

    Input File (students.txt)
    Example:
    Alice,85
    Bob,90
    Charlie,abc
    David,78
    Eve,95

---

    assignment7/          ← корневая папка репозитория
    ├── README.md                      ← это задание (не трогать)
    ├── src/
    │   └── StudentRecordProcessor.java    ← ←← ВСЁ ЗАДАНИЕ ВЫПОЛНЯЕТСЯ ТОЛЬКО В ЭТОМ ФАЙЛЕ
    ├── data/                          ← папка для входных данных
    │   └── students.txt               ← ←← Создайте этот файл и запишите в него СВОИ данные
    ├── output/                        ← папка для результатов
    │   └── report.txt                 ← ←← Программа сама создаст/перезапишет этот файл


---

## Requirements
✅ Task 1: Read File (10 pts)
- Read from students.txt
- Use BufferedReader
- Print all valid lines

✅ Task 2: Handle Exceptions (20 pts)

You must handle:
- FileNotFoundException
- IOException
- NumberFormatException
  If GPA/score is invalid:
- Skip the line
   

      Print:
      Invalid data: Charlie,abc

✅ Task 3: Process Data (15 pts)
- Store valid students in a collection (ArrayList)
## • Compute:
- Average score
- Highest score

✅ Task 4: Write Output File (15 pts)
Create report.txt:
Example output:
## Average: 87.0
## Highest: Eve - 95

✅ Task 5: Use try-with-resources (10 pts)
- Must be used for:
  - Reading
  - Writing

✅ Task 6: Custom Exception (10 pts)
Create your own exception:
class InvalidScoreException extends Exception
Throw it when:
- score < 0 or score > 100


✅ Task 7: Clean Code & Structure (10 pts)
- Use methods:
  - readFile()
  - processData()
  - writeFile()
- Proper naming
- No duplicated code


✅ Task 8: Sort Students (10 pts)
- Sort students by score (descending)
- Save full sorted list to file

## Important Rules
❌ Program must NOT crash
❌ Do NOT ignore exceptions
❌ Do NOT hardcode values

## Expected Learning Outcomes
Students will understand:
- Difference between checked & unchecked exceptions
- Real-world error handling
- File reading/writing patterns
- Defensive programming
