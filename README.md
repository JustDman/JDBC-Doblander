# JDBC-Doblander



This repository is for educational purposes. It is for me to learn JDBC in school.
It is essential to use a Version Control (Git) for this exercise.

## Tasks
### Task 1
* [x] Setting up a mysql server using Docker
* [x] Setup a Maven Project to Program JDBC
### Task 2
* [x] Create a table called `Invoice`, which has the attributes
    - id (Pk)
    - date
    - description
    - value
    - paid (boolean or tinyint(1))
* [x] Fill the table with 3 dummy records
### Task 3
Create a Java-program, which handles the connection to the database. Create four static methods to access the table
* [x] `public void showInvoices()`
* [ ] `public void insertInvoice(Date date, String description, double value, Boolean paid)`
* [ ] `public void updateInvoice(int id, Date date, String description, double value, Boolean paid)`
* [ ] `public void deleteInvoice(int id)`
### Task 4
* [ ] Create classes based on a Database model, which only uses dummy data instead of connecting to the database
    - ![Picture of the ORM](/assets/orm.png)
    - [Tip for the dao pattern:](http://www.informit.com/articles/article.aspx?p=1398621&seqNum=3)
        - ![Tips for the pattern](/assets/dao_pattern.png)
### Task 5
* [ ] add a class `SQLInvoiceDaoIImp`, which implements the database connection

> GitHub [@JustDman](https://github.com/JustDman)