# libaryBorrower

1.0 Introduction

During this vast development of information and the great need and interests on reading and broadening our horizons of knowledge, there is a specific and urgent need for developing new apps which facilitate the process of borrowing books via internet without losing time , effort or even money in some situations.
As an android developer, I am thinking of developing an application of a library system of a previously existed library.
This app aims at altering the normal process of borrowing into an electronic one. A person can simply download this app and easily search for whatever book I need by brief and simple steps. One can borrow and return any book whenever and wherever he wants through some notifications and user interface (UI).
This app serves two users: the borrower as well as the librarian.


1.1 Description

1.1.1 Librarian

Collecting all books in one database.
Searching for any book easily.
Defining the dates and times of borrowing and giving back books.
Collecting all the data related to the customers in a specific profile activity for each.
Collecting all the details related to the librarian in a specific profile.
Adding, deleting and even updating books at many times.
Adding and updating  all the details of books in a book activity.
Controlling the option of displaying books for all the visitors of the library after receiving the borrowed books from the borrowers.









1.1.2 Borrower

Simplicity of searching for books whenever they want in three different ways:
1. Name of book.
2. Bar code.
3. ISBN.
Taking a look on the book details, the authors , and the other borrowers opinions.
Making sure if the intended book is available or not.
Requesting the intended books and defining the times the borrower agrees on via a simple activity.
Requesting to postpone  the time of giving back books in specific conditions.
Writing down the borrowers’ opinions and feedback.
 

1.2.0 Module
 
1.2.1 Book

Book title:
Author name:
Edition:
ISBN:
Bar code:
Page numbers:
Publisher:
Translator:
Linguistic editor:
Description:
Profile designer:


1.2.2 Borrower

Name:
Age:
Date of birth:
phone number:
Email address:
Credit card:
Borrowed books:
Feedback:
Picture:


1.2.3 Librarian

Name:
Age:
Date of birth:
phone number:
Email address:
Credit card:
Feedback:
Picture:





1.2 Process

First activity after registration is the newly displayed books activity.
1.2.1 Borrowing
First, the borrower searches for the intended book in the search label.
The user then chooses one of the three previously mentioned options of search, so book details will appear in book detail activity which includes the details of the position of the book, in which section and even the shelf as well as knowing if the book is available or not.
The borrower can now access all the book and author details.
When pressing the button of borrowing, the app calls OnClick method and the book now is booked for the same borrower whenever he or she wants by defining the number of days by a dialogue.
Finally, the app leads the borrower to an option of extending the period of borrowing by submitting to specific limitations according to the library.
