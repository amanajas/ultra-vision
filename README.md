# Overview

This is a project to study a little Java by practicing and review its concepts.

## Object Oriented Constructs / Systems Analysis & Design
### Module Title(s): Object Oriented Constructs / Systems Analysis & Design
### Assignment Type: Practical Project

## Assignment Introduction

Ultra-Vision is a Music and Video rental shop that rent Music, Music Videos, Movies, and TV Box sets. Ultra-Vision has one shop but is planning on having several shops located throughout Ireland and needs to computerize their current system. Currently all items in the shop are tracked using a paper-based system of inventory tracking.

### You have been tasked by Ultra-Vision to create a movie rental shop management system.

The shop has several titles that can be classified as described in the following section. Also, there are different types of customers, and the rental shop has different subscriptions plans. These plans are designed to limit the titles that a customer can rent unless the customer has a premium membership.

You have to create a system that allows the user (shop staff), to keep track of the titles (rented and in stock) and the customers of the shop. The system is described further on the following pages.

## Object Oriented Constructs

- Apply best practices in Object Oriented Programming and Constructs in the production of software systems.
- Write robust Object-Oriented software.
- Utilise Object Oriented features and constructs such as Packages, Nested Classes,Inheritance, Polymorphism, Enums, Abstract Classes, Interfaces and Collections to provide elegant solutions to appropriate problems.
- Understand the benefits of using IDE tools in software development in terms of development, deployments, packing, code conventions and version control.

## Systems Analysis & Design

- Implement UML-based planning during the software development process
- Devise clear roadmap for a software project to aid the future direction of a company based on direction and feedback
- Select the testing needs of a piece of software and design automatic and manual tests to address these
- Keep abreast of new developments in Systems Analysis and Design
- Assess a piece of software code and develop a collection of UML and design documents for the software 

### Specific Requirements

- Titles in the shop are broken down into types:
  - (ML) Music
  - (ML) Live Concert Videos
  - (VL) Movie
  - (TV) Box Set
- Customers must obtain a membership card. All transactions are cashless. Members are required to link their membership card to their credit or debit card account. The membership card doubles as a Loyalty card which allows the customer to accumulate 10 loyalty points for each rental. The customer automatically receives one free rental of their choice when their
card is inserted, and 100 points are detected. The loyalty points counter is reset to zero whenever the customer is provided with a free rental.
- All items must be returned within 3-days (72 hours). Items are returned to one of 10 ‘return slots’ which scan the bar code of the items as they slide through the slot and the database is notified about the time and date of the return, and the database is automatically updated.
> **Note**: The Accu-Rent company has been contracted to handle this part of the system and therefore you are not required to program this aspect of the software.
- The membership card will be programmed to retain the access level of the customer as shown here:
  - Customers can subscribe to any one of the following access levels:
    - (ML) Music Lovers: Can only rent Music CDs and Live Concert Videos
    - (VL) Video Lovers: Can only rent Movies (excluding Live Concert Videos)
    - (TV) TV Lover: Can only rent Box Sets.
    - (PR) Premium: Can rent any title
    - The media formats include CD, DVD, and Blu-Ray
- Attributes and behaviour for Titles and Customer are completely up to you. Make sure they are relevant to the nature of the object you are representing.
- Example Title
  - Movie – DVD (Year of release / Title / Genre / Director)
  - Live Concert Video – Blu-Ray (Year of release / Title / Band)
- Any customer is entitled to rent up to 4 titles within their specific subscription type.
- The system must allow a user to perform all of the following tasks:
- Search for Titles
- Search for Customers
- Add new Titles
- Add new Customers
- Update Customers and their subscription plan if they want to change it
- Register that a customer has rented a title – Verifying that they are entitled to rent the title
- Register that a customer has returned a title
