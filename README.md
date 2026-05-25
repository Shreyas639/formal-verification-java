# Formal Verification in Java — Design by Contract

Individual coursework for CST3110 Testing and Verification at Middlesex University (2024).

## What it does
Formally verifies two Java classes using Design by Contract (DbC) principles with Google Cofoja:
- `Natural` — a non-negative integer with overflow and underflow protection
- `NaturalList` — a collection of Natural numbers with null safety and sorting

## Contracts implemented
- Class invariants — guarantee data is always in a valid state
- Preconditions — block illegal inputs (null, overflow, underflow, out-of-bounds)
- Postconditions — guarantee correct behaviour after every operation

## Tests covered
- Constructor validation (negative inputs blocked)
- Overflow protection on increment, add, multiply
- Underflow protection on decrement, subtract
- Null checks on multiply, divide, push, search
- Division by zero prevention
- Sort and binary search correctness

## Tech Stack
- Java
- Google Cofoja (Design by Contract)
- JUnit
- Eclipse
