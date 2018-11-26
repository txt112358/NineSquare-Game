# NineSquare-Game
Java code used to play Nine Square Game
## NineSquare.java

This file is used to test all other classes in the project.

## CheckNineSquare.java

CheckNineSquare class is used to exam whether the number to be inserted into the NineSquare is legal for the game. Obviously, it will return 'false' if we have same number in a row, in a column or in a nearby 3*3 square.

## CreateNineQuestion.java

This class is used to create a instance of NineQuestion class for the purpose of creating problems. We can use a two dimension array to create a question.

## NineQuestion.java

This class is used to record all numbers in the square. It also has boolean type array to record whether it is a question, so we can decide whether the number can be changed.

## NumberLaw.java

We can use this class to create a rule of banned numbers. The number to be judged cannot be the same as added to this class.

## OutputFormat.java

This interface is used to formalize the output format. Any class implements this interface must have function:

```java
public void outputQuestion(NineQuestion q);
```

So, we can appoint the output style.

## PrintNineQuestion

This class implements OutputFormat interface, so we can print NineSquare instance to the screen, which is System.out in java.