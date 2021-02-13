# CSC109-Assignment-3

## Features

This program simulates a user's interaction with a vending machine using console input and output.

## How to Run

Clone the repository, open it in your IDE of choice, and then run ``Test.java``.

## About the Code

This project was made to demonstrate collaboration as well as push and pull requests using Git. It consists of three classes: 
* ``Test.java``: Driver class with example snacks
* ``Snack.java``: Template for snack with price and name
* ``VendingMachine.java``: Contains snacks and accepts payment

## Example Output

An example run of the program looks like this, where the lines with ``>`` are user input.
```
Hello, welcome to the vending machine.
The items inside are the following: 
A1: Potato Chips - $1.0
A2: Doritos - $5.0
B1: Oreos - $1.5
B2: Water - $1.0
C1: Mountain Dew - $0.5
C2: Gatorade - $3.0

To order an item, input the slot for that item.
For example, put in "A1" to order Potato Chips
> B1
You chose the Oreos for $1.5.
Please enter the amount of dollars you would like to insert.
> 2
You have inserted 2 dollars.
You have chosen to buy Oreos for $1.5.
Are you sure you want to buy that? (yes/no)
> yes
Your change is $0.5 (0 dollar(s) and 2 quarter(s)).
Please take your change.
Enjoy your Oreos!
```