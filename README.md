# Java Programming: Arrays, Lists and Structured Data
This is the second course out of nine programming courses provided by [coursera](https://www.coursera.org/) and are listed [here](https://github.com/ForrestKnight/open-source-cs)

You can find this course [here](https://www.coursera.org/learn/java-programming-arrays-lists-data)


## Week 1
In this week you will learn about arrays and how to use them. You will also learn about cryptography and how important it is and you will implement the Caeser Cipher cryptography algorithm. You will learn how to encrypt, decrypt using keys or drcrypt without keys by calculating the most common litter index which is suppose to be 'e' and calculate the key then decrypt the input. You will learn about how to make the Caeser Cipher using two keys and breaking it as well.  

You will learn about the StringBuilder class and how it is mutable unlike the normal String class which is immutable which can't be changed once created.  

#### StringBuilder class usage:
```java
StringBuilder sb = new StringBuilder();

sb.append(input);              //addes the input at the end of the StringBuilder object sb
sb.insert(index, input);       //addes the input in the middle starting by the location of the specified index
sb.charAt(index);              //returns the character at the specified index
sb.setCharAt(index, input);    //replaces the character at the specified index by the specified character (input) 
sb.toString();                 //returns the StringBuilder object as a string

```
---

You will also learn about the Character class 

#### Character class usage:
```java
Character.isLowerCase(inputChar);       //returns ture if the character is lower case
Character.isUpperCase(inputChar);       //returns ture if the character is upper case
Character.toLowerCase(inputChar);       //returns the crossponding lower case character
Character.toUpperCase(inputChar);       //returns the crossponding upper case character
Character.isDigit(inputChar);           //returns ture if the character is a digit
Character.isAlphabet(inputChar);        //returns ture if the character is an alphabet
Character.isLetter(inputChar);          //returns ture if the character is a letter
```

---

#### This week will also introduce some basic OOP concepts like:
**Class** is a type.  
**Object** is an instance of that class (type). It contains **Code** and **Data**.  
**Code** represents the methods inside the object.  
**Data** represents the fields of the object.  

---

#### Encapsulation:
The code(methods) and the data are logically inside of the object and the method acts on the data inside the object.

---

#### Design Principles:
| Type          | Naming Convention | Description  |
| ------------- |:-------------| :-----|
| Class     | Noun | Should describe things |
| Method      | Verbs  | Sometimes they aren't like substring() or indexOf(). These methods describe actions |
| Fields | Noun      | Should describe things the class has, sometimes it could be Adjectives to describe properties |

#### Visibility Modifiers:
- Public,                 Any class in any package can access these methods or fields
- Protected,              Any class in the same package or a sub class from another package can access these methods or fields
- Default(Not written),   Any class in the same package can access these methods or fields.
- Private,                Only the class in which these methods or fields are defined has access to them

>If you try to access a private method or field from another class you will get ```fieldName has private access in className``` error

---

#### Abstraction:
The seperation of the **interface**(what it does) and the **implementation**(how it does it).  
**Interface** should be public.  
**Implementation** should be private.  

Fields should be private since they are a part of the implementation.  
Methods depends of the purpose of it. If the method represents what the object does, it should be public. And if it is a helper method it should be private.  

---

#### Constructos:
- Should have the same name as the class
- Should have no return type not even **void**
- Should be used to initialize the fields of the class
- They aren't called directly
- They are called when creating an object with the keyword **new**
- When there is no constructor, java provides a default one with no parameters and no body
```java 
Public className(){}
```
---

## Week 2
In this week you will learn about ArrayLists and HashMaps and some programming concepts like **brittle code** and **Open/Closed** open for extension, closed for modification.

#### ArrayList
- Like arrays but growable. You create an arrayList using generics eg. Integer instead of int, String, Double...etc  
- java uses <> for generics.
- Indexable collection of elements.  
- Stores objects not primitives eg. Integer not int.
- Two step process to update Integer values - you must get the value, then update it -.  


#### ArrayList Usage:

```java
ArrayList<Integer> arrayList = new ArrayList<>();
arrayList.add();                        //to add a new Integer to the arrayList.
arrayList.get(index);                   //to get the Integer at the specified index.
arrayList.set(index, newValue);         //replaces the value at the index with the new one.
arrayList.indexOf(value);               //gets the index of the specified value.
arrayList.size();                       //returns the number of elements inside the arrayList.
```
---

#### Brittle Code:
If your software is **brittle** it will break when extending it or trying to use it in a way it's not suppose to be.  

#### Open/Closed
Your code should be open for extension, closed for modification. So you should extend your software without extinsive modifications to the extinding code.

#### Great Design:
- Keeping changes in one place.
- Minimize duplicate code.

---

#### HashMap:
- HashMaps are collection of (Key, Value) pairs with keys mapping to values.
- HashMaps replaces two parallel ArrayLists  
- HashMaps are much faster than the ArrayLists, almost x40 faster.  
- HashMaps are very efficient structure than two ArrayLists that can be used to associate keys with values.  
- To define a HashMap you need to specify the key and the value types and use **generics**. The key should be of type String, Both key and value should be objects.
- Keys should be immutable like Strings.
- Keys must be unique.
- Value can be anything eg. ArrayList, String, Integer...etc.

```java
HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
hashMap.get("Key");             //returns the Integer value associated with the specified key.
hashMap.containsKey("Key");     //returns true if the specified key is in the hashMap.
hashMap.put("Key", value);      //inserts a value with the specified key inside the hashMap.
hashMap.keySet();               //iterate over all the keys in the hashMap;
hashMap.size();                 //returns the number of unique keys inside the hashMap.

//to print the values inside the hashMap.
for(String key: hashMap.KeySet()){
    System.out.println(hashMap.get(key));
}

//or
for(Integer value: hashMap.values()){
        System.out.println(value);
}

```
---

## Week 3:
If a class ha a toString() method, it will be used to print the class's object as a String.  

#### Equlity:
```java
a == b          //returns true if both a and b referes to the same object.

a.equals(b);    //returns true if the two strings have the same sequence of characters.
```