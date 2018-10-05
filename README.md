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

## References
>alciregi, Resize image in the wiki of GitHub using Markdown, https://stackoverflow.com/questions/24383700/resize-image-in-the-wiki-of-github-using-markdown/34482991

>Sohail Aziz, Passing custom objects between android activities, http://sohailaziz05.blogspot.com/2012/04/passing-custom-objects-between-android.html

>Andrey Akhmetov,Getting hours,minutes, and seconds from Date? [duplicate], https://stackoverflow.com/questions/25474033/getting-hours-minutes-and-seconds-from-date

>CodingWithMitch, Android Beginner Tutorial #25 - DatePicker Dialog [Choosing a Date from a Dialog Pop-Up], https://www.youtube.com/watch?v=hwe1abDO2Ag

>Coding in Flow, How to Save an ArrayList of Custom Objects to SharedPreferences with Gson - Android Studio Tutorial, https://www.youtube.com/watch?v=jcliHGR3CHo

>Florent Guillaume,I want to get Year, Month, Day, etc from Java Date to compare with Gregorian Calendar date in Java. Is this possible?
 , https://stackoverflow.com/questions/9474121/i-want-to-get-year-month-day-etc-from-java-date-to-compare-with-gregorian-cal

>ρяσѕρєя K,How to pass data from 2nd activity to 1st activity when pressed back? - android
, https://stackoverflow.com/questions/14292398/how-to-pass-data-from-2nd-activity-to-1st-activity-when-pressed-back-android


>mkyong,Java – Convert String to int , https://www.mkyong.com/java/java-convert-string-to-int/

>Developer Android, DatePickerDialog, https://developer.android.com/reference/android/app/DatePickerDialog

>cookie_time,Cannot resolve method DateFormat.is24HourFormat in TimePickerDIalog , https://stackoverflow.com/questions/41507754/cannot-resolve-method-dateformat-is24hourformat-in-timepickerdialog
