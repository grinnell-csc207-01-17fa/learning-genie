# homework-6-learning-genie-guptayas-jinannan
homework-6-learning-genie-guptayas-jinannan created by GitHub Classroom

## Author 
[guptayas][jinannan]

## Introduction

## Class and Methods

### DecisionNode Interface (GuessNode & QuestionNode)
```
  public int countObjects(): returns a count of the number of objects this decision tree records, i.e., the number of guess nodes contained in the tree.
  public DecisionNode guess(Scanner in): performs the guessing game starting at this node using the given Scanner object to query the user for input; returns an updated node that is the result of any knowledge learned during the game.
  public void write(FileWriter out) throws IOException: writes this node in the serialized format described above to the given file represented by a FileWriter object.
```

### DecisionTree
```
public int countObjects(): returns a count of the number of objects this decision tree records, i.e., the number of guess nodes contained in the tree.
public void guess(Scanner in): performs the guessing game starting at the root of this decision tree using the given Scanner object to query the user for input. Also modifies the decision tree if the genie learns any additional information in playing the game.
public void write(FileWriter out) throws IOException: writes this decision tree in the serialized format described above to the given file.
```
```
public DecisionTree(): constructs a decision tree with an initial guess node containing Dog.
public DecisionTree(File file): constructs a decision tree stored in a serialized form in the given file.
```

### LearningGenie
```
Contains the main method
```

## Reference
http://www.cs.grinnell.edu/~osera/courses/csc207/17fa/homework/learning-genie.html
