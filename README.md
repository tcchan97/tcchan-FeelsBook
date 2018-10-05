<img src="https://github.com/tcchan97/tcchan-FeelsBook/blob/master/Pics%20used%20for%20read%20me/First%20screen.png" width="100">


## Purpose of App:
The application is used to record the emotions of a individual. it give the access of recording an emotion while writing a message, when an emotion is clicked. When this occurs the emotion is then record with the date. After the emotion is displayed in a list in which the user can scroll through to access their record emotions. If the user wants to change their message and date of when the emotion if recorded. The user can then click on the emotion to edit the message or date and time. If the user chooses to remove the record of the emotion then the user can click and hold on the emotion to remove the emotion recording.

### How the code works
<img src="https://github.com/tcchan97/tcchan-FeelsBook/blob/master/Pics%20used%20for%20read%20me/Buttons.png" width="150">

When a user clicked on one of the 6 emotions on the screen, an emotion object is created and stored in an emotion array meanwhile the count for the emotion is incremented. I created and Emotion array class that stores emotion objects in a array and then I added methods which can update the count for each emotion and return the values for each emotion count.



### User Interface
<img src="https://github.com/tcchan97/tcchan-FeelsBook/blob/master/Pics%20used%20for%20read%20me/First%20screen.png" width="100"> <img src="https://github.com/tcchan97/tcchan-FeelsBook/blob/master/Pics%20used%20for%20read%20me/Added%20emotion.png" width="100"><img src="https://github.com/tcchan97/tcchan-FeelsBook/blob/master/Pics%20used%20for%20read%20me/Popup.png" width="100">



## UML Diagram
![alt text](https://github.com/tcchan97/tcchan-FeelsBook/blob/master/Pics%20used%20for%20read%20me/Feels%20Book%20UMl%20Diagram.png "Uml Diagram")
The emotion class holds all the data about an emotion while the emotion array class holds all these emotion objects. To access the data the app must go through the emotion array and retrieve the emotion from the list in order to use getter and setter methods to access its private variables. The Emotion array is use to manage all the emotions into one place while storing the count of each emotion.
