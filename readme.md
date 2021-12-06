# CMPE202 Individualproject Jigar Desai

Name : Jigar Desai
Student Id: 015213263.

## Design Patterns used:
* The Singleton Design Pattern was used to guarantee that the AppDatabase class only has one instance while still giving a global access point to it.
* On the FileOutput interface, the Factory Method Design pattern was utilized because ErrorOutput and CheckoutOutput used comparable objects, but the types of objects used were different.
* The FileHelper class used the Decorator Design pattern to use a filepath that was independent of the ProcessOrder or Inventory Class.

## Class Diagram:
![Screen Shot 2021-12-05 at 23 44 10](https://user-images.githubusercontent.com/78275689/144806999-7f99aec3-31b8-4bc2-9454-889c631d14a0.png)

## How to run:
1. Clone repo
2. While in 'src' folder, run command 'java -jar App.java'
3. add path of the dataset and inputs as prompted.

## Output images:
* For file 1
![Output 1](https://user-images.githubusercontent.com/78275689/144809888-1f1df022-52a3-4b71-841f-f8f54004f445.png)
* For file 2
![Output 2](https://user-images.githubusercontent.com/78275689/144809895-ac452208-6149-4b05-b706-8a8079613237.png)
* For file 3
![output 3](https://user-images.githubusercontent.com/78275689/144809901-95d297ee-cc29-47aa-876f-9ed1e31cd1bd.png)
