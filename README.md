# Financial Report Element Processor

## Visitor Pattern Implementation

This project demonstrates a comprehensive implementation of the **Visitor Design Pattern** in Java for processing financial elements in a quarterly report system.

## Project Overview

The Financial Report Element Processor utilizes the Visitor pattern to perform various operations (tax calculation, report generation) on different types of financial elements without modifying their core structure. This implementation showcases:

- **Visitor Pattern** with double dispatch mechanism
- **SOLID Principles** adherence (especially OCP and SRP)
- **Clean Code** principles and practices
- **Object-Oriented Programming** best practices

## Architecture

### Core Components

#### Financial Elements Hierarchy
- `FinancialElement` - Base interface defining the contract for all financial elements
- `Revenue` - Represents financial gains (amount, source)
- `Expense` - Represents financial outflows (amount, category)  
- `Investment` - Represents long-term assets (amount, risk factor)

#### Visitor Hierarchy
- `FinancialVisitor` - Base interface defining visit operations
- `TaxCalculator` - Calculates tax liability with different rates per element type
- `ReportGenerator` - Generates formatted reports for each element

#### Execution Context
- `FinancialReportDemo` - Main driver class demonstrating the pattern

### Tax Calculation Rules
- **Revenue**: 15% tax rate
- **Expense**: 5% tax deduction (negative tax)
- **Investment**: 10% tax on (amount × risk factor)

### Report Format
- **Format**: `[Element Type] - [Key Detail] - Value: [Amount]`
- **Example**: `Revenue - Sales - Value: 150000.00`

## How to Run

### Prerequisites
- Java 8 or higher
- Command line access

### Compilation and Execution
```bash
# Navigate to project directory
cd /home/denis/IdeaProjects/software_design_patterns

# Compile all Java files with proper package structure
javac -d out src/com/financialreport/**/*.java

# Run the demonstration
java -cp out com.financialreport.demo.FinancialReportDemo
```

## Sample Output

```
=== Financial Report Element Processor ===
Demonstrating Visitor Pattern Implementation

Financial Elements:
==================
 1. Revenue{amount=150000.00, source='Sales'}
 2. Revenue{amount=75000.00, source='Service'}
 3. Revenue{amount=25000.00, source='Licensing'}
 4. Expense{amount=80000.00, category='Salaries'}
 5. Expense{amount=15000.00, category='Utilities'}
 6. Investment{amount=100000.00, riskFactor=0.30}

Tax Calculation:
================
Total Tax Liability: $40250.00

Generated Report:
=================
Revenue - Sales - Value: 150000.00
Revenue - Service - Value: 75000.00
Revenue - Licensing - Value: 25000.00
Expense - Salaries - Value: 80000.00
Expense - Utilities - Value: 15000.00
Investment - Risk Factor 0.30 - Value: 100000.00
```

## Design Patterns & Principles

### Visitor Pattern Benefits
- **Separation of Concerns**: Operations are separated from element structure
- **Open/Closed Principle**: New operations can be added without modifying elements
- **Single Responsibility**: Each visitor has one specific purpose
- **Maintainability**: Operations are grouped by type rather than scattered

### SOLID Principles Implementation
- **SRP**: Each class has a single responsibility
- **OCP**: Open for extension (new visitors), closed for modification (elements)
- **LSP**: All implementations properly substitute their interfaces
- **ISP**: Interfaces are focused and cohesive
- **DIP**: Depends on abstractions, not concretions

### Clean Code Practices
- **Meaningful Names**: Clear, intention-revealing names throughout
- **Small Functions**: Methods are focused and do one thing
- **Comments**: Comprehensive Javadoc documentation
- **Error Handling**: Proper validation and exception handling
- **Consistent Formatting**: Professional code style

## Extensibility

The Visitor pattern makes adding new operations straightforward:

```java
// Adding a new visitor is easy - no element modification needed
public class ComplianceValidator implements FinancialVisitor {
    public void visit(Revenue revenue) { /* validate revenue compliance */ }
    public void visit(Expense expense) { /* validate expense compliance */ }
    public void visit(Investment investment) { /* validate investment compliance */ }
}
```

## File Structure

```
src/
└── com/
    └── financialreport/
        ├── elements/
        │   ├── FinancialElement.java     # Base interface for financial elements
        │   ├── Revenue.java              # Revenue element implementation
        │   ├── Expense.java              # Expense element implementation
        │   └── Investment.java           # Investment element implementation
        ├── visitors/
        │   ├── FinancialVisitor.java     # Base visitor interface
        │   ├── TaxCalculator.java        # Tax calculation visitor
        │   └── ReportGenerator.java      # Report generation visitor
        └── demo/
            └── FinancialReportDemo.java  # Main demonstration class
```

## Additional Documentation

See `analysis.md` for detailed theoretical analysis including:
- Flexibility Analysis (OCP compliance)
- Structural Trade-offs (ISP considerations)
- Use Case Justification (Visitor vs. Direct Methods)

## Author

Denis - Software Design Patterns Assignment
Version 1.0 - November 2025
